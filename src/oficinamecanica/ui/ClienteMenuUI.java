package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteMenuUI extends JFrame {

    private JButton cadastrarButton;
    private JButton listarButton;
    private JButton atualizarButton;
    private JButton excluirButton;
    private JButton voltarButton;

    public ClienteMenuUI() {
        setTitle("Menu Cliente");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        cadastrarButton = new JButton("Cadastrar Cliente");
        listarButton = new JButton("Listar Clientes");
        atualizarButton = new JButton("Atualizar Cliente");
        excluirButton = new JButton("Excluir Cliente");
        voltarButton = new JButton("Voltar");

        panel.add(cadastrarButton);
        panel.add(listarButton);
        panel.add(atualizarButton);
        panel.add(excluirButton);
        panel.add(voltarButton);

        cadastrarButton.addActionListener(e -> abrirCadastroCliente());
        listarButton.addActionListener(e -> abrirListagemClientes());
        atualizarButton.addActionListener(e -> abrirAtualizacaoCliente());
        excluirButton.addActionListener(e -> abrirExclusaoCliente());
        voltarButton.addActionListener(e -> voltarAoMenuPrincipal());

        add(panel);
    }

    private void abrirCadastroCliente() {
        new ClienteCadastroUI().setVisible(true);
    }

    private void abrirListagemClientes() {
        new ClienteListagemUI().setVisible(true);
    }

    private void abrirAtualizacaoCliente() {
        new ClienteAtualizarUI().setVisible(true);
    }

    private void abrirExclusaoCliente() {
        new ClienteExcluirUI().setVisible(true);
    }

    private void voltarAoMenuPrincipal() {
        this.dispose(); // Fecha a tela atual, retornando ao menu principal
    }
}
