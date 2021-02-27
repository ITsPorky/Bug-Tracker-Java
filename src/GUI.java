// GUI Class
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.miginfocom.swing.MigLayout;

public class GUI extends JFrame {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private int screenWidth;
    private int screenHeight;

    private EmployeeMap employees;
    private BugMap bugs;
    private ProjectMap projects;

    // Buttons
    private JButton homeButton, exitButton, bugButton, 
            employeeButton, projectButton;

    // Panels
    private JPanel left, center;

    // Labels
    private JButton logo;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public GUI() {
        employees = new EmployeeMap();
        bugs = new BugMap();
        projects = new ProjectMap();
        // Connect to database
        Database db = new Database();
        db.readEmpData(employees);
        db.readBugData(bugs);
        db.readProjectData(projects);
        // Initialise GUI Window
        initWindow();
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    // Initialise Window
    private void initWindow() {

        // Initialise the GUI
        // Methods
        this.setLayout(new BorderLayout());
        this.setTitle("Bug Tracker");
        this.setSize(900, 600);

        // Logo
        logo = new JButton("Bug Tracker");
        logo = Style.logo(logo);

        // Left side panel Menu
        left = new JPanel(new MigLayout());
        left = Style.sidePanel(left);

        left.add(logo, "wrap 100, grow");

        // Center Menu Buttons
        center = new JPanel();
        center.setBackground(Color.WHITE);
        
        // Home Page
        HomePage homePage = new HomePage(employees, bugs, projects);
        center.add(homePage);

        // Home Button
        homeButton = new JButton("Home");
        homeButton = Style.styleButton(homeButton, 20);
        homeButton = Style.hover(homeButton);
        left.add(homeButton, "wrap, grow");

        // View Bugs
        bugButton = new JButton("View Bugs");
        bugButton = Style.styleButton(bugButton, 20);
        bugButton = Style.hover(bugButton);
        left.add(bugButton, "wrap, grow");

        // View Projects
        projectButton = new JButton("View Projects");
        projectButton = Style.styleButton(projectButton, 20);
        projectButton = Style.hover(projectButton);
        left.add(projectButton, "wrap, grow");

        // View Employees
        employeeButton = new JButton("View Employees");
        employeeButton = Style.styleButton(employeeButton, 20);
        employeeButton = Style.hover(employeeButton);
        left.add(employeeButton, "wrap, grow");

        // Save and Exit Button
        exitButton = new JButton("Exit");
        exitButton = Style.styleButton(exitButton, 20);
        exitButton = Style.hover(exitButton);
        left.add(exitButton, "wrap, grow");

        // Left Panel Contents
        this.add(left, BorderLayout.WEST);

        // Add Buttons
        this.add(center, BorderLayout.CENTER);


        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Menu Items
        // Home Button
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                center.removeAll();
                center.repaint();
                center.revalidate();

                // Add panel
                HomePage form = new HomePage(employees, bugs, projects);
                center.add(form);
                center.repaint();
                center.revalidate();
            }
        });

        // View Bugs Button
        bugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                center.removeAll();
                center.repaint();
                center.revalidate();

                // Read database data
                Database db = new Database();
                db.readBugData(bugs);

                // Add Form panel
                ViewBugs form = new ViewBugs(bugs.grabBugs());
                center.add(form);
                center.repaint();
                center.revalidate();
            }
        });

        // View Projects Button
        projectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                center.removeAll();
                center.repaint();
                center.revalidate();

                // Read database data
                Database db = new Database();
                db.readProjectData(projects);

                // Add Form panel
                ViewProjects form = new ViewProjects(projects.grabProjects());
                center.add(form);
                center.repaint();
                center.revalidate();
            }
        });

        // View Employees Button
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                center.removeAll();
                center.repaint();
                center.revalidate();

                // Read database data
                Database db = new Database();
                db.readEmpData(employees);

                // Add Form panel
                ViewEmployee form = new ViewEmployee(employees.grabEmployees());
                center.add(form);
                center.repaint();
                center.revalidate();
            }
        });

        // Save and Exit the Program
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        // Pop up on closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to exit the program? Changes will not be saved.", "Exit Program Message Box",
                    JOptionPane.YES_NO_OPTION);
            
                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setMinimumSize(new Dimension(960, 540));
        this.setVisible(true);

    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    // Close the Current Window
    private void closeWindow() {
        this.dispose();
    }

    // Resizing window
    // public JComponent resizeWindow(JComponent component) {
    //     // java - get screen size using the Toolkit class
    //     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //     // the screen height
    //     screenSize.getHeight();

    //     // the screen width
    //     screenSize.getWidth();

    //     int screenHeight = screenSize.height;
    //     int screenWidth = screenSize.width;

    //     return component;
    // }

    // private void setScreenSize(int width, int height) {
    //     this.screenWidth = width;
    //     this.screenHeight = height;
    // }
    // private Dimension getScreenSize() {
    //     Dimension screen = new Dimension(screenWidth, screenHeight);
    //     return screen;
    // }
    // public void inputScreenSize(int width, int height) {
    //     setScreenSize(width, height);
    // }
    // public Dimension grabScreenSize() {
    //     return getScreenSize();
    // }
    
}