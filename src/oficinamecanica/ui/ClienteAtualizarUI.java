package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ClienteAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JButton atualizarButton;
    private JButton voltarButton;

    public ClienteAtualizarUI() {
        setTitle("Atualizar Cliente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        atualizarButton = new JButton("Atualizar");
        voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> atualizarCliente());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(telefoneLabel);
        panel.add(telefoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(atualizarButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void atualizarCliente() {
        // Implementação da lógica para atualizar cliente
        JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
    }
}
