package oficinamecanica.teste;

import java.util.Date;
import java.util.List;
import oficinamecanica.dao.OrdemServicoDAO;
import oficinamecanica.model.OrdemServico;

public class TesteOrdemServicoDAO {
    public static void main(String[] args) {
        OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
        
        // Testar Adição de Ordem de Serviço
        OrdemServico novaOrdem = new OrdemServico();
        novaOrdem.setClienteId(1); // Assumindo que o cliente com ID 1 existe no banco
        novaOrdem.setVeiculoId(1); // Assumindo que o veículo com ID 1 existe no banco
        novaOrdem.setDataAbertura(new Date());
        novaOrdem.setDataFechamento(new Date());
        novaOrdem.setValorTotal(1500.00);
        novaOrdem.setStatus("Em andamento");
        
        ordemServicoDAO.adicionarOrdemServico(novaOrdem);
        System.out.println("Ordem de serviço adicionada.");

        // Testar Listagem de Ordens de Serviço
        List<OrdemServico> ordens = ordemServicoDAO.listarOrdemServicos();
        System.out.println("Listando todas as ordens de serviço:");
        for (OrdemServico ordem : ordens) {
            System.out.println("ID: " + ordem.getId() + ", Cliente ID: " + ordem.getClienteId() + 
                               ", Veículo ID: " + ordem.getVeiculoId() + ", Status: " + ordem.getStatus());
        }

        // Testar Atualização de Ordem de Serviço
        if (!ordens.isEmpty()) {
            OrdemServico ordemParaAtualizar = ordens.get(0);
            ordemParaAtualizar.setStatus("Concluída");
            ordemParaAtualizar.setValorTotal(2000.00);
            ordemServicoDAO.atualizarOrdemServico(ordemParaAtualizar);
            System.out.println("Ordem de serviço atualizada com sucesso!");
        }

        // Testar Exclusão de Ordem de Serviço
        if (!ordens.isEmpty()) {
            int ordemIdParaExcluir = ordens.get(0).getId();
            ordemServicoDAO.excluirOrdemServico(ordemIdParaExcluir);
            System.out.println("Ordem de serviço excluída com sucesso!");
        }
    }
}
