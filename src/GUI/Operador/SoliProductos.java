package GUI.Operador;

import javax.swing.*;

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

    public SoliProductos() {
        setContentPane(Sproductos);
        setSize(600,800);
        setVisible(true);
    }



    public static void main(String[] args) {
        SoliProductos sproductos = new SoliProductos();
        sproductos .setContentPane(sproductos .Sproductos);
        sproductos .setSize(600,800);
        sproductos .setVisible(true);
    }
}
