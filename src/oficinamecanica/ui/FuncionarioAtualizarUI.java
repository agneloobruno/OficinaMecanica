package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Funcionario;
import oficinamecanica.service.FuncionarioService;

public class FuncionarioAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField nomeField;
    private JTextField cargoField;
    private JButton atualizarButton;
    private FuncionarioService funcionarioService;

    public FuncionarioAtualizarUI() {
        funcionarioService = new FuncionarioService();

        setTitle("Atualizar Funcionário");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        nomeField = new JTextField();
        cargoField = new JTextField();
        atualizarButton = new JButton("Atualizar");

        atualizarButton.addActionListener(e -> atualizarFuncionario());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Funcionário:"));
        panel.add(idField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Cargo:"));
        panel.add(cargoField);
        panel.add(atualizarButton);

        add(panel);
    }

    private void atualizarFuncionario() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nome = nomeField.getText();
            String cargo = cargoField.getText();

            Funcionario funcionario = new Funcionario();
            funcionario.setId(id);
            funcionario.setNome(nome);
            funcionario.setCargo(cargo);

            funcionarioService.atualizarFuncionario(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!");
            idField.setText("");
            nomeField.setText("");
            cargoField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FuncionarioAtualizarUI().setVisible(true));
    }
}
