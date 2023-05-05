package pedido;

import Cliente.Cliente;
import Productos.Producto;

public class Pedido {

    private int id;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private int precioTotal;

    public Pedido(int id, Cliente cliente, Producto producto, int cantidad, int precioTotal) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public Pedido() {
        this.id = 0;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = 0;
        this.precioTotal = 0;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int calcularPrecioTotal(String ciudad) {
        int precioUnitario = producto.getPrecio();
        int cantidad = this.cantidad;
        int precioTotal = precioUnitario * cantidad;

        int recargoDomicilio;

        if (ciudad.equals("Floridablanca") || ciudad.equals("floridablanca")) {
            int distancia = 8; // Distancia en kilómetros desde Bucaramanga hasta Floridablanca
            recargoDomicilio = Math.max(distancia - 5, 0) * 1000 + 5000; // Se cobra $1.000 por cada kilómetro adicional a los primeros 5, con un mínimo de $5.000
        } else if (ciudad.equals("Girón") || ciudad.equals("giron")) {
            int distancia = 15; // Distancia en kilómetros desde Bucaramanga hasta Girón
            recargoDomicilio = Math.max(distancia - 5, 0) * 1000 + 5000; // Se cobra $1.000 por cada kilómetro adicional a los primeros 5, con un mínimo de $5.000
        } else if (ciudad.equals("Piedecuesta") || ciudad.equals("piedecuesta")) {
            int distancia = 19; // Distancia en kilómetros desde Bucaramanga hasta Piedecuesta
            recargoDomicilio = Math.max(distancia - 5, 0) * 1000 + 5000; // Se cobra $1.000 por cada kilómetro adicional a los primeros 5, con un mínimo de $5.000
        } else {
            recargoDomicilio = 0; // Si la ciudad no está dentro de las mencionadas, no se cobra recargo de domicilio
        }
        precioTotal += recargoDomicilio;
        this.setPrecioTotal(precioTotal);
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precioTotal=" + precioTotal +
                '}';
    }
}