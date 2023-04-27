package Auxiliar.StackList;

public class Main {

    public static void main(String[] args) {
        StackList stack = new StackList();
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(3);
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        stack.clear();
        System.out.println(stack.toString());
        stack.push(5);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        

}
}