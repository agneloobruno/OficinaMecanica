package oficinamecanica.dao;

import oficinamecanica.model.Veiculo;
import oficinamecanica.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oficinamecanica.model.OrdemServico;

public class VeiculoDAO {
    
    //Metodo para adicionar veiculo
    public void adicionarVeiculo(Veiculo veiculo) throws SQLException{
        String sql = "INSERT INTO Veiculo (cliente_id, placa, marca, modelo, ano) VALUES (?, ?, ?, ?, ?)";
        
        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, veiculo.getClienteId());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3,veiculo.getMarca());
            stmt.setString(4, veiculo.getModelo());
            stmt.setInt(5, veiculo.getAno());
            
            stmt.executeUpdate();
            System.out.println("Veiculo cadastrado com sucesso!");
            
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao cadastrar veiculo");
        }
    }
    
    // Método para listar todas as ordens de serviço
    public List<Veiculo> listarVeiculo() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM Veiculo";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id")); // id no banco
                veiculo.setClienteId(rs.getInt("cliente_id")); // cliente_id no banco
                veiculo.setPlaca(rs.getString("placa")); 
                veiculo.setMarca(rs.getString("marca")); 
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculos.add(veiculo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar ordens de serviço.");
        }

        return veiculos;
    }

    // Método para atualizar uma ordem de serviço existente
    public void atualizarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE OrdemServico SET cliente_id = ?, ano = ?, data_abertura = ?, data_fechamento = ?, valor_total = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, veiculo.getClienteId()); // cliente_id no banco
            stmt.setInt(2, veiculo.getAno()); 
            stmt.setString(5, veiculo.getPlaca()); 
            stmt.setString(6, veiculo.getMarca()); 
            stmt.setInt(7, veiculo.getId()); // id no banco
            stmt.setString(8, veiculo.getModelo());

            stmt.executeUpdate();
            System.out.println("Veiculo atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar veiculo.");
        }
    }

    // Método para excluir 
    public void excluirVeiculo(int id) {
        String sql = "DELETE FROM Veiculo WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Veiculo excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir Veiculo.");
        }
    }

    public Veiculo buscarPorId(int id) {
        String sql = "SELECT * FROM Veiculo WHERE id = ?";
        Veiculo veiculo = null;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
             veiculo.setPlaca(rs.getString("placa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar veículo por ID.");
        }

        return veiculo;
    }

}

