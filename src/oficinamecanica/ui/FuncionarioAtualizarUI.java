package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class FuncionarioAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField nomeField;
    private JTextField cargoField;
    private JButton atualizarButton;
    private JButton voltarButton;

    public FuncionarioAtualizarUI() {
        setTitle("Atualizar Funcionário");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel cargoLabel = new JLabel("Cargo:");
        cargoField = new JTextField();

        atualizarButton = new JButton("Atualizar");
        voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> atualizarFuncionario());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(cargoLabel);
        panel.add(cargoField);
        panel.add(atualizarButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void atualizarFuncionario() {
        // Lógica para atualizar funcionário
        JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!");
    }
}
