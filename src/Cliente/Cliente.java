package Cliente;

import java.util.List;

public class Cliente {
    String telefono;
    String nombre;
    String apellidos;
    String TipoCliente;
    String ciudad;
    String direccion;
    String[] pedidosFrecuentes;

    public Cliente(String telefono, String nombre, String apellidos, String tipoCliente, String ciudad, String direccion, List<String> pedidosFrecuentes) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        TipoCliente = tipoCliente;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.pedidosFrecuentes = pedidosFrecuentes.toArray(new String[0]);
    }

    public Cliente() {

    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    public String getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        TipoCliente = tipoCliente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String dirección) {
        this.direccion = dirección;
    }

    public String[] getPedidosFrecuentes() {
        return pedidosFrecuentes;
    }

    public void setPedidosFrecuentes(List<String> pedidosFrecuentes) {
        this.pedidosFrecuentes = pedidosFrecuentes.toArray(new String[0]);
    }
}
