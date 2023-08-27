import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.toedter.calendar.JDateChooser;

public class Registro extends JFrame {
    private JPanel contentPane;
    private static final String IMAGE_PATH = "src/imagenes/registro.png";
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtTelefone;
    private JTextField txtNreserva;
    private JDateChooser txtDataN;
    private JComboBox<String> txtNacionalidade;

    public Registro() {
        initializeUI();
        addBackgroundImage();
    }

    private void addBackgroundImage() {
        ImageIcon backgroundImageIcon = new ImageIcon(IMAGE_PATH);
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 484, 527);
        contentPane.add(backgroundImageLabel);
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

        txtNacionalidade = new JComboBox<>();
        txtNacionalidade.setBounds(560, 350, 289, 36);
        txtNacionalidade.setBackground(SystemColor.text);
        txtNacionalidade.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNacionalidade.setModel(new DefaultComboBoxModel<>(new String[] {"alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio", "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano", "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês", "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano", "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês", "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano", "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano", "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco", "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano", "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino", "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense", "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano", "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano", "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio", "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio37", "malawiano", "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense", "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano", "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani", "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio", "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano", "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense", "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio", "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês", "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano", "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense", "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano"}));
        contentPane.add(txtNacionalidade);

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
        lblNacionalidade.setBounds(560, 326, 255, 14);
        lblNacionalidade.setForeground(SystemColor.textInactiveText);
        lblNacionalidade.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidade);

        txtNacionalidade = new JComboBox<>();
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

        JButton btnExit = createIconButton("Exit", "X", 871, 0);
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(btnExit);
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
                    // Show success message and navigate back to PaginaPrincipal.java
                    // ...
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
            String password = "Cross-fire1";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO hospedes (nome, sobrenome, data_nascimento, nacionalidade, telefone, numero_reserva) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtNome.getText());
            preparedStatement.setString(2, txtSobrenome.getText());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(txtDataN.getDate());
            preparedStatement.setString(3, formattedDate);

            preparedStatement.setString(4, txtNacionalidade.getSelectedItem().toString());
            preparedStatement.setString(5, txtTelefone.getText());
            preparedStatement.setInt(6, Integer.parseInt(txtNreserva.getText()));

            preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "An error occurred", ex);
        }
    }

        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Registro frame = new Registro();
            frame.setVisible(true);
        });
    }
}
