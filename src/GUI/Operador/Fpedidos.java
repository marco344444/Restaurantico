package GUI.Operador;

import javax.swing.*;

public class Fpedidos extends JFrame{
    private JButton ATRASButton;
    private JButton REALIZARButton;
    private JList list1;
    private JPanel Fpedido;

    public static void main(String[] args) {
        Fpedidos fpedidos = new Fpedidos();
        fpedidos.setContentPane(fpedidos.Fpedido);
        fpedidos.setSize(600,800);
        fpedidos.setVisible(true);
    }
}
