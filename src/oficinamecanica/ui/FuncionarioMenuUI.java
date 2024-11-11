package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class FuncionarioMenuUI extends JFrame {

    private JButton cadastrarButton;
    private JButton listarButton;
    private JButton atualizarButton;
    private JButton excluirButton;
    private JButton voltarButton;

    public FuncionarioMenuUI() {
        setTitle("Menu Funcionário");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        cadastrarButton = new JButton("Cadastrar Funcionário");
        listarButton = new JButton("Listar Funcionários");
        atualizarButton = new JButton("Atualizar Funcionário");
        excluirButton = new JButton("Excluir Funcionário");
        voltarButton = new JButton("Voltar");

        panel.add(cadastrarButton);
        panel.add(listarButton);
        panel.add(atualizarButton);
        panel.add(excluirButton);
        panel.add(voltarButton);

        cadastrarButton.addActionListener(e -> new FuncionarioCadastroUI().setVisible(true));
        listarButton.addActionListener(e -> new FuncionarioListagemUI().setVisible(true));
        atualizarButton.addActionListener(e -> new FuncionarioAtualizarUI().setVisible(true));
        excluirButton.addActionListener(e -> new FuncionarioExcluirUI().setVisible(true));
        voltarButton.addActionListener(e -> this.dispose());

        add(panel);
    }
}
