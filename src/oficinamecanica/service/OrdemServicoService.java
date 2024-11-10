package oficinamecanica.service;

import oficinamecanica.dao.OrdemServicoDAO;
import oficinamecanica.model.OrdemServico;

import java.util.List;

public class OrdemServicoService {
    private OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();

    public boolean cadastrarOrdemServico(OrdemServico ordemServico) {
        // Validar campos obrigatórios
        if (ordemServico.getClienteId() <= 0 || ordemServico.getVeiculoId() <= 0) {
            System.out.println("Erro: Cliente e Veículo são obrigatórios.");
            return false;
        }

        // Salvar a ordem de serviço
        ordemServicoDAO.adicionarOrdemServico(ordemServico);
        System.out.println("Ordem de serviço cadastrada com sucesso!");
        return true;
    }

    public List<OrdemServico> listarOrdensServico() {
        return ordemServicoDAO.listarOrdemServicos();
    }

    public OrdemServico buscarOrdemServicoPorId(int id) {
        return ordemServicoDAO.buscarPorId(id);
    }

    public boolean atualizarOrdemServico(OrdemServico ordemServico) {
        if (ordemServicoDAO.buscarPorId(ordemServico.getId()) == null) {
            System.out.println("Erro: Ordem de serviço não encontrada.");
            return false;
        }

        ordemServicoDAO.atualizarOrdemServico(ordemServico);
        System.out.println("Ordem de serviço atualizada com sucesso!");
        return true;
    }

    public boolean excluirOrdemServico(int id) {
        if (ordemServicoDAO.buscarPorId(id) == null) {
            System.out.println("Erro: Ordem de serviço não encontrada.");
            return false;
        }

        ordemServicoDAO.excluirOrdemServico(id);
        System.out.println("Ordem de serviço excluída com sucesso!");
        return true;
    }
}
