package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class ClienteListagemUI extends JFrame {
    public ClienteListagemUI() {
        setTitle("Listar Clientes");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea listaClientes = new JTextArea("Exemplo de lista de clientes...");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(e -> this.dispose());

        setLayout(new BorderLayout());
        add(new JScrollPane(listaClientes), BorderLayout.CENTER);
        add(voltarButton, BorderLayout.SOUTH);
    }
}
