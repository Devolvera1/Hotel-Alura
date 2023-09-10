import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_one";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT RESERVAS.ID, HOSPEDES.ID_RESERVA FROM RESERVAS " +
                    "JOIN HOSPEDES ON RESERVAS.ID = HOSPEDES.ID_RESERVA";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int idReserva = resultSet.getInt("RESERVAS.ID");
                        int idHospede = resultSet.getInt("HOSPEDES.ID_RESERVA");

                        System.out.println("Reserva ID: " + idReserva + ", Hospede ID Reserva: " + idHospede);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
