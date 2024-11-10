package oficinamecanica.service;

import java.sql.SQLException;
import oficinamecanica.dao.VeiculoDAO;
import oficinamecanica.model.Veiculo;

import java.util.List;

public class VeiculoService {
    private VeiculoDAO veiculoDAO = new VeiculoDAO();

    public boolean cadastrarVeiculo(Veiculo veiculo) throws SQLException {
        
        // Verificar se o veículo possui os dados obrigatórios, como marca e modelo
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty() || veiculo.getModelo() == null || veiculo.getModelo().isEmpty()) {
            System.out.println("Erro: Marca e modelo do veículo são obrigatórios.");
            return false;
        }

        veiculoDAO.adicionarVeiculo(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        return true;
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoDAO.listarVeiculo();
    }

    public Veiculo buscarVeiculoPorId(int id) {
        return veiculoDAO.buscarPorId(id);
    }

    public boolean atualizarVeiculo(Veiculo veiculo) {
        // Verificar se o veículo existe antes de atualizar
        if (veiculoDAO.buscarPorId(veiculo.getId()) == null) {
            System.out.println("Erro: Veículo não encontrado.");
            return false;
        }

        veiculoDAO.atualizarVeiculo(veiculo);
        System.out.println("Veículo atualizado com sucesso!");
        return true;
    }

    public boolean excluirVeiculo(int id) {
        // Verificar se o veículo existe antes de excluir
        if (veiculoDAO.buscarPorId(id) == null) {
            System.out.println("Erro: Veículo não encontrado.");
            return false;
        }

        veiculoDAO.excluirVeiculo(id);
        System.out.println("Veículo excluído com sucesso!");
        return true;
    }
    
}
