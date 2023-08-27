import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNome.setBounds(560, 135, 285, 33);
        txtNome.setBackground(Color.WHITE);
        txtNome.setColumns(10);
        txtNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNome);

        txtSobrenome = new JTextField();
        txtSobrenome.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtSobrenome.setBounds(560, 204, 285, 33);
        txtSobrenome.setColumns(10);
        txtSobrenome.setBackground(Color.WHITE);
        txtSobrenome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtSobrenome);

        txtDataN = new JDateChooser();
        txtDataN.setBounds(560, 278, 285, 36);
        txtDataN.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtDataN.setDateFormatString("yyyy-MM-dd");
        contentPane.add(txtDataN);

        txtNacionalidade = new JComboBox();
        txtNacionalidade.setBounds(560, 350, 289, 36);
        txtNacionalidade.setBackground(SystemColor.text);
        txtNacionalidade.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNacionalidade.setModel(new DefaultComboBoxModel(new String[] {"alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio", "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano", "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês", "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano", "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês", "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano", "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano", "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco", "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano", "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino", "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense", "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano", "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano", "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio", "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio37", "malawiano", "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense", "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano", "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani", "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio", "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano", "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense", "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio", "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês", "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano", "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense", "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano"}));
        contentPane.add(txtNacionalidade);

        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(562, 119, 253, 14);
        lblNome.setForeground(SystemColor.textInactiveText);
        lblNome.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNome);

        JLabel lblSobrenome = new JLabel("SOBRENOME");
        lblSobrenome.setBounds(560, 189, 255, 14);
        lblSobrenome.setForeground(SystemColor.textInactiveText);
        lblSobrenome.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblSobrenome);

        JLabel lblDataN = new JLabel("DATA DE NASCIMENTO");
        lblDataN.setBounds(560, 256, 255, 14);
        lblDataN.setForeground(SystemColor.textInactiveText);
        lblDataN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblDataN);

        JLabel lblNacionalidade = new JLabel("NACIONALIDADE");
        lblNacionalidade.setBounds(560, 326, 255, 14);
        lblNacionalidade.setForeground(SystemColor.textInactiveText);
        lblNacionalidade.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidade);

        JLabel lblTelefone = new JLabel("TELEFONE");
        lblTelefone.setBounds(562, 406, 253, 14);
        lblTelefone.setForeground(SystemColor.textInactiveText);
        lblTelefone.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtTelefone.setBounds(560, 424, 285, 33);
        txtTelefone.setColumns(10);
        txtTelefone.setBackground(Color.WHITE);
        txtTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtTelefone);

        JLabel lblTitulo = new JLabel("REGISTRO HÓSPEDE");
        lblTitulo.setBounds(590, 55, 250, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
        contentPane.add(lblTitulo);

        JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
        lblNumeroReserva.setBounds(560, 474, 253, 14);
        lblNumeroReserva.setForeground(SystemColor.textInactiveText);
        lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNumeroReserva);

        txtNreserva = new JTextField();
        txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNreserva.setBounds(560, 495, 285, 33);
        txtNreserva.setColumns(10);
        txtNreserva.setBackground(Color.WHITE);
        txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNreserva);

        JPanel btnsalvar = new JPanel();
        btnsalvar.setBounds(723, 560, 122, 35);
        btnsalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnsalvar.setLayout(null);
        btnsalvar.setBackground(new Color(12, 138, 199));
        contentPane.add(btnsalvar);
        btnsalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel labelSalvar = new JLabel("SALVAR");
        labelSalvar.setHorizontalAlignment(SwingConstants.CENTER);
        labelSalvar.setForeground(Color.WHITE);
        labelSalvar.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelSalvar.setBounds(0, 0, 122, 35);
        btnsalvar.add(labelSalvar);







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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Registro frame = new Registro();
            frame.setVisible(true);
        });
    }
}
