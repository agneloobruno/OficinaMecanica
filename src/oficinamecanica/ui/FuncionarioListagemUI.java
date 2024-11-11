package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import oficinamecanica.model.Funcionario;
import oficinamecanica.service.FuncionarioService;

public class FuncionarioListagemUI extends JFrame {

    private JTextArea listaFuncionariosArea;
    private FuncionarioService funcionarioService;

    public FuncionarioListagemUI() {
        funcionarioService = new FuncionarioService();

        setTitle("Listar Funcionários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaFuncionariosArea = new JTextArea();
        listaFuncionariosArea.setEditable(false);
        atualizarListaFuncionarios();

        JScrollPane scrollPane = new JScrollPane(listaFuncionariosArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void atualizarListaFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
            listaFuncionariosArea.setText("");  // Limpa a área de texto

            for (Funcionario funcionario : funcionarios) {
                listaFuncionariosArea.append("ID: " + funcionario.getId() +
                                             ", Nome: " + funcionario.getNome() +
                                             ", Cargo: " + funcionario.getCargo() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar funcionários: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FuncionarioListagemUI().setVisible(true));
    }
}
