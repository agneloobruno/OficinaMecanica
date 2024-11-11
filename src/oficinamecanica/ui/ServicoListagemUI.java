package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import oficinamecanica.model.Servico;
import oficinamecanica.service.ServicoService;

public class ServicoListagemUI extends JFrame {

    private JTextArea listaServicoArea;
    private ServicoService servicoService;

    public ServicoListagemUI() {
        servicoService = new ServicoService();

        setTitle("Listar Serviços");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaServicoArea = new JTextArea();
        listaServicoArea.setEditable(false);
        atualizarListaServico();

        JScrollPane scrollPane = new JScrollPane(listaServicoArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void atualizarListaServico() {
        try {
            List<Servico> servicos = servicoService.listarServicos();
            listaServicoArea.setText("");  // Limpa a área de texto

            for (Servico servico : servicos) {
                listaServicoArea.append("ID: " + servico.getId() +
                                        ", Descrição: " + servico.getDescricao() +
                                        ", Preço: " + servico.getPreco() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar serviços: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServicoListagemUI().setVisible(true));
    }
}
