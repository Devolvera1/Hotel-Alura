import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class MouseMotionExample extends JFrame {
    private JLabel statusLabel;

    public MouseMotionExample() {
        setTitle("Mouse Motion Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        statusLabel = new JLabel("Mouse Position: ");
        add(statusLabel);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                statusLabel.setText("Mouse Position: " + x + ", " + y);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseMotionExample example = new MouseMotionExample();
            example.setVisible(true);
        });
    }
}
