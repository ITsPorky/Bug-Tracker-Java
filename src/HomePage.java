import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class HomePage extends JPanel {
    
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private JLabel pageTitle, statsTitle, numEmpLabel, numBugsLabel, 
        numProjectsLabel, numEmployees, numBugs, numProjects;

    private String totalBugs, totalEmployees, totalProjects;

    EmployeeMap empMap;
    BugMap bugMap;
    ProjectMap projectMap;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public HomePage() {
        // Initialise Homepage
        initHomePage(empMap, bugMap, projectMap);
    }

    // Argument Constructor
    public HomePage(EmployeeMap empMap, BugMap bugMap, ProjectMap projectMap) {
        this.empMap = empMap;
        this.bugMap = bugMap;
        this.projectMap = projectMap;
        // Initialise Homepage
        initHomePage(empMap, bugMap, projectMap);
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    public void initHomePage(EmployeeMap empMap, BugMap bugMap, ProjectMap projectMap) {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Page Title
        pageTitle = new JLabel("Dashboard");
        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
        this.add(pageTitle, "wrap 50");

        // Statistics section
        statsTitle = new JLabel("Stats");
        statsTitle.setFont(new Font("Helvetica", Font.BOLD, 32));
        this.add(statsTitle, "wrap");

        // Project stats
        numProjectsLabel = new JLabel("Total Projects: ");
        numProjectsLabel = Style.label(numProjectsLabel);
        totalProjects = String.valueOf(projectMap.grabProjects().size());
        numProjects = new JLabel(totalProjects);
        numProjects = Style.label(numProjects);
        this.add(numProjectsLabel, "label align, span 2");
        this.add(numProjects);

        // Bug stats
        numBugsLabel = new JLabel("Total Bugs: ");
        numBugsLabel = Style.label(numBugsLabel);
        totalBugs = String.valueOf(bugMap.grabBugs().size());
        numBugs = new JLabel(totalBugs);
        numBugs = Style.label(numBugs);
        this.add(numBugsLabel, "label align, span 2");
        this.add(numBugs);

        // Employee Stats
        numEmpLabel = new JLabel("Total Employees: ");
        numEmpLabel = Style.label(numEmpLabel);
        totalEmployees = String.valueOf(empMap.grabEmployees().size());
        numEmployees = new JLabel(totalEmployees);
        numEmployees = Style.label(numEmployees);
        this.add(numEmpLabel, "label align, span 2");
        this.add(numEmployees);

        this.setVisible(true);
    }

    // -----------------------------------
    // Listeners
    // -----------------------------------


    // -----------------------------------
    // Methods
    // -----------------------------------


}
