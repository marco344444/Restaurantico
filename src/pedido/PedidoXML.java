package pedido;
;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
    public void guardarCliente1(Pedido pedido) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoPedidoXML));

            Element rootElement = doc.getDocumentElement();

            Element elementoPedido = doc.createElement("pedido");

            //escribir en el XML telefono del cliente
            Element elementoTelefono = doc.createElement("Telefono");
            elementoTelefono.setTextContent(pedido.cliente.getTelefono());
            elementoPedido.appendChild(elementoTelefono);

            //escribir en el XML nombre del cliente
            Element elementoNombre = doc.createElement("Nombre");
            elementoNombre.setTextContent(pedido.cliente.getNombre());
            elementoPedido.appendChild(elementoNombre);

            //escribir en el XML apellido del cliente
            Element elementoApellidos = doc.createElement("Apellidos");
            elementoApellidos.setTextContent(pedido.cliente.getApellidos());
            elementoPedido.appendChild(elementoApellidos);

            //escribir en el XML el tpo cliente
            Element elementoTipoCliente = doc.createElement("Tipodecliente");
            elementoTipoCliente.setTextContent(pedido.cliente.getTipoCliente());
            elementoPedido.appendChild(elementoTipoCliente);

            //escribir en el XML la ciudad del cliente
            Element elementoCiudad = doc.createElement("Ciudad");
            elementoCiudad.setTextContent(pedido.cliente.getCiudad());
            elementoPedido.appendChild(elementoCiudad);

            //escribir en el XML la direccion del cliente
            Element elementoDireccion = doc.createElement("Direccion");
            elementoDireccion.setTextContent(pedido.cliente.getDireccion());
            elementoPedido.appendChild(elementoDireccion);

            //escribir en el XML el id del producto
            Element elementoId = doc.createElement("Id");
            elementoId.setTextContent(String.valueOf(pedido.producto.getId()));
            elementoPedido.appendChild(elementoId);

            //escribir en el XML la nombre del cliente
            Element elementoNombreProducto = doc.createElement("NombreProducto");
            elementoNombreProducto.setTextContent(pedido.getProducto().getNombre());
            elementoPedido.appendChild(elementoNombreProducto);

            //escribir en el XML la descripcion del cliente
            Element elementoDescripcion = doc.createElement("Descripcion");
            elementoDescripcion.setTextContent(pedido.producto.getDescripcion());
            elementoPedido.appendChild(elementoDescripcion);

            //escribir en el XML la tiempoCoccion del cliente
            Element elementoTiempoCoccion = doc.createElement("Precio");
            elementoTiempoCoccion.setTextContent(String.valueOf(pedido.producto.getTiempoCoccion()));
            elementoPedido.appendChild(elementoTiempoCoccion);

            //escribir en el XML la precio del cliente
            Element elementoPrecio = doc.createElement("Precio");
            elementoPrecio.setTextContent(String.valueOf(pedido.producto.getPrecio()));
            elementoPedido.appendChild(elementoPrecio);

            rootElement.appendChild(doc.createTextNode("\n"));

            rootElement.appendChild(elementoPedido);

            guardarDocumento(doc);

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
            StreamResult result = new StreamResult(new File(archivoPedidoXML));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

