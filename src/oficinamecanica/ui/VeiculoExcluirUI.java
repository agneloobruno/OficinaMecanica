package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.service.VeiculoService;

public class VeiculoExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private VeiculoService veiculoService;

    public VeiculoExcluirUI() {
        veiculoService = new VeiculoService();

        setTitle("Excluir Veículo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        excluirButton = new JButton("Excluir");

        excluirButton.addActionListener(e -> excluirVeiculo());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Veículo:"));
        panel.add(idField);
        panel.add(excluirButton);

        add(panel);
    }

    private void excluirVeiculo() {
        try {
            int id = Integer.parseInt(idField.getText());
            veiculoService.excluirVeiculo(id);
            JOptionPane.showMessageDialog(this, "Veículo excluído com sucesso!");
            idField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir veículo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VeiculoExcluirUI().setVisible(true));
    }
}
