package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import oficinamecanica.model.Veiculo;
import oficinamecanica.service.VeiculoService;

public class VeiculoListagemUI extends JFrame {

    private JTextArea listaVeiculosArea;
    private VeiculoService veiculoService;

    public VeiculoListagemUI() {
        veiculoService = new VeiculoService();

        setTitle("Listar Veículos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaVeiculosArea = new JTextArea();
        listaVeiculosArea.setEditable(false);
        atualizarListaVeiculos();

        JScrollPane scrollPane = new JScrollPane(listaVeiculosArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void atualizarListaVeiculos() {
        try {
            List<Veiculo> veiculos = veiculoService.listarVeiculos();
            listaVeiculosArea.setText("");  // Limpa a área de texto

            for (Veiculo veiculo : veiculos) {
                listaVeiculosArea.append("ID: " + veiculo.getId() +
                                        ", Marca: " + veiculo.getMarca() +
                                        ", Modelo: " + veiculo.getModelo() +
                                        ", Ano: " + veiculo.getAno() +
                                        ", Placa: " + veiculo.getPlaca() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar veículos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VeiculoListagemUI().setVisible(true));
    }
}
