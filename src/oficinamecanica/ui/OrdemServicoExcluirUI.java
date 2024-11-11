package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.service.OrdemServicoService;

public class OrdemServicoExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private OrdemServicoService ordemServicoService;

    public OrdemServicoExcluirUI() {
        ordemServicoService = new OrdemServicoService();

        setTitle("Excluir Ordem de Serviço");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        excluirButton = new JButton("Excluir");

        excluirButton.addActionListener(e -> excluirOrdemServico());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID da Ordem de Serviço:"));
        panel.add(idField);
        panel.add(excluirButton);

        add(panel);
    }

    private void excluirOrdemServico() {
        try {
            int id = Integer.parseInt(idField.getText());
            ordemServicoService.excluirOrdemServico(id);
            JOptionPane.showMessageDialog(this, "Ordem de serviço excluída com sucesso!");
            idField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir ordem de serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdemServicoExcluirUI().setVisible(true));
    }
}
