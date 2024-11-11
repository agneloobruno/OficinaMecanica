package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Servico;
import oficinamecanica.service.ServicoService;

public class ServicoCadastroUI extends JFrame {

    private JTextField descricaoField;
    private JTextField precoField;
    private JButton cadastrarButton;
    private ServicoService servicoService;

    public ServicoCadastroUI() {
        servicoService = new ServicoService(); // Instancia uma única vez

        setTitle("Cadastrar Serviço");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        descricaoField = new JTextField();
        precoField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> cadastrarServico());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Preço:"));
        panel.add(precoField);
        panel.add(cadastrarButton);

        add(panel);
    }

    private void cadastrarServico() {
        String descricao = descricaoField.getText();
        double preco;
        try {
            preco = Double.parseDouble(precoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chama o serviço para salvar o serviço
        Servico servico = new Servico();
        servico.setDescricao(descricao);
        servico.setPreco(preco);

        try {
            servicoService.cadastrarServico(servico); // Simples e direto
            JOptionPane.showMessageDialog(this, "Serviço cadastrado com sucesso!");
            descricaoField.setText("");
            precoField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServicoCadastroUI().setVisible(true));
    }
}
