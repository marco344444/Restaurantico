package Auxiliar.QueueList;

public class Main {
	public static void main(String[] args) {
	    QueueList queue = new QueueList();
	    queue.insert(5);
	    queue.insert(2);
	    queue.insert(8);
	    queue.insert(3);
	    queue.insert(4);
	    queue.insert(1);

	    System.out.println(queue);
	    System.out.println("¿La cola contiene el elemento 7? " + queue.search(7));
	    System.out.println("¿La cola contiene el elemento 8? " + queue.search(8));
	    
	    queue.reverse();
	    System.out.println(queue);


	    queue.sort();
	    System.out.println(queue);


	    queue.reverse();
	    System.out.println(queue);
	}


}
