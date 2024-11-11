package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame {

    // Declaração dos botões do menu principal
    private JButton clienteButton;
    private JButton funcionarioButton;
    private JButton veiculoButton;
    private JButton ordemServicoButton;
    private JButton servicoButton;
    private JButton sairButton;

    public MainMenuUI() {
        // Configurações da janela principal
        setTitle("Menu Principal - Oficina Mecânica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel principal com GridLayout para organizar os botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        // Inicializar botões
        clienteButton = new JButton("Cliente");
        funcionarioButton = new JButton("Funcionário");
        veiculoButton = new JButton("Veículo");
        ordemServicoButton = new JButton("Ordem de Serviço");
        servicoButton = new JButton("Serviço");
        sairButton = new JButton("Sair");

        // Adicionar botões ao painel
        panel.add(clienteButton);
        panel.add(funcionarioButton);
        panel.add(veiculoButton);
        panel.add(ordemServicoButton);
        panel.add(servicoButton);
        panel.add(sairButton);

        // Configurar ações dos botões
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuCliente();
            }
        });

        funcionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuFuncionario();
            }
        });

        veiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuVeiculo();
            }
        });

        ordemServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuOrdemServico();
            }
        });

        servicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuServico();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adicionar o painel à janela principal
        add(panel);
    }

    // Métodos para abrir outras janelas para cada menu
    private void abrirMenuCliente() {
        // Abre a janela de cadastro de cliente
        ClienteMenuUI clienteMenuUI = new ClienteMenuUI();
        clienteMenuUI.setVisible(true);
    }

    private void abrirMenuFuncionario() {
        FuncionarioMenuUI funcionarioMenuUI = new FuncionarioMenuUI();
        funcionarioMenuUI.setVisible(true);
    }

    private void abrirMenuVeiculo() {
        VeiculoMenuUI veiculoMenuUI = new VeiculoMenuUI();
        veiculoMenuUI.setVisible(true);
    }

    private void abrirMenuOrdemServico() {
        OrdemServicoMenuUI ordemServicoMenuUI = new OrdemServicoMenuUI();
        ordemServicoMenuUI.setVisible(true);
    }

    private void abrirMenuServico() {
        ServicoMenuUI servicoMenuUI = new ServicoMenuUI();
        servicoMenuUI.setVisible(true);
    }

    // Método main para rodar a interface gráfica
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenuUI().setVisible(true);
            }
        });
    }
}
