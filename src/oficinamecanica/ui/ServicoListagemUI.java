package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ServicoListagemUI extends JFrame {

    public ServicoListagemUI() {
        setTitle("Listar Serviços");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea listaServicos = new JTextArea("Exemplo de lista de serviços...");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(e -> this.dispose());

        setLayout(new BorderLayout());
        add(new JScrollPane(listaServicos), BorderLayout.CENTER);
        add(voltarButton, BorderLayout.SOUTH);
    }
}
