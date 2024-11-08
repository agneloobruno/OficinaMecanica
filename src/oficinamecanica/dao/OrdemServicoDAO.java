package oficinamecanica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oficinamecanica.model.OrdemServico;
import oficinamecanica.util.DatabaseConnection;

public class OrdemServicoDAO {

    // Método para adicionar uma nova ordem de serviço
    public void adicionarOrdemServico(OrdemServico ordemServico) {
        String sql = "INSERT INTO OrdemServico (cliente_id, veiculo_id, data_abertura, data_fechamento, valor_total, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ordemServico.getClienteId()); // cliente_id no banco
            stmt.setInt(2, ordemServico.getVeiculoId()); // veiculo_id no banco
            stmt.setDate(3, new Date(ordemServico.getDataAbertura().getTime())); // data_abertura no banco
            stmt.setDate(4, new Date(ordemServico.getDataFechamento().getTime())); // data_fechamento no banco
            stmt.setDouble(5, ordemServico.getValorTotal()); // valor_total no banco
            stmt.setString(6, ordemServico.getStatus()); // status no banco

            stmt.executeUpdate();
            System.out.println("Ordem de serviço adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar ordem de serviço.");
        }
    }

    // Método para listar todas as ordens de serviço
    public List<OrdemServico> listarOrdemServicos() {
        List<OrdemServico> ordens = new ArrayList<>();
        String sql = "SELECT * FROM OrdemServico";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                OrdemServico ordem = new OrdemServico();
                ordem.setId(rs.getInt("id")); // id no banco
                ordem.setClienteId(rs.getInt("cliente_id")); // cliente_id no banco
                ordem.setVeiculoId(rs.getInt("veiculo_id")); // veiculo_id no banco
                ordem.setDataAbertura(rs.getDate("data_abertura")); // data_abertura no banco
                ordem.setDataFechamento(rs.getDate("data_fechamento")); // data_fechamento no banco
                ordem.setValorTotal(rs.getDouble("valor_total")); // valor_total no banco
                ordem.setStatus(rs.getString("status")); // status no banco
                ordens.add(ordem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar ordens de serviço.");
        }

        return ordens;
    }

    // Método para atualizar uma ordem de serviço existente
    public void atualizarOrdemServico(OrdemServico ordemServico) {
        String sql = "UPDATE OrdemServico SET cliente_id = ?, veiculo_id = ?, data_abertura = ?, data_fechamento = ?, valor_total = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ordemServico.getClienteId()); // cliente_id no banco
            stmt.setInt(2, ordemServico.getVeiculoId()); // veiculo_id no banco
            stmt.setDate(3, new Date(ordemServico.getDataAbertura().getTime())); // data_abertura no banco
            stmt.setDate(4, new Date(ordemServico.getDataFechamento().getTime())); // data_fechamento no banco
            stmt.setDouble(5, ordemServico.getValorTotal()); // valor_total no banco
            stmt.setString(6, ordemServico.getStatus()); // status no banco
            stmt.setInt(7, ordemServico.getId()); // id no banco

            stmt.executeUpdate();
            System.out.println("Ordem de serviço atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar ordem de serviço.");
        }
    }

    // Método para excluir uma ordem de serviço
    public void excluirOrdemServico(int id) {
        String sql = "DELETE FROM OrdemServico WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Ordem de serviço excluída com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir ordem de serviço.");
        }
    }
    
      // Método para buscar uma ordem de serviço por ID
    public OrdemServico buscarPorId(int id) {
        String sql = "SELECT * FROM OrdemServico WHERE id = ?";
        OrdemServico ordemServico = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ordemServico = new OrdemServico();
                ordemServico.setId(rs.getInt("id"));
                ordemServico.setClienteId(rs.getInt("cliente_id"));
                ordemServico.setVeiculoId(rs.getInt("veiculo_id"));
                ordemServico.setDataAbertura(rs.getDate("data_abertura"));
                ordemServico.setDataFechamento(rs.getDate("data_fechamento"));
                ordemServico.setValorTotal(rs.getDouble("valor_total"));
                ordemServico.setStatus(rs.getString("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar ordem de serviço por ID.");
        }

        return ordemServico;
    }
}
