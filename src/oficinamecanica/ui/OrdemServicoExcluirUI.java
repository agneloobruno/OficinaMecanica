package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class OrdemServicoExcluirUI extends JFrame {

    private JTextField idField;
    private JButton excluirButton;
    private JButton voltarButton;

    public OrdemServicoExcluirUI() {
        setTitle("Excluir Ordem de Serviço");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("ID da Ordem:");
        idField = new JTextField();

        excluirButton = new JButton("Excluir");
        voltarButton = new JButton("Voltar");

        excluirButton.addActionListener(e -> excluirOrdemServico());
        voltarButton.addActionListener(e -> this.dispose());

        panel.add(idLabel);
        panel.add(idField);
        panel.add(excluirButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void excluirOrdemServico() {
        // Lógica para excluir ordem de serviço
        JOptionPane.showMessageDialog(this, "Ordem de Serviço excluída com sucesso!");
    }
}
