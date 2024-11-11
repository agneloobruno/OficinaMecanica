package oficinamecanica.ui;

import javax.swing.*;
import oficinamecanica.model.Veiculo;
import oficinamecanica.service.VeiculoService;

public class VeiculoAtualizarUI extends JFrame {

    private JTextField idField;
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField anoField;
    private JTextField placaField;
    private JButton atualizarButton;
    private VeiculoService veiculoService;

    public VeiculoAtualizarUI() {
        veiculoService = new VeiculoService();

        setTitle("Atualizar Veículo");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField();
        marcaField = new JTextField();
        modeloField = new JTextField();
        anoField = new JTextField();
        placaField = new JTextField();
        atualizarButton = new JButton("Atualizar");

        atualizarButton.addActionListener(e -> atualizarVeiculo());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID do Veículo:"));
        panel.add(idField);
        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(new JLabel("Ano:"));
        panel.add(anoField);
        panel.add(new JLabel("Placa:"));
        panel.add(placaField);
        panel.add(atualizarButton);

        add(panel);
    }

    private void atualizarVeiculo() {
        try {
            int id = Integer.parseInt(idField.getText());
            String marca = marcaField.getText();
            String modelo = modeloField.getText();
            int ano = Integer.parseInt(anoField.getText());
            String placa = placaField.getText();

            Veiculo veiculo = new Veiculo();
            veiculo.setId(id);
            veiculo.setMarca(marca);
            veiculo.setModelo(modelo);
            veiculo.setAno(ano);
            veiculo.setPlaca(placa);

            veiculoService.atualizarVeiculo(veiculo);
            JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
            idField.setText("");
            marcaField.setText("");
            modeloField.setText("");
            anoField.setText("");
            placaField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar veículo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VeiculoAtualizarUI().setVisible(true));
    }
}
