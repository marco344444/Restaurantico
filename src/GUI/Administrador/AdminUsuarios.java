package GUI.Administrador;

import javax.swing.*;

public class AdminUsuarios extends JDialog {
    private JList list1;
    private JPanel panel;
    public AdminUsuarios(){
        setContentPane(panel);
        setModal(true);
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        AdminUsuarios Usuarios = new AdminUsuarios();
        Usuarios.pack();
        Usuarios.setSize(300,400);
        Usuarios.setVisible(true);
        System.exit(0);
    }
}
