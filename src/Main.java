import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Cross-fire1";

        Connection connection = null;

        try {
            // Registrar o driver JDBC corretamente
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver JDBC não encontrado.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}
