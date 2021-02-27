import javax.swing.*;
import java.awt.*;

public class Style {

    // Colors 
    // private static Color oldBlue = new Color(16, 37, 56);
    // private static Color fgColor = new Color(61, 61, 61);
    private static Color white = new Color(255, 255, 255);
    private static Color bgBlue = new Color(59, 134, 191);
    private static Color hoverBlue = new Color(53, 119, 171);

    // Side panel 
    public static JPanel sidePanel(JPanel panel) {
        // Styling
        panel.setBackground(bgBlue);

        return panel;
    }

    // Button style
    public static JButton styleButton(JButton button, int fontSize) {
        // Button styling
        button.setFont(new Font("Helvetica", Font.BOLD, fontSize));
        button.setForeground(white);
        button.setBackground(bgBlue);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setPreferredSize(new Dimension(200, 50));
 
        return button;
    }

    // Hovering
    public static JButton hover(JButton button) {
        // Mouse listeners
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverBlue);
                button.setForeground(white);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgBlue);
                button.setForeground(white);
            }
        });

        return button;
    }

    // Active Button
    public static JButton active(JButton button) {
        // Set selected button to active
        button.setBackground(hoverBlue);

        return button;
    }   

    // Logo Button 
    public static JButton logo(JButton button) {
        // Styling
        button.setBackground(bgBlue);
        button.setForeground(white);
        button.setFont(new Font("Helvetica", Font.BOLD, 48));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        return button;
    }

    // Titles
    public static JLabel title(JLabel label) {
        // Styling
        label.setFont(new Font("Helvetica", Font.BOLD, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;
    }

    // Normal labels
    public static JLabel label(JLabel label) {
        // Styling
        label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;
    }

    // Table
    public static JTable table(JTable table) {
        // Styling
        table.setFont(new Font("Helvetica", Font.PLAIN, 20));
        
        return table;
    }

}
