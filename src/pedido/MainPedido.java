package pedido;


import Cliente.Cliente;
import Productos.Producto;

import java.util.List;

public class MainPedido {

    public static void main(String[] args) {
        // Crear un objeto Pedido y asignar valores a sus propiedades
        Cliente cliente = new Cliente("123456789", "Juan", "Pérez", "Estandar", "Bucaramanga", "Calle Mayor 1");
        Producto producto = new Producto(00,"Ceviche", "Inventese algo", 5, 20000);
        Pedido pedido = new Pedido(00,cliente, producto, 2);

        // Crear un objeto PedidoXML y llamar al método guardarPedido
        PedidoXML pedidoXML = new PedidoXML("archivoPedidoXML");
        pedidoXML.crearArchivo();
        pedidoXML.guardarPedido(pedido);
    }
}
