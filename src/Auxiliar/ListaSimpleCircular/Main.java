
package Auxiliar.ListaSimpleCircular;





public class Main {


		public static void main(String[] args) {
		    CircularLinkedList list = new CircularLinkedList("todo bien");
			        
		            list.addLast("xd");
			        list.add("hola");
			        list.add(45);
			        list.addFirst(4);
			        System.out.println(list.add(4));
			        list.add("xd");
			        System.out.println(list.toString());
			        list.clear();
                    System.out.println(list.toString());
		                
			 
			    }
}
