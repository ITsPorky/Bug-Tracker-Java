import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import net.miginfocom.swing.MigLayout;

public class EditProject extends JPanel {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel idLabel, nameLabel, startDateLabel, estimatedDurationLabel, 
        priorityLabel, pageTitle;
    private JTextField idField, nameField, startDateField, estimatedDurationField, priorityField;
    // Buttons
    private JButton closeButton, saveButton;
    // Employee Map
    private Map<Integer, Project> projects;
    private Map.Entry<Integer, Project> entry;
    private Project project;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EditProject() {
        initEditProject();
    }

    // Default Constructor
    public EditProject(Map<Integer, Project> projects, Project project) {
        this.projects = projects;
        this.project = project;
        // Initialise Form
        initEditProject();
        // Fill fields with employee data
        showProject(project);
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initEditProject() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Page Title
        pageTitle = new JLabel("Edit Project");
        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
        this.add(pageTitle, "span, wrap 50");

        // Report Section Fields/Labels
        idLabel = new JLabel("Project ID:");
        idField = new JTextField("");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        idField.setFont(new Font("Arial", Font.PLAIN, 20));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField("");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));

        startDateLabel = new JLabel("Start Date:");
        startDateField = new JTextField("");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        startDateField.setFont(new Font("Arial", Font.PLAIN, 20));

        estimatedDurationLabel = new JLabel("Estimated Duration:");
        estimatedDurationField = new JTextField("");
        estimatedDurationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        estimatedDurationField.setFont(new Font("Arial", Font.PLAIN, 20));

        priorityLabel = new JLabel("Priority:");
        priorityField = new JTextField("");
        priorityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priorityField.setFont(new Font("Arial", Font.PLAIN, 20));

        // Top Row
        // this.add(empIDLabel, "label align");
        // this.add(empIDField, "grow");
        // 1st Row
        this.add(nameLabel, "label align, right");
        this.add(nameField, "grow");
        this.add(startDateLabel, "label align, right");
        this.add(startDateField, "grow, wrap 50");
        // 2nd Row
        this.add(estimatedDurationLabel, "label align, right");
        this.add(estimatedDurationField, "grow");
        this.add(priorityLabel, "label align, right");
        this.add(priorityField, "grow, wrap 50");

        // Close Button
        closeButton = new JButton("Cancel");
        closeButton = Style.styleButton(closeButton, 20);
        closeButton = Style.hover(closeButton);
        this.add(closeButton, "span 2, align left");

        // Save Button
        saveButton = new JButton("Save Data");
        saveButton = Style.styleButton(saveButton, 20);
        saveButton = Style.hover(saveButton);
        this.add(saveButton, "span 2, align right");

        // -----------------------------------
        // Listeners
        // -----------------------------------
        // Save Edited Bug
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open database
                Database db = new Database();
                // Save New Bug Data
                addValues(project);
                db.editProjectData(project);

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

        this.setVisible(true);
    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    private void showProject(Project entry) {
        // Fill Bug data in fields
        idField.setText(entry.grabID().toString());
        nameField.setText(entry.grabName());
        startDateField.setText(entry.grabStartDate());
        estimatedDurationField.setText(entry.grabEstimatedDuration());
        priorityField.setText(entry.grabPriority());
    }

    private void addValues(Project entry) {
        entry.IDValid(entry.grabID());
        entry.nameValid(nameField.getText());
        entry.startDateValid(startDateField.getText());
        entry.estimatedDurationValid(estimatedDurationField.getText());
        entry.priorityValid(priorityField.getText());
    }
}
