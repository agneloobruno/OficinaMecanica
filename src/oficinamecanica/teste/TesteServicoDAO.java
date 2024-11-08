package oficinamecanica.teste;

import oficinamecanica.dao.ServicoDAO;
import oficinamecanica.model.Servico;
import java.util.List;

public class TesteServicoDAO {
    public static void main(String[] args) {
        ServicoDAO servicoDAO = new ServicoDAO();

        // Teste de Adição de Serviço
        Servico novoServico = new Servico();
        novoServico.setDescricao("Troca de óleo");
        novoServico.setPreco(100.00);
        
        servicoDAO.adicionarServico(novoServico);
        System.out.println("Serviço adicionado com sucesso.");

        // Teste de Listagem de Serviços
        List<Servico> servicos = servicoDAO.listarServicos();
        System.out.println("Listando todos os serviços:");
        for (Servico servico : servicos) {
            System.out.println("ID: " + servico.getId() + ", Descrição: " + servico.getDescricao() + ", Preço: " + servico.getPreco());
        }

        // Teste de Atualização de Serviço
        if (!servicos.isEmpty()) {
            Servico servicoParaAtualizar = servicos.get(0); // Pega o primeiro serviço da lista
            servicoParaAtualizar.setDescricao("Troca de óleo completo");
            servicoParaAtualizar.setPreco(150.00);
            
            servicoDAO.atualizarServico(servicoParaAtualizar);
            System.out.println("Serviço atualizado com sucesso.");
        }

        // Teste de Busca de Serviço por ID
        if (!servicos.isEmpty()) {
            int servicoId = servicos.get(0).getId(); // Pega o ID do primeiro serviço
            Servico servicoBuscado = servicoDAO.buscarPorId(servicoId);
            if (servicoBuscado != null) {
                System.out.println("Serviço encontrado:");
                System.out.println("ID: " + servicoBuscado.getId());
                System.out.println("Descrição: " + servicoBuscado.getDescricao());
                System.out.println("Preço: " + servicoBuscado.getPreco());
            } else {
                System.out.println("Serviço com ID " + servicoId + " não encontrado.");
            }
        }

        // Teste de Exclusão de Serviço
        if (!servicos.isEmpty()) {
            int servicoIdParaExcluir = servicos.get(0).getId();
            servicoDAO.excluirServico(servicoIdParaExcluir);
            System.out.println("Serviço excluído com sucesso.");
        }
    }
}
