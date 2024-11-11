package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class OrdemServicoAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField clienteIdField;
    private JTextField veiculoIdField;
    private JTextField valorTotalField;
    private JTextField statusField;
    private JButton atualizarButton;
    private JButton voltarButton;

    public OrdemServicoAtualizarUI() {
        setTitle("Atualizar Ordem de Serviço");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel idLabel = new JLabel("ID da Ordem:");
        idField = new JTextField();
        JLabel clienteIdLabel = new JLabel("ID do Cliente:");
        clienteIdField = new JTextField();
        JLabel veiculoIdLabel = new JLabel("ID do Veículo:");
        veiculoIdField = new JTextField();
        JLabel valorTotalLabel = new JLabel("Valor Total:");
        valorTotalField = new JTextField();
        JLabel statusLabel = new JLabel("Status:");
        statusField = new JTextField();

        atualizarButton = new JButton("Atualizar");
        voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> atualizarOrdemServico());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(clienteIdLabel);
        panel.add(clienteIdField);
        panel.add(veiculoIdLabel);
        panel.add(veiculoIdField);
        panel.add(valorTotalLabel);
        panel.add(valorTotalField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(atualizarButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void atualizarOrdemServico() {
        // Lógica para atualizar ordem de serviço
        JOptionPane.showMessageDialog(this, "Ordem de Serviço atualizada com sucesso!");
    }
}
