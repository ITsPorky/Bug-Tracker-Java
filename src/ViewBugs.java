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

public class ViewBugs extends JPanel{
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Page Title
    private JLabel pageTitle;
    // bug Labels/Fields
    private JLabel IDField, nameField, typeField, priorityField, statusField;
    // Buttons
    private JButton addBugButton,
            editBugButton, deleteBugButton;
    // Scrollpane
    private JScrollPane scrollPane;
    // bug Map
    private Map<Integer, Bug> bugs;
    private Set<Map.Entry<Integer, Bug>> entries;
    private Iterator<Map.Entry<Integer, Bug>> iterator;
    private Map.Entry<Integer, Bug> entry;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public ViewBugs() {
        bugs = new HashMap<Integer, Bug>();
        entries = bugs.entrySet();
        iterator = entries.iterator();
        initForm();
    }

    // Argument Constructor
    public ViewBugs(Map<Integer, Bug> bugs) {
        this.bugs = bugs;
        entries = bugs.entrySet();
        iterator = entries.iterator();
        // Initialise Form
        initForm();
        // Fill fields with employee data
        // showEmployee();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initForm() {

        // Main Panel Contents
        this.setLayout(new MigLayout());
        this.setBackground(Color.WHITE);

        // Page Title
        pageTitle = new JLabel("Bugs");
        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 48));
        this.add(pageTitle, "wrap 50");

        // center contents
        JTable table = generateBugTable();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new DimensionUIResource(1128, 700));
        this.add(scrollPane, "wrap, span");

        // Delete Employee Button
        deleteBugButton = new JButton("Delete Bug");
        deleteBugButton = Style.styleButton(deleteBugButton, 20);
        deleteBugButton = Style.hover(deleteBugButton);
        this.add(deleteBugButton, "align left");

        // Add bug Button
        addBugButton = new JButton("Add Bug");
        addBugButton = Style.styleButton(addBugButton, 20);
        addBugButton = Style.hover(addBugButton);
        this.add(addBugButton, "align left");

        // Edit bug Button
        editBugButton = new JButton("Edit Bug");
        editBugButton = Style.styleButton(editBugButton, 20);
        editBugButton = Style.hover(editBugButton);
        this.add(editBugButton, "wrap, align right");

        // Make table elements hoverable
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseMoved(java.awt.event.MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row > -1) {
                    // easiest way:
                    table.clearSelection();
                    table.setRowSelectionInterval(row, row);
                }
                else {
                    table.setSelectionBackground(Color.blue);
                }
            }
        });


        // -----------------------------------
        // Listeners
        // -----------------------------------

        // // Search Field
        // searchEmp.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         Integer userInput = Integer.parseInt(searchEmp.getText());
        //         if(entry.getValue().grabEmpID() < userInput) {
        //             while (entry.getValue().grabEmpID() < userInput) {
        //                 if (iterator.hasNext()) {
        //                     entry.getValue().next = iterator.next();
        //                     entry.getValue().next.getValue().previous = entry;
        //                 }
        //                 if (entry.getValue().next != null) {
        //                     entry = entry.getValue().next;
        //                     showEmployee();
        //                 }
        //             }
        //         }else if(entry.getValue().grabEmpID() > userInput) {
        //             while (entry.getValue().grabEmpID() > userInput) {
        //                 if (entry.getValue().previous != null) {
        //                     entry = entry.getValue().previous;
        //                     showEmployee();
        //                 }
        //             }
        //         }
        //         // Update search box number
        //         searchEmp.setText(entry.getValue().grabEmpID().toString());
        //     }
        // });

        // Add bug Button
        addBugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                // Get bug data
                Database db = new Database();
                // Add Form panel
                NewBug bug = new NewBug(bugs);
                add(bug);
                repaint();
                revalidate();
            }
        });

        // Edit bug Button
        editBugButton.addActionListener(new ActionListener() {
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
                Bug bug = bugs.get(id);
                EditBug editBug = new EditBug(bugs, bug);
                add(editBug);
                repaint();
                revalidate();
            }
        });

        // Delete Employee Button
        deleteBugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove current panel
                removeAll();
                repaint();
                revalidate();
                // Get Employee data
                Database db = new Database();
                int column = 0;
                int row = table.getSelectedRow();
                String value = table.getModel().getValueAt(row, column).toString();
                Integer id = Integer.parseInt(value);
                Bug bug = bugs.get(id);
                // Remove from database
                db.deleteBugData(bug);
                // Remove from hashmap
                bugs.remove(bug.grabID());
                ViewBugs form = new ViewBugs(bugs);
                add(form);
                repaint();
                revalidate();
            }
        });

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Hovering elements of the table
        // table.addMouseListener(new java.awt.event.MouseAdapter() {

        //     int hoveredRow;
        //     int hoveredColumn;
        //     @Override
        //     public void mouseMoved(java.awt.event.MouseEvent e) {
        //         Point p = e.getPoint();
        //         hoveredRow = table.rowAtPoint(p);
        //         hoveredColumn = table.columnAtPoint(p);
        //         table.setRowSelectionInterval(hoveredRow, hoveredRow);
        //         table.repaint();    
        //     }
        //     @Override
        //     public void mouseDragged(java.awt.event.MouseEvent e) {
        //         hoveredRow = hoveredColumn = -1;
        //         table.repaint();
        //     }
        // });

        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    public JTable generateBugTable() {
        // Column names
        String[] columnNames = {"ID:", "Name:", "Type:", "Priority:", "Status:"};
        
        // Table bug data
        Object[][] data = new Object[bugs.size()][5];
        int i = 0;
        while(iterator.hasNext()) {
            // Get bug data
            entry = iterator.next();
            // Insert bug data into array
            data[i] [0] = entry.getValue().grabID().toString();
            data[i] [1] = entry.getValue().grabName().toString();
            data[i] [2] = entry.getValue().grabType().toString();
            data[i] [3] = entry.getValue().grabPriority().toString();
            data[i] [4] = entry.getValue().grabStatus().toString();
            // Increment
            i++;
        }

        JTable table = new JTable(data, columnNames);
        table = Style.table(table);

        // Resize table fields
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(225);
        table.getColumnModel().getColumn(3).setPreferredWidth(225);
        table.getColumnModel().getColumn(4).setPreferredWidth(225);      

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);

        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        return table;
    } 
}
