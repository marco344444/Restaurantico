package Auxiliar.ArbolBinBusqueda;

public class Main {

    public static void main(String[] args) {
        
        // Creamos un árbol de búsqueda vacío
        ArbolBusqueda<Integer> arbol = new ArbolBusqueda<>();

        // Agregamos algunos valores al árbol
        arbol.agregar(5);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(1);
        arbol.agregar(4);
        arbol.agregar(6);
        arbol.agregar(8);

        // Imprimimos la cantidad de nodos y la altura del árbol
        System.out.println("Cantidad de nodos: " + arbol.countNodes());
        System.out.println("Altura del árbol: " + arbol.height());

        // Verificamos si el árbol es completo
        if (arbol.isComplete()) {
            System.out.println("El árbol es completo.");
        } else {
            System.out.println("El árbol NO es completo.");
        }

        // Verificamos si el árbol es lleno
        if (arbol.isFull()) {
            System.out.println("El árbol es lleno.");
        } else {
            System.out.println("El árbol NO es lleno.");
        }

        // Buscamos algunos valores en el árbol
        System.out.println("¿El árbol contiene el valor 6? " + arbol.buscar(6));
        System.out.println("¿El árbol contiene el valor 2? " + arbol.buscar(2));

        // Eliminamos un valor del árbol
        System.out.println("¿Se eliminó el valor 3? " + arbol.eliminar(3));

        // Imprimimos la cantidad de nodos y la altura del árbol de nuevo
        System.out.println("Cantidad de nodos: " + arbol.countNodes());
        System.out.println("Altura del árbol: " + arbol.height());
    }
}