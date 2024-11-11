package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import oficinamecanica.model.OrdemServico;
import oficinamecanica.service.OrdemServicoService;

public class OrdemServicoListagemUI extends JFrame {

    private JTextArea listaOrdemServicoArea;
    private OrdemServicoService ordemServicoService;

    public OrdemServicoListagemUI() {
        ordemServicoService = new OrdemServicoService();

        setTitle("Listar Ordens de Serviço");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaOrdemServicoArea = new JTextArea();
        listaOrdemServicoArea.setEditable(false);
        atualizarListaOrdemServico();

        JScrollPane scrollPane = new JScrollPane(listaOrdemServicoArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void atualizarListaOrdemServico() {
        try {
            List<OrdemServico> ordens = ordemServicoService.listarOrdensServico();
            listaOrdemServicoArea.setText("");  // Limpa a área de texto

            for (OrdemServico ordem : ordens) {
                listaOrdemServicoArea.append("ID: " + ordem.getId() +
                                             ", Cliente ID: " + ordem.getClienteId() +
                                             ", Veículo ID: " + ordem.getVeiculoId() +
                                             ", Valor Total: " + ordem.getValorTotal() +
                                             ", Status: " + ordem.getStatus() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar ordens de serviço: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdemServicoListagemUI().setVisible(true));
    }
}
