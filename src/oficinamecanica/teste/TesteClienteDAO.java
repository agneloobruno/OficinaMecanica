package oficinamecanica.teste;

import oficinamecanica.dao.ClienteDAO;
import oficinamecanica.model.Cliente;

public class TesteClienteDAO {
    public static void main(String[] args){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente(0, "João Silva", "123456789", "joao@email.com");
        
        //Testar adição de Cliente
        clienteDAO.adicionarCliente(cliente);
        
        //Testar listagem de clientes
        for(Cliente c : clienteDAO.listarClientes()){
            System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome());            
        }
        
        //Testar atualização de cliente
        cliente.setNome("Joao Silva Atualizado");
        clienteDAO.atualizarCliente(cliente);
        
        //Testar exclusão de cliente
        clienteDAO.excluirCliente(cliente.getId());
    }
}
