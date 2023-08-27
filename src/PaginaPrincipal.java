import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;



public class PaginaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton closeButton;

    public PaginaPrincipal() {
        initializeUI();
    }

    private void initializeUI() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 609);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        addSidePanel();
        addNewPanel();
    }

    private void addSidePanel() {
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 191, 255));
        panel_1.setForeground(Color.WHITE);
        panel_1.setBounds(0, 0, 250, 609);
        panel_1.setLayout(null);
        contentPane.add(panel_1);

        ImageIcon icon = new ImageIcon("src/imagenes/aH-150px.png");
        JLabel label = new JLabel(icon);
        int iconX = (panel_1.getWidth() - icon.getIconWidth()) / 2;
        label.setBounds(iconX, 20, icon.getIconWidth(), icon.getIconHeight());
        panel_1.add(label);

        JButton btnRegistro = new JButton();
        btnRegistro.setBounds(15, 255, 257, 56);
        btnRegistro.setOpaque(false);
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.setBorderPainted(false);
        btnRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel_1.add(btnRegistro);

        JLabel labelRegistro = new JLabel("Registro de reservas");
        labelRegistro.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/reservado.png")));
        labelRegistro.setForeground(Color.WHITE); // Corrigida a cor do texto
        labelRegistro.setBounds(0, 11, 205, 34);
        labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
        btnRegistro.add(labelRegistro);

        btnRegistro.addActionListener(e -> {
            Registro Registro = new Registro();
            Registro.setVisible(true);

            dispose();
        });

        JButton btnBuscar = new JButton();
        btnBuscar.setBounds(15, 321, 257, 56);
        btnBuscar.setOpaque(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel_1.add(btnBuscar);

        JLabel labelBuscar = new JLabel("Buscar");
        labelBuscar.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/pessoas.png")));
        labelBuscar.setForeground(Color.WHITE); // Corrigida a cor do texto
        labelBuscar.setBounds(0, 11, 205, 34);
        labelBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelBuscar.setHorizontalAlignment(SwingConstants.LEFT);
        btnBuscar.add(labelBuscar);

        btnBuscar.addActionListener(e -> {
            Buscar Buscar = new Buscar();
            Buscar.setVisible(true);

            dispose();
        });

    }

    private void addNewPanel() {
        JPanel newPanel = new JPanel();
        newPanel.setBounds(250, 0, 694, 609);
        newPanel.setBackground(Color.white);
        newPanel.setLayout(null);
        contentPane.add(newPanel);

        closeButton = new JButton();
        closeButton.setBounds(600, 530, 50, 50); // Reduzindo o tamanho para acomodar o ícone
        closeButton.setIcon(new ImageIcon("src/imagenes/exit.png")); // Substitua pelo caminho correto do ícone
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false); // Remove a área de preenchimento
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        newPanel.add(closeButton);




        closeButton.addActionListener(e -> {
            System.exit(0);
        });


        JPanel panelFecha = new JPanel();
        panelFecha.setBackground(new Color(118, 187, 223));
        panelFecha.setBounds(0, 60, 694, 100);
        newPanel.add(panelFecha);
        panelFecha.setLayout(null);

        JLabel lblTituloPrincipal = new JLabel("Sistema de reservas Hotel Alura");
        lblTituloPrincipal.setBounds(180, 11, 356, 42);
        panelFecha.add(lblTituloPrincipal);
        lblTituloPrincipal.setForeground(Color.WHITE);
        lblTituloPrincipal.setFont(new Font("Roboto", Font.PLAIN, 24));

        JLabel labelFecha = new JLabel("New label");
        labelFecha.setBounds(35, 64, 294, 36);
        panelFecha.add(labelFecha);
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
        Date fechaActual = new Date(); //data atual
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formata a data numa string
        labelFecha.setText("Hoje é " + fecha); //estabelece a data na label

        JLabel lbltitulo = new JLabel("Bem-vindo");
        lbltitulo.setFont(new Font("Roboto", Font.BOLD, 24));
        lbltitulo.setBounds(20, 160, 694, 100);
        newPanel.add(lbltitulo);

        String textoDescripcion = "<html><body>Sistema de reservas de hotéis. Controle e gerencie de forma otimizada e fácil <br> o fluxo de reservas e hóspedes do hotel   </body></html>";
        JLabel labelDescripcion_0 = new JLabel(textoDescripcion);
        labelDescripcion_0.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescripcion_0.setBounds(20, 220, 694, 100);
        newPanel.add(labelDescripcion_0);

        String textoDescricao1 = "<html><body> Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiais para tarefas específicas como:</body></html>";
        JLabel labelDescricao_1 = new JLabel(textoDescricao1);
        labelDescricao_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_1.setBounds(20, 300, 694, 90);
        newPanel.add(labelDescricao_1);

        JLabel labelDescricao_2 = new JLabel("- Registro de Reservas e Hóspedes");
        labelDescricao_2.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_2.setBounds(20, 400, 694, 30);
        newPanel.add(labelDescricao_2);

        JLabel labelDescricao_3 = new JLabel("- Edição de Reservas e Hóspedes existentes");
        labelDescricao_3.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_3.setBounds(20, 450, 694, 30);
        newPanel.add(labelDescricao_3);

        JLabel labelDescricao_4 = new JLabel("- Excluir todos os tipos de registros");
        labelDescricao_4.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_4.setBounds(20, 500, 694, 30);
        newPanel.add(labelDescricao_4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaPrincipal frame = new PaginaPrincipal();
            frame.setVisible(true);
        });
    }
}
