import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Buscar extends JFrame {
    private JTable tbReservas;
    private JTable tbHospedes;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHospedes;
    private EditButton editButton;
    private DeleteButton deleteButton;

    private JTextField txtBuscar;

    public Buscar() {
        initializeUI();
    }

    private void initializeUI() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblTitulo.setBounds(331, 62, 280, 42);
        contentPane.add(lblTitulo);

        MetodoBuscar MetodoBuscar = new MetodoBuscar();
        MetodoBuscar.setBounds(536, 127, 260, 50);
        contentPane.add(MetodoBuscar);

        // Table config
        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = new DefaultTableModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Data Check In");
        modelo.addColumn("Data Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pgto");
        tbReservas.setModel(modelo);

        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/imagenes/reservado.png")), scroll_table);

// Chame o método para preencher os dados da tabela de reservas
        fetchDataFromDatabaseForReservas();

        tbHospedes = new JTable();
        tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloHospedes = new DefaultTableModel();
        modeloHospedes.addColumn("Numero de Hóspede");
        modeloHospedes.addColumn("Nome");
        modeloHospedes.addColumn("Sobrenome");
        modeloHospedes.addColumn("Data de Nascimento");
        modeloHospedes.addColumn("Nacionalidade");
        modeloHospedes.addColumn("Telefone");
        modeloHospedes.addColumn("Numero de Reserva");
        tbHospedes.setModel(modeloHospedes);

        fetchDataFromDatabaseForHospedes();

        JScrollPane scroll_tableHospedes = new JScrollPane(tbHospedes);
        panel.addTab("Hóspedes", new ImageIcon(Buscar.class.getResource("/imagenes/pessoas.png")), scroll_tableHospedes);

        editButton = new EditButton("Edit", tbReservas, modelo);
        editButton.setBounds(536, 497, 122, 35);
        contentPane.add(editButton);

        deleteButton = new DeleteButton("Delete", tbReservas, modelo);
        deleteButton.setBounds(668, 497, 122, 35);
        contentPane.add(deleteButton);

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

    // BCO DADOS CONFIG.
    private void fetchDataFromDatabaseForHospedes() {
        String url = "jdbc:mysql://localhost:3306/db_one";
        String username = "root";
        String password = "Cross-fire1";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM db_one.hospedes";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            modeloHospedes.setRowCount(0);

            while (resultSet.next()) {
                Object[] rowData = new Object[7];  // Adjust the number of columns as needed
                for (int i = 1; i <= 7; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                modeloHospedes.addRow(rowData);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fetchDataFromDatabaseForReservas() {
        String url = "jdbc:mysql://localhost:3306/db_one";
        String username = "root";
        String password = "Cross-fire1";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM db_one.reservas";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            modelo.setRowCount(0);

            while (resultSet.next()) {
                Object[] rowData = new Object[5];  // Adjust the number of columns as needed
                for (int i = 1; i <= 5; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                modelo.addRow(rowData);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Buscar frame = new Buscar();
            frame.setVisible(true);
        });
    }
}
