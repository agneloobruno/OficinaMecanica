package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class FuncionarioListagemUI extends JFrame {

    public FuncionarioListagemUI() {
        setTitle("Listar Funcionários");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea listaFuncionarios = new JTextArea("Exemplo de lista de funcionários...");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(e -> this.dispose());

        setLayout(new BorderLayout());
        add(new JScrollPane(listaFuncionarios), BorderLayout.CENTER);
        add(voltarButton, BorderLayout.SOUTH);
    }
}
