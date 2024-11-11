package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.service.ServicoService;

public class ServicoExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private ServicoService servicoService;

    public ServicoExcluirUI() {
        servicoService = new ServicoService();

        setTitle("Excluir Serviço");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        excluirButton = new JButton("Excluir");

        excluirButton.addActionListener(e -> excluirServico());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Serviço:"));
        panel.add(idField);
        panel.add(excluirButton);

        add(panel);
    }

    private void excluirServico() {
        try {
            int id = Integer.parseInt(idField.getText());
            servicoService.excluirServico(id);
            JOptionPane.showMessageDialog(this, "Serviço excluído com sucesso!");
            idField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServicoExcluirUI().setVisible(true));
    }
}
