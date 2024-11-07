package oficinamecanica.service;

import oficinamecanica.dao.ClienteDAO;
import oficinamecanica.model.Cliente;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrarCliente(Cliente cliente) {
        // Validação simples (ex.: verificar formato do email)
        if (cliente.getEmail() != null && cliente.getEmail().contains("@")) {
            clienteDAO.adicionarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Email inválido");
        }
    }

    // Outros métodos da camada de serviços, como buscar, atualizar, etc.
    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id);
    }
}
