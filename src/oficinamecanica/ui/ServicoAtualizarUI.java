package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ServicoAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField descricaoField;
    private JTextField precoField;
    private JButton atualizarButton;
    private JButton voltarButton;

    public ServicoAtualizarUI() {
        setTitle("Atualizar Serviço");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoField = new JTextField();
        JLabel precoLabel = new JLabel("Preço:");
        precoField = new JTextField();

        atualizarButton = new JButton("Atualizar");
        voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> atualizarServico());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(descricaoLabel);
        panel.add(descricaoField);
        panel.add(precoLabel);
        panel.add(precoField);
        panel.add(atualizarButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void atualizarServico() {
        // Lógica para atualizar serviço
        JOptionPane.showMessageDialog(this, "Serviço atualizado com sucesso!");
    }
}
