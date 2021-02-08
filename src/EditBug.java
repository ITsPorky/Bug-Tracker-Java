import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import net.miginfocom.swing.MigLayout;

public class EditBug extends JPanel{
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel idLabel, nameLabel, typeLabel, priorityLabel, statusLabel;
    private JTextField idField, nameField, typeField, priorityField, statusField;
    // Buttons
    private JButton closeButton, saveButton;
    // Employee Map
    private Map<Integer, Bug> bugs;
    private Map.Entry<Integer, Bug> entry;
    private Bug bug;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EditBug() {
        initEditBug();
    }

    // Default Constructor
    public EditBug(Map<Integer, Bug> bugs, Bug bug) {
        this.bugs = bugs;
        this.bug = bug;
        // Initialise Form
        initEditBug();
        // Fill fields with employee data
        showBug(bug);
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initEditBug() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Report Section Fields/Labels
        idLabel = new JLabel("Bug ID:");
        idField = new JTextField("ex. 1");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        idField.setFont(new Font("Arial", Font.PLAIN, 20));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField("ex. John");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));

        typeLabel = new JLabel("Type:");
        typeField = new JTextField("ex. Doe");
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        typeField.setFont(new Font("Arial", Font.PLAIN, 20));

        priorityLabel = new JLabel("Priority:");
        priorityField = new JTextField("ex. example@domain.com");
        priorityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priorityField.setFont(new Font("Arial", Font.PLAIN, 20));

        statusLabel = new JLabel("Status:");
        statusField = new JTextField("ex. 0400000000");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        statusField.setFont(new Font("Arial", Font.PLAIN, 20));

        // Top Row
        // this.add(empIDLabel, "label align");
        // this.add(empIDField, "grow");
        // 1st Row
        this.add(nameLabel, "label align, right");
        this.add(nameField, "grow");
        this.add(typeLabel, "label align, right");
        this.add(typeField, "grow, wrap 50");
        // 2nd Row
        this.add(priorityLabel, "label align, right");
        this.add(priorityField, "grow");
        this.add(statusLabel, "label align, right");
        this.add(statusField, "grow, wrap 50");

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
                addValues(bug);
                db.editBugData(bug);

                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                
                // Add Form panel
                ViewBugs form = new ViewBugs(bugs);
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
                ViewBugs form = new ViewBugs(bugs);
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

    private void showBug(Bug entry) {
        // Fill Bug data in fields
        idField.setText(entry.grabID().toString());
        nameField.setText(entry.grabName());
        typeField.setText(entry.grabType());
        priorityField.setText(entry.grabPriority());
        statusField.setText(entry.grabStatus());
    }

    private void addValues(Bug entry) {
        entry.IDValid(entry.grabID());
        entry.nameValid(nameField.getText());
        entry.typeValid(typeField.getText());
        entry.priorityValid(priorityField.getText());
        entry.statusValid(statusField.getText());
    }
}

