import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EditEmployee extends JFrame {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel empIDLabel, fNameLabel, lNameLabel, emailLabel, phoneNumberLabel,
            stateLabel, cityLabel, postCodeLabel, streetAddressLabel;
    private JTextField empIDField, fNameField, lNameField, emailField, phoneNumberField,
            stateField, cityField, postCodeField, streetAddressField;
    // Buttons
    private JButton closeButton, saveButton;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EditEmployee() {
        initEditEmp();
    }

    // Default Constructor
    public EditEmployee(Map<Integer, Employee> employee, Map.Entry<Integer, Employee> entryEmp) {
        this.employees = employee;
        this.entry = entryEmp;
        // Initialise Form
        initEditEmp();
        // Fill fields with employee data
        showEmployee(entry);
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initEditEmp() {

        // Main Panel Contents
        this.setLayout(null);
        this.setTitle("Employee Software Tracker | Edit Employee");
        this.setSize(675, 600);

        // Center New Window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Report Section Fields/Labels
        empIDLabel = new JLabel("Employee ID:");
        empIDField = new JTextField("ex. 1");
        empIDField.setFont(new Font("Arial", Font.PLAIN, 12));
        empIDLabel.setBounds(50, 5, 150, 25);
        empIDField.setBounds(50, 30, 150, 25);

        fNameLabel = new JLabel("First Name:");
        fNameField = new JTextField("ex. John");
        fNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        fNameLabel.setBounds(250, 5, 150, 25);
        fNameField.setBounds(250, 30, 150, 25);

        lNameLabel = new JLabel("Last Name:");
        lNameField = new JTextField("ex. Doe");
        lNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        lNameLabel.setBounds(450, 5, 150, 25);
        lNameField.setBounds(450, 30, 150, 25);

        emailLabel = new JLabel("Email:");
        emailField = new JTextField("ex. example@domain.com");
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        emailLabel.setBounds(50, 60, 150, 25);
        emailField.setBounds(50, 90, 150, 25);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField("ex. 04xxxxxxxx");
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 12));
        phoneNumberLabel.setBounds(250, 60, 150, 25);
        phoneNumberField.setBounds(250, 90, 150, 25);

        stateLabel = new JLabel("State:");
        stateField = new JTextField("QLD");
        stateField.setFont(new Font("Arial", Font.PLAIN, 12));
        stateLabel.setBounds(450, 60, 150, 25);
        stateField.setBounds(450, 90, 150, 25);

        cityLabel = new JLabel("City:");
        cityField = new JTextField("ex. Toowoomba");
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        cityLabel.setBounds(50, 120, 150, 25);
        cityField.setBounds(50, 150, 150, 25);

        postCodeLabel = new JLabel("Post Code:");
        postCodeField = new JTextField("ex. 4000");
        postCodeField.setFont(new Font("Arial", Font.PLAIN, 12));
        postCodeLabel.setBounds(250, 120, 150, 25);
        postCodeField.setBounds(250, 150, 150, 25);

        streetAddressLabel = new JLabel("Street Address:");
        streetAddressField = new JTextField("ex. 123 Example Street");
        streetAddressField.setFont(new Font("Arial", Font.PLAIN, 12));
        streetAddressLabel.setBounds(450, 120, 150, 25);
        streetAddressField.setBounds(450, 150, 150, 25);

        // Top Row
        this.add(empIDLabel);
        this.add(fNameLabel);
        this.add(lNameLabel);
        this.add(empIDField);
        this.add(fNameField);
        this.add(lNameField);
        // 2nd Row
        this.add(emailLabel);
        this.add(phoneNumberLabel);
        this.add(stateLabel);
        this.add(emailField);
        this.add(phoneNumberField);
        this.add(stateField);
        // 3rd Row
        this.add(cityLabel);
        this.add(postCodeLabel);
        this.add(streetAddressLabel);
        this.add(cityField);
        this.add(postCodeField);
        this.add(streetAddressField);

        // Save Button
        saveButton = new JButton("Save Data");
        saveButton.setBounds(250, 495, 150, 25);
        this.add(saveButton);

        // Close Button
        closeButton = new JButton("Close Window");
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton);

        // -----------------------------------
        // Listeners
        // -----------------------------------
        // Save Edited Employee
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addValues(entry);
                FileOutput output = new FileOutput(employees);
                dispose();
            }
        });

        // Close Button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutput output = new FileOutput(employees);
                dispose();
            }
        });

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    private void showEmployee(Map.Entry<Integer, Employee> entry) {
        // Fill employee data in fields
        empIDField.setText(entry.getValue().grabEmpID().toString());
        fNameField.setText(entry.getValue().grabFirstName());
        lNameField.setText(entry.getValue().grabLastName());
        emailField.setText(entry.getValue().grabEmail());
        phoneNumberField.setText(entry.getValue().grabPhoneNumber());
        stateField.setText(entry.getValue().address.grabState());
        cityField.setText(entry.getValue().address.grabCity());
        postCodeField.setText(entry.getValue().address.grabPostCode());
        streetAddressField.setText(entry.getValue().address.grabStreetAddress());

    }

    private void addValues(Map.Entry<Integer, Employee> entry) {
        entry.getValue().empIDValid(empIDField.getText());
        entry.getValue().fnameValid(fNameField.getText());
        entry.getValue().lnameValid(lNameField.getText());
        entry.getValue().emailValid(emailField.getText());
        entry.getValue().phoneNumberValid(phoneNumberField.getText());
        entry.getValue().address.stateValid(stateField.getText());
        entry.getValue().address.cityValid(cityField.getText());
        entry.getValue().address.postCodeValid(postCodeField.getText());
        entry.getValue().address.streetAddressValid(streetAddressField.getText());
    }

}
