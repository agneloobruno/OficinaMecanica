package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Veiculo;
import oficinamecanica.service.VeiculoService;

public class VeiculoCadastroUI extends JFrame {

    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField anoField;
    private JTextField placaField;
    private JButton cadastrarButton;
    private VeiculoService veiculoService;

    public VeiculoCadastroUI() {
        veiculoService = new VeiculoService();

        setTitle("Cadastrar Veículo");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        marcaField = new JTextField();
        modeloField = new JTextField();
        anoField = new JTextField();
        placaField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> cadastrarVeiculo());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(new JLabel("Ano:"));
        panel.add(anoField);
        panel.add(new JLabel("Placa:"));
        panel.add(placaField);
        panel.add(cadastrarButton);

        add(panel);
    }

    private void cadastrarVeiculo() {
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        int ano;
        try {
            ano = Integer.parseInt(anoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ano inválido. Insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String placa = placaField.getText();

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setPlaca(placa);

        try {
            veiculoService.cadastrarVeiculo(veiculo);
            JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
            marcaField.setText("");
            modeloField.setText("");
            anoField.setText("");
            placaField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar veículo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VeiculoCadastroUI().setVisible(true));
    }
}
