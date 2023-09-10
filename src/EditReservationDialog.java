import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class EditReservationDialog extends JDialog {
    private JTextField numeroReservaField;
    private JTextField dataCheckInField;
    private JTextField dataCheckOutField;
    private JTextField valorField;
    private JTextField formaPgtoField;

    public EditReservationDialog(String[] rowData) {
        initializeUI();

        numeroReservaField.setText(rowData[0]);
        dataCheckInField.setText(rowData[1]);
        dataCheckOutField.setText(rowData[2]);
        valorField.setText(rowData[3]);
        formaPgtoField.setText(rowData[4]);
    }

    private void initializeUI() {
        setResizable(false);
        setTitle("Edit Reservation");
        setSize(300, 250);
        setModal(true);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addFieldsToPanel(panel);
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveChanges());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addFieldsToPanel(JPanel panel) {
        panel.add(new JLabel("Reservation Number:"));
        numeroReservaField = new JTextField();
        panel.add(numeroReservaField);

        panel.add(new JLabel("Check-In Date:"));
        dataCheckInField = new JTextField();
        panel.add(dataCheckInField);

        panel.add(new JLabel("Check-Out Date:"));
        dataCheckOutField = new JTextField();
        panel.add(dataCheckOutField);

        panel.add(new JLabel("Value:"));
        valorField = new JTextField();
        panel.add(valorField);

        panel.add(new JLabel("Payment Method:"));
        formaPgtoField = new JTextField();
        panel.add(formaPgtoField);
    }

    private void saveChanges() {
        String numeroReserva = numeroReservaField.getText();
        String newDataCheckIn = dataCheckInField.getText();
        String newDataCheckOut = dataCheckOutField.getText();
        String newValor = valorField.getText();
        String newFormaPgto = formaPgtoField.getText();

        String url = "jdbc:mysql://localhost:3306/db_one";
        String username = "root";
        String password = "root";

        String updateQuery = "UPDATE db_one.reservas " +
                "SET DATA_ENTRADA = ?, DATA_SAIDA = ?, valor = ?, FORMA_PAGAMENTO = ? " +
                "WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newDataCheckIn);
            preparedStatement.setString(2, newDataCheckOut);
            preparedStatement.setString(3, newValor);
            preparedStatement.setString(4, newFormaPgto);
            preparedStatement.setString(5, numeroReserva);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Changes saved successfully.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save changes.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while saving changes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class EditButton extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public EditButton(String label, JTable table, DefaultTableModel model) {
        this.table = table;
        this.model = model;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton editButton = new JButton(label);
        editButton.addActionListener(e -> performEdit());
        editButton.setLayout(null);

        add(editButton);
    }

    private void performEdit() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String[] rowData = new String[model.getColumnCount()];
            for (int col = 0; col < rowData.length; col++) {
                rowData[col] = getModelValue(selectedRow, col);
            }

            EditReservationDialog editDialog = new EditReservationDialog(rowData);
            editDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Select a record to edit.");
        }
    }

    private String getModelValue(int row, int col) {
        return model.getValueAt(row, col).toString();
    }
}


class DeleteButton extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public DeleteButton(String label, JTable table, DefaultTableModel model) {
        this.table = table;
        this.model = model;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton deleteButton = new JButton(label);
        deleteButton.addActionListener(e -> performDelete());

        add(deleteButton);
    }

    private void performDelete() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int confirmDelete = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmDelete == JOptionPane.YES_OPTION) {
                // Primeiro, obtenha o ID_RESERVA do registro que você está prestes a excluir
                String numeroReserva = getModelValue(selectedRow, 0);

                // Em seguida, atualize os registros relacionados na tabela hospedes (ou em outra tabela) para remover a referência
                updateRelatedRecords(numeroReserva);

                // Agora você pode prosseguir com a exclusão
                deleteRecord(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar");
        }
    }

    private void updateRelatedRecords(String numeroReserva) {
        String url = "jdbc:mysql://localhost:3306/db_one";
        String username = "root";
        String password = "root";

        String updateQuery = "UPDATE db_one.hospedes SET ID_RESERVA = NULL WHERE ID_RESERVA = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, numeroReserva);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Registros relacionados atualizados com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Não foram encontrados registros relacionados para atualizar.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar registros relacionados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }





    private String getModelValue(int row, int col) {
        return model.getValueAt(row, col).toString();
    }

    private void deleteRecord(int row) {
        String numeroReserva = getModelValue(row, 0);
        String url = "jdbc:mysql://localhost:3306/db_one";
        String username = "root";
        String password = "root";

        String deleteQuery = "DELETE FROM db_one.reservas WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setString(1, numeroReserva);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete record.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while deleting record.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}