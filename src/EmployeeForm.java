// Form Class
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class EmployeeForm extends JPanel {
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
            editEmpButton;

    // Employee Map
    private Map<Integer, Employee> employees;
    private Set<Map.Entry<Integer, Employee>> entries;
    private Iterator<Map.Entry<Integer, Employee>> iterator;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EmployeeForm() {
        employees = new HashMap<Integer, Employee>();
        entries = employees.entrySet();
        iterator = entries.iterator();
        initForm();
    }

    // Argument Constructor
    public EmployeeForm(Map<Integer, Employee> employees) {
        this.employees = employees;
        entries = employees.entrySet();
        iterator = entries.iterator();
        entry = iterator.next();
        // Initialise Form
        initForm();
        // Fill fields with employee data
        showEmployee();
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
        this.add(pageTitle, "north, wrap 40, grow");

        // Report Section Fields/Labels
        empIDLabel = new JLabel("Employee ID:");
        empIDLabel = Style.title(empIDLabel);
        empIDField = new JLabel("ex. 1");
        empIDField = Style.label(empIDField);

        fNameLabel = new JLabel("Name:");
        fNameLabel = Style.title(fNameLabel);
        fNameField = new JLabel();
        fNameField = Style.label(fNameField);

        lNameLabel = new JLabel("Last Name:");
        lNameLabel = Style.title(lNameLabel);
        lNameField = new JLabel();
        lNameField = Style.label(lNameField);

        emailLabel = new JLabel("Email:");
        emailLabel = Style.title(emailLabel);
        emailField = new JLabel();
        emailField = Style.label(emailField);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel = Style.title(phoneNumberLabel);
        phoneNumberField = new JLabel();
        phoneNumberField = Style.label(phoneNumberField);

        stateLabel = new JLabel("State:");
        stateLabel = Style.title(stateLabel);
        stateField = new JLabel();
        stateField = Style.label(stateField);

        cityLabel = new JLabel("City:");
        cityLabel = Style.title(cityLabel);
        cityField = new JLabel();
        cityField = Style.label(cityField);

        postCodeLabel = new JLabel("Post Code:");
        postCodeLabel = Style.title(postCodeLabel);
        postCodeField = new JLabel();
        postCodeField = Style.label(postCodeField);

        roleLabel = new JLabel("Role:");
        roleLabel = Style.title(roleLabel);
        roleField = new JLabel();
        roleField = Style.label(roleField);

        // Title headings for list
        this.add(empIDLabel, "gapright 10, grow 10");
        this.add(fNameLabel, "gapright 10, grow");
        this.add(lNameLabel, "gapright 10, grow");
        this.add(emailLabel, "gapright 10, grow");
        this.add(phoneNumberLabel, "gapright 10, grow");
        this.add(stateLabel, "gapright 10, grow");
        this.add(cityLabel, "gapright 10, grow");
        this.add(postCodeLabel, "gapright 10, grow");
        this.add(roleLabel, "gapright 10, wrap");

        // Scroll pane for employees
        
        while(iterator.hasNext()) {
            // Increment Iterator
            entry = iterator.next();

            // Create labels
            empIDField = new JLabel();
            empIDField.setFont(new Font("Arial", Font.PLAIN, 16));
            fNameField = new JLabel();
            fNameField.setFont(new Font("Arial", Font.PLAIN, 16));
            lNameField = new JLabel();
            lNameField.setFont(new Font("Arial", Font.PLAIN, 16));
            emailField = new JLabel();
            emailField.setFont(new Font("Arial", Font.PLAIN, 16));
            phoneNumberField = new JLabel();
            phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
            stateField = new JLabel();
            stateField.setFont(new Font("Arial", Font.PLAIN, 16));
            cityField = new JLabel();
            cityField.setFont(new Font("Arial", Font.PLAIN, 16));
            postCodeField = new JLabel();
            postCodeField.setFont(new Font("Arial", Font.PLAIN, 16));
            roleField = new JLabel();
            roleField.setFont(new Font("Arial", Font.PLAIN, 16));

            // Employee data for list
            this.add(empIDField, "grow");
            this.add(fNameField, "grow");
            this.add(lNameField, "grow");
            this.add(emailField, "grow");
            this.add(phoneNumberField, "grow");
            this.add(stateField, "grow");
            this.add(cityField, "grow");
            this.add(postCodeField, "grow");
            this.add(roleField, "wrap");

            // Fill fields with data
            showEmployee();
        }

        // Scroll Pane for Employee Software
        // scrPane = new JScrollPane(softwareForm);
        // scrPane.setBounds(0, 200, 660, 215);
        // scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // this.add(scrPane);

        // // Search Employee
        // searchEmp = new JTextField("");
        // searchEmp.setText(entry.getValue().grabEmpID().toString());
        // searchEmp.setBounds(315, 425, 20, 25);
        // this.add(searchEmp);

        // Add Employee Button
        addEmpButton = new JButton("Add Employee");
        addEmpButton = Style.styleButton(addEmpButton, 20);
        addEmpButton = Style.hover(addEmpButton);
        this.add(addEmpButton);

        // Edit Employee Button
        editEmpButton = new JButton("Edit Employee");
        editEmpButton = Style.styleButton(editEmpButton, 20);
        editEmpButton = Style.hover(editEmpButton);
        this.add(editEmpButton);


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
                NewEmployee newEmp = new NewEmployee(employees);
                // dispose();
            }
        });

        // Edit Employee Button
        editEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditEmployee editEmp = new EditEmployee(employees, entry);
                // dispose();
            }
        });

        // this.setLocationRelativeTo(null);
        // this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    public void showEmployee() {
        // Fill employee data in fields
        empIDField.setText(entry.getValue().grabEmpID().toString());
        fNameField.setText(entry.getValue().grabFirstName());
        lNameField.setText(entry.getValue().grabLastName());
        emailField.setText(entry.getValue().grabEmail());
        phoneNumberField.setText(entry.getValue().grabPhoneNumber());
        stateField.setText(entry.getValue().grabState());
        cityField.setText(entry.getValue().grabCity());
        postCodeField.setText(entry.getValue().grabPostCode());
        roleField.setText(entry.getValue().grabRole());

        // displaySoftware();
        // scrPane.repaint();
    }

    public void generateTable() {
        

    }

}