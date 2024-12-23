package oficinamecanica.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oficinamecanica.model.Cliente;
import oficinamecanica.util.DatabaseConnection;

public class ClienteDAO {
    
    //Método para adicionar um novo cliete ao banco de daods
    public int adicionarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, telefone, email) VALUES (?, ?, ?)";
        int generatedId = -1;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());

            stmt.executeUpdate();

            // Obter o ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            System.out.println("Cliente cadastrado com sucesso com ID: " + generatedId);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar cliente.");
            throw e;
        }
        return generatedId;
    }

    
    //Método para listar todos os clientes
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar clientes.");
        }
        
        return clientes;
    }
    
    // Método para atualizar um cliente existente
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, telefone = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getId());

            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar cliente.");
        }
    }

    // Método para excluir um cliente
    public void excluirCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Cliente excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir cliente.");
        }
    }
    
    // Método para buscar um cliente por ID
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        Cliente cliente = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id")); // id no banco de dados
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente por ID.");
        }
        
        

        return cliente;
    }

    public boolean existeClientePorEmail(String email) {
        String sql = "SELECT 1 FROM Cliente WHERE email = ?";
        boolean existe = false;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true; // Se houver resultado, o cliente existe
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao verificar se o cliente existe por email.");
        }

        return existe;
    }
    
}
