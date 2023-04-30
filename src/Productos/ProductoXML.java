package Productos;


import Productos.Producto;
import org.w3c.dom.Attr;
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

public class ProductoXML{
    private static final String FILE_NAME = "productos.xml";
    public static void crearArchivo() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("productos");
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

                    productos.add(new Producto(id, nombre, descripcion, tiempoCoccion, precio));
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
            Element rootElement = doc.createElement("productos");
            doc.appendChild(rootElement);

            // productos
            for (Producto producto : productos) {
                // producto element
                Element productoElement = doc.createElement("producto");
                productoElement.setAttribute("id", String.valueOf(producto.getId()));
                rootElement.appendChild(productoElement);

                // nombre element
                Element nombreElement = doc.createElement("nombre");
                nombreElement.appendChild(doc.createTextNode(producto.getNombre()));
                productoElement.appendChild(nombreElement);

                // descripcion element
                Element descripcionElement = doc.createElement("descripcion");
                descripcionElement.appendChild(doc.createTextNode(producto.getDescripcion()));
                productoElement.appendChild(descripcionElement);

                // tiempoCoccion element
                Element tiempoCoccionElement = doc.createElement("tiempo Coccion");
                tiempoCoccionElement.appendChild(doc.createTextNode(String.valueOf(producto.getTiempoCoccion())));
                productoElement.appendChild(tiempoCoccionElement);

                // precio element
                Element precioElement = doc.createElement("precio");
                precioElement.appendChild(doc.createTextNode(String.valueOf(producto.getPrecio())));
                productoElement.appendChild(precioElement);
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
            if (productos.get(i).equals(id)) {
                productos.remove(i);
                break;
            }
        }
        escribirProductos(productos);
    }

    public static Producto buscarProducto(String id) {
        ArrayList<Producto> productos = leerProductos();
        for (Producto producto : productos) {
            if (producto.equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public static void modificarProducto(Producto producto) {
        ArrayList<Producto> productos = leerProductos();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).equals(producto.getId())) {
                productos.set(i, producto);
                break;
            }
        }
        escribirProductos(productos);
    }
    public static Producto obtenerProductos() {
        ArrayList<Producto> productos = leerProductos();
        int randomIndex = (int) (Math.random() * productos.size());
        return productos.get(randomIndex);
    }


}
