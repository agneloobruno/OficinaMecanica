package oficinamecanica.ui;

import oficinamecanica.model.Cliente;
import oficinamecanica.service.ClienteService;
import java.util.Scanner;

public class ClienteForm {
    private ClienteService clienteService = new ClienteService();

    public void exibirFormularioCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);

        clienteService.cadastrarCliente(cliente);
    }
}
