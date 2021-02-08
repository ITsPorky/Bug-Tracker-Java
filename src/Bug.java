import javax.swing.*;
import java.util.Scanner;

public class Bug {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Integer ID;
    private String name;
    private String type;
    private String priority;
    private String status;

    // Validation Scanner
    Scanner sc = new Scanner(System.in);

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public Bug() {
        ID = 0;
        name = "";
        type = "";
        priority = "";
        status = "";
    }

    // Argument Constructor
    public Bug(Integer ID, 
            String name, 
            String type, 
            String priority, 
            String status) {
        setID(ID);
        setName(name);
        setType(type);
        setPriority(priority);
        setStatus(status);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters

    // ID
    private void setID(Integer ID) {
        this.ID = ID;
    }
    private Integer getID() {
        return ID;
    }
    public void inputID(Integer ID) {
        setID(ID);
    }
    public Integer grabID() {
        return getID();
    }

    // Name
    private void setName(String name) {
        this.name = name;
    }
    private String getName() {
        return name;
    }
    public void inputName(String name) {
        setName(name);
    }
    public String grabName() {
        return getName();
    }

    // Type
    private void setType(String type) {
        this.type = type;
    }
    private String getType() {
        return type;
    }
    public void inputType(String type) {
        setName(type);
    }
    public String grabType() {
        return getType();
    }

    // Priority
    private void setPriority(String priority) {
        this.priority = priority;
    }
    private String getPriority() {
        return priority;
    }
    public void inputPriority(String priority) {
        setName(priority);
    }
    public String grabPriority() {
        return getPriority();
    }

    // Status
    private void setStatus(String status) {
        this.status = status;
    }
    private String getStatus() {
        return status;
    }
    public void inputStatus(String status) {
        setStatus(status);
    }
    public String grabStatus() {
        return getStatus();
    }

    // Validation Methods

    // ID Valid
    public void IDValid(int input) {
        boolean flag;
        do {
            // int IDPattern = "[0-9]{1,25}";
            // flag = input.matches(IDPattern);
            if (input == (int)input) {
                System.out.println("Invalid ID");
                JPopupMenu error = new JPopupMenu("Error: Invalid Input");

                break;
            }
        } while (input == (int)input);
        System.out.println("Valid ID");
        System.out.println("The ID " + input + " has been set\n");

        setID(input);
    }

    // Name Validation
    public void nameValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z1-9\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid name");
        } while (!flag);
        System.out.println("Valid name");
        System.out.println("The name " + input + " has been set\n");
        
        setName(input);
    }

    // Type Validation
    public void typeValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z1-9\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid type");
        } while (!flag);
        System.out.println("Valid type");
        System.out.println("The type " + input + " has been set\n");
        
        setType(input);
    }

    // Priority Validation
    public void priorityValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid priority");
        } while (!flag);
        System.out.println("Valid priority");
        System.out.println("The priority " + input + " has been set\n");
        
        setPriority(input);
    }

    // Status Validation
    public void statusValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid status");
        } while (!flag);
        System.out.println("Valid status");
        System.out.println("The status " + input + " has been set\n");
        
        setStatus(input);
    }

    // Output Of Bug Objects 
    @Override
    public String toString() {
        return getID() + "\n" +
         getName() + "\n" + 
         getType() + "\n" +
         getPriority() + "\n" +
         getStatus() + "\n";
    }
}
