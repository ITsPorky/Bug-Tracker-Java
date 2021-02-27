import javax.swing.*;
import java.util.Scanner;

public class Project {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Integer ID;
    private String name;
    private String startDate;
    private String estimatedDuration;
    private String priority;

    // Validation Scanner
    Scanner sc = new Scanner(System.in);

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public Project() {
        ID = 0;
        name = "";
        startDate = "";
        estimatedDuration = "";
        priority = "";
    }

    // Argument Constructor
    public Project(Integer ID, 
            String name,  
            String startDate, 
            String estimatedDuration,
            String priority) {
        setID(ID);
        setName(name);
        setStartDate(startDate);
        setEstimatedDuration(estimatedDuration);
        setPriority(priority);
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

    // Start Date
    private void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    private String getStartDate() {
        return startDate;
    }
    public void inputStartDate(String startDate) {
        setStartDate(startDate);
    }
    public String grabStartDate() {
        return getStartDate();
    }

    // Estimated Duration
    private void setEstimatedDuration(String estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }
    private String getEstimatedDuration() {
        return estimatedDuration;
    }
    public void inputEstimatedDuration(String estimatedDuration) {
        setEstimatedDuration(estimatedDuration);
    }
    public String grabEstimatedDuration() {
        return getEstimatedDuration();
    }

    // Priority
    private void setPriority(String priority) {
        this.priority = priority;
    }
    private String getPriority() {
        return priority;
    }
    public void inputPriority(String priority) {
        setPriority(priority);
    }
    public String grabPriority() {
        return getPriority();
    }

    // -----------------------------------
    // Validation Methods
    // -----------------------------------

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
            String namePattern = "[a-zA-Z0-9\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid name");
        } while (!flag);
        System.out.println("Valid name");
        System.out.println("The name " + input + " has been set\n");
        
        setName(input);
    }

    // startDate Validation
    public void startDateValid(String input) {
        boolean flag;
        do {
            String namePattern = "[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid Start Date");
        } while (!flag);
        System.out.println("Valid Start Date");
        System.out.println("The Start Date " + input + " has been set\n");
        
        setStartDate(input);
    }

    // estimated Duration Validation
    public void estimatedDurationValid(String input) {
        boolean flag;
        do {
            String namePattern = "[0-9]{1,6}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid Duration");
        } while (!flag);
        System.out.println("Valid Duration");
        System.out.println("The Duration " + input + " has been set\n");
        
        setEstimatedDuration(input);
    }

    // Priority Validation
    public void priorityValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z1-9\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid Priority");
        } while (!flag);
        System.out.println("Valid Priority");
        System.out.println("The Priority " + input + " has been set\n");
        
        setPriority(input);
    }

    // Output Of Bug Objects 
    @Override
    public String toString() {
        return getID() + "\n" +
         getName() + "\n" + 
         getStartDate() + "\n" +
         getEstimatedDuration();
    }

}
