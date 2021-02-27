import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import net.miginfocom.swing.MigLayout;

public class NewProject extends JPanel{

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel IDLabel, nameLabel, startDateLabel, estimatedDurationLabel, priorityLabel, pageTitle;
    private JTextField IDField, nameField, startDateField, estimatedDurationField, priorityField;
    // Buttons
    private JButton closeButton, addButton;
    // Employee Map
    private Map<Integer, Project> projects;
    private Map.Entry<Integer, Project> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public NewProject() {
        initNewProject();
    }

    // Argument Constructor
    public NewProject(Map<Integer, Project> projects) {
        this.projects = projects;
        initNewProject();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initNewProject() {

        // Main Panel Contents
        this.setLayout(new MigLayout("wrap 4",
            "[] 5 [fill,50] 50 [] 5 [fill,50]"));
        this.setBackground(Color.WHITE);

       // Page Title
       pageTitle = new JLabel("Add Project");
       pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
       this.add(pageTitle, "span, wrap 50");

        // Report Section Fields/Labels
        IDLabel = new JLabel("Project ID:");
        IDField = new JTextField("ex. 1");
        IDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        IDField.setFont(new Font("Arial", Font.PLAIN, 20));

        nameLabel = new JLabel("Project Name:");
        nameField = new JTextField("ex. Project 1");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));

        startDateLabel = new JLabel("Start Date:");
        startDateField = new JTextField("ex. 10/02/2021");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        startDateField.setFont(new Font("Arial", Font.PLAIN, 20));

        estimatedDurationLabel = new JLabel("Estimated Duration (Days):");
        estimatedDurationField = new JTextField("ex. 100");
        estimatedDurationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        estimatedDurationField.setFont(new Font("Arial", Font.PLAIN, 20));

        priorityLabel = new JLabel("Priority:");
        priorityField = new JTextField("ex. HIGH");
        priorityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priorityField.setFont(new Font("Arial", Font.PLAIN, 20));

        // Top Row
        // this.add(empIDLabel, "label align");
        // this.add(empIDField, "grow");
        // 1st Row
        this.add(nameLabel, "label align");
        this.add(nameField, "span 3, wrap");
        this.add(startDateLabel, "label align");
        this.add(startDateField, "span 3, wrap 50");
        // 2nd Row
        this.add(estimatedDurationLabel, "label align");
        this.add(estimatedDurationField);
        this.add(priorityLabel, "label align");
        this.add(priorityField);

        // Close Button
        closeButton = new JButton("Cancel");
        closeButton = Style.styleButton(closeButton, 20);
        closeButton = Style.hover(closeButton);
        this.add(closeButton, "span 2, align left");

        // Add Employee Button
        addButton = new JButton("Save Project");
        addButton = Style.styleButton(addButton, 20);
        addButton = Style.hover(addButton);
        this.add(addButton, "span 2, align right");

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Add Project Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create new Project
                Project newProject = new Project();
                // Save New Project Data
                addValues(newProject);
                // Open database
                Database db = new Database();
                // Insert values
                db.insertProjectData(newProject);

                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                
                // Add Form panel
                ViewProjects form = new ViewProjects(projects);
                add(form);
                repaint();
                revalidate();
            }
        });

        // Close Button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                
                
                // Add Form panel
                ViewProjects form = new ViewProjects(projects);
                add(form);
                repaint();
                revalidate();
            }
        });
        

        // this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    private void addValues(Project newProject) {
        newProject.IDValid(projects.size() + 1);
        newProject.nameValid(nameField.getText());
        newProject.startDateValid(startDateField.getText());
        newProject.estimatedDurationValid(estimatedDurationField.getText());
        newProject.priorityValid(priorityField.getText());
        // Add to map
        projects.put(newProject.grabID(), newProject);
    }

}
