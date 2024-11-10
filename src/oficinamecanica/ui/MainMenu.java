package oficinamecanica.ui;

import java.sql.SQLException;
import oficinamecanica.model.Cliente;
import oficinamecanica.model.Funcionario;
import oficinamecanica.model.OrdemServico;
import oficinamecanica.model.Servico;
import oficinamecanica.model.Veiculo;
import oficinamecanica.service.ClienteService;
import oficinamecanica.service.FuncionarioService;
import oficinamecanica.service.OrdemServicoService;
import oficinamecanica.service.ServicoService;
import oficinamecanica.service.VeiculoService;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static ClienteService clienteService = new ClienteService();
    private static FuncionarioService funcionarioService = new FuncionarioService();
    private static VeiculoService veiculoService = new VeiculoService();
    private static OrdemServicoService ordemServicoService = new OrdemServicoService();
    private static ServicoService servicoService = new ServicoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionário");
            System.out.println("3. Veículo");
            System.out.println("4. Ordem de Serviço");
            System.out.println("5. Serviço");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> menuCliente();
                case 2 -> menuFuncionario();
                case 3 -> menuVeiculo();
                case 4 -> menuOrdemServico();
                case 5 -> menuServico();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuCliente() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> atualizarCliente();
                case 4 -> excluirCliente();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuFuncionario() throws SQLException {
        int opcao;
        do {
            System.out.println("\n--- Menu Funcionário ---");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> atualizarFuncionario();
                case 4 -> excluirFuncionario();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuVeiculo() throws SQLException {
        int opcao;
        do {
            System.out.println("\n--- Menu Veículo ---");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Atualizar Veículo");
            System.out.println("4. Excluir Veículo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> listarVeiculos();
                case 3 -> atualizarVeiculo();
                case 4 -> excluirVeiculo();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuOrdemServico() {
        int opcao;
        do {
            System.out.println("\n--- Menu Ordem de Serviço ---");
            System.out.println("1. Cadastrar Ordem de Serviço");
            System.out.println("2. Listar Ordens de Serviço");
            System.out.println("3. Atualizar Ordem de Serviço");
            System.out.println("4. Excluir Ordem de Serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarOrdemServico();
                case 2 -> listarOrdensServico();
                case 3 -> atualizarOrdemServico();
                case 4 -> excluirOrdemServico();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuServico() {
        int opcao;
        do {
            System.out.println("\n--- Menu Serviço ---");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Listar Serviços");
            System.out.println("3. Atualizar Serviço");
            System.out.println("4. Excluir Serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarServico();
                case 2 -> listarServicos();
                case 3 -> atualizarServico();
                case 4 -> excluirServico();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // Métodos para Funcionário
    private static void cadastrarFuncionario() throws SQLException {
        System.out.println("\n--- Cadastrar Funcionário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
     

        funcionarioService.cadastrarFuncionario(funcionario);
    }

    private static void listarFuncionarios() throws SQLException {
        System.out.println("\n--- Lista de Funcionários ---");
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + ", Cargo: " + funcionario.getCargo());
        }
    }

    private static void atualizarFuncionario() throws SQLException {
        System.out.print("\nDigite o ID do funcionário para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            System.out.print("Novo nome: ");
            funcionario.setNome(scanner.nextLine());
            System.out.print("Novo cargo: ");
            funcionario.setCargo(scanner.nextLine());

            funcionarioService.atualizarFuncionario(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void excluirFuncionario() throws SQLException {
        System.out.print("\nDigite o ID do funcionário para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        funcionarioService.excluirFuncionario(id);
    }

    // Métodos para Veículo
    private static void cadastrarVeiculo() throws SQLException {
        
        System.out.println("\n--- Cadastrar Veículo ---");

        // Solicita o ID do cliente
        System.out.print("ID do Cliente (necessário): ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();

        // Verifica se o cliente existe
        if (clienteService.buscarClientePorId(clienteId) == null) {
            System.out.println("Erro: Cliente não encontrado. Não é possível cadastrar o veículo sem um cliente válido.");
            return; // Cancela o cadastro do veículo
        }

        System.out.println("\n--- Cadastrar Veículo ---");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setPlaca(placa);

        veiculoService.cadastrarVeiculo(veiculo);
    }

    private static void listarVeiculos() {
        System.out.println("\n--- Lista de Veículos ---");
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        for (Veiculo veiculo : veiculos) {
            System.out.println("ID: " + veiculo.getId() + ", Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Ano: " + veiculo.getAno() + ", Placa: " + veiculo.getPlaca());
        }
    }

    private static void atualizarVeiculo() {
        System.out.print("\nDigite o ID do veículo para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        if (veiculo != null) {
            System.out.print("Nova marca: ");
            veiculo.setMarca(scanner.nextLine());
            System.out.print("Novo modelo: ");
            veiculo.setModelo(scanner.nextLine());
            System.out.print("Novo ano: ");
            veiculo.setAno(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Nova placa: ");
            veiculo.setPlaca(scanner.nextLine());

            veiculoService.atualizarVeiculo(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void excluirVeiculo() {
        System.out.print("\nDigite o ID do veículo para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        veiculoService.excluirVeiculo(id);
    }
    
    private static void cadastrarOrdemServico() {
        System.out.println("\n--- Cadastrar Ordem de Serviço ---");
        System.out.print("ID do Cliente: ");
        int clienteId = scanner.nextInt();
        System.out.print("ID do Veículo: ");
        int veiculoId = scanner.nextInt();
        scanner.nextLine();

        OrdemServico ordem = new OrdemServico();
        ordem.setClienteId(clienteId);
        ordem.setVeiculoId(veiculoId);

        ordemServicoService.cadastrarOrdemServico(ordem);
    }

    private static void listarOrdensServico() {
        System.out.println("\n--- Lista de Ordens de Serviço ---");
        List<OrdemServico> ordens = ordemServicoService.listarOrdensServico();
        for (OrdemServico ordem : ordens) {
            System.out.println("ID: " + ordem.getId() + ", Cliente ID: " + ordem.getClienteId() + ", Veículo ID: " + ordem.getVeiculoId());
        }
    }

    private static void atualizarOrdemServico() {
        System.out.print("\nDigite o ID da ordem para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        OrdemServico ordem = ordemServicoService.buscarOrdemServicoPorId(id);
        if (ordem != null) {
            System.out.print("Novo ID do cliente: ");
            ordem.setClienteId(scanner.nextInt());
            System.out.print("Novo ID do veículo: ");
            ordem.setVeiculoId(scanner.nextInt());
            scanner.nextLine();

            ordemServicoService.atualizarOrdemServico(ordem);
        } else {
            System.out.println("Ordem de serviço não encontrada.");
        }
    }

    private static void excluirOrdemServico() {
        System.out.print("\nDigite o ID da ordem para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ordemServicoService.excluirOrdemServico(id);
    }
    
    private static void cadastrarCliente() {
        System.out.println("\n--- Cadastrar Cliente ---");
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

    private static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = clienteService.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + ", Email: " + cliente.getEmail());
        }
    }

    private static void atualizarCliente() {
        System.out.print("\nDigite o ID do cliente para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            System.out.print("Novo nome: ");
            cliente.setNome(scanner.nextLine());
            System.out.print("Novo telefone: ");
            cliente.setTelefone(scanner.nextLine());
            System.out.print("Novo email: ");
            cliente.setEmail(scanner.nextLine());

            clienteService.atualizarCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void excluirCliente() {
        System.out.print("\nDigite o ID do cliente para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        clienteService.excluirCliente(id);
    }

    private static void cadastrarServico() {
        System.out.println("\n--- Cadastrar Serviço ---");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Servico servico = new Servico();
        servico.setDescricao(descricao);
        servico.setPreco(preco);

        servicoService.cadastrarServico(servico);
    }

    private static void listarServicos() {
        System.out.println("\n--- Lista de Serviços ---");
        List<Servico> servicos = servicoService.listarServicos();
        for (Servico servico : servicos) {
            System.out.println("ID: " + servico.getId() + ", Descrição: " + servico.getDescricao() + ", Preço: " + servico.getPreco());
        }
    }

    private static void atualizarServico() {
        System.out.print("\nDigite o ID do serviço para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Servico servico = servicoService.buscarServicoPorId(id);
        if (servico != null) {
            System.out.print("Nova descrição: ");
            servico.setDescricao(scanner.nextLine());
            System.out.print("Novo preço: ");
            servico.setPreco(scanner.nextDouble());

            servicoService.atualizarServico(servico);
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }

    private static void excluirServico() {
        System.out.print("\nDigite o ID do serviço para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        servicoService.excluirServico(id);
    }

}
