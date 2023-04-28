package Productos;

import Productos.Producto;
import Productos.ProductoXML;

public class Main {
    public static void main(String[] args) {


        // Creamos archivo para producto
        ProductoXML.crearArchivo();

        Producto producto1 = new Producto(00,"Ceviche", "Inventese algo", "15 minutos", "Inventese algo");
        Producto producto2 = new Producto(01,"Pescado frito", "Inventese algo", "Inventese algo", "Inventese algo");
        Producto producto3 = new Producto(02,"Pescado sudado", "Inventese algo", "Inventese algo", "Inventese algo");
        Producto producto4 = new Producto(03,"Casuela", "Inventese algo", "Inventese algo", "Inventese algo");
        Producto producto5 = new Producto(04,"Cocadas", "Inventese algo", "Inventese algo", "Inventese algo");
        Producto producto6 = new Producto(05,"Arroz con coco", "Inventese algo", "Inventese algo", "Inventese algo");
        Producto producto7 = new Producto(06,"Camarones en salsa", "Inventese algo", "Inventese algo", "Inventese algo");





        // Guardamos usuarios y clientes en archivos XML
        ProductoXML.agregarProducto(producto1);
        ProductoXML.agregarProducto(producto2);
        ProductoXML.agregarProducto(producto3);
        ProductoXML.agregarProducto(producto4);
        ProductoXML.agregarProducto(producto5);
        ProductoXML.agregarProducto(producto6);
        ProductoXML.agregarProducto(producto7);




        System.out.println("Productos:");
        for (Producto producto : ProductoXML.leerProductos()) {
            System.out.println(producto);
        }


    }
}