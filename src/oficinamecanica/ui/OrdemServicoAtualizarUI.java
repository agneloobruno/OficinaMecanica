package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.OrdemServico;
import oficinamecanica.service.OrdemServicoService;

public class OrdemServicoAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField clienteIdField;
    private JTextField veiculoIdField;
    private JTextField valorTotalField;
    private JTextField statusField;
    private JButton atualizarButton;
    private OrdemServicoService ordemServicoService;

    public OrdemServicoAtualizarUI() {
        ordemServicoService = new OrdemServicoService();

        setTitle("Atualizar Ordem de Serviço");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        clienteIdField = new JTextField();
        veiculoIdField = new JTextField();
        valorTotalField = new JTextField();
        statusField = new JTextField();
        atualizarButton = new JButton("Atualizar");

        atualizarButton.addActionListener(e -> atualizarOrdemServico());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID da Ordem de Serviço:"));
        panel.add(idField);
        panel.add(new JLabel("ID do Cliente:"));
        panel.add(clienteIdField);
        panel.add(new JLabel("ID do Veículo:"));
        panel.add(veiculoIdField);
        panel.add(new JLabel("Valor Total:"));
        panel.add(valorTotalField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
        panel.add(atualizarButton);

        add(panel);
    }

    private void atualizarOrdemServico() {
        try {
            int id = Integer.parseInt(idField.getText());
            int clienteId = Integer.parseInt(clienteIdField.getText());
            int veiculoId = Integer.parseInt(veiculoIdField.getText());
            double valorTotal = Double.parseDouble(valorTotalField.getText());
            String status = statusField.getText();

            OrdemServico ordem = new OrdemServico();
            ordem.setId(id);
            ordem.setClienteId(clienteId);
            ordem.setVeiculoId(veiculoId);
            ordem.setValorTotal(valorTotal);
            ordem.setStatus(status);

            ordemServicoService.atualizarOrdemServico(ordem);
            JOptionPane.showMessageDialog(this, "Ordem de serviço atualizada com sucesso!");
            idField.setText("");
            clienteIdField.setText("");
            veiculoIdField.setText("");
            valorTotalField.setText("");
            statusField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar ordem de serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdemServicoAtualizarUI().setVisible(true));
    }
}
