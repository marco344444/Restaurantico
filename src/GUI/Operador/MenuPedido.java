package GUI.Operador;

import Productos.Producto;
import Productos.ProductoXML;
import pedido.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPedido extends JFrame {
    private JList<Producto> lista1;
    private JButton crearFacturaButton;
    private JButton atrasButton;
    private JPanel panelPrincipal;
    private JLabel cantidadLabel;
    private JTextField textField1;

    private Pedido pedido;

    public MenuPedido() {
        initComponents();
        cargarListaProductos();
        pedido = new Pedido();
        setContentPane(panelPrincipal);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        panelPrincipal = new JPanel();
        lista1 = new JList<>();
        JScrollPane scrollPane = new JScrollPane(lista1);
        crearFacturaButton = new JButton("Crear factura");
        atrasButton = new JButton("Atrás");
        cantidadLabel = new JLabel("Cantidad:");
        textField1 = new JTextField();

        GroupLayout layout = new GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cantidadLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                                                .addComponent(crearFacturaButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(atrasButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cantidadLabel)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(crearFacturaButton)
                                        .addComponent(atrasButton))
                                .addContainerGap())
        );

        crearFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidoXML pedidoXML = new PedidoXML("archivoPedidoXML");

                int cantidad = Integer.parseInt(textField1.getText());
                ArrayList<Producto> productosSeleccionados = new ArrayList<>(lista1.getSelectedValuesList());
                for (Producto producto : productosSeleccionados) {
                    pedidoXML.agregarProducto(producto);
                }
                // Crear la factura usando el objeto pedido
                // ...
            }
        });
    }

    private void cargarListaProductos() {
        ProductoXML productoXML = new ProductoXML();
        ArrayList<Producto> listaProductos = productoXML.leerProductos();
        DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<>();

        for (Producto producto : listaProductos) {
            modeloListaProductos.addElement(producto);
        }
        lista1.setModel(modeloListaProductos);
    }

    public static void main(String[] args) {
        MenuPedido menu = new MenuPedido();
        menu.setContentPane(menu.panelPrincipal);
        menu.setSize(800, 600);
        menu.setVisible(true);
    }
    private void crearFactura() {
        // Crear instancia del objeto PedidoXML
        PedidoXML pedidoXML = new PedidoXML("archivoPedidoXML");
        // Agregar productos al pedido usando el objeto PedidoXML
        pedidoXML.agregarProducto(pedido.getProducto());
        // Crear factura usando el objeto PedidoXML
        // ...
    }
}
