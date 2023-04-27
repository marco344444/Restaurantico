package Auxiliar.DoublyLinkedList;

public class main {
	 public static void main(String[] args) {
	        
	        DoubleLinkedList<String> list = new DoubleLinkedList<>();

	        // Agregar elementos a la lista
	        list.add("Hola");
	        list.add("Mundo");
	        list.add("!");

	        // Imprimir la lista
	        System.out.println("Lista original: ");
	        System.out.println(list.toString());

	        // Clonar la lista
	        List<String> clonedList = list.clone();

	        // Agregar elementos a la lista clonada
	        clonedList.add("Esto");
	        clonedList.add("es");
	        clonedList.add("una");
	        clonedList.add("prueba");

	        // Imprimir la lista clonada
	        System.out.println("Lista clonada: ");
	        System.out.println(clonedList.toString());

	        // Eliminar elementos de la lista original
	        list.clear();

	        // Imprimir la lista original después de haber sido eliminada
	        System.out.println("Lista original después de haber sido eliminada: ");
	        System.out.println(list.toString());
	    }
	
}
