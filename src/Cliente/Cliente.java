package Cliente;

import java.util.List;

public class Cliente {
    String telefono;
    String nombre;
    String apellidos;
    String tipoCliente;
    String ciudad;
    String direccion;

    public Cliente(String telefono, String nombre, String apellidos, String tipoCliente, String ciudad, String direccion) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoCliente = tipoCliente;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Cliente() {

    }

    public Cliente(String telefono, String nombre, String direccion) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
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
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
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
}