package Usuarios;

import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class Main{



    public static void main(String[] args) {

        UsuarioXML metodos = new UsuarioXML("archivoUsuarioXML");
        metodos.crearArchivo();

        Usuario usuario1 = new Usuario("admin", "admin123", "administrador");
        metodos.guardarUsuario(usuario1);
        Usuario usuario2 = new Usuario("operador1", "oper123", "operador");
        metodos.guardarUsuario(usuario2);
        Usuario usuario3 = new Usuario("operador2", "oper123", "operador");
        metodos.guardarUsuario(usuario3);
        Usuario usuario4 = new Usuario("operador3", "oper123", "operador");
        metodos.guardarUsuario(usuario4);
        Usuario usuario5 = new Usuario("operador4", "oper123", "operador");
        metodos.guardarUsuario(usuario5);
        Usuario usuario6 = new Usuario("cocina", "cocina123", "cocina");
        metodos.guardarUsuario(usuario6);

        System.out.println("probar imprimir todos los usuarios");
        metodos.obtenerUsuarios();



    }

}
