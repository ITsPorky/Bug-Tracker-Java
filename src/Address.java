// Address class
import java.util.Scanner;

class Address {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private String state;
    private String city;
    private String streetAddress;
    private String postCode;
    // Validation Scanner
    Scanner sc = new Scanner(System.in);

    // ----------------------------------
    // Constructors
    // ----------------------------------

    public Address() {
        this.state = "N/A";
        this.city = "N/A";
        this.streetAddress = "N/A";
        this.postCode = "N/A";
    }

    public Address(String state,
                   String city,
                   String postCode,
                   String streetAddress) {
        setState(state);
        setCity(city);
        setPostCode(postCode);
        setStreetAddress(streetAddress);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters
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

    // Street Address
    private void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    private String getStreetAddress() {
        return streetAddress;
    }
    public void inputStreetAddress(String streetAddress) {
        setStreetAddress(streetAddress);
    }
    public String grabStreetAddress() {
        return getStreetAddress();
    }

    // Post Code
    private void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    private String getPostCode() {
        return postCode;
    } 
    public void inputPostCode() {
        setPostCode(postCode);
    }
    public String grabPostCode() {
        return getPostCode();
    }

    // Validation Methods

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

    // Street Address Validation
    public void streetAddressValid(String input) {
        boolean flag;
        do {
            String streetPattern = "[0-9\\s]{1,5}[a-zA-Z\\s]{1,25}[a-zA-Zs]{1,10}";
            flag = input.matches(streetPattern);
            if (!flag) System.out.println("Invalid street address");
        } while (!flag);
        System.out.println("Valid address");
        System.out.println("The street address " + input + " has been set\n");
        
        setStreetAddress(input);
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

    // Output for Address Objects
    @Override
    public String toString() {
        return getState() + "\n" +
        getCity() + "\n" +
        getPostCode() + "\n" +
        getStreetAddress();
    }

}