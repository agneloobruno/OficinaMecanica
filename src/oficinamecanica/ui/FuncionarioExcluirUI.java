package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class FuncionarioExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private JButton voltarButton;

    public FuncionarioExcluirUI() {
        setTitle("Excluir Funcionário");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        excluirButton = new JButton("Excluir");
        voltarButton = new JButton("Voltar");

        excluirButton.addActionListener(e -> excluirFuncionario());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(excluirButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void excluirFuncionario() {
        // Lógica para excluir funcionário
        JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
    }
}
