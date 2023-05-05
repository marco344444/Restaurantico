package GUI.Operador;

import Productos.Producto;
import pedido.Pedido;
import pedido.PedidoXML;
import Cliente.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SoliProductos extends JFrame {
    private JPanel Sproductos;
    private JPanel ceviche;
    private JPanel Pfrito;
    private JPanel Psudado;
    private JPanel casuela;
    private JPanel cocadas;
    private JPanel arroz;
    private JPanel camarones;
    private JPanel patacones;
    private JSpinner Sceviche;
    private JSpinner Spfrito;
    private JSpinner Scocadas;
    private JSpinner Sarroz;
    private JSpinner Spsudado;
    private JSpinner Scasuela;
    private JSpinner Scamarones;
    private JSpinner Spatacones;
    private JButton SIGUIENTEButton;
    private JButton ATRASButton;
    private JLabel pescadoSudado;
    private JLabel Jceviche;
    private JLabel jcasuela;
    private JLabel jpescadoFrito;
    private JLabel jcocadas;
    private JLabel jpatacones;
    private JLabel jcamarones;
    private Operario ventanaAnterior;

    public SoliProductos(Operario ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        setContentPane(Sproductos);
        setSize(600,800);
        setVisible(true);
        ATRASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });
    }

}
