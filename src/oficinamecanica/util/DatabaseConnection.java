package oficinamecanica.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // URL de conexão ao banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/oficina_mecanica"; // substitua pelo nome do seu banco
    private static final String USER = "root"; // substitua pelo seu usuário MySQL
    private static final String PASSWORD = "minha_senha"; // substitua pela sua senha MySQL

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

