// GUI Class
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.miginfocom.swing.MigLayout;

public class GUI extends JFrame {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------
 
    private JFileChooser fileChooser;
    private String filePath;

    private Map<Integer, Employee> employees;

    // Buttons
    private JButton homeButton, openFileButton, exitButton, 
            employeeButton, addEmpButton, empReport;

    // Menu Fields
    private JMenu fileMenu;
    private JMenuItem open, save;

    private JMenu view;
    private JMenuItem viewEmployees;

    // Panels
    private JPanel left, center;

    // Labels
    private JButton logo;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public GUI() {
        employees = new HashMap<Integer, Employee>();
        chooseFile();
        // Pass values to input
        FileInput input = new FileInput(filePath, employees);
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
        this.setTitle("Employee Software Tracker | " + filePath);
        this.setSize(900, 600);

        // Menu
        // Menu 1
        JMenuBar menuBar = new JMenuBar();
        this.add(menuBar);
        fileMenu = new JMenu("File");
        fileMenu.setFont(new Font("Arial", Font.PLAIN, 16));
        open = new JMenuItem("Open File");
        open.setFont(new Font("Arial", Font.PLAIN, 16));
        save = new JMenuItem("Save");
        save.setFont(new Font("Arial", Font.PLAIN, 16));
        fileMenu.add(open);
        fileMenu.add(save);
        menuBar.add(fileMenu);

        // Menu 3
        view = new JMenu("View");
        view.setFont(new Font("Arial", Font.PLAIN, 16));
        viewEmployees = new JMenuItem("View Employees");
        viewEmployees.setFont(new Font("Arial", Font.PLAIN, 16));
        view.add(viewEmployees);
        menuBar.add(view);

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

        // Home Button
        homeButton = new JButton("Home");
        homeButton = Style.styleButton(homeButton, 20);
        homeButton = Style.hover(homeButton);
        left.add(homeButton, "wrap, grow");

        // Open Button
        openFileButton = new JButton("Open New File");
        openFileButton = Style.styleButton(openFileButton, 20);
        openFileButton = Style.hover(openFileButton);
        left.add(openFileButton, "wrap, grow");

        // View Employees
        employeeButton = new JButton("View Employees");
        employeeButton = Style.styleButton(employeeButton, 20);
        employeeButton = Style.hover(employeeButton);
        left.add(employeeButton, "wrap, grow");

        // Save and Exit Button
        exitButton = new JButton("Save & Exit");
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
            }
        });

        // Open File Menu
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
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
                
                // Add Form panel
                EmployeeForm form = new EmployeeForm(employees);
                center.add(form);
                center.repaint();
                center.revalidate();
            }
        });

        // Menu Bar Listeners
        // Open File
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        // View Employess 
        viewEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Form
                EmployeeForm form = new EmployeeForm(employees);
            }
        });

        // Save and Exit the Program
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndExit();
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

        this.setJMenuBar(menuBar);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    // Read Data from file into Memory
    private void chooseFile() {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choose Directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showSaveDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().toString();
        }

    }

    // Save data into text file
    private void save() {
        FileOutput output = new FileOutput(filePath, employees);
    }

    // Save data into text file and exit program
    private void saveAndExit() {
        FileOutput output = new FileOutput(filePath, employees);
        closeWindow();
    }

    // Close the Current Window
    private void closeWindow() {
        this.dispose();
    }
    
}