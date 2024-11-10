package oficinamecanica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oficinamecanica.model.Servico;
import oficinamecanica.util.DatabaseConnection;

public class ServicoDAO {

    // Método para adicionar um novo serviço
    public void adicionarServico(Servico servico) {
        String sql = "INSERT INTO Servico (descricao, preco) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());

            stmt.executeUpdate();
            System.out.println("Serviço adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar serviço.");
        }
    }

    // Método para listar todos os serviços
    public List<Servico> listarServicos() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM Servico";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                servicos.add(servico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar serviços.");
        }

        return servicos;
    }

    // Método para atualizar um serviço existente
    public void atualizarServico(Servico servico) {
        String sql = "UPDATE Servico SET descricao = ?, preco = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());
            stmt.setInt(3, servico.getId());

            stmt.executeUpdate();
            System.out.println("Serviço atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar serviço.");
        }
    }

    // Método para excluir um serviço
    public void excluirServico(int id) {
        String sql = "DELETE FROM Servico WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Serviço excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir serviço.");
        }
    }

    // Método para buscar um serviço por ID
    public Servico buscarPorId(int id) {
        String sql = "SELECT * FROM Servico WHERE id = ?";
        Servico servico = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar serviço por ID.");
        }

        return servico;
    }
}
