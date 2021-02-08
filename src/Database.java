import java.sql.*;
import java.util.Map;

public class Database {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Create a null DB
    private static Connection conn = null;
    // Database info
    private static String url = "jdbc:postgresql://localhost:5454/BugTrackerDB";
    private static String user = "postgres";
    private static String password = "root";

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public Database() {

        try {
            // Try Connect to database
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // Connection status
            if(conn != null) {
                System.out.println("Connection Successful");
            }else{
                System.out.println("Connection failed");
            }

        } catch (Exception e) {
            // Print Error message to console
            System.out.println(e);
        }
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void closeConnection() {
        if(conn == null) return;
        try {
            conn.close();
            conn = null;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    public boolean execute(String sql) throws SQLException {
        if(conn == null) 
           throw new SQLException("Connection null!");

        Statement statement = conn.createStatement();
        boolean res = statement.execute(sql);
        statement.close();
        
        return res;
    }
 
    public int executeUpdate(String sql) throws SQLException {
        if(conn == null)
           throw new SQLException("Connection null!");

        Statement statement = conn.createStatement();
        int res = statement.executeUpdate(sql);
        statement.close();

        return res;
    }
 
    public ResultSet executeQuery(String sql) throws SQLException {
        if(conn == null)
           throw new SQLException("Connection null!");

        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery(sql);
        statement.close();

        return res;
    }

    // -----------------------------------
    // Employee Data Methods
    // -----------------------------------

    // Get employee data from database
    public void readEmpData(EmployeeMap map) {
        try{
            Database db = new Database();
            ResultSet resSet = db.executeQuery("SELECT * FROM employees");
            while (resSet.next()) {
                // Create Employee
                Employee emp = new Employee();
                // Store data to Employee
                emp.inputEmpID(resSet.getInt("emp_id"));
                emp.inputFirstName(resSet.getString("emp_fname"));
                emp.inputLastName(resSet.getString("emp_lname"));
                emp.inputEmail(resSet.getString("emp_email"));
                emp.inputPhoneNumber(resSet.getString("emp_phone"));
                emp.inputState(resSet.getString("emp_state"));
                emp.inputCity(resSet.getString("emp_city"));
                emp.inputPostCode(resSet.getString("emp_postcode"));
                emp.inputRole(resSet.getString("emp_role"));
                
                // save map
                map.addEmployee(map.grabEmployees() ,emp);
            }

            resSet.close();
            db.closeConnection();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert Employee to database
    public long insertEmployeeData(Employee emp) {
        long id = 0;
        // SQL statement
        String SQL = "INSERT INTO employees(emp_id, emp_fname," 
            + "emp_lname, emp_email, emp_phone, emp_state, emp_city," 
            + "emp_postcode, emp_role)"
            + "VALUES(?,?,?,?,?,?,?,?,?)";

        try(Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            
            // Get employee data
            pstmt.setInt(1, emp.grabEmpID());
            pstmt.setString(2, emp.grabFirstName());
            pstmt.setString(3, emp.grabLastName());
            pstmt.setString(4, emp.grabEmail());
            pstmt.setString(5, emp.grabPhoneNumber());
            pstmt.setString(6, emp.grabState());
            pstmt.setString(7, emp.grabCity());
            pstmt.setString(8, emp.grabPostCode());
            pstmt.setString(9, emp.grabRole());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // Edit an employees data
    public void editEmpData(Employee emp) {
        // SQL statement
        String SQL = "UPDATE employees SET emp_fname = ?, emp_lname = ?,"
            +"emp_email = ?, emp_phone = ?, emp_state = ?, emp_city = ?,"
            +"emp_postcode = ?, emp_role = ? WHERE emp_id = ?"; 

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Open database connection
            Database db = new Database();

            // Get employee data
            pstmt.setString(1, emp.grabFirstName());
            pstmt.setString(2, emp.grabLastName());
            pstmt.setString(3, emp.grabEmail());
            pstmt.setString(4, emp.grabPhoneNumber());
            pstmt.setString(5, emp.grabState());
            pstmt.setString(6, emp.grabCity());
            pstmt.setString(7, emp.grabPostCode());
            pstmt.setString(8, emp.grabRole());
            pstmt.setInt(9, emp.grabEmpID());
                        
            pstmt.executeUpdate();
            db.closeConnection();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an employee from database
    public void deleteEmpData(Employee emp) {
        String SQL = "DELETE FROM employees WHERE emp_id = ?";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Open database connection
            Database db = new Database();
                        
            pstmt.setInt(1, emp.grabEmpID());

            pstmt.executeUpdate();
            db.closeConnection();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


    // -----------------------------------
    // Bug Data Methods
    // -----------------------------------

    // Get Bug data from database
    public void readBugData(BugMap map) {
        try{
            Database db = new Database();
            ResultSet resSet = db.executeQuery("SELECT * FROM bugs");

            while (resSet.next()) {
                // Create Employee
                Bug bug = new Bug();
                // Store data to Employee
                bug.inputID(resSet.getInt("bug_id"));
                bug.inputName(resSet.getString("bug_name"));
                bug.inputType(resSet.getString("bug_type"));
                bug.inputPriority(resSet.getString("bug_priority"));
                bug.inputStatus(resSet.getString("bug_status"));
                
                // save map
                map.addBug(map.grabBugs(), bug);
            }

            resSet.close();
            db.closeConnection();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert Bug to database
    public long insertBugData(Bug bug) {
        long id = 0;
        // SQL statement
        String SQL = "INSERT INTO bugs(bug_id, bug_name," 
        + "bug_type, bug_priority, bug_status)"
        + "VALUES(?,?,?,?,?)";

        try(Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            // Get employee data
            pstmt.setInt(1, bug.grabID());
            pstmt.setString(2, bug.grabName());
            pstmt.setString(3, bug.grabType());
            pstmt.setString(4, bug.grabPriority());
            pstmt.setString(5, bug.grabStatus());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // Edit an employees data
    public void editBugData(Bug bug) {
        // SQL statement
        String SQL = "UPDATE bugs SET bug_name = ?, bug_type = ?,"
            +"bug_priority = ?, bug_status = ? WHERE emp_id = ?"; 

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Open database connection
            Database db = new Database();

            // Get employee data
            pstmt.setString(1, bug.grabName());
            pstmt.setString(2, bug.grabType());
            pstmt.setString(3, bug.grabPriority());
            pstmt.setString(4, bug.grabStatus());
            pstmt.setInt(5, bug.grabID());
                        
            pstmt.executeUpdate();
            db.closeConnection();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an bug from database
    public void deleteBugData(Bug bug) {
        String SQL = "DELETE FROM bugs WHERE bug_id = ?";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Open database connection
            Database db = new Database();
                        
            pstmt.setInt(1, bug.grabID());

            pstmt.executeUpdate();
            db.closeConnection();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    
    // Write Employee data to DB
    // public void addEmpData() {
    //     try {
    //         Database db = new Database();
    //         for (Map.Entry<Integer, Employee> next) { 
    //             db.executeUpdate("INSERT INTO employees (Key, Value) VALUES("+next.getKey()+",'"+next.getValue()+"');");
    //         }

    //         db.closeConnection();
    //     }catch(SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
};