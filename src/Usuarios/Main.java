package Usuarios;

import Cliente.Cliente;
import Cliente.ClienteXML;
import Usuarios.Usuario;
import Usuarios.UsuarioXML;

public class Main {
    public static void main(String[] args) {
        // Creamos archivo para usuario

        // Creamos archivo para clientes
        ClienteXML.crearArchivo();
        // Creamos usuarios y clientes
        Usuario usuario1 = new Usuario("usuario1", "1234", "admin");
        Usuario usuario2 = new Usuario("usuario2", "5678", "operador");

        Cliente cliente1 = new Cliente(00,"Juan", "Pérez", "123456789", "particular", "Calle Falsa 123", "Bucaramanga");
        Cliente cliente2 = new Cliente(01,"María", "García", "987654321", "empresariale", "Avenida Siempreviva 742", "Piedecuesta");




        // Guardamos usuarios y clientes en archivos XML
        UsuarioXML.guardarUsuario(usuario1);
        UsuarioXML.guardarUsuario(usuario2);

        ClienteXML.agregarCliente(cliente1);
        ClienteXML.agregarCliente(cliente2);



        System.out.println("Clientes:");
        for (Cliente cliente : ClienteXML.leerClientes()) {
            System.out.println(cliente);
        }


    }
}
