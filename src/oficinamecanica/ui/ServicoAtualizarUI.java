package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Servico;
import oficinamecanica.service.ServicoService;

public class ServicoAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField descricaoField;
    private JTextField precoField;
    private JButton atualizarButton;
    private ServicoService servicoService;

    public ServicoAtualizarUI() {
        servicoService = new ServicoService();

        setTitle("Atualizar Serviço");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        descricaoField = new JTextField();
        precoField = new JTextField();
        atualizarButton = new JButton("Atualizar");

        atualizarButton.addActionListener(e -> atualizarServico());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Serviço:"));
        panel.add(idField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Preço:"));
        panel.add(precoField);
        panel.add(atualizarButton);

        add(panel);
    }

    private void atualizarServico() {
        try {
            int id = Integer.parseInt(idField.getText());
            String descricao = descricaoField.getText();
            double preco = Double.parseDouble(precoField.getText());

            Servico servico = new Servico();
            servico.setId(id);
            servico.setDescricao(descricao);
            servico.setPreco(preco);

            servicoService.atualizarServico(servico);
            JOptionPane.showMessageDialog(this, "Serviço atualizado com sucesso!");
            idField.setText("");
            descricaoField.setText("");
            precoField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServicoAtualizarUI().setVisible(true));
    }
}
