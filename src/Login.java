import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
    private JPanel contentPane;

    private static final String IMAGE_PATH = "src/imagenes/menu-img.png";

    public Login() {
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
        addAttributionLabel();
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

        ImageIcon icon = new ImageIcon("src/imagenes/aH-150px.png");
        JLabel label = new JLabel(icon);
        int iconX = (panel_1.getWidth() - icon.getIconWidth()) / 2;
        label.setBounds(iconX, 20, icon.getIconWidth(), icon.getIconHeight());
        panel_1.add(label);

        JLabel labelTitulo = new JLabel("LOGIN");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
        int labelX = (panel_1.getWidth() - labelTitulo.getPreferredSize().width) / 2;
        labelTitulo.setBounds(labelX, 190, labelTitulo.getPreferredSize().width, labelTitulo.getPreferredSize().height);
        panel_1.add(labelTitulo);

        ImageIcon additionalImageIcon = new ImageIcon("src/imagenes/login.png");
        JLabel additionalImageLabel = new JLabel(additionalImageIcon);
        int imageX = (panel_1.getWidth() - additionalImageIcon.getIconWidth()) / 2;
        int imageY = 240;
        additionalImageLabel.setBounds(imageX, imageY, additionalImageIcon.getIconWidth(), additionalImageIcon.getIconHeight());

        additionalImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewScreen();
            }
        });

        panel_1.add(additionalImageLabel);

    }

    private void addAttributionLabel() {
        JLabel attributionLabel = new JLabel("");
        attributionLabel.setForeground(Color.BLACK);
        attributionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        attributionLabel.setBounds(10, 500, 782, 30);
        contentPane.add(attributionLabel);
    }

    private void openNewScreen() {
        Login_log newScreen = new Login_log();
        newScreen.setVisible(true);
        dispose();
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

