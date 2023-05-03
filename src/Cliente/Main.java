package Cliente;


import java.util.List;

public class Main {

        public static void main(String[] args) {


            ClienteXML metodos = new ClienteXML("archivoClienteXML");
            metodos.crearArchivo();

            Cliente cliente;
            cliente = new Cliente ("3222892002", "carlos", "Quintero perez", "premium",
                    "Bucaramanga", "calle 18 27-33");
            metodos.guardarCliente(cliente);

            cliente = new Cliente("3123261018", "luis", "Rodriguez Salazar", "comun",
                    "Bucaramanga", "calle 19 22-33");
            metodos.guardarCliente(cliente);


            metodos.imprimirClientePorTelefono("3222892002");
            metodos.imprimirClientePorTelefono("3123261018");






        }
    }


