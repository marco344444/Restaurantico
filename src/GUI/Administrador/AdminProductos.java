package GUI.Administrador;

import javax.swing.*;

public class AdminProductos extends JDialog {
    private JList list1;
    private JPanel Panel;

    public AdminProductos(){
        setContentPane(Panel);
        setModal(true);
        this.setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        AdminProductos productos = new AdminProductos();
        productos.pack();
        productos.setSize(300,400);
        productos.setVisible(true);
        System.exit(0);
    }
}
