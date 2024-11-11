package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ClienteExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private JButton voltarButton;

    public ClienteExcluirUI() {
        setTitle("Excluir Cliente");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        excluirButton = new JButton("Excluir");
        voltarButton = new JButton("Voltar");

        excluirButton.addActionListener(e -> excluirCliente());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(excluirButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void excluirCliente() {
        // Implementação da lógica para excluir cliente
        JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
    }
}
