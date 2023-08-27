import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetodoBuscar extends JPanel {
    private JTextField txtBuscar;
    private JButton btnBuscar;

    public MetodoBuscar() {
        setLayout(null);
        setBackground(new Color(240, 240, 240));

        txtBuscar = new JTextField();
        txtBuscar.setBounds(10, 10, 150, 30);
        add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(170, 10, 90, 30);
        btnBuscar.setBackground(new Color(12, 138, 199));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnBuscar);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch(); // Call the method to perform the search
            }
        });
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    // Method to perform the search
    private void performSearch() {
        String searchTerm = txtBuscar.getText().trim();
    }

    // Example method to show the panel
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.add(new MetodoBuscar());
            frame.setVisible(true);
        });
    }
}
