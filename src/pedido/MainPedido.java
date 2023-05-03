package pedido;


import Cliente.Cliente;
import Productos.Producto;

import java.util.List;

public class MainPedido {

    public static void main(String[] args) {
        // Crear un objeto Pedido y asignar valores a sus propiedades
        Cliente cliente = new Cliente("123456789", "Juan", "Pérez", "Particular", "Madrid", "Calle Mayor 1");
        Producto producto = new Producto(1, "Pizza Margarita", "Pizza con salsa de tomate y mozzarella", 30, 8);
        Pedido pedido = new Pedido(cliente, producto, 2);

        // Crear un objeto PedidoXML y llamar al método guardarPedido
        PedidoXML pedidoXML = new PedidoXML("archivoPedidoXML");
        pedidoXML.crearArchivo();
        pedidoXML.guardarPedido(pedido);
    }
}
