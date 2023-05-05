package GUI.Operador;

import Cliente.*;
import Productos.Producto;
import pedido.Pedido;
import pedido.PedidoXML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

public class Operario extends JFrame{
    private JTextField numeroCelular;
    private JButton buscarButton;
    private JButton registrarClienteButton1;
    public JPanel Menu;
    private JList<Cliente> list1;
    private JButton crearPedidoButton;
    private JButton atrasButton;

    private ClienteXML clienteXML = new ClienteXML("archivoClienteXML");
    private DefaultListModel<Cliente> modeloListaClientes; // Variable de instancia para el modelo de lista

    Cliente clienteSeleccionado;

    public Operario() {
        PedidoXML pedidoXML;
        pedidoXML = new PedidoXML("archivoPedidoXML");

        setSize(800, 600);
        modeloListaClientes = new DefaultListModel<>(); // Inicializar la variable de instancia
        List<Cliente> clientes = clienteXML.obtenerTodosLosClientes();
        for (Cliente cliente : clientes) {
            modeloListaClientes.addElement(cliente);
        }
        list1.setModel(modeloListaClientes);

        list1.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getNombre() + " " + cliente.getApellidos());
                }
                return this;
            }
        });

        buscarButton.addActionListener(e -> buscarCliente());

        registrarClienteButton1.addActionListener(e -> {
            JDialog dialogo = new JDialog();
            dialogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dialogo.setSize(400, 300);
            dialogo.setLocationRelativeTo(null);

            JTextField nombreField = new JTextField();
            JTextField apellidosField = new JTextField();
            JTextField telefonoField = new JTextField();
            JTextField direccionField = new JTextField();
            JTextField ciudadField = new JTextField();
            JComboBox<String> tipoClienteComboBox = new JComboBox<>(new String[]{"comun", "premium"});

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Nombre:"));
            panel.add(nombreField);
            panel.add(new JLabel("Apellidos:"));
            panel.add(apellidosField);
            panel.add(new JLabel("Teléfono:"));
            panel.add(telefonoField);
            panel.add(new JLabel("Dirección:"));
            panel.add(direccionField);
            panel.add(new JLabel("Ciudad:"));
            panel.add(ciudadField);
            panel.add(new JLabel("Tipo de cliente:"));
            panel.add(tipoClienteComboBox);

            int resultado = JOptionPane.showConfirmDialog(dialogo, panel, "Registrar cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (resultado == JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText();
                String apellidos = apellidosField.getText();
                String telefono = telefonoField.getText();
                String direccion = direccionField.getText();
                String ciudad = ciudadField.getText();
                String tipoCliente = (String) tipoClienteComboBox.getSelectedItem();
                String[] pedidosFrecuentes = {"pedido 1", "pedido 2", "pedido 3"};

                if (!nombre.isEmpty() && !apellidos.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty() && !ciudad.isEmpty() && !tipoCliente.isEmpty()) {
                    Cliente nuevoCliente = new Cliente(telefono, nombre, apellidos, tipoCliente, ciudad, direccion);
                    clienteXML.guardarCliente(nuevoCliente);
                    modeloListaClientes.addElement(nuevoCliente);
                } else {
                    JOptionPane.showMessageDialog(dialogo, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            dialogo.dispose();
        });

        crearPedidoButton.addActionListener(e -> {
            SoliProductos soliProductos = new SoliProductos(this);
            soliProductos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            soliProductos.setSize(600, 800);
            soliProductos.setLocationRelativeTo(null);
            soliProductos.setVisible(true);

        });

        atrasButton.addActionListener(e -> volverAMostrarLista());

        list1.addListSelectionListener(e -> {
            clienteSeleccionado = (Cliente) list1.getSelectedValue();
        });

        pedidoXML = new PedidoXML("archivoPedidoXML");

        PedidoXML finalPedidoXML = pedidoXML;
        crearPedidoButton.addActionListener(e -> {
            Pedido pedido = new Pedido(clienteSeleccionado);
            finalPedidoXML.guardarPedido(pedido);
            
        });



    }
    public void onButtonClick(ActionEvent e) {
        if (e.getActionCommand().equals("Crear pedido")) {
            Pedido pedido = new Pedido(clienteSeleccionado);
            PedidoXML pedidoXML = null;
            pedidoXML.guardarPedido(pedido);
        }
    }



    private void volverAMostrarLista() {
        modeloListaClientes.removeAllElements(); // Limpiar el modelo de lista
        List<Cliente> clientes = clienteXML.obtenerTodosLosClientes();
        for (Cliente cliente : clientes) {
            modeloListaClientes.addElement(cliente); // Agregar los clientes al modelo original
        }
        list1.setModel(modeloListaClientes); // Establecer el modelo original en el JList
        setVisible(true);
    }

    private void buscarCliente() {
        String telefono = numeroCelular.getText();
        if (!telefono.isEmpty()) {
            Cliente cliente = clienteXML.imprimirClientePorTelefono(telefono);
            if (cliente != null) {
                DefaultListModel<Cliente> modeloListaClientes = new DefaultListModel<>();
                modeloListaClientes.addElement(cliente);
                list1.setModel(modeloListaClientes);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha encontrado ningún cliente con ese número de teléfono", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // No hacemos nada en este caso, simplemente dejamos que el usuario vuelva a la lista de clientes
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Operario");
        frame.setContentPane(new Operario().Menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}