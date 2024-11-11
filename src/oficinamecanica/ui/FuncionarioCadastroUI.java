package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Funcionario;
import oficinamecanica.service.FuncionarioService;

public class FuncionarioCadastroUI extends JFrame {

    private JTextField nomeField;
    private JTextField cargoField;
    private JButton cadastrarButton;
    private FuncionarioService funcionarioService;

    public FuncionarioCadastroUI() {
        funcionarioService = new FuncionarioService();

        setTitle("Cadastrar Funcionário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        nomeField = new JTextField();
        cargoField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> cadastrarFuncionario());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Cargo:"));
        panel.add(cargoField);
        panel.add(cadastrarButton);

        add(panel);
    }

    private void cadastrarFuncionario() {
        String nome = nomeField.getText();
        String cargo = cargoField.getText();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);

        try {
            funcionarioService.cadastrarFuncionario(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            nomeField.setText("");
            cargoField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FuncionarioCadastroUI().setVisible(true));
    }
}
