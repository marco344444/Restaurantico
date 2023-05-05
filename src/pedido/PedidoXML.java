package pedido;
import Cliente.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Productos.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class PedidoXML {

    private String archivoPedidoXML;

    public PedidoXML(String archivoXML) {
        this.archivoPedidoXML = archivoXML;
    }

    // Crea un nuevo archivo XML con la estructura inicial
    public void crearArchivo() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element rootElement = doc.createElement("Pedido");
            doc.appendChild(rootElement);

            guardarDocumento(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    // Guarda un pedido en el archivo XML




    // Guardar el documento en el archivo XML
    private void guardarDocumento(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoPedidoXML));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Guarda un pedido en el archivo XML
    public void guardarPedido(Pedido pedido) {
        if (pedido.getCliente() == null) {
            System.out.println("No tiene cliente seleccionado para crear pedido");
            return;
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoPedidoXML));

            Element rootElement = doc.getDocumentElement();

            Element elementoPedido = doc.createElement("pedido");

            // ...

            // Escribir en el XML el teléfono del cliente
            Element elementoTelefono = doc.createElement("Telefono");
            elementoTelefono.setTextContent(pedido.getCliente().getTelefono());
            elementoPedido.appendChild(elementoTelefono);

            // Escribir en el XML el nombre del cliente
            Element elementoNombre = doc.createElement("Nombre");
            elementoNombre.setTextContent(pedido.getCliente().getNombre());
            elementoPedido.appendChild(elementoNombre);

            // Escribir en el XML los apellidos del cliente
            Element elementoApellidos = doc.createElement("Apellidos");
            elementoApellidos.setTextContent(pedido.getCliente().getApellidos());
            elementoPedido.appendChild(elementoApellidos);

            // Escribir en el XML el tipo de cliente
            Element elementoTipoCliente = doc.createElement("Tipodecliente");
            elementoTipoCliente.setTextContent(pedido.getCliente().getTipoCliente());
            elementoPedido.appendChild(elementoTipoCliente);

            // Escribir en el XML la ciudad del cliente
            Element elementoCiudad = doc.createElement("Ciudad");
            elementoCiudad.setTextContent(pedido.getCliente().getCiudad());
            elementoPedido.appendChild(elementoCiudad);

            // Escribir en el XML la dirección del cliente
            Element elementoDireccion = doc.createElement("Direccion");
            elementoDireccion.setTextContent(pedido.getCliente().getDireccion());
            elementoPedido.appendChild(elementoDireccion);

            // ...

            rootElement.appendChild(doc.createTextNode("\n"));

            rootElement.appendChild(elementoPedido);

            guardarDocumento(doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    public String getUltimoTelefonoRegistrado() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoPedidoXML));
            NodeList nodosPedidos = doc.getElementsByTagName("pedido");
            int cantidadPedidos = nodosPedidos.getLength();
            if (cantidadPedidos == 0) {
                System.out.println("No hay pedidos registrados en el archivo.");
                return null;
            }
            Element elementoUltimoPedido = (Element) nodosPedidos.item(cantidadPedidos - 1);
            return elementoUltimoPedido.getElementsByTagName("Telefono").item(0).getTextContent();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void agregarProducto(Producto producto) {
        try {
            Pedido pedido= new Pedido();
            String ultimoTelefonoRegistrado = getUltimoTelefonoRegistrado();
            if (ultimoTelefonoRegistrado == null) {
                System.out.println("No se pudo obtener el último teléfono registrado.");
                return;
            }
            pedido.setCliente(new Cliente(ultimoTelefonoRegistrado, "", "")); // Solo se necesita el teléfono para buscar el pedido correspondiente

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoPedidoXML));

            Element rootElement = doc.getDocumentElement();

            // Buscar el elemento pedido correspondiente
            Element elementoPedido = null;
            for (int i = 0; i < rootElement.getElementsByTagName("pedido").getLength(); i++) {
                Element tempElementoPedido = (Element) rootElement.getElementsByTagName("pedido").item(i);
                if (tempElementoPedido.getElementsByTagName("Telefono").item(0).getTextContent().equals(pedido.getCliente().getTelefono())) {
                    elementoPedido = tempElementoPedido;
                    break;
                }
            }

            if (elementoPedido == null) {
                System.out.println("No se encontró el pedido correspondiente");
                return;
            }

            // Crear el elemento producto
            Element elementoProducto = doc.createElement("producto");

            // Agregar los atributos del producto
            elementoProducto.setAttribute("id", String.valueOf(producto.getId()));
            elementoProducto.setAttribute("nombre", producto.getNombre());
            elementoProducto.setAttribute("precio", String.valueOf(producto.getPrecio()));
            elementoProducto.setAttribute("cantidad", String.valueOf(pedido.getCantidad())); // Usamos el método getCantidad de pedido

            // Agregar el elemento producto al elemento pedido
            elementoPedido.appendChild(doc.createTextNode("\n    "));
            elementoPedido.appendChild(elementoProducto);
            elementoPedido.appendChild(doc.createTextNode("\n"));

            guardarDocumento(doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }






}


