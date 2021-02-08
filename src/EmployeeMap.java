import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EmployeeMap {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Map<Integer, Employee> employees;
    private Set<Map.Entry<Integer, Employee>> entries;
    private Iterator<Map.Entry<Integer, Employee>> iterator;
    private Map.Entry<Integer, Employee> entry;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EmployeeMap() {
        employees = new HashMap<Integer, Employee>();
    }

    // Argument Constructor
    public EmployeeMap(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters
    private void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }
    private Map<Integer, Employee> getEmployees() {
        return employees;
    }
    public void inputEmployees(Map<Integer, Employee> employees) {
        setEmployees(employees);
    }
    public Map<Integer, Employee> grabEmployees() {
        return getEmployees();
    }

    // Insert Employees to Map
    public void addEmployee(Map<Integer, Employee> map, Employee emp) {
        // map = getEmployees();
        map.put(emp.grabEmpID(), emp);
    }
}
