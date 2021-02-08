import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import net.miginfocom.swing.MigLayout;

public class EditEmployee extends JPanel {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel empIDLabel, fNameLabel, lNameLabel, emailLabel, phoneNumberLabel,
            stateLabel, cityLabel, postCodeLabel, streetAddressLabel, roleLabel;
    private JTextField empIDField, fNameField, lNameField, emailField, phoneNumberField,
            stateField, cityField, postCodeField, streetAddressField, roleField;
    // Buttons
    private JButton closeButton, saveButton;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;
    private Employee emp;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EditEmployee() {
        initEditEmp();
    }

    // Default Constructor
    public EditEmployee(Map<Integer, Employee> employee, Employee emp) {
        this.employees = employee;
        this.emp = emp;
        // Initialise Form
        initEditEmp();
        // Fill fields with employee data
        showEmployee(emp);
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initEditEmp() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Report Section Fields/Labels
        empIDLabel = new JLabel("Employee ID:");
        empIDField = new JTextField("ex. 1");
        empIDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        empIDField.setFont(new Font("Arial", Font.PLAIN, 20));

        fNameLabel = new JLabel("First Name:");
        fNameField = new JTextField("ex. John");
        fNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        fNameField.setFont(new Font("Arial", Font.PLAIN, 20));

        lNameLabel = new JLabel("Last Name:");
        lNameField = new JTextField("ex. Doe");
        lNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lNameField.setFont(new Font("Arial", Font.PLAIN, 20));

        emailLabel = new JLabel("Email:");
        emailField = new JTextField("ex. example@domain.com");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailField.setFont(new Font("Arial", Font.PLAIN, 20));

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField("ex. 0400000000");
        phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 20));

        roleLabel = new JLabel("Job Role:");
        roleField = new JTextField("ex. Programmer");
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        roleField.setFont(new Font("Arial", Font.PLAIN, 20));

        stateLabel = new JLabel("State:");
        stateField = new JTextField("ex. QLD");
        stateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        stateField.setFont(new Font("Arial", Font.PLAIN, 20));

        cityLabel = new JLabel("City:");
        cityField = new JTextField("ex. Toowoomba");
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        cityField.setFont(new Font("Arial", Font.PLAIN, 20));

        postCodeLabel = new JLabel("Post Code:");
        postCodeField = new JTextField("ex. 4000");
        postCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        postCodeField.setFont(new Font("Arial", Font.PLAIN, 20));

        streetAddressLabel = new JLabel("Street Address:");
        streetAddressField = new JTextField("ex. 123 Example Street");
        streetAddressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        streetAddressField.setFont(new Font("Arial", Font.PLAIN, 20));

        // Top Row
        // this.add(empIDLabel, "label align");
        // this.add(empIDField, "grow");
        // 1st Row
        this.add(fNameLabel, "label align, right");
        this.add(fNameField, "grow");
        this.add(lNameLabel, "label align, right");
        this.add(lNameField, "grow, wrap 50");
        // 2nd Row
        this.add(emailLabel, "label align, right");
        this.add(emailField, "grow");
        this.add(phoneNumberLabel, "label align, right");
        this.add(phoneNumberField, "grow, wrap 50");
        // 3rd Row
        this.add(roleLabel, "label align, right");
        this.add(roleField, "grow");
        this.add(stateLabel, "label align, right");
        this.add(stateField, "grow, wrap 50");

        // 4th Row
        this.add(postCodeLabel, "label align, right");
        this.add(postCodeField, "grow");
        this.add(cityLabel, "label align, right");
        this.add(cityField, "grow, wrap 50");

        // Close Button
        closeButton = new JButton("Cancel");
        closeButton = Style.styleButton(closeButton, 20);
        closeButton = Style.hover(closeButton);
        this.add(closeButton, "span 2, align left");

        // Save Button
        saveButton = new JButton("Save Data");
        saveButton = Style.styleButton(saveButton, 20);
        saveButton = Style.hover(saveButton);
        this.add(saveButton, "span 2, align right");

        // -----------------------------------
        // Listeners
        // -----------------------------------
        // Save Edited Employee
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open database
                Database db = new Database();
                // Save New Employee Data
                addValues(emp);
                db.editEmpData(emp);

                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                
                // Add Form panel
                ViewEmployee form = new ViewEmployee(employees);
                add(form);
                repaint();
                revalidate();
            }
        });

        // Close Button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                
                // Add Form panel
                ViewEmployee form = new ViewEmployee(employees);
                add(form);
                repaint();
                revalidate();
            }
        });

        this.setVisible(true);
    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    private void showEmployee(Employee entry) {
        // Fill employee data in fields
        empIDField.setText(entry.grabEmpID().toString());
        fNameField.setText(entry.grabFirstName());
        lNameField.setText(entry.grabLastName());
        emailField.setText(entry.grabEmail());
        phoneNumberField.setText(entry.grabPhoneNumber());
        stateField.setText(entry.grabState());
        cityField.setText(entry.grabCity());
        postCodeField.setText(entry.grabPostCode());
        roleField.setText(entry.grabRole());

    }

    private void addValues(Employee entry) {
        entry.empIDValid(entry.grabEmpID());
        entry.fnameValid(fNameField.getText());
        entry.lnameValid(lNameField.getText());
        entry.emailValid(emailField.getText());
        entry.phoneNumberValid(phoneNumberField.getText());
        entry.stateValid(stateField.getText());
        entry.cityValid(cityField.getText());
        entry.postCodeValid(postCodeField.getText());
        entry.roleValid(roleField.getText());
    }

}
