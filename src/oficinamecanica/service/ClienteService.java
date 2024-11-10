package oficinamecanica.service;

import java.util.List;
import oficinamecanica.dao.ClienteDAO;
import oficinamecanica.model.Cliente;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    public boolean cadastrarCliente(Cliente cliente) {
        // Verificar se o cliente já existe pelo email
        if (clienteDAO.existeClientePorEmail(cliente.getEmail())) {
            System.out.println("Erro: Cliente com o email '" + cliente.getEmail() + "' já existe.");
            return false;
        }
        
        // Validar campos obrigatórios
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            System.out.println("Erro: O nome do cliente é obrigatório.");
            return false;
        }
        
        // Se estiver tudo certo, adiciona o cliente
        clienteDAO.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        return true;
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id);
    }

    public boolean atualizarCliente(Cliente cliente) {
        // Verificar se o cliente existe antes de atualizar
        if (clienteDAO.buscarPorId(cliente.getId()) == null) {
            System.out.println("Erro: Cliente não encontrado.");
            return false;
        }

        clienteDAO.atualizarCliente(cliente);
        System.out.println("Cliente atualizado com sucesso!");
        return true;
    }

    public boolean excluirCliente(int id) {
        // Verificar se o cliente existe antes de excluir
        if (clienteDAO.buscarPorId(id) == null) {
            System.out.println("Erro: Cliente não encontrado.");
            return false;
        }

        clienteDAO.excluirCliente(id);
        System.out.println("Cliente excluído com sucesso!");
        return true;
    }

}
