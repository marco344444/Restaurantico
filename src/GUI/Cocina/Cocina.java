package GUI.Cocina;

import GUI.Operario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cocina extends JFrame{


    private JLabel PedidoPorHacer;
    private JLabel PedidosTerminados;
    private JButton button1;
    private JButton button2;
    private JPanel Cocina;

    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        cocina.setContentPane(cocina.Cocina);
        cocina.setSize(800, 600);
        cocina.setVisible(true);

        cocina.button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CocinaMensaje mensaje = new CocinaMensaje();
                mensaje.pack();
                mensaje.setVisible(true);
            }
        });
    }

}
