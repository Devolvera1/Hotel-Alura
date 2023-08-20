import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_log extends JFrame {
    private JPanel contentPane;

    private static final String IMAGE_PATH = "src/imagenes/registro.png";

    public Login_log() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 788, 527);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        addBackgroundImage();
        addSidePanel();
    }

    private void addBackgroundImage() {
        ImageIcon backgroundImageIcon = new ImageIcon(IMAGE_PATH);
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 484, 502);
        contentPane.add(backgroundImageLabel);
    }

    private void addSidePanel() {
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(484, 0, 304, 502);
        panel_1.setLayout(null);
        contentPane.add(panel_1);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Login tela = new Login();
                tela.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
