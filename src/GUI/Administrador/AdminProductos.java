package GUI.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProductos extends JDialog {
    private JList list1;
    private JPanel Panel;
    private JButton atrasButton;

    public AdminProductos() {
        setContentPane(Panel);
        setModal(true);

        // Crear una instancia del modelo de lista
        DefaultListModel<String> modeloLista = new DefaultListModel<String>();
        // Establecer el modelo de lista en la lista
        list1.setModel(modeloLista);

        // Agregar objetos a la lista
        modeloLista.addElement("Objeto 1");
        modeloLista.addElement("Objeto 2");
        modeloLista.addElement("Objeto 3");

        // Agregar el ActionListener al botón "atrasButton"
        atrasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
                // Crear una instancia de la clase "Admin" y mostrarla
                Admin admin = new Admin();
                admin.setContentPane(admin.Administrador);
                admin.setSize(300, 200);
                admin.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase "AdminProductos"
        AdminProductos productos = new AdminProductos();
        productos.pack();
        productos.setSize(500, 600);
        productos.setVisible(true);
        System.exit(0);
    }
}


