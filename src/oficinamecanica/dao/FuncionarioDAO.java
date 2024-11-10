package oficinamecanica.dao;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oficinamecanica.model.Funcionario;
import oficinamecanica.util.DatabaseConnection;

public class FuncionarioDAO {
    
    //Método para adicionar um novo funcionario ao banco de daods
    public void adicionarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Funcionario(nome, cargo, telefone) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getTelefone());
            stmt.executeUpdate();
            System.out.println("Funcionário adicionado com Sucesso!");
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar Funcionário.");
        }
    }
    
    //Metodo para Listar Funcionários
    public List<Funcionario> listarFuncionarios() throws SQLException{
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql); 
            ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar funcionarios");
        }
        
        return funcionarios;
    }
    
    //Metodo para atualizar funcionario
    public void atualizarFuncionario(Funcionario funcionario) throws SQLException{
        String sql = "UPDATE Funcionario SET nome = ?, cargo = ?, telefone = ? WHERE  id = ?";
        
        try(Connection conn = DatabaseConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate();
            System.out.println("Funcionario atualizado com sucesso.");
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar Funcionario.");
        }
    }
    
    //Metodo para excluir funcionario
    public void excluirFuncionario(int id) throws SQLException {
        String sql = "DELETE FROM Funcionario WHERE id = ?";
        
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Funcionario excluido com sucesso!");
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar funcionario.");
        }
    }
    
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM Funcionario WHERE id = ?";
        Funcionario funcionario = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar funcionário por ID.");
        }

        return funcionario;
    }

}
