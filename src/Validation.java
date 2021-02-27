import javax.swing.*;

public class Validation {
    
    // Default Constructor 
    public Validation() {}

    public boolean nameValid() {
        try {
            
        } catch (Exception e) {

        }

        return false;
    }
    
    // Methods
    public boolean textValid(JTextField input, String message) {
        boolean flag;
        try {
            String namePattern = "[a-zA-Z0-9\\s]{3,25}";
            flag = message.matches(namePattern);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean emailValid(JTextField input, String message) {

        return false;
    }

    public boolean dateValid(JTextField input, String message) {

        return false;
    }

}
