// Form Class
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import java.awt.*;

public class ViewEmployee extends JPanel {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Page Title
    private JLabel pageTitle;
    // Employee Labels/Fields
    private JLabel empIDLabel, fNameLabel, lNameLabel, emailLabel, phoneNumberLabel,
            stateLabel, cityLabel, postCodeLabel, roleLabel;
    private JLabel empIDField, fNameField, lNameField, emailField, phoneNumberField,
            stateField, cityField, postCodeField, roleField;
    private JTextField searchEmp;
    // Buttons
    private JButton addEmpButton,
            editEmpButton, deleteEmpButton;
    // Scrollpane
    private JScrollPane scrollPane;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Set<Map.Entry<Integer, Employee>> entries;
    private Iterator<Map.Entry<Integer, Employee>> iterator;
    private Map.Entry<Integer, Employee> entry;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public ViewEmployee() {
        employees = new HashMap<Integer, Employee>();
        entries = employees.entrySet();
        iterator = entries.iterator();
        initForm();
    }

    // Argument Constructor
    public ViewEmployee(Map<Integer, Employee> employees) {
        this.employees = employees;
        entries = employees.entrySet();
        iterator = entries.iterator();
        // Initialise Form
        initForm();
        // Fill fields with employee data
        // showEmployee();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initForm() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Page Title
        pageTitle = new JLabel("Employees");
        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
        this.add(pageTitle, "wrap 50");

        // center contents
        JTable table = generateEmployeeTable();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new DimensionUIResource(1128, 700));
        this.add(scrollPane, "wrap, span");

        // Delete Employee Button
        deleteEmpButton = new JButton("Delete Employee");
        deleteEmpButton = Style.styleButton(deleteEmpButton, 20);
        deleteEmpButton = Style.hover(deleteEmpButton);
        this.add(deleteEmpButton, "align left");

        // Add Employee Button
        addEmpButton = new JButton("Add Employee");
        addEmpButton = Style.styleButton(addEmpButton, 20);
        addEmpButton = Style.hover(addEmpButton);
        this.add(addEmpButton, "align left");

        // Edit Employee Button
        editEmpButton = new JButton("Edit Employee");
        editEmpButton = Style.styleButton(editEmpButton, 20);
        editEmpButton = Style.hover(editEmpButton);
        this.add(editEmpButton, "wrap, align right");

        // Make table elements hoverable
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseMoved(java.awt.event.MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row > -1) {
                    // easiest way:
                    table.clearSelection();
                    table.setRowSelectionInterval(row, row);
                }
                else {
                    table.setSelectionBackground(Color.blue);
                }
            }
        });


        // -----------------------------------
        // Listeners
        // -----------------------------------

        // // Search Field
        // searchEmp.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         Integer userInput = Integer.parseInt(searchEmp.getText());
        //         if(entry.getValue().grabEmpID() < userInput) {
        //             while (entry.getValue().grabEmpID() < userInput) {
        //                 if (iterator.hasNext()) {
        //                     entry.getValue().next = iterator.next();
        //                     entry.getValue().next.getValue().previous = entry;
        //                 }
        //                 if (entry.getValue().next != null) {
        //                     entry = entry.getValue().next;
        //                     showEmployee();
        //                 }
        //             }
        //         }else if(entry.getValue().grabEmpID() > userInput) {
        //             while (entry.getValue().grabEmpID() > userInput) {
        //                 if (entry.getValue().previous != null) {
        //                     entry = entry.getValue().previous;
        //                     showEmployee();
        //                 }
        //             }
        //         }
        //         // Update search box number
        //         searchEmp.setText(entry.getValue().grabEmpID().toString());
        //     }
        // });

        // Add Employee Button
        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                // Get Employee data
                Database db = new Database();
                // Add Form panel
                NewEmployee employee = new NewEmployee(employees);
                add(employee);
                repaint();
                revalidate();
            }
        });

        // Edit Employee Button
        editEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                Integer id = Integer.parseInt(value);
                Employee emp = employees.get(id);
                EditEmployee editEmp = new EditEmployee(employees, emp);
                add(editEmp);
                repaint();
                revalidate();
            }
        });

        // Delete Employee Button
        deleteEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                // Get Employee data
                Database db = new Database();
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                Integer id = Integer.parseInt(value);
                Employee emp = employees.get(id);
                // Remove from database
                db.deleteEmpData(emp);
                // Remove from hashmap
                employees.remove(emp.grabEmpID());
                ViewEmployee form = new ViewEmployee(employees);
                add(form);
                repaint();
                revalidate();
            }
        });

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Hovering elements of the table
        // table.addMouseListener(new java.awt.event.MouseAdapter() {

        //     int hoveredRow;
        //     int hoveredColumn;
        //     @Override
        //     public void mouseMoved(java.awt.event.MouseEvent e) {
        //         Point p = e.getPoint();
        //         hoveredRow = table.rowAtPoint(p);
        //         hoveredColumn = table.columnAtPoint(p);
        //         table.setRowSelectionInterval(hoveredRow, hoveredRow);
        //         table.repaint();    
        //     }
        //     @Override
        //     public void mouseDragged(java.awt.event.MouseEvent e) {
        //         hoveredRow = hoveredColumn = -1;
        //         table.repaint();
        //     }
        // });

        // this.setLocationRelativeTo(null);
        // this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // public void showEmployee() {
    //     // Fill employee data in fields
    //     empIDField.setText(entry.getValue().grabEmpID().toString());
    //     fNameField.setText(entry.getValue().grabFirstName());
    //     lNameField.setText(entry.getValue().grabLastName());
    //     emailField.setText(entry.getValue().grabEmail());
    //     phoneNumberField.setText(entry.getValue().grabPhoneNumber());
    //     stateField.setText(entry.getValue().grabState());
    //     cityField.setText(entry.getValue().grabCity());
    //     postCodeField.setText(entry.getValue().grabPostCode());
    //     roleField.setText(entry.getValue().grabRole());

    //     // displaySoftware();
    //     // scrPane.repaint();
    // }

    public JTable generateEmployeeTable() {
        // Column names
        String[] columnNames = {"ID:", "Name:", "Email:", "Phone:", 
                "State:", "City:", "PostCode:", "Role:"};
        
        // for(int i = 0; i < columnNames.length; i++) {
        //     columnNames[i].setFont(new Font("Helvetica", Font.BOLD, 20));
        // }
        
        // Table employee data
        Object[][] data = new Object[employees.size()][8];
        int i = 0;
        while(iterator.hasNext()) {
            // Get employee data
            entry = iterator.next();
            // Insert employee data into array
            data[i] [0] = entry.getValue().grabEmpID().toString();
            data[i] [1] = entry.getValue().grabFirstName() + 
            " " + entry.getValue().grabLastName();
            data[i] [2] = entry.getValue().grabEmail();
            data[i] [3] = entry.getValue().grabPhoneNumber();
            data[i] [4] = entry.getValue().grabState();
            data[i] [5] = entry.getValue().grabCity();
            data[i] [6] = entry.getValue().grabPostCode();
            data[i] [7] = entry.getValue().grabRole();
            // Increment
            i++;
        }

        JTable table = new JTable(data, columnNames);
        table = Style.table(table);

        // Resize table fields
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getColumnModel().getColumn(3).setPreferredWidth(125);
        table.getColumnModel().getColumn(4).setPreferredWidth(75);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(75);
        table.getColumnModel().getColumn(7).setPreferredWidth(250);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);

        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        return table;
    }

    // Check empID exists
    public void checkEmpID() {
        
    }

}