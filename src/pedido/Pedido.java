package pedido;


import Cliente.Cliente;
import Productos.Producto;

public class Pedido {

    Cliente cliente;
    Producto producto;

    public Pedido(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
