import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import net.miginfocom.swing.MigLayout;

public class NewEmployee extends JPanel {
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
    private JButton closeButton, addEmpButton;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public NewEmployee() {
        initNewEmployee();
    }

    // Argument Constructor
    public NewEmployee(Map<Integer, Employee> employees) {
        this.employees = employees;
        initNewEmployee();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initNewEmployee() {

        // Create new Employee
        Employee newEmp = new Employee();

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Center New Window
        // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Report Section Fields/Labels
        empIDLabel = new JLabel("Employee ID:");
        empIDField = new JTextField("ex. 1");
        empIDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        empIDField.setFont(new Font("Arial", Font.PLAIN, 20));
        // empIDLabel.setBounds(50, 5, 150, 25);
        // empIDField.setBounds(50, 30, 150, 25);

        fNameLabel = new JLabel("First Name:");
        fNameField = new JTextField("ex. John");
        fNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        fNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        // fNameLabel.setBounds(250, 5, 150, 25);
        // fNameField.setBounds(250, 30, 150, 25);

        lNameLabel = new JLabel("Last Name:");
        lNameField = new JTextField("ex. Doe");
        lNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        // lNameLabel.setBounds(450, 5, 150, 25);
        // lNameField.setBounds(450, 30, 150, 25);

        emailLabel = new JLabel("Email:");
        emailField = new JTextField("ex. example@domain.com");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailField.setFont(new Font("Arial", Font.PLAIN, 20));
        // emailLabel.setBounds(50, 60, 150, 25);
        // emailField.setBounds(50, 90, 150, 25);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField("ex. 0400000000");
        phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 20));
        // phoneNumberLabel.setBounds(250, 60, 150, 25);
        // phoneNumberField.setBounds(250, 90, 150, 25);

        stateLabel = new JLabel("State:");
        stateField = new JTextField("ex. QLD");
        stateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        stateField.setFont(new Font("Arial", Font.PLAIN, 20));
        // stateLabel.setBounds(450, 60, 150, 25);
        // stateField.setBounds(450, 90, 150, 25);

        cityLabel = new JLabel("City:");
        cityField = new JTextField("ex. Toowoomba");
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        cityField.setFont(new Font("Arial", Font.PLAIN, 20));
        // cityLabel.setBounds(50, 120, 150, 25);
        // cityField.setBounds(50, 150, 150, 25);

        postCodeLabel = new JLabel("Post Code:");
        postCodeField = new JTextField("ex. 4000");
        postCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        postCodeField.setFont(new Font("Arial", Font.PLAIN, 20));
        // postCodeLabel.setBounds(250, 120, 150, 25);
        // postCodeField.setBounds(250, 150, 150, 25);

        streetAddressLabel = new JLabel("Street Address:");
        streetAddressField = new JTextField("ex. 123 Example Street");
        streetAddressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        streetAddressField.setFont(new Font("Arial", Font.PLAIN, 20));
        // streetAddressLabel.setBounds(450, 120, 150, 25);
        // streetAddressField.setBounds(450, 150, 150, 25);

        // Top Row
        this.add(empIDLabel, "label align");
        this.add(empIDField, "grow");
        this.add(fNameLabel, "label align");
        this.add(fNameField, "grow");
        this.add(lNameLabel, "label align");
        this.add(lNameField, "wrap");
        // 2nd Row
        this.add(emailLabel, "label align");
        this.add(emailField, "grow");
        this.add(phoneNumberLabel, "label align");
        this.add(phoneNumberField);
        this.add(stateLabel, "label align");
        this.add(stateField, "wrap");
        // 3rd Row
        this.add(cityLabel, "label align");
        this.add(cityField);
        this.add(postCodeLabel, "label align");
        this.add(postCodeField);
        this.add(streetAddressLabel, "label align");
        this.add(streetAddressField, "wrap");

        // Add Employee Button
        addEmpButton = new JButton("Save & Close");
        addEmpButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addEmpButton.setBounds(250, 495, 150, 25);
        this.add(addEmpButton, "span 3");

        // Close Button
        closeButton = new JButton("Close Window");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton, "span 3");

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Add Employee Button
        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addValues(newEmp);
                FileOutput output = new FileOutput(employees);
                // dispose();
            }
        });

        // Close Button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(newEmp.grabEmpID());
                FileOutput output = new FileOutput(employees);
                // dispose();
            }
        });

        // this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    private void addValues(Employee newEmp) {
        newEmp.empIDValid(empIDField.getText());
        newEmp.fnameValid(fNameField.getText());
        newEmp.lnameValid(lNameField.getText());
        newEmp.emailValid(emailField.getText());
        newEmp.phoneNumberValid(phoneNumberField.getText());
        newEmp.stateValid(stateField.getText());
        newEmp.cityValid(cityField.getText());
        newEmp.postCodeValid(postCodeField.getText());
        // newEmp.roleValid(roleValid.getText());

        employees.put(newEmp.grabEmpID(), newEmp);

    }

}
