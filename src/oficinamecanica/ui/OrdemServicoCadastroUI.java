package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.OrdemServico;
import oficinamecanica.service.OrdemServicoService;

public class OrdemServicoCadastroUI extends JFrame {

    private JTextField clienteIdField;
    private JTextField veiculoIdField;
    private JTextField valorTotalField;
    private JTextField statusField;
    private JButton cadastrarButton;
    private OrdemServicoService ordemServicoService;

    public OrdemServicoCadastroUI() {
        ordemServicoService = new OrdemServicoService();

        setTitle("Cadastrar Ordem de Serviço");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        clienteIdField = new JTextField();
        veiculoIdField = new JTextField();
        valorTotalField = new JTextField();
        statusField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> cadastrarOrdemServico());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Cliente:"));
        panel.add(clienteIdField);
        panel.add(new JLabel("ID do Veículo:"));
        panel.add(veiculoIdField);
        panel.add(new JLabel("Valor Total:"));
        panel.add(valorTotalField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
        panel.add(cadastrarButton);

        add(panel);
    }

    private void cadastrarOrdemServico() {
        int clienteId, veiculoId;
        double valorTotal;

        try {
            clienteId = Integer.parseInt(clienteIdField.getText());
            veiculoId = Integer.parseInt(veiculoIdField.getText());
            valorTotal = Double.parseDouble(valorTotalField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro nos campos numéricos. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String status = statusField.getText();

        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setClienteId(clienteId);
        ordemServico.setVeiculoId(veiculoId);
        ordemServico.setValorTotal(valorTotal);
        ordemServico.setStatus(status);

        try {
            ordemServicoService.cadastrarOrdemServico(ordemServico);
            JOptionPane.showMessageDialog(this, "Ordem de serviço cadastrada com sucesso!");
            clienteIdField.setText("");
            veiculoIdField.setText("");
            valorTotalField.setText("");
            statusField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar ordem de serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdemServicoCadastroUI().setVisible(true));
    }
}
