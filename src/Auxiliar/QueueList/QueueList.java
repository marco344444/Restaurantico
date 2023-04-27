package Auxiliar.QueueList;

public class QueueList implements QueueInterface {
    LinkedList list;
    private int size;
    
    public QueueList() {
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
	public Object extract() {
	    if (isEmpty()) {
	        return null;
	    } else {
	        size--;
	        list.remove(list.head);
	        return list.head;
	    }
	}

	@Override
	public boolean insert(Object object) {
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
	    LinkedListNode currentNode = list.head;
	    while (currentNode != null) {
	        if (currentNode.getObject().equals(object)) {
	            return true;
	        }
	        currentNode = currentNode.next;
	    }
	    return false;
	}

	@Override
	public void sort() {
	    LinkedListNode current = list.head;
	    int size = size();
	    for (int i = 0; i < size - 1; i++) {
	        current = list.head;
	        for (int j = 0; j < size - i - 1; j++) {
	            if (((Comparable) current.getObject()).compareTo(current.next.getObject()) > 0) {
	                // intercambia los elementos //
	                Object temp = current.getObject();
	                current.setObject(current.next.getObject());
	                current.next.setObject(temp);
	            }
	            current = current.next;
	        }
	    }
	}

	@Override
		public void reverse() {
		    LinkedListNode current = list.head;
		    LinkedListNode prev = null;
		    LinkedListNode next = null;
		    while (current != null) {
		        next = current.next;
		        current.next = prev;
		        prev = current;
		        current = next;
		    }
		    list.head = prev;
		}





	public String toString() {
		return "Queue{" + "size=" + size + ", list=" + list.toString() +  '}';
	}

}
