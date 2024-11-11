package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Cliente;
import oficinamecanica.service.ClienteService;

public class ClienteCadastroUI extends JFrame {

    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JButton cadastrarButton;
    private ClienteService clienteService;

    public ClienteCadastroUI() {
        clienteService = new ClienteService();

        setTitle("Cadastrar Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        nomeField = new JTextField();
        telefoneField = new JTextField();
        emailField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> cadastrarCliente());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(cadastrarButton);

        add(panel);
    }

    private void cadastrarCliente() {
        String nome = nomeField.getText();
        String telefone = telefoneField.getText();
        String email = emailField.getText();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);

        try {
            clienteService.cadastrarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            nomeField.setText("");
            telefoneField.setText("");
            emailField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteCadastroUI().setVisible(true));
    }
}
