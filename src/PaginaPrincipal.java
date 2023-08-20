import javax.swing.*;
import java.awt.*;

public class PaginaPrincipal extends JFrame {
    private static final String BACKGROUND_IMAGE_PATH = "src/imagenes/menu-img.png";
    private static final String SIDE_PANEL_IMAGE_PATH = "src/imagenes/aH-150px.png";

    private JPanel contentPane; // Declare content pane

    public PaginaPrincipal() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 788, 527);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addBackgroundImage();
        addSidePanel();
        // Call other methods to add components as needed
    }

    private void addBackgroundImage() {
        ImageIcon backgroundImageIcon = new ImageIcon(BACKGROUND_IMAGE_PATH);
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 484, 527);
        contentPane.add(backgroundImageLabel);
    }

    private void addSidePanel() {
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(484, 0, 304, 527);
        panel_1.setLayout(null);
        contentPane.add(panel_1);

        ImageIcon sidePanelIcon = new ImageIcon(SIDE_PANEL_IMAGE_PATH);
        JLabel label = new JLabel(sidePanelIcon);
        int iconX = (panel_1.getWidth() - sidePanelIcon.getIconWidth()) / 2;
        label.setBounds(iconX, 20, sidePanelIcon.getIconWidth(), sidePanelIcon.getIconHeight());
        panel_1.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaPrincipal frame = new PaginaPrincipal();
            frame.setVisible(true);
        });
    }
}
