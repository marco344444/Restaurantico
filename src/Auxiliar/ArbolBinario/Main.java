package Auxiliar.ArbolBinario;

public class Main {

	public static void main(String[] args) {
	    ArbolBinario arbol = new ArbolBinario();
	    arbol.insertByDepth(5);
	    arbol.insertByDepth(3);
	    arbol.insertByDepth(8);
	    arbol.insertByDepth(1);
	    arbol.insertByDepth(4);
	    arbol.insertByDepth(7);
	    arbol.insertByDepth(9);
	    System.out.println("Recorrido en preorden: ");
	    arbol.preorder(arbol.root);
	    System.out.println("\nRecorrido en inorden: ");
	    arbol.inorder(arbol.root);
	    System.out.println("\nRecorrido en posorden: ");
	    arbol.posorder(arbol.root);
	    System.out.println("\nRecorrido por anchura: ");
	    arbol.widthorder();
	    System.out.println("\nBuscando el nodo con valor 7...");
	    NodoArbol buscado = arbol.buscarPreorden(arbol.root, 7);
	    if (buscado != null) {
	        System.out.println("Se encontró el nodo con valor " + buscado.val);
	    } else {
	        System.out.println("No se encontró ningún nodo con valor 7");
	    }
	    System.out.println("Eliminando el nodo con valor 5...");
	    arbol.remove(5);
	    System.out.println("Recorrido en inorden después de eliminar el nodo con valor 5: ");
	    arbol.inorder(arbol.root);
}
}