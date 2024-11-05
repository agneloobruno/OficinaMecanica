package oficinamecanica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/oficina_mecanica"; // substitua pelo nome do seu banco de dados
        String user = "root"; // substitua pelo seu usuário MySQL
        String password = "minha_senha"; // substitua pela sua senha MySQL

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}
