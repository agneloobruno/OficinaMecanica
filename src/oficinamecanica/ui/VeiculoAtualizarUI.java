package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class VeiculoAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField anoField;
    private JTextField placaField;
    private JButton atualizarButton;
    private JButton voltarButton;

    public VeiculoAtualizarUI() {
        setTitle("Atualizar Veículo");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel marcaLabel = new JLabel("Marca:");
        marcaField = new JTextField();
        JLabel modeloLabel = new JLabel("Modelo:");
        modeloField = new JTextField();
        JLabel anoLabel = new JLabel("Ano:");
        anoField = new JTextField();
        JLabel placaLabel = new JLabel("Placa:");
        placaField = new JTextField();

        atualizarButton = new JButton("Atualizar");
        voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> atualizarVeiculo());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(marcaLabel);
        panel.add(marcaField);
        panel.add(modeloLabel);
        panel.add(modeloField);
        panel.add(anoLabel);
        panel.add(anoField);
        panel.add(placaLabel);
        panel.add(placaField);
        panel.add(atualizarButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void atualizarVeiculo() {
        // Lógica para atualizar veículo
        JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
    }
}
