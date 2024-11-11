package oficinamecanica.ui;

import javax.swing.*;
import java.awt.*;

public class VeiculoListagemUI extends JFrame {

    public VeiculoListagemUI() {
        setTitle("Listar Veículos");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea listaVeiculos = new JTextArea("Exemplo de lista de veículos...");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(e -> this.dispose());

        setLayout(new BorderLayout());
        add(new JScrollPane(listaVeiculos), BorderLayout.CENTER);
        add(voltarButton, BorderLayout.SOUTH);
    }
}
