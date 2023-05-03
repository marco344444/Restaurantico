package pedido;


import Cliente.Cliente;
import Productos.Producto;

import java.util.List;

public class MainPedido {

    public static void main(String[] args) {

        PedidoXML metodos = new PedidoXML("archivoPedidoXML");
        metodos.crearArchivo();

        Cliente cliente;
        Producto producto;
        Pedido pedido;

        cliente = new Cliente("3222892005", "carlos", "Quintero perez",
                "premium", "Bucaramanga", "calle 18 27-33", List.of(new String[]{"pizza"}));

        producto = new Producto(00, "Ceviche", "Inventese algo", 15, 20000);

        pedido = new Pedido(cliente, producto);

        metodos.guardarCliente1(pedido);


    }
}
