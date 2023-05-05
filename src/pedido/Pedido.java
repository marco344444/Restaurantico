package pedido;


import Cliente.Cliente;
import Productos.Producto;

public class Pedido {

    private int id;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    private int precioTotal;

    public Pedido(Cliente cliente, Producto producto, int cantidad, int id, int precioTotal) {

        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {this.precioTotal = precioTotal;}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public Producto getProducto() {return producto;}

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
