import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class Registro extends JFrame {
    private JPanel contentPane;
    private static final String IMAGE_PATH = "src/imagenes/reservas-img-3.png";
    private JTextField txtValor;
    private JDateChooser txtCheck_IN;
    private JDateChooser txtCheck_out;
    private JComboBox<String> txtFormaPagamento;

    public Registro() {
        initializeUI();
        addBackgroundImage();
        createFieldsAndLabels();
        createButtons();
    }


    private void addBackgroundImage() {
        ImageIcon backgroundImageIcon = new ImageIcon(IMAGE_PATH);
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 1200, 634);
        contentPane.add(backgroundImageLabel);

        JLabel labelTitulo = new JLabel("SISTEMA DE RESERVAS");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setBounds(80, 150, 285, 14);
        Font fonte = labelTitulo.getFont();
        labelTitulo.setFont(new Font(fonte.getName(), Font.PLAIN, 18));
        contentPane.add(labelTitulo);

        ImageIcon icon = new ImageIcon("src/imagenes/Ha-100px.png");
        JLabel label = new JLabel(icon);
        label.setBounds(10, 10, 150, 100);
        contentPane.add(label);

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
        setWindowProperties();
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
        JLabel lblCheck_IN = new JLabel("CHECK-IN");
        lblCheck_IN.setBounds(50, 200, 255, 14);
        lblCheck_IN.setForeground(SystemColor.textInactiveText);
        lblCheck_IN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblCheck_IN);

        txtCheck_IN = new JDateChooser();
        txtCheck_IN.setBounds(50, 220, 253, 25);
        contentPane.add(txtCheck_IN);

        JLabel lblCheck_out = new JLabel("CHECK-OUT");
        lblCheck_out.setBounds(50, 260, 255, 14);
        lblCheck_out.setForeground(SystemColor.textInactiveText);
        lblCheck_out.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblCheck_out);

        txtCheck_out = new JDateChooser();
        txtCheck_out.setBounds(50, 280, 253, 25);
        contentPane.add(txtCheck_out);

        JLabel lblValor = new JLabel("VALOR DA RESERVA");
        lblValor.setForeground(SystemColor.textInactiveText);
        lblValor.setBounds(50, 320, 196, 14);
        lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(50, 340, 250, 27);
        contentPane.add(txtValor);

        JLabel lblPgto = new JLabel("VALOR DA RESERVA");
        lblPgto.setForeground(SystemColor.textInactiveText);
        lblPgto.setBounds(50, 370, 289, 38);
        lblPgto.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblPgto);

        txtFormaPagamento = new JComboBox<>();
        txtFormaPagamento.setBounds(50, 400, 250, 32);
        txtFormaPagamento.setBackground(SystemColor.text);
        txtFormaPagamento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtFormaPagamento.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtFormaPagamento.setModel(new DefaultComboBoxModel<>(new String[]{"Cartão de Crédito", "Cartão de Débito", "Dinheiro"}));
        contentPane.add(txtFormaPagamento);
    }


    private void createButtons() {
        JButton btnSave = new JButton("Continuar");
        btnSave.setBounds(170, 450, 130, 36);
        btnSave.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnSave.setBackground(Color.WHITE);
        contentPane.add(btnSave);
        ImageIcon icon = new ImageIcon("src/imagenes/save.png");
        btnSave.setIcon(icon);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areAllFieldsFilled()) {
                    saveToDatabase();
                    RegistroHospede usuario = new RegistroHospede();
                    usuario.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(Registro.this, "Preencha todos os campos antes de continuar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean areAllFieldsFilled() {
        return txtCheck_IN.getDate() != null &&
                txtCheck_out.getDate() != null &&
                !txtValor.getText().isEmpty() &&
                txtFormaPagamento.getSelectedItem() != null;
    }

    private void saveToDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_one", "root", "root")) {
            String sql = "INSERT INTO reservas (DATA_ENTRADA, DATA_SAIDA, VALOR, FORMA_PAGAMENTO) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Get values from JDateChooser and JTextField components
                java.sql.Date checkInDate = new java.sql.Date(txtCheck_IN.getDate().getTime());
                java.sql.Date checkOutDate = new java.sql.Date(txtCheck_out.getDate().getTime());
                double valor = Double.parseDouble(txtValor.getText());
                String formaPagamento = txtFormaPagamento.getSelectedItem().toString();

                preparedStatement.setDate(1, checkInDate);
                preparedStatement.setDate(2, checkOutDate);
                preparedStatement.setDouble(3, valor);
                preparedStatement.setString(4, formaPagamento);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Reserva salva com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao salvar reserva.");
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Registro frame = new Registro();
            frame.setVisible(true);
        });
    }
}
