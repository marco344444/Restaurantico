package Auxiliar.QueueArray;

public class Main {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        queue.insert(20);
        queue.insert(50);
        queue.insert(10);
        queue.insert(40);
        
        System.out.println(queue.toString());
        queue.sort();
        System.out.println(queue.toString());
        System.out.println("salio de la cola: " + queue.extract());
        System.out.println(queue.toString());

        System.out.println("¿esta el 30 en la cola? " + queue.search(30));
        System.out.println(queue.toString());
        
        queue.sort();
        System.out.println(queue.toString());

        queue.reverse();
        System.out.println(queue.toString());

        queue.clear();
        System.out.println(queue.toString());
    }
}