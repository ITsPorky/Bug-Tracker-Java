import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import net.miginfocom.swing.MigLayout;

public class NewBug extends JPanel {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel IDLabel, nameLabel, typeLabel, priorityLabel, statusLabel, pageTitle;
    private JTextField IDField, nameField, typeField, priorityField, statusField;
    // Buttons
    private JButton closeButton, addButton;
    // Employee Map
    private Map<Integer, Bug> bugs;
    private Map.Entry<Integer, Bug> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public NewBug() {
        initNewBug();
    }

    // Argument Constructor
    public NewBug(Map<Integer, Bug> bugs) {
        this.bugs = bugs;
        initNewBug();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initNewBug() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

       // Page Title
       pageTitle = new JLabel("Add Bug");
       pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
       this.add(pageTitle, "span, wrap 50");

        // Report Section Fields/Labels
        IDLabel = new JLabel("Bug ID:");
        IDField = new JTextField("ex. 1");
        IDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        IDField.setFont(new Font("Arial", Font.PLAIN, 20));

        nameLabel = new JLabel("Bug Name:");
        nameField = new JTextField("ex. bug1");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));

        typeLabel = new JLabel("Type:");
        typeField = new JTextField("ex. Runtime Error");
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        typeField.setFont(new Font("Arial", Font.PLAIN, 20));

        priorityLabel = new JLabel("Priority:");
        priorityField = new JTextField("ex. HIGH");
        priorityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priorityField.setFont(new Font("Arial", Font.PLAIN, 20));

        statusLabel = new JLabel("Status:");
        statusField = new JTextField("ex. NEW");
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

        // Add Employee Button
        addButton = new JButton("Save Bug");
        addButton = Style.styleButton(addButton, 20);
        addButton = Style.hover(addButton);
        this.add(addButton, "span 2, align right");

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Add Bug Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create new Employee
                Bug newBug = new Bug();
                // Save New Employee Data
                addValues(newBug);
                // Open database
                Database db = new Database();
                // Insert values
                db.insertBugData(newBug);

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
                // dispose();
            }
        });

        // this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    private void addValues(Bug newBug) {
        newBug.IDValid(bugs.size() + 1);
        newBug.nameValid(nameField.getText());
        newBug.typeValid(typeField.getText());
        newBug.priorityValid(priorityField.getText());
        newBug.statusValid(statusField.getText());
        
        bugs.put(newBug.grabID(), newBug);

    }
}
