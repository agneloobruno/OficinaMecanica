package oficinamecanica.service;

import oficinamecanica.dao.ServicoDAO;
import oficinamecanica.model.Servico;

import java.util.List;

public class ServicoService {
    private ServicoDAO servicoDAO = new ServicoDAO();

    public boolean cadastrarServico(Servico servico) {
        // Verificar se o preço é válido
        if (servico.getPreco() <= 0) {
            System.out.println("Erro: O preço do serviço deve ser positivo.");
            return false;
        }

        servicoDAO.adicionarServico(servico);
        System.out.println("Serviço cadastrado com sucesso!");
        return true;
    }

    public List<Servico> listarServicos() {
        return servicoDAO.listarServicos();
    }

    public Servico buscarServicoPorId(int id) {
        return servicoDAO.buscarPorId(id);
    }

    public boolean atualizarServico(Servico servico) {
        if (servicoDAO.buscarPorId(servico.getId()) == null) {
            System.out.println("Erro: Serviço não encontrado.");
            return false;
        }

        servicoDAO.atualizarServico(servico);
        System.out.println("Serviço atualizado com sucesso!");
        return true;
    }

    public boolean excluirServico(int id) {
        if (servicoDAO.buscarPorId(id) == null) {
            System.out.println("Erro: Serviço não encontrado.");
            return false;
        }

        servicoDAO.excluirServico(id);
        System.out.println("Serviço excluído com sucesso!");
        return true;
    }
}
