package GUI.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame{
    public JPanel Administrador;
    private JButton productosButton;
    private JButton usuariosButton;
    private JLabel Label;

    public Admin() {
        this.setLocationRelativeTo(null);
        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva instancia de la ventana AdminProductos
                AdminProductos productos = new AdminProductos();

                // Establecer el comportamiento al cerrar la ventana actual
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Cerrar la ventana actual
                dispose();

                // Mostrar la nueva ventana
                productos.pack();
                productos.setSize(1000, 600);
                productos.setVisible(true);

            }


        });
        usuariosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva instancia de la ventana AdminProductos
                AdminUsuarios Usuarios = new AdminUsuarios();

                // Establecer el comportamiento al cerrar la ventana actual
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Cerrar la ventana actual
                dispose();

                // Mostrar la nueva ventana
                Usuarios.pack();
                Usuarios.setSize(500, 600);
                Usuarios.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        Admin admin = new Admin();

        admin.setContentPane(admin.Administrador);
        admin.setSize(300,200);
        admin.setVisible(true);
    }
}
