import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class FileInput {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private String filePath;
    private File employeeFile;
    private Scanner scan;

    private Map<Integer, Employee> employees;

    private JLabel errorMsg = new JLabel("Error!");

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // GUI Constructor
    public FileInput(String path, Map<Integer, Employee> employee) {
        this.filePath = path;
        this.employees = employee;
        employeeFile = new File(filePath + "\\Data.txt");
        // gather class info
        try {
            readEmployees(employeeFile);
            // outputEmployees(outputFile);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        closeFile(scan);
    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    // Reads Employee data into memory
    private void readEmployees(File file) throws FileNotFoundException {
        scan = new Scanner(new FileInputStream(file));
        String validation = "";
        // Employee Data
        String firstName, lastName, email, phone, state, city, postCode, streetName;
        Integer empID;

        while (scan.hasNextLine()) {
            // Get Employee Data
            empID = intTest(scan.nextLine());
            if (empID == null)
                break;

            firstName = scan.nextLine();
            lastName = scan.nextLine();
            email = scan.nextLine();
            phone = scan.nextLine();
            state = scan.nextLine();
            city = scan.nextLine();
            postCode = scan.nextLine();
            streetName = scan.nextLine();

            Employee employee = new Employee(empID, firstName, lastName, email, phone, state, city, postCode, streetName);

            if (scan.hasNextLine())
                validation = scan.nextLine();
            else {
                employees.put(empID, employee);
                break;
            }

            employees.put(empID, employee);
        }
    }

    // Test if int
    private Integer intTest(String num) {
        Integer i;

        try {
            i = Integer.parseInt(num);
        } catch (NumberFormatException notNum) {
            errorMsg.setText("Number format exception: \"" + num + "\" is not a number.");
            return null;
        }

        return i;
    }

    // Close File scan
    private void closeFile(Scanner sc) {
        sc.close();
    }

    // -----------------------------------
    // Setters and Getters
    // -----------------------------------

    private File getEmployeeFile() {
        return employeeFile;
    }
    public File grabEmployeeFile() {
        return getEmployeeFile();
    }

}
