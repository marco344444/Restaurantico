package Auxiliar.StackList;

public class StackList implements StackInterface {

    LinkedList list;
    private int size;

    public StackList() {
        list = new LinkedList();
    }

    @Override
    public void clear() {
        this.size = 0;
        this.list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getLast();
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        list.remove(list.tail);
        size--;
        return list.tail;
    }

    @Override
    public boolean push(Object object) {
        list.add(object);
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        if (list.contains(object) == true) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }

    }

    @Override
    public void reverse() {
        LinkedList<Object> reversedList = new LinkedList<Object>();
        while (!isEmpty()) {
            reversedList.addLast(pop());
        }
        list = reversedList;
    }

    public String toString() {
        return "ListStack{" + "size=" + size + ", list=" + list.toString() +  '}';
    }

	@Override
	public void sort() {
	    StackList sortedStack = new StackList();
	    while (!isEmpty()) {
	        Object smallest = pop();
	        while (!sortedStack.isEmpty() && ((Comparable)sortedStack.peek()).compareTo(smallest) > 0) {
	            push(sortedStack.pop());
	        }
	        sortedStack.push(smallest);
	    }
	    list = sortedStack.list;
	}
}