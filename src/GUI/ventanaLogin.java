package GUI;

import GUI.Administrador.Admin;
import GUI.Cocina.Cocina;
import GUI.Operador.Operario;
import Usuarios.Usuario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ventanaLogin extends JFrame {
    JLayeredPane contenedor = new JLayeredPane();
    public ventanaLogin(){
        this.setTitle("Login");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Ventana en el centro de la pantalla

        componentes();
    }//fin del JFrame

    private void componentes(){
        JPanel panel = new JPanel();//Crear panel
        panel.setLayout(null);
        panel.setBackground(Color.white);

        JLabel titulo = new JLabel("BIENVENIDO", SwingConstants.CENTER);
        titulo.setBounds(280,500,300,38);//Posisción y tamaño del JLabel
        titulo.setFont(new Font("Serif",Font.PLAIN,35));//Tamaño y fuente del JLabel

        //fondo para el login
        JLabel fondo = new JLabel();
        fondo.setBackground(Color.PINK);
        fondo.setOpaque(true);
        fondo.setBounds(820,87,450,620);

        //logo
        JLabel logo = new JLabel(new ImageIcon("pizza.png"));
        logo.setBounds(10,20,256,256);


        //boton se inicio
        JButton boton = new JButton("INGRESAR");
        boton.setBounds(947,620,190,45);

        JLabel textoInicio = new JLabel("INICIAR SESIÓN");
        textoInicio.setBounds(908,180,300,30);
        textoInicio.setFont(new Font("Serif",Font.BOLD,35));

        //correo
        JLabel correo = new JLabel("Usuario");
        correo.setBounds(1000,275,190,45);
        correo.setFont(new Font("Serif",Font.BOLD,25));

        JTextField textoCorreo = new JTextField();
        textoCorreo.setBounds(893,330,300,45);

        //contraseña
        JLabel contrasena = new JLabel("Contraseña");
        contrasena.setBounds(980,420,190,45);
        contrasena.setFont(new Font("Serif",Font.BOLD,25));

        JTextField textoContrasena = new JTextField();
        textoContrasena.setBounds(893,480,300,45);

        contenedor.add(panel,Integer.valueOf(0));
        contenedor.add(titulo,Integer.valueOf(1));
        contenedor.add(fondo,Integer.valueOf(1));
        contenedor.add(logo,Integer.valueOf(2));
        contenedor.add(boton,Integer.valueOf(2));
        contenedor.add(correo,Integer.valueOf(2));
        contenedor.add(contrasena,Integer.valueOf(2));
        contenedor.add(textoCorreo,Integer.valueOf(2));
        contenedor.add(textoContrasena,Integer.valueOf(2));
        contenedor.add(textoInicio,Integer.valueOf(2));


        this.getContentPane().add(contenedor);
        this.setSize(getMaximumSize());

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


        boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nombreUsuario = textoCorreo.getText();
                    String contrasena = textoContrasena.getText();

                    Usuario usuario = obtenerUsuario(nombreUsuario, contrasena);

                    if (usuario != null) {
                        // Verificar el tipo de usuario y mostrar la ventana correspondiente
                        if (usuario.getTipo().equals("administrador")) {
                            Admin admin = new Admin();

                            admin.setContentPane(admin.Administrador);
                            admin.setSize(300,200);
                            admin.setVisible(true);
                            dispose();
                        } else if (usuario.getTipo().equals("operador")) {
                            Operario menu = new Operario();
                            menu.setContentPane(menu.Menu);
                            menu.setSize(600,800);
                            menu.setVisible(true);
                            dispose(); // Cerrar la ventana de inicio de sesión
                        } else if (usuario.getTipo().equals("cocina")) {
                            Cocina cocina = new Cocina();
                            cocina.setContentPane(cocina.Cocina);
                            cocina.setSize(800, 600);
                            cocina.setVisible(true);
                            dispose(); // Cerrar la ventana de inicio de sesión
                        }
                    } else {
                        // Inicio de sesión fallido
                        JOptionPane.showMessageDialog(null, "Inicio de sesión fallido");
                    }
                }
            });

    }//Fin de lo que va dentro del panel

    private Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("archivoUsuarioXML"));

            NodeList listaUsuarios = doc.getElementsByTagName("usuario");

            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Element elementoUsuario = (Element) listaUsuarios.item(i);
                String nombre = elementoUsuario.getElementsByTagName("nombre").item(0).getTextContent();

                if (nombre.equals(nombreUsuario)) {
                    String contrasenaUsuario = elementoUsuario.getElementsByTagName("contrasena").item(0).getTextContent();

                    if (contrasenaUsuario.equals(contrasena)){
                        String tipo = elementoUsuario.getElementsByTagName("tipo").item(0).getTextContent();
                        usuario = new Usuario(nombre, contrasena, tipo);
                        return usuario;
                    } else {
                        System.out.println("Contraseña incorrecta");
                        return null;
                    }
                }
            }

            System.out.println("Usuario no existe");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}//fin de la clase