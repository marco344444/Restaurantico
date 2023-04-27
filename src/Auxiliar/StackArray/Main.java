package Auxiliar.StackArray;

public class Main {
	public static void main(String[] args) {
	    StackArray stack = new StackArray(5);
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    System.out.println(stack.toString()); 
	    System.out.println(stack.pop()); 
	    System.out.println(stack.peek()); 
	    System.out.println(stack.size()); 
	    System.out.println(stack.search(2)); 
	    System.out.println(stack.search(4)); 
	    stack.reverse();
	    System.out.println(stack.toString()); 
	    stack.sort();
	    System.out.println(stack.toString()); 
	}
}
