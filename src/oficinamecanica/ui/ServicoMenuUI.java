package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ServicoMenuUI extends JFrame {

    private JButton cadastrarButton;
    private JButton listarButton;
    private JButton atualizarButton;
    private JButton excluirButton;
    private JButton voltarButton;

    public ServicoMenuUI() {
        setTitle("Menu Serviço");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        cadastrarButton = new JButton("Cadastrar Serviço");
        listarButton = new JButton("Listar Serviços");
        atualizarButton = new JButton("Atualizar Serviço");
        excluirButton = new JButton("Excluir Serviço");
        voltarButton = new JButton("Voltar");

        panel.add(cadastrarButton);
        panel.add(listarButton);
        panel.add(atualizarButton);
        panel.add(excluirButton);
        panel.add(voltarButton);

        cadastrarButton.addActionListener(e -> new ServicoCadastroUI().setVisible(true));
        listarButton.addActionListener(e -> new ServicoListagemUI().setVisible(true));
        atualizarButton.addActionListener(e -> new ServicoAtualizarUI().setVisible(true));
        excluirButton.addActionListener(e -> new ServicoExcluirUI().setVisible(true));
        voltarButton.addActionListener(e -> this.dispose());

        add(panel);
    }
}
