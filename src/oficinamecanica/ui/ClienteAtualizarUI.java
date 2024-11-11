package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Cliente;
import oficinamecanica.service.ClienteService;

public class ClienteAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JButton atualizarButton;
    private ClienteService clienteService;

    public ClienteAtualizarUI() {
        clienteService = new ClienteService();

        setTitle("Atualizar Cliente");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        nomeField = new JTextField();
        telefoneField = new JTextField();
        emailField = new JTextField();
        atualizarButton = new JButton("Atualizar");

        atualizarButton.addActionListener(e -> atualizarCliente());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Cliente:"));
        panel.add(idField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(atualizarButton);

        add(panel);
    }

    private void atualizarCliente() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nome = nomeField.getText();
            String telefone = telefoneField.getText();
            String email = emailField.getText();

            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);

            clienteService.atualizarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
            idField.setText("");
            nomeField.setText("");
            telefoneField.setText("");
            emailField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteAtualizarUI().setVisible(true));
    }
}
