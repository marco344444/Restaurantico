package Productos;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private String tiempoCoccion;
    private String precio;


    public Producto(int id, String nombre, String descripcion, String tiempoCoccion, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoCoccion = tiempoCoccion;
        this.precio = precio;

    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTiempoCoccion() {
        return tiempoCoccion;
    }
    public void setTiempoCoccion(String tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tiempo de Coccion='" + tiempoCoccion + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
