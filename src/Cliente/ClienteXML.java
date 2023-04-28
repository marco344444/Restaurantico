package Cliente;

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

public class ClienteXML {

    private String archivoClienteXML;

    public ClienteXML(String archivoXML) {
        this.archivoClienteXML = archivoXML;
    }

    // Crea un nuevo archivo XML con la estructura inicial
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

    public void imprimirClientePorTelefono(String telefono) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoClienteXML));

            NodeList nodosClientes = doc.getElementsByTagName("cliente");
            for (int i = 0; i < nodosClientes.getLength(); i++) {
                Element elementoCliente = (Element) nodosClientes.item(i);
                String telefonoCliente = elementoCliente.getElementsByTagName("Telefono").item(0).getTextContent();
                if (telefonoCliente.equals(telefono)) {
                    System.out.println("Cliente encontrado:");
                    System.out.println("Nombre: " + elementoCliente.getElementsByTagName("Nombre").item(0).getTextContent());
                    System.out.println("Apellidos: " + elementoCliente.getElementsByTagName("Apellidos").item(0).getTextContent());
                    System.out.println("Tipo de cliente: " + elementoCliente.getElementsByTagName("Tipodecliente").item(0).getTextContent());
                    System.out.println("Ciudad: " + elementoCliente.getElementsByTagName("Ciudad").item(0).getTextContent());
                    System.out.println("Dirección: " + elementoCliente.getElementsByTagName("Direccion").item(0).getTextContent());
                    NodeList nodosPedidos = elementoCliente.getElementsByTagName("Pedido");
                    if (nodosPedidos.getLength() > 0) {
                        System.out.println("Pedidos frecuentes:");
                        for (int j = 0; j < nodosPedidos.getLength(); j++) {
                            System.out.println("- " + nodosPedidos.item(j).getTextContent());
                        }
                    }
                    return;
                }
            }
            System.out.println("No se encontró ningún cliente con el teléfono " + telefono);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
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
