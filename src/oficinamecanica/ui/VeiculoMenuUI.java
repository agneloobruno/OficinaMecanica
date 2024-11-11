package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class VeiculoMenuUI extends JFrame {

    private JButton cadastrarButton;
    private JButton listarButton;
    private JButton atualizarButton;
    private JButton excluirButton;
    private JButton voltarButton;

    public VeiculoMenuUI() {
        setTitle("Menu Veículo");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        cadastrarButton = new JButton("Cadastrar Veículo");
        listarButton = new JButton("Listar Veículos");
        atualizarButton = new JButton("Atualizar Veículo");
        excluirButton = new JButton("Excluir Veículo");
        voltarButton = new JButton("Voltar");

        panel.add(cadastrarButton);
        panel.add(listarButton);
        panel.add(atualizarButton);
        panel.add(excluirButton);
        panel.add(voltarButton);

        cadastrarButton.addActionListener(e -> new VeiculoCadastroUI().setVisible(true));
        listarButton.addActionListener(e -> new VeiculoListagemUI().setVisible(true));
        atualizarButton.addActionListener(e -> new VeiculoAtualizarUI().setVisible(true));
        excluirButton.addActionListener(e -> new VeiculoExcluirUI().setVisible(true));
        voltarButton.addActionListener(e -> this.dispose());

        add(panel);
    }
}
