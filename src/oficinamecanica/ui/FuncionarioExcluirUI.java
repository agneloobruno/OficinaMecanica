package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.service.FuncionarioService;

public class FuncionarioExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private FuncionarioService funcionarioService;

    public FuncionarioExcluirUI() {
        funcionarioService = new FuncionarioService();

        setTitle("Excluir Funcionário");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        excluirButton = new JButton("Excluir");

        excluirButton.addActionListener(e -> excluirFuncionario());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Funcionário:"));
        panel.add(idField);
        panel.add(excluirButton);

        add(panel);
    }

    private void excluirFuncionario() {
        try {
            int id = Integer.parseInt(idField.getText());
            funcionarioService.excluirFuncionario(id);
            JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
            idField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FuncionarioExcluirUI().setVisible(true));
    }
}
