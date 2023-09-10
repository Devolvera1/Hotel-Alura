import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.toedter.calendar.JDateChooser;

public class RegistroHospede extends JFrame {
    private JPanel contentPane;
    private static final String IMAGE_PATH = "src/imagenes/registro.png";
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtTelefone;
    private JTextField txtNreserva;
    private JDateChooser txtDataN;
    private JTextField txtNacionalidade;

    public RegistroHospede() {
        initializeUI();
        addBackgroundImage();
    }

    private void addBackgroundImage() {
        ImageIcon backgroundImageIcon = new ImageIcon(IMAGE_PATH);
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 484, 527);
        contentPane.add(backgroundImageLabel);

        // Button exit(X) and Back(<).
        JLabel lblExcluir = new JLabel("DELETAR");
        lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
        lblExcluir.setForeground(Color.WHITE);
        lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblExcluir.setBounds(0, 0, 122, 35);

        JPanel btnExit = new JPanel();
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaginaPrincipal usuario = new PaginaPrincipal();
                usuario.setVisible(true);
                dispose();
            }
        });

        btnExit.setLayout(null);
        btnExit.setBackground(new Color(12, 138, 199));
        btnExit.setBounds(832, 0, 39, 35);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnExit);

        JLabel labelExit = new JLabel("<");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.WHITE);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 39, 35);
        btnExit.add(labelExit);

        JPanel btnVoltar = new JPanel();
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
                dispose();
            }
        });

        btnVoltar.setLayout(null);
        btnVoltar.setBackground(new Color(12, 138, 199));
        btnVoltar.setBounds(871, 0, 39, 35);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnVoltar);

        JLabel labelVoltar = new JLabel("X");
        labelVoltar.setHorizontalAlignment(SwingConstants.CENTER);
        labelVoltar.setForeground(Color.WHITE);
        labelVoltar.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelVoltar.setBounds(0, 0, 39, 35);
        btnVoltar.add(labelVoltar);

    }

    private void initializeUI() {
        setLookAndFeel();
        setWindowProperties();
        createFieldsAndLabels();
        createButtons();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setWindowProperties() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
    }

    private void createFieldsAndLabels() {
        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(560, 119, 253, 14);
        lblNome.setForeground(SystemColor.textInactiveText);
        lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(560, 143, 253, 25);
        contentPane.add(txtNome);

        JLabel lblSobrenome = new JLabel("SOBRENOME");
        lblSobrenome.setBounds(560, 189, 255, 14);
        lblSobrenome.setForeground(SystemColor.textInactiveText);
        lblSobrenome.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblSobrenome);

        txtSobrenome = new JTextField();
        txtSobrenome.setBounds(560, 213, 253, 25);
        contentPane.add(txtSobrenome);

        JLabel lblDataN = new JLabel("DATA DE NASCIMENTO");
        lblDataN.setBounds(560, 256, 255, 14);
        lblDataN.setForeground(SystemColor.textInactiveText);
        lblDataN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblDataN);

        txtDataN = new JDateChooser();
        txtDataN.setBounds(560, 280, 253, 25);
        contentPane.add(txtDataN);

        JLabel lblNacionalidade = new JLabel("NACIONALIDADE");
        lblNacionalidade.setBounds(560, 326, 253, 14);
        lblNacionalidade.setForeground(SystemColor.textInactiveText);
        lblNacionalidade.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidade);

        txtNacionalidade = new JTextField();
        txtNacionalidade.setBounds(560, 350, 253, 25);
        contentPane.add(txtNacionalidade);


        JLabel lblTelefone = new JLabel("TELEFONE");
        lblTelefone.setBounds(560, 406, 253, 14);
        lblTelefone.setForeground(SystemColor.textInactiveText);
        lblTelefone.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(560, 430, 253, 25);
        contentPane.add(txtTelefone);

        JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
        lblNumeroReserva.setBounds(560, 476, 253, 14);
        lblNumeroReserva.setForeground(SystemColor.textInactiveText);
        lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNumeroReserva);

        txtNreserva = new JTextField();
        txtNreserva.setBounds(560, 500, 253, 25);
        contentPane.add(txtNreserva);


        // Add all the labels and text fields to the contentPane
        contentPane.add(lblNome);
        contentPane.add(txtNome);
        contentPane.add(lblSobrenome);
        contentPane.add(txtSobrenome);
        contentPane.add(lblDataN);
        contentPane.add(txtDataN);
        contentPane.add(lblNacionalidade);
        contentPane.add(txtNacionalidade);
        contentPane.add(lblTelefone);
        contentPane.add(txtTelefone);
        contentPane.add(lblNumeroReserva);
        contentPane.add(txtNreserva);
    }

    private void createButtons() {
        JButton btnSave = new JButton("Salvar");
        btnSave.setBounds(560, 550, 100, 35);
        btnSave.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnSave.setBackground(Color.WHITE);
        btnSave.addActionListener(e -> handleButtonCommand("Save"));  // Corrected line
        contentPane.add(btnSave);
        ;
    }

    private JButton createIconButton(String command, String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 39, 35);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(new Color(12, 138, 199));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Roboto", Font.PLAIN, 18));
        if (command.equals("Save")) {
            button.addActionListener(e -> saveButtonClicked());
        } else {
            button.addActionListener(e -> handleButtonCommand(command));
        }

        return button;
    }
    private boolean areAllFieldsFilled() {
        return !txtNome.getText().isEmpty() &&
                !txtSobrenome.getText().isEmpty() &&
                txtDataN.getDate() != null &&
                !txtTelefone.getText().isEmpty();
    }
    private void handleButtonCommand(String command) {
        if (command.equals("Exit")) {
            System.exit(0);
        } else if (command.equals("Save")) {
            if (areAllFieldsFilled()) {
                int result = JOptionPane.showConfirmDialog(
                        contentPane,
                        "Deseja realmente salvar o registro?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    saveToDatabase();
                    JOptionPane.showMessageDialog(
                            contentPane,
                            "Registro salvo com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(
                        contentPane,
                        "Preencha todos os campos antes de salvar.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void saveButtonClicked() {
        handleButtonCommand("Save");
    }


    private void saveToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_one";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Recupere o maior valor de ID da tabela RESERVAS
            String sqlMaxIdReserva = "SELECT MAX(ID) AS ID FROM RESERVAS";
            Statement maxIdReservaStatement = connection.createStatement();
            ResultSet resultSet = maxIdReservaStatement.executeQuery(sqlMaxIdReserva);

            int ID_RESERVA = -1;
            if (resultSet.next()) {
                ID_RESERVA = resultSet.getInt("ID");
            }

            String sqlInsercao = "INSERT INTO hospedes (NOME, SOBRENOME, DATA_NASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insercaoStatement = connection.prepareStatement(sqlInsercao);
            insercaoStatement.setString(1, txtNome.getText());
            insercaoStatement.setString(2, txtSobrenome.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(txtDataN.getDate());
            insercaoStatement.setString(3, formattedDate);
            insercaoStatement.setString(4, txtNacionalidade.getText());
            insercaoStatement.setString(5, txtTelefone.getText());
            insercaoStatement.setInt(6, ID_RESERVA);

            // Execute a instrução de inserção
            insercaoStatement.executeUpdate();

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "An error occurred", ex);
        }
    }

        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistroHospede frame = new RegistroHospede();
            frame.setVisible(true);
        });
    }
}
