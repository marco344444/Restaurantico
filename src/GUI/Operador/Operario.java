package GUI.Operador;

import javax.swing.*;
import java.awt.*;

public class Operario extends JFrame{
    private JTextField numeroCelular;
    private JButton buscarButton;
    private JButton registrarClienteButton1;
    private JPanel Menu;


    public static void main(String[] args) {

        Operario menu = new Operario();
        menu.setContentPane(menu.Menu);
        menu.setSize(600,800);
        menu.setVisible(true);
    }
}
