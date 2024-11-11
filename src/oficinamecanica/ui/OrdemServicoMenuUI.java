package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class OrdemServicoMenuUI extends JFrame {

    private JButton cadastrarButton;
    private JButton listarButton;
    private JButton atualizarButton;
    private JButton excluirButton;
    private JButton voltarButton;

    public OrdemServicoMenuUI() {
        setTitle("Menu Ordem de Serviço");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        cadastrarButton = new JButton("Cadastrar Ordem de Serviço");
        listarButton = new JButton("Listar Ordens de Serviço");
        atualizarButton = new JButton("Atualizar Ordem de Serviço");
        excluirButton = new JButton("Excluir Ordem de Serviço");
        voltarButton = new JButton("Voltar");

        panel.add(cadastrarButton);
        panel.add(listarButton);
        panel.add(atualizarButton);
        panel.add(excluirButton);
        panel.add(voltarButton);

        cadastrarButton.addActionListener(e -> new OrdemServicoCadastroUI().setVisible(true));
        listarButton.addActionListener(e -> new OrdemServicoListagemUI().setVisible(true));
        atualizarButton.addActionListener(e -> new OrdemServicoAtualizarUI().setVisible(true));
        excluirButton.addActionListener(e -> new OrdemServicoExcluirUI().setVisible(true));
        voltarButton.addActionListener(e -> this.dispose());

        add(panel);
    }
}
