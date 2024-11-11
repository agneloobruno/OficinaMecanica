package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ServicoExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private JButton voltarButton;

    public ServicoExcluirUI() {
        setTitle("Excluir Serviço");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        excluirButton = new JButton("Excluir");
        voltarButton = new JButton("Voltar");

        excluirButton.addActionListener(e -> excluirServico());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(excluirButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void excluirServico() {
        // Lógica para excluir serviço
        JOptionPane.showMessageDialog(this, "Serviço excluído com sucesso!");
    }
}
