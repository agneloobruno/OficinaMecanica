package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class VeiculoExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private JButton voltarButton;

    public VeiculoExcluirUI() {
        setTitle("Excluir Veículo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        excluirButton = new JButton("Excluir");
        voltarButton = new JButton("Voltar");

        excluirButton.addActionListener(e -> excluirVeiculo());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(excluirButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void excluirVeiculo() {
        // Lógica para excluir veículo
        JOptionPane.showMessageDialog(this, "Veículo excluído com sucesso!");
    }
}
