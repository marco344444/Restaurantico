package GUI.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUsuarios extends JDialog {
    private JList list1;
    private JPanel panel;
    private JButton atrasButton;

    public AdminUsuarios(){
        setContentPane(panel);
        setModal(true);
        this.setLocationRelativeTo(null);
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
        AdminUsuarios Usuarios = new AdminUsuarios();
        Usuarios.pack();
        Usuarios.setSize(300,400);
        Usuarios.setVisible(true);
        System.exit(0);
    }
}
