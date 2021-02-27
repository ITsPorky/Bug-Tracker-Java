import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import java.awt.*;

public class ViewProjects extends JPanel {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Page Title
    private JLabel pageTitle;
    // bug Labels/Fields
    private JLabel IDField, nameField, startDateField, estimatedDurationField;
    // Buttons
    private JButton addProjectButton,
            editProjectButton, deleteProjectButton;
    // Scrollpane
    private JScrollPane scrollPane;
    // projects Map
    private Map<Integer, Project> projects;
    private Set<Map.Entry<Integer, Project>> entries;
    private Iterator<Map.Entry<Integer, Project>> iterator;
    private Map.Entry<Integer, Project> entry;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public ViewProjects() {
        projects = new HashMap<Integer, Project>();
        entries = projects.entrySet();
        iterator = entries.iterator();
        initForm();
    }

    // Argument Constructor
    public ViewProjects(Map<Integer, Project> projects) {
        this.projects = projects;
        entries = projects.entrySet();
        iterator = entries.iterator();
        // Initialise Form
        initForm();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initForm() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Page Title
        pageTitle = new JLabel("Projects");
        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
        this.add(pageTitle, "wrap 50");

        // center contents
        JTable table = generateProjectTable();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new DimensionUIResource(1128, 700));
        this.add(scrollPane, "wrap, span");

        // Delete Project Button
        deleteProjectButton = new JButton("Delete Project");
        deleteProjectButton = Style.styleButton(deleteProjectButton, 20);
        deleteProjectButton = Style.hover(deleteProjectButton);
        this.add(deleteProjectButton, "align left");

        // Add Project Button
        addProjectButton = new JButton("Add Project");
        addProjectButton = Style.styleButton(addProjectButton, 20);
        addProjectButton = Style.hover(addProjectButton);
        this.add(addProjectButton, "align left");

        // Edit Project Button
        editProjectButton = new JButton("Edit Project");
        editProjectButton = Style.styleButton(editProjectButton, 20);
        editProjectButton = Style.hover(editProjectButton);
        this.add(editProjectButton, "wrap, align right");

        // Add Project Button
        addProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                // Add Form panel
                NewProject project = new NewProject(projects);
                add(project);
                repaint();
                revalidate();
            }
        });

        // Edit Project Button
        editProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                Integer id = Integer.parseInt(value);
                Project project = projects.get(id);
                EditProject editProject = new EditProject(projects, project);
                add(editProject);
                repaint();
                revalidate();
            }
        });

        // Delete Project Button
        deleteProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                // Get Project data
                Database db = new Database();
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                Integer id = Integer.parseInt(value);
                Project project = projects.get(id);
                // Remove from database
                db.deleteProjectData(project);
                // Remove from hashmap
                projects.remove(project.grabID());
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

    public JTable generateProjectTable() {
        // Column names
        String[] columnNames = {"ID:", "Name:", "Start Date:", "Estimated Duration:", "Priority"};
        
        // Table bug data
        Object[][] data = new Object[projects.size()][5];
        int i = 0;
        while(iterator.hasNext()) {
            // Get bug data
            entry = iterator.next();
            // Insert bug data into array
            data[i] [0] = entry.getValue().grabID().toString();
            data[i] [1] = entry.getValue().grabName();
            data[i] [2] = entry.getValue().grabStartDate();
            data[i] [3] = entry.getValue().grabEstimatedDuration();
            data[i] [4] = entry.getValue().grabPriority();
            // Increment
            i++;
        }

        JTable table = new JTable(data, columnNames);
        table = Style.table(table);

        // Resize table fields
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(258);
        table.getColumnModel().getColumn(3).setPreferredWidth(258);
        table.getColumnModel().getColumn(4).setPreferredWidth(258);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        return table;
    } 
}
