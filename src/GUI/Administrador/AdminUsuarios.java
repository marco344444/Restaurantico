package GUI.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Usuarios.Usuario;
import Usuarios.UsuarioXML;

public class AdminUsuarios extends JDialog {
    private JList list1;
    private JPanel panel;
    private JButton atrasButton;
    private JButton eliminarButton;
    private JButton agregarButton;

    public AdminUsuarios(){
        setContentPane(panel);
        setModal(true);

        // Crear una instancia de la clase UsuarioXML y obtener la lista de usuarios
        UsuarioXML usuarioXML = new UsuarioXML("archivoUsuarioXML");
        List<Usuario> usuarios = usuarioXML.obtenerUsuarios();

        // Crear una instancia del modelo de lista utilizando la clase DefaultListModel
        DefaultListModel<String> modeloLista = new DefaultListModel<String>();
        // Agregar los usuarios a la lista utilizando el método addElement() del modelo de lista
        for (Usuario usuario : usuarios) {
            modeloLista.addElement(usuario.getNombre() + " (" + usuario.getTipo() + ")");
        }

        // Establecer el modelo de lista en la lista
        list1.setModel(modeloLista);

        // Agregar un ActionListener al botón "Eliminar" para eliminar el usuario seleccionado de la lista
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list1.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    modeloLista.remove(indiceSeleccionado);
                    usuarios.remove(indiceSeleccionado);
                    usuarioXML.guardarUsuarios(usuarios);
                }
            }
        });

        // Agregar un ActionListener al botón "Agregar usuario" para abrir una ventana de diálogo para ingresar los detalles del nuevo usuario
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogo = new JDialog();
                dialogo.setTitle("Agregar usuario");
                dialogo.setModal(true);
                dialogo.setSize(300, 200);
                dialogo.setLocationRelativeTo(null);

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JLabel nombreLabel = new JLabel("Nombre:");
                JTextField nombreField = new JTextField(20);
                JLabel contrasenaLabel = new JLabel("Contraseña:");
                JPasswordField contrasenaField = new JPasswordField(20);
                JLabel tipoLabel = new JLabel("Tipo:");
                JComboBox<String> tipoComboBox = new JComboBox<String>(new String[] {"operador", "cocina"});
                JButton crearButton = new JButton("Crear");
                JButton cancelarButton = new JButton("Cancelar");

                panel.add(nombreLabel);
                panel.add(nombreField);
                panel.add(contrasenaLabel);
                panel.add(contrasenaField);
                panel.add(tipoLabel);
                panel.add(tipoComboBox);
                panel.add(Box.createVerticalStrut(10));
                panel.add(crearButton);
                panel.add(cancelarButton);

                // Agregar un ActionListener al botón "Crear" para crear el nuevo usuario y agregarlo a la lista
                crearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombre = nombreField.getText();
                        String contrasena = new String(contrasenaField.getPassword());
                        String tipo = (String) tipoComboBox.getSelectedItem();

                        if (!nombre.isEmpty() && !contrasena.isEmpty() && (tipo.equals("operador") || tipo.equals("cocina"))) {
                            Usuario nuevoUsuario = new Usuario(nombre, contrasena, tipo);
                            usuarios.add(nuevoUsuario);
                            modeloLista.addElement(nuevoUsuario.getNombre() + " (" + nuevoUsuario.getTipo() + ")");
                            usuarioXML.guardarUsuarios(usuarios);
                            dialogo.dispose();
                        } else {
                            JOptionPane.showMessageDialog(dialogo, "Por favor ingrese un nombre y una contraseña válidos y seleccione un tipo de usuario válido", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Agregar un ActionListener al botón "Cancelar" para cerrar la ventana de diálogo
                cancelarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialogo.dispose();
                    }
                });

                dialogo.setContentPane(panel);
                dialogo.setVisible(true);
            }
        });

        // Agregar un ActionListener para volver
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

        // Establecer el tamaño de la ventana y la posición relativa al centro de la pantalla
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        AdminUsuarios dialog = new AdminUsuarios();
        dialog.setVisible(true);
        System.exit(0);
    }
}