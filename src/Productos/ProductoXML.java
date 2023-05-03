package Productos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoXML {
    private static final String FILE_NAME = "archivoProductoXML";

    public static void crearArchivo() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("archivoProductoXML");
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

    public static ArrayList<Producto> leerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("producto");
                for (int i = 0; i < nList.getLength(); i++) {
                    Element element = (Element) nList.item(i);
                    int id = Integer.parseInt(element.getAttribute("id"));
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = element.getElementsByTagName("descripcion").item(0).getTextContent();
                    int tiempoCoccion = Integer.parseInt(element.getAttribute("tiempoCoccion"));
                    int precio = Integer.parseInt(element.getAttribute("precio"));

                    Producto producto = new Producto(id, nombre, descripcion, tiempoCoccion, precio);
                    productos.add(producto);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public static void escribirProductos(ArrayList<Producto> productos) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("archivoProductoXML");
            doc.appendChild(rootElement);

            // productos
            for (Producto producto : productos) {
                Element productoElement = convertirProductoAXMLElement(producto, doc);
                rootElement.appendChild(productoElement);
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

    public static void agregarProducto(Producto producto) {
        ArrayList<Producto> productos = leerProductos();
        productos.add(producto);
        escribirProductos(productos);
    }

    public static void eliminarProducto(String id) {
        ArrayList<Producto> productos = leerProductos();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == Integer.parseInt(id)) {
                productos.remove(i);
                break;
            }
        }
        escribirProductos(productos);
    }

    public static Producto buscarProducto(String id) {
        ArrayList<Producto> productos = leerProductos();
        for (Producto producto : productos) {
            if (producto.getId() == Integer.parseInt(id)) {
                return producto;
            }
        }
        return null;
    }

    public static void modificarProducto(Producto producto) {
        ArrayList<Producto> productos = leerProductos();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                productos.set(i, producto);
                break;
            }
        }
        escribirProductos(productos);
    }

    private static Element convertirProductoAXMLElement(Producto producto, Document doc) {
        Element productoElement = doc.createElement("producto");
        productoElement.setAttribute("id", Integer.toString(producto.getId()));

        Element nombreElement = doc.createElement("nombre");
        nombreElement.appendChild(doc.createTextNode(producto.getNombre()));
        productoElement.appendChild(nombreElement);

        Element descripcionElement = doc.createElement("descripcion");
        descripcionElement.appendChild(doc.createTextNode(producto.getDescripcion()));
        productoElement.appendChild(descripcionElement);

        productoElement.setAttribute("tiempoCoccion", Integer.toString(producto.getTiempoCoccion()));
        productoElement.setAttribute("precio", Integer.toString(producto.getPrecio()));

        return productoElement;
    }
}