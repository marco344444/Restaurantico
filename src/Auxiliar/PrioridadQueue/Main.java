package Auxiliar.PrioridadQueue;

public class Main {
	public static void main(String[] args) {
	    QueuePrioridad queue = new QueuePrioridad(10);
	    queue.insert(5);
	    queue.insert(8);
	    queue.insert(2);
	    queue.insert(10);
	    queue.insert(1);

	    System.out.println("Cola antes de ordenar: " + queue);

	    queue.sort();

	    System.out.println("Cola después de ordenar: " + queue);

	    queue.reverse();

	    System.out.println("Cola después de revertir: " + queue);

	    System.out.println("Tamaño de la cola: " + queue.size());

	    System.out.println("Extrayendo elementos de la cola: ");
	    while (!queue.isEmpty()) {
	        System.out.println(queue.extract());
	    }
	}

}
