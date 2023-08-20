import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login_log extends JFrame {
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;

    private static final String IMAGE_PATH = "src/imagenes/hotel.png";

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

        // Adicione o KeyListener para o campo de senha aqui
        txtSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(); // Chama a função de login quando a tecla Enter é pressionada
                }
            }
        });
    }

    private void addBackgroundImage() {
        ImageIcon backgroundImageIcon = new ImageIcon(IMAGE_PATH);
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

        ImageIcon icon = new ImageIcon("src/imagenes/aH-150px.png");
        JLabel label = new JLabel(icon);
        int iconX = (panel_1.getWidth() - icon.getIconWidth()) / 2;
        label.setBounds(iconX, 20, icon.getIconWidth(), icon.getIconHeight());
        panel_1.add(label);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(40, 210, 100, 30);
        panel_1.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(40, 240, 220, 30);
        panel_1.add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(40, 270, 100, 30);
        panel_1.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(40, 300, 220, 30);
        panel_1.add(txtSenha);

        // Create and add a login button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 350, 100, 30);
        panel_1.add(btnLogin);

        // Adicione o ActionListener para o botão de login aqui
        btnLogin.addActionListener(e -> {
            login();
        });

        JButton btncancelar = new JButton("Cancelar");
        btncancelar.setBounds(160, 350, 100, 30); // Adjust the position and size as needed
        panel_1.add(btncancelar);

        // Adicione o ActionListener para o botão de cancelar aqui
        btncancelar.addActionListener(e -> {
            cancel();
        });
    }

    private void cancel() {
        System.exit(0); // Exit the application
    }

    private void login() {
        String Usuario = "admin";
        String Senha = "admin";

        String senhaa = new String(txtSenha.getPassword());

        if (txtUsuario.getText().equals(Usuario) && senhaa.equals(Senha)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
            paginaPrincipal.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Login_log tela = new Login_log();
                tela.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
