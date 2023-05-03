package Cliente;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
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

public class ClienteXML {

    private String archivoClienteXML;

    public ClienteXML(String archivoXML) {
        this.archivoClienteXML = archivoXML;
    }

    // Crea un nuevo archivo XML con la estructura inicial
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoClienteXML));
            NodeList nodosClientes = doc.getElementsByTagName("cliente");
            for (int i = 0; i < nodosClientes.getLength(); i++) {
                Element elementoCliente = (Element) nodosClientes.item(i);
                Cliente cliente = new Cliente();
                cliente.setTelefono(elementoCliente.getElementsByTagName("Telefono").item(0).getTextContent());
                cliente.setNombre(elementoCliente.getElementsByTagName("Nombre").item(0).getTextContent());
                cliente.setApellidos(elementoCliente.getElementsByTagName("Apellidos").item(0).getTextContent());
                cliente.setTipoCliente(elementoCliente.getElementsByTagName("Tipodecliente").item(0).getTextContent());
                cliente.setCiudad(elementoCliente.getElementsByTagName("Ciudad").item(0).getTextContent());
                cliente.setDireccion(elementoCliente.getElementsByTagName("Direccion").item(0).getTextContent());
                NodeList nodosPedidos = elementoCliente.getElementsByTagName("Pedido");
                if (nodosPedidos.getLength() > 0) {
                    List<String> pedidosFrecuentes = new ArrayList<>();
                    for (int j = 0; j < nodosPedidos.getLength(); j++) {
                        pedidosFrecuentes.add(nodosPedidos.item(j).getTextContent());
                    }
                    cliente.setPedidosFrecuentes(pedidosFrecuentes);
                }
                clientes.add(cliente);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public void cargarClientesEnJList(DefaultListModel<Cliente> modeloJList) {
        List<Cliente> clientes = obtenerTodosLosClientes();
        modeloJList.clear();
        for (Cliente cliente : clientes) {
            modeloJList.addElement(cliente);
        }
    }
    public void crearArchivo() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element rootElement = doc.createElement("Clientes");
            doc.appendChild(rootElement);

            guardarDocumento(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    // Guarda un Cliente en el archivo XML
    public void guardarCliente(Cliente cliente) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoClienteXML));

            Element rootElement = doc.getDocumentElement();

            Element elementoCliente = doc.createElement("cliente");

            //escribir en el XML telefono del cliente
            Element elementoTelefono = doc.createElement("Telefono");
            elementoTelefono.setTextContent(cliente.getTelefono());
            elementoCliente.appendChild(elementoTelefono);

            //escribir en el XML nombre del cliente
            Element elementoNombre = doc.createElement("Nombre");
            elementoNombre.setTextContent(cliente.getNombre());
            elementoCliente.appendChild(elementoNombre);

            //escribir en el XML apellido del cliente
            Element elementoApellidos = doc.createElement("Apellidos");
            elementoApellidos.setTextContent(cliente.getApellidos());
            elementoCliente.appendChild(elementoApellidos);

            //escribir en el XML el tpo cliente
            Element elementoTipoCliente = doc.createElement("Tipodecliente");
            elementoTipoCliente.setTextContent(cliente.getTipoCliente());
            elementoCliente.appendChild(elementoTipoCliente);

            //escribir en el XML la ciudad del cliente
            Element elementoCiudad = doc.createElement("Ciudad");
            elementoCiudad.setTextContent(cliente.getCiudad());
            elementoCliente.appendChild(elementoCiudad);

            //escribir en el XML la direccion del cliente
            Element elementoDireccion = doc.createElement("Direccion");
            elementoDireccion.setTextContent(cliente.getDireccion());
            elementoCliente.appendChild(elementoDireccion);

            // Escribir en el XML los pedidos frecuentes
            Element elementoPedidosFrecuentes = doc.createElement("PedidosFrecuentes");
            for (String pedidoFrecuente : cliente.getPedidosFrecuentes()) {
                Element elementoPedidoFrecuente = doc.createElement("Pedido");
                elementoPedidoFrecuente.setTextContent(pedidoFrecuente);
                elementoPedidosFrecuentes.appendChild(elementoPedidoFrecuente);
            }
            elementoCliente.appendChild(elementoPedidosFrecuentes);

            rootElement.appendChild(doc.createTextNode("\n"));

            rootElement.appendChild(elementoCliente);

            guardarDocumento(doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public Cliente imprimirClientePorTelefono(String telefono) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoClienteXML));

            NodeList nodosClientes = doc.getElementsByTagName("cliente");
            for (int i = 0; i < nodosClientes.getLength(); i++) {
                Element elementoCliente = (Element) nodosClientes.item(i);
                String telefonoCliente = elementoCliente.getElementsByTagName("Telefono").item(0).getTextContent();
                if (telefonoCliente.equals(telefono)) {
                    String nombre = elementoCliente.getElementsByTagName("Nombre").item(0).getTextContent();
                    String apellidos = elementoCliente.getElementsByTagName("Apellidos").item(0).getTextContent();
                    String tipoCliente = elementoCliente.getElementsByTagName("Tipodecliente").item(0).getTextContent();
                    String ciudad = elementoCliente.getElementsByTagName("Ciudad").item(0).getTextContent();
                    String direccion = elementoCliente.getElementsByTagName("Direccion").item(0).getTextContent();
                    List<String> pedidosFrecuentes = new ArrayList<>();
                    NodeList nodosPedidos = elementoCliente.getElementsByTagName("Pedido");
                    for (int j = 0; j < nodosPedidos.getLength(); j++) {
                        pedidosFrecuentes.add(nodosPedidos.item(j).getTextContent());
                    }
                    return new Cliente(nombre, apellidos, telefonoCliente, direccion, ciudad, tipoCliente, pedidosFrecuentes);
                }
            }
            return null; // si no se encuentra al cliente
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Guardar el documento en el archivo XML
    private void guardarDocumento(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoClienteXML));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
