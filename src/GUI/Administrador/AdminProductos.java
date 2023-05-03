package GUI.Administrador;

import Productos.Producto;
import Productos.ProductoXML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//esta clase maneja todos los productos desde el administrador
public class AdminProductos extends JDialog {
    private JList list1;
    private JPanel Panel;
    private JButton atrasButton;
    private JButton addProductoButton;
    private JButton eliminarProductoButton;

    public AdminProductos() {
        setContentPane(Panel);
        setModal(true);

        // Crear una instancia del modelo de lista
        DefaultListModel<Producto> modeloLista = new DefaultListModel<Producto>();

        // Obtener la lista de productos del archivo XML
        ArrayList<Producto> productos = ProductoXML.leerProductos();

        // Agregar los productos al modelo de lista
        for (Producto producto : productos) {
            modeloLista.addElement(producto);
        }

        // Establecer el modelo de lista en la lista
        list1.setModel(modeloLista);

        // Agregar el ActionListener al botón "atrasButton"
        addProductoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialogo = new JDialog();
                dialogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialogo.setSize(400, 300);
                dialogo.setLocationRelativeTo(null);

                // Crear los componentes de la ventana de diálogo
                JTextField idField = new JTextField();
                JTextField nombreField = new JTextField();
                JTextField descripcionField = new JTextField();
                JTextField tiempoCoccionField = new JTextField();
                JTextField precioField = new JTextField();

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("ID:"));
                panel.add(idField);
                panel.add(new JLabel("Nombre:"));
                panel.add(nombreField);
                panel.add(new JLabel("Descripción:"));
                panel.add(descripcionField);
                panel.add(new JLabel("Tiempo de cocción:"));
                panel.add(tiempoCoccionField);
                panel.add(new JLabel("Precio:"));
                panel.add(precioField);

                // Mostrar la ventana de diálogo
                int resultado = JOptionPane.showConfirmDialog(dialogo, panel, "Agregar producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION) {
                    // Obtener los valores ingresados por el usuario
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    int tiempoCoccion = Integer.parseInt(tiempoCoccionField.getText());
                    int precio = Integer.parseInt(precioField.getText());

                    // Crear una instancia de Producto con los valores ingresados
                    Producto nuevoProducto = new Producto(id, nombre, descripcion, tiempoCoccion, precio);

                    // Obtener el modelo de lista actual
                    DefaultListModel<Producto> modeloLista = (DefaultListModel<Producto>) list1.getModel();

                    // Agregar el nuevo producto al modelo de lista
                    modeloLista.addElement(nuevoProducto);

                    // Guardar el nuevo producto en el archivo XML
                    ProductoXML.agregarProducto(nuevoProducto);
                }

                dialogo.dispose();
            }
        });
        eliminarProductoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el índice del producto seleccionado en la lista
                int selectedIndex = list1.getSelectedIndex();

                // Verificar si se ha seleccionado un producto
                if (selectedIndex != -1) {
                    // Obtener el modelo de lista actual
                    DefaultListModel<Producto> modeloLista = (DefaultListModel<Producto>) list1.getModel();

                    // Obtener el producto seleccionado
                    Producto productoSeleccionado = modeloLista.getElementAt(selectedIndex);

                    // Mostrar un cuadro de diálogo de confirmación
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Si el usuario confirma la eliminación, eliminar el producto del modelo de lista y del archivo XML
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        modeloLista.remove(selectedIndex);
                        ProductoXML.eliminarProducto(productoSeleccionado.getId());
                    }
                }
            }
        });

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
        productos.setSize(800, 600);
        productos.setVisible(true);
        System.exit(0);
    }
}


