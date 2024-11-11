package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class OrdemServicoListagemUI extends JFrame {

    public OrdemServicoListagemUI() {
        setTitle("Listar Ordens de Serviço");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea listaOrdens = new JTextArea("Exemplo de lista de ordens de serviço...");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(e -> this.dispose());

        setLayout(new BorderLayout());
        add(new JScrollPane(listaOrdens), BorderLayout.CENTER);
        add(voltarButton, BorderLayout.SOUTH);
    }
}
