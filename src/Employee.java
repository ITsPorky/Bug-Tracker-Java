// Employee Class
import javax.swing.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.sql.*;

public class Employee {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Integer empID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String state;
    private String city;
    private String postCode;
    private String role;
    
    // private Map.Entry<Integer, Employee> next;
    // private Map.Entry<Integer, Employee> previous;
    // Validation Scanner
    Scanner sc = new Scanner(System.in);

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public Employee() {
        empID = 0;
        firstName = "";
        lastName = "";
        email = "";
        phoneNumber = "";
        state = "";
        city = "";
        postCode = "";
        role = "";
    }

    // Agument constructor
    public Employee(Integer empID,
                    String firstName, 
                    String lastName,
                    String email,
                    String phoneNumber,
                    String state, 
                    String city,
                    String postCode,
                    String role) {
        setEmpID(empID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setState(state);
        setCity(city);
        setPostCode(postCode);
        setRole(role);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters

    // Employee ID
    private void setEmpID(Integer empID) {
        this.empID = empID;
    }
    private Integer getEmpID() {
        return empID;
    }
    public void inputEmpID(Integer empID) {
        setEmpID(empID);
    }
    public Integer grabEmpID() {
        return getEmpID();
    }

    // First Name
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private String getFirstName() {
        return firstName;
    }
    public void inputFirstName(String firstName) {
        setFirstName(firstName);
    }
    public String grabFirstName() {
        return getFirstName();
    }

    // Last Name
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private String getLastName() {
        return lastName;
    }
    public void inputLastName(String lastName) {
        setLastName(lastName);
    }
    public String grabLastName() {
        return getLastName();
    }

    // Email
    private void setEmail(String email) {
        this.email = email;
    }
    private String getEmail() {
        return email;
    }
    public void inputEmail(String email) {
        setEmail(email);
    }
    public String grabEmail() {
        return getEmail();
    }

    // Phone Number
    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    private String getPhoneNumber() {
        return phoneNumber;
    }
    public void inputPhoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }
    public String grabPhoneNumber() {
        return getPhoneNumber();
    }

    // State
    private void setState(String state) {
        this.state = state;
    }
    private String getState() {
        return state;
    }
    public void inputState(String state) {
        setState(state);
    }
    public String grabState() {
        return getState();
    }

    // City
    private void setCity(String city) {
        this.city = city;
    }
    private String getCity() {
        return city;
    }
    public void inputCity(String city) {
        setCity(city);
    }
    public String grabCity() {
        return getCity();
    }

    // PostCode
    private void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    private String getPostCode() {
        return postCode;
    }
    public void inputPostCode(String postCode) {
        setPostCode(postCode);
    }
    public String grabPostCode() {
        return getPostCode();
    }

    // Role
    private void setRole(String role) {
        this.role = role;
    }
    private String getRole() {
        return role;
    }
    public void inputRole(String role) {
        setRole(role);
    }
    public String grabRole() {
        return getRole();
    }

    // Validation Methods

    // Employee ID Valid
    public void empIDValid(int input) {
        boolean flag;
        do {
            // int IDPattern = "[0-9]{1,25}";
            // flag = input.matches(IDPattern);
            if (input == (int)input) {
                System.out.println("Invalid Employee ID");
                JPopupMenu error = new JPopupMenu("Error: Invalid Input");

                break;
            }
        } while (input == (int)input);
        System.out.println("Valid Employee ID");
        System.out.println("The Employee ID " + input + " has been set\n");

        setEmpID(input);
    }

    // First Name Validation
    public void fnameValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid first name");
        } while (!flag);
        System.out.println("Valid first name");
        System.out.println("The first name " + input + " has been set\n");
        
        setFirstName(input);
    }

    // Last Name Validation
    public void lnameValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid last name");
        } while (!flag);
        System.out.println("Valid last name");
        System.out.println("The last name " + input + " has been set\n");
        
        setLastName(input);
    }

    // Email Validation
    public void emailValid(String input) {
        boolean flag;
        do {
            String emailPattern = "[a-zA-Z0-9.\\s]{3,15}@[a-zA-Z0-9\\s]{3,15}[.\\s][a-zA-Z\\s]{2,5}";
            flag = input.matches(emailPattern);
            if (!flag) System.out.println("Invalid email");
        } while (!flag);
        System.out.println("Valid email");
        System.out.println("The email " + input + " has been set\n");

        setEmail(input);
    }

    // Phone Number Validation
    public void phoneNumberValid(String input) {
        boolean flag;
        do {
            String phonePattern = "[0-9\\s]{10}";
            flag = input.matches(phonePattern);
            if(!flag) System.out.println("Invalid phone number");
        } while (!flag);
        System.out.println("Valid phone number");
        System.out.println("The phone number " + input + " has been set\n");
        
        setPhoneNumber(input);
    }

    // State Validation
    public void stateValid(String input) {
        boolean flag;
        do {
            String statePattern = "[A-Z\\s]{2,4}";
            flag = input.matches(statePattern);
            if (!flag) System.out.println("Invalid state");
        } while (!flag);
        System.out.println("Valid state");
        System.out.println("The state " + input + " has been set\n");
        
        setState(input);
    }

    // City Validation
    public void cityValid(String input) {
        boolean flag;
        do {
            String cityPattern = "[a-zA-Z\\s]{1,25}";
            flag = input.matches(cityPattern);
            if (!flag) System.out.println("Invalid city");
        } while (!flag);
        System.out.println("Valid city");
        System.out.println("The city " + input + " has been set\n");
        
        setCity(input);
    }

    // Post Code validation
    public void postCodeValid(String input) {
        boolean flag;
        do {
            String postCodePattern = "[0-9\\s]{4}";
            flag = input.matches(postCodePattern);
            if (!flag) System.out.println("Invalid post code");
        } while (!flag);
        System.out.println("Valid post code");
        System.out.println("The post code " + input + " has been set\n");
        
        setPostCode(input);
    }

    // Role Validatiion
    public void roleValid(String input) {
        boolean flag;
        do {
            String rolePattern = "[a-zA-Z\\s]{1,25}";
            flag = input.matches(rolePattern);
            if (!flag) System.out.println("Invalid role");
        } while (!flag);
        System.out.println("Valid role");
        System.out.println("The role " + input + " has been set\n");
        
        setRole(input);
    }

    // Output Of Employee Objects 
    @Override
    public String toString() {
        return getEmpID() + "\n" +
         getFirstName() + "\n" + 
         getLastName() + "\n" +
         getEmail() + "\n" +
         getPhoneNumber() + "\n" + 
         getState() + "\n" + 
         getCity() + "\n" + 
         getPostCode() + "\n" + 
         getRole() + "\n";
    }
    
}