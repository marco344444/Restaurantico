package Usuarios;

import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class Main{



    public static void main(String[] args) {

        UsuarioXML metodos = new UsuarioXML("archivoUsuarioXML");
        metodos.crearArchivo();

        Usuario usuario;
        usuario = new Usuario ("arnol", "123", "operador");
        metodos.guardarUsuario(usuario);

        usuario = new Usuario("fernando", "321", "operador");
        metodos.guardarUsuario(usuario);


        metodos.obtenerUsuario("arnol");
        metodos.obtenerUsuario("fernando");

        System.out.println("probar imprimir todos los usuarios");
        metodos.obtenerUsuarios();

        metodos.eliminarUsuario(usuario);

        metodos.obtenerUsuario("fernando");

        usuario = new Usuario("arnol", "098", "cocinero");
        metodos.actualizarUsuario(usuario);
        metodos.obtenerUsuario("arnol");


    }

}
