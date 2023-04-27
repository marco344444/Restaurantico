package Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ClienteXML{

    private static final String FILE_NAME = "clientes.xml";
    public static void crearArchivo() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("clientes");
            doc.appendChild(rootElement);

            // write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> leerClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("cliente");
                for (int i = 0; i < nList.getLength(); i++) {
                    Element element = (Element) nList.item(i);
                    int id = Integer.parseInt(element.getAttribute("id"));
                    String nombres = element.getElementsByTagName("nombres").item(0).getTextContent();
                    String apellidos = element.getElementsByTagName("apellidos").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();
                    String tipo = element.getElementsByTagName("tipo").item(0).getTextContent();
                    String direccion = element.getElementsByTagName("direccion").item(0).getTextContent();
                    String ciudad = element.getElementsByTagName("ciudad").item(0).getTextContent();
                    clientes.add(new Cliente(id, nombres, apellidos, telefono, tipo, direccion, ciudad));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static void escribirClientes(ArrayList<Cliente> clientes) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("clientes");
            doc.appendChild(rootElement);

            // clientes
            for (Cliente cliente : clientes) {
                // cliente element
                Element clienteElement = doc.createElement("cliente");
                clienteElement.setAttribute("id", String.valueOf(cliente.getId()));
                rootElement.appendChild(clienteElement);

                // nombres element
                Element nombresElement = doc.createElement("nombres");
                nombresElement.appendChild(doc.createTextNode(cliente.getNombre()));
                clienteElement.appendChild(nombresElement);

                // apellidos element
                Element apellidosElement = doc.createElement("apellidos");
                apellidosElement.appendChild(doc.createTextNode(cliente.getApellido()));
                clienteElement.appendChild(apellidosElement);

                // telefono element
                Element telefonoElement = doc.createElement("telefono");
                telefonoElement.appendChild(doc.createTextNode(cliente.getTelefono()));
                clienteElement.appendChild(telefonoElement);

                // tipo element
                Element tipoElement = doc.createElement("tipo");
                tipoElement.appendChild(doc.createTextNode(cliente.getTipo()));
                clienteElement.appendChild(tipoElement);

                // direccion element
                Element direccionElement = doc.createElement("direccion");
                direccionElement.appendChild(doc.createTextNode(cliente.getDireccion()));
                clienteElement.appendChild(direccionElement);
                // ciudad element
                Element ciudadElement = doc.createElement("ciudad");
                ciudadElement.appendChild(doc.createTextNode(cliente.getCiudad()));
                clienteElement.appendChild(direccionElement);
            }

            // write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void agregarCliente(Cliente cliente) {
        ArrayList<Cliente> clientes = leerClientes();
        clientes.add(cliente);
        escribirClientes(clientes);
    }

    public static void eliminarCliente(String id) {
        ArrayList<Cliente> clientes = leerClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(id)) {
                clientes.remove(i);
                break;
            }
        }
        escribirClientes(clientes);
    }

    public static Cliente buscarCliente(String id) {
        ArrayList<Cliente> clientes = leerClientes();
        for (Cliente cliente : clientes) {
            if (cliente.equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public static void modificarCliente(Cliente cliente) {
        ArrayList<Cliente> clientes = leerClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(cliente.getId())) {
                clientes.set(i, cliente);
                break;
            }
        }
        escribirClientes(clientes);
    }
    public static Cliente obtenerCliente() {
        ArrayList<Cliente> clientes = leerClientes();
        int randomIndex = (int) (Math.random() * clientes.size());
        return clientes.get(randomIndex);
    }


}