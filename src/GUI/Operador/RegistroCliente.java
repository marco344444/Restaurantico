package GUI.Operador;

import javax.swing.*;

public class RegistroCliente extends JFrame {
    private JTextField telefono;
    private JTextField nombre;
    private JTextField apellidos;
    private JComboBox tipoCliente;
    private JTextField textField1;
    private JTextField textField2;
    private JButton REGISTRARButton;
    private JPanel RCliente;


    public static void main(String[] args) {
        RegistroCliente rcliente = new RegistroCliente();
        rcliente .setContentPane(rcliente .RCliente);
        rcliente .setSize(600,800);
        rcliente .setVisible(true);
    }
}
