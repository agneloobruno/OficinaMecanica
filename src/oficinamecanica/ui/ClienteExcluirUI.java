package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.service.ClienteService;

public class ClienteExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private ClienteService clienteService;

    public ClienteExcluirUI() {
        clienteService = new ClienteService();

        setTitle("Excluir Cliente");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        excluirButton = new JButton("Excluir");

        excluirButton.addActionListener(e -> excluirCliente());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Cliente:"));
        panel.add(idField);
        panel.add(excluirButton);

        add(panel);
    }

    private void excluirCliente() {
        try {
            int id = Integer.parseInt(idField.getText());
            clienteService.excluirCliente(id);
            JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
            idField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteExcluirUI().setVisible(true));
    }
}
