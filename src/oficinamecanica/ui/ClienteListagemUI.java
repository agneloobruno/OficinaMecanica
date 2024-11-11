package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import oficinamecanica.model.Cliente;
import oficinamecanica.service.ClienteService;

public class ClienteListagemUI extends JFrame {

    private JTextArea listaClientesArea;
    private ClienteService clienteService;

    public ClienteListagemUI() {
        clienteService = new ClienteService();

        setTitle("Listar Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaClientesArea = new JTextArea();
        listaClientesArea.setEditable(false);
        atualizarListaClientes();

        JScrollPane scrollPane = new JScrollPane(listaClientesArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void atualizarListaClientes() {
        try {
            List<Cliente> clientes = clienteService.listarClientes();
            listaClientesArea.setText("");  // Limpa a área de texto

            for (Cliente cliente : clientes) {
                listaClientesArea.append("ID: " + cliente.getId() +
                                         ", Nome: " + cliente.getNome() +
                                         ", Telefone: " + cliente.getTelefone() +
                                         ", Email: " + cliente.getEmail() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteListagemUI().setVisible(true));
    }
}
