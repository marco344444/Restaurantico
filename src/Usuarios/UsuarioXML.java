package Usuarios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioXML {

    private String archivoUsuarioXML;

    public UsuarioXML(String archivoXML) {
        this.archivoUsuarioXML = archivoXML;
    }

    // Crea un nuevo archivo XML con la estructura inicial
    public void crearArchivo() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element rootElement = doc.createElement("usuarios");
            doc.appendChild(rootElement);

            guardarDocumento(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    // Guarda un usuario en el archivo XML
    public void guardarUsuario(Usuario usuario) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoUsuarioXML));

            Element rootElement = doc.getDocumentElement();

            Element elementoUsuario = doc.createElement("usuario");

            Element elementoNombre = doc.createElement("nombre");
            elementoNombre.setTextContent(usuario.getNombre());
            elementoUsuario.appendChild(elementoNombre);

            Element elementoContrasena = doc.createElement("contrasena");
            elementoContrasena.setTextContent(usuario.getContrasena());
            elementoUsuario.appendChild(elementoContrasena);

            Element elementoTipo = doc.createElement("tipo");
            elementoTipo.setTextContent(usuario.getTipo());
            elementoUsuario.appendChild(elementoTipo);

            rootElement.appendChild(doc.createTextNode("\n"));

            rootElement.appendChild(elementoUsuario);

            guardarDocumento(doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // Actualiza un usuario en el archivo XML
    public void actualizarUsuario(Usuario usuario) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoUsuarioXML));

            Element rootElement = doc.getDocumentElement();

            NodeList listaUsuarios = doc.getElementsByTagName("usuario");

            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Element elementoUsuario = (Element) listaUsuarios.item(i);
                String nombre = elementoUsuario.getElementsByTagName("nombre").item(0).getTextContent();
                if (nombre.equals(usuario.getNombre())) {
                    elementoUsuario.getElementsByTagName("contrasena").item(0).setTextContent(usuario.getContrasena());
                    elementoUsuario.getElementsByTagName("tipo").item(0).setTextContent(usuario.getTipo());

                    guardarDocumento(doc);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Elimina un usuario del archivo XML
    public void eliminarUsuario(Usuario usuario) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoUsuarioXML));

            Element rootElement = doc.getDocumentElement();

            NodeList listaUsuarios = doc.getElementsByTagName("usuario");

            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Element elementoUsuario = (Element) listaUsuarios.item(i);
                String nombre = elementoUsuario.getElementsByTagName("nombre").item(0).getTextContent();
                if (nombre.equals(usuario.getNombre())) {
                    rootElement.removeChild(elementoUsuario);
                    guardarDocumento(doc);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método privado para
    // Guardar el documento en el archivo XML
    private void guardarDocumento(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoUsuarioXML));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void guardarUsuarios(List<Usuario> usuarios) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element rootElement = doc.createElement("usuarios");
            doc.appendChild(rootElement);

            for (Usuario usuario : usuarios) {
                Element elementoUsuario = doc.createElement("usuario");

                Element elementoNombre = doc.createElement("nombre");
                elementoNombre.setTextContent(usuario.getNombre());
                elementoUsuario.appendChild(elementoNombre);

                Element elementoContrasena = doc.createElement("contrasena");
                elementoContrasena.setTextContent(usuario.getContrasena());
                elementoUsuario.appendChild(elementoContrasena);

                Element elementoTipo = doc.createElement("tipo");
                elementoTipo.setTextContent(usuario.getTipo());
                elementoUsuario.appendChild(elementoTipo);

                rootElement.appendChild(doc.createTextNode("\n"));

                rootElement.appendChild(elementoUsuario);
            }

            guardarDocumento(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoUsuarioXML));

            NodeList listaUsuarios = doc.getElementsByTagName("usuario");

            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Element elementoUsuario = (Element) listaUsuarios.item(i);
                String nombre = elementoUsuario.getElementsByTagName("nombre").item(0).getTextContent();

                if (nombre.equals(nombreUsuario)) {
                    String contrasenaUsuario = elementoUsuario.getElementsByTagName("contrasena").item(0).getTextContent();

                    if (contrasenaUsuario.equals(contrasena)){
                        String tipo = elementoUsuario.getElementsByTagName("tipo").item(0).getTextContent();
                        usuario = new Usuario(nombre, contrasena, tipo);
                        System.out.println(nombre + "\n" + tipo );
                        return usuario;
                    } else {
                        System.out.println("contraseña incorrecta");
                        return null;
                    }
                }
            }

            System.out.println("usuario no existe");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoUsuarioXML));
            NodeList listaUsuarios = doc.getElementsByTagName("usuario");

            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Element elementoUsuario = (Element) listaUsuarios.item(i);
                String nombre = elementoUsuario.getElementsByTagName("nombre").item(0).getTextContent();
                String contrasena = elementoUsuario.getElementsByTagName("contrasena").item(0).getTextContent();
                String tipo = elementoUsuario.getElementsByTagName("tipo").item(0).getTextContent();
                System.out.println(nombre + " "+ tipo );
                Usuario usuario = new Usuario(nombre, contrasena, tipo);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}