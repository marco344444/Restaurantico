
package Auxiliar.CircularDobleLinkedList;

import java.util.Iterator;

public class DoubleCircularLinkedList<T> implements List<T>{
    
    public LinkedListNode head;
    public LinkedListNode tail;

    public DoubleCircularLinkedList(){
        head = new LinkedListNode(null);
        head.next = head;
        head.prev = head; // Se agrega un puntero prev al nodo cabeza
        tail = head;
    }
    
    public DoubleCircularLinkedList(T object){
        this.head = tail = new LinkedListNode(object);
        head.next = head;
        head.prev = head; // Se agrega un puntero prev al nodo cabeza
    }
    
    @Override
    public boolean add(T object) {
        if (object == null) {
            return false;
        }

        if (isEmpty()) {
            head = new LinkedListNode(object);
            head.prev = head;
            tail = head;
            tail.next = head;
        } else {
            tail.next = new LinkedListNode(object);
            tail.next.prev = tail;
            tail = tail.next;
            tail.next = head;
            head.prev = tail;
        }
        
        return true;
    }

    @Override
    public boolean add(Node node, T object) {
        boolean ack = false;
        try {
            LinkedListNode<T> current = (LinkedListNode<T>) node;
            LinkedListNode<T> newNode = new LinkedListNode<>(object);

            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;

            ack = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ack;
    }

    @Override
    public boolean add(Node node, Node next) {
    	boolean ack = false;
        try {
            LinkedListNode<T> nodo = (LinkedListNode<T>) node;
            LinkedListNode<T> nodoNuevo = (LinkedListNode<T>) next;
            if (nodo.next == null) {
                nodo.next = nodoNuevo;
                nodoNuevo.prev = nodo;
                tail = nodoNuevo;
            } else {
                nodoNuevo.next = nodo.next;
                nodoNuevo.prev = nodo;
                nodo.next.prev = nodoNuevo;
                nodo.next = nodoNuevo;
            }
            ack = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return ack;
    }

    @Override
    public boolean add(T[] objects) {
    	 boolean ack = false;
         try {
             for (T object : objects) {
                 if (isEmpty()) {
                     head = tail = new LinkedListNode<>(object);
                 } else {
                     tail.next = new LinkedListNode<>(object);
                     tail.next.prev = tail;
                     tail = tail.next;
                 }
             }
             ack = true;
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
         return ack;
     }

    @Override
    public boolean add(Node node, T[] objects) {
    	 boolean ack = false;
         try {
             LinkedListNode<T> nodo = (LinkedListNode<T>) node;
             if (nodo.next != null) {
                 for (T object : objects) {
                     LinkedListNode<T> nodoNuevo = new LinkedListNode<>(object);
                     nodoNuevo.next = nodo.next;
                     nodoNuevo.prev = nodo;
                     nodo.next.prev = nodoNuevo;
                     nodo.next = nodoNuevo;
                 }
                 ack = true;
             }
         } catch (ClassCastException e) {
             System.err.println("Error: el nodo no es compatible con la lista enlazada.");
         }
         return ack;
     }

    @Override
    public boolean addFirst(T object) {
        if (object == null) {
            return false;
        }

        LinkedListNode<T> newNode = new LinkedListNode<>(object);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        return true;
    }
    @Override
    public boolean addFirst(T[] objects) {
    	 boolean ack = false;
    	    try{
    	        for (T object : objects) {
    	            LinkedListNode nodoNuevo = new LinkedListNode(object);
    	            if (head == null) {
    	                head = nodoNuevo;
    	                tail = nodoNuevo;
    	            } else {
    	                nodoNuevo.next = head;
    	                head.prev = nodoNuevo;
    	                head = nodoNuevo;
    	            }
    	        }
    	        ack = true;
    	    } catch (Exception e){
    	        e.printStackTrace();
    	    } finally {
    	        return ack;
    	    }
    	}

    @Override
    public boolean addLast(T object) {
        boolean ack = false;
        try{
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            if (tail == null) {
                head = nodoNuevo;
                tail = nodoNuevo;
            } else {
                tail.next = nodoNuevo;
                nodoNuevo.prev = tail;
                tail = nodoNuevo;
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    @Override
    public boolean addLast(T[] objects) {
        boolean ack = false;
        try{
            for (T object : objects) {
                LinkedListNode nodoNuevo = new LinkedListNode(object);
                if (tail == null) {
                    head = nodoNuevo;
                    tail = nodoNuevo;
                } else {
                    tail.next = nodoNuevo;
                    nodoNuevo.prev = tail;
                    tail = nodoNuevo;
                }
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return ack;
        }
    }

    @Override
    public boolean clear() {
        boolean ack = false;
        try{
            head = tail = null;
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public List clone() {
        Iterator iterator = iterator();
        DoubleCircularLinkedList clon = new DoubleCircularLinkedList();
            while(iterator.hasNext()){
                LinkedListNode nodoTemp = (LinkedListNode) iterator.next();
                clon.add(nodoTemp.getObject());
            }
        return clon;
    }

    @Override
    public boolean contains(T object) {
        boolean ack = false;
        try{
            Iterator iterator = iterator();
            while(iterator.hasNext()){
                LinkedListNode nodo = (LinkedListNode) iterator.next();
                if(nodo.getObject().equals(object)){
                    ack = true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean contains(T[] objects) {
        boolean ack = true;
        try{
            int i = 0;
            Iterator iterator = iterator();
            for (T object : objects) {
                while(iterator.hasNext()){
                    LinkedListNode nodo = (LinkedListNode) iterator.next();
                    if(!(nodo.getObject().equals(object))){
                        ack = false;
                        break;
                    }
                } 
                if(!ack){break;}
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
        
    }

    @Override
    public Node nodeOf(T object) {
        LinkedListNode nodoR = null;
        Iterator iterator = iterator();
        
        while(iterator.hasNext()){
            LinkedListNode nodo = (LinkedListNode) iterator.next();
            if(nodo.getObject().equals(object)){
                nodoR = nodo;
                break;
            }
        }
        return nodoR;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T get() {
        return (T) tail.getObject();
    }

    @Override
    public T get(Node node) {
        return (T) node.getObject();
    }

    @Override
    public T getPrevious(LinkedListNode node) {
        if (node == null || node == head) {
            return null;
        }
        return (T) node.prev.getObject();
    }

    @Override
    public T getNext(LinkedListNode node) {
        if (node == null || node.next == null) {
            return null;
        }
        return (T) node.next.getObject();
    }
    @Override
    public T getFirst() {
        return (T) head.getObject();
    }

    @Override
    public T[] getFirst(int n) {
        @SuppressWarnings("unchecked")
        T[] elements = (T[]) new Object[n];
        int i = 0;
        Iterator iterator = iterator();
        while (iterator.hasNext() && i < n) {
            LinkedListNode<T> node = (LinkedListNode<T>) iterator.next();
            elements[i++] = node.getObject();
        }
        return elements;
    }

    @Override
    public T getLast() {
        return (T) tail.getObject();
    }

    @Override
    public T[] getLast(int n) {
        @SuppressWarnings("unchecked")
        T[] elements = (T[]) new Object[n];
        int i = n - 1;
        LinkedListNode<T> node = tail;
        while (node != null && i >= 0) {
            elements[i--] = node.getObject();
            node = node.prev;
        }
        return elements;
    }

    @Override
    public T pop() {
        LinkedListNode nodoPop = tail;
        LinkedListNode nodoPrev = (LinkedListNode) nodeOf(getPrevious(tail));
        nodoPrev.next = null;
        tail = nodoPrev;
        return (T) nodoPop.getObject();
    }

    @Override
    public boolean remove(T object) {
        try {
            LinkedListNode<T> eliminar = (LinkedListNode<T>) nodeOf(object);
            LinkedListNode<T> prev = (LinkedListNode<T>) nodeOf(getPrevious(eliminar));
            if (prev == null) {
                // El nodo a eliminar es el primer nodo de la lista
                head = eliminar.next;
            } else {
                prev.next = eliminar.next;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Node node) {
        try {
            LinkedListNode<T> eliminar = (LinkedListNode<T>) node;
            LinkedListNode<T> prev = (LinkedListNode<T>) nodeOf(getPrevious(eliminar));
            if (prev == null) {
                // El nodo a eliminar es el primer nodo de la lista
                head = eliminar.next;
            } else {
                prev.next = eliminar.next;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAll(T[] objects) {
        boolean ack = false;
        try{
            for (T object : objects) {remove(object);}
            ack = true;
        return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean retainAll(T[] objects) {
        boolean ack = false;
        try{
            Iterator iterator = iterator();
            DoubleCircularLinkedList list = new DoubleCircularLinkedList();
            for (T object : objects) {
                while( iterator.hasNext() ){
                    LinkedListNode nodo = (LinkedListNode) iterator.next();
                    if(nodo.getObject().equals(object)){
                        list.add(nodo.getObject());
                    }
                }
            }
            head = list.head;
            tail = list.tail;
        }catch(Exception e){
            e.getStackTrace();
        }finally{
            return ack;
        }
    }

    @Override
    public boolean set(Node node, T object) {
        boolean ack = false;
        try{
            node.setObject(object);
            ack = true;
        }catch( Exception e ){
            e.getStackTrace();
        }finally{
            return ack;
        }
    }

    @Override
    public int size() {
        Iterator iterator = iterator();
        int tm = 0;
        while(iterator.hasNext()){
            iterator.next();
            tm++;
        }
        return tm;
    }

    @Override
    public List subList(Node from, Node to) {
    	DoubleCircularLinkedList<T> list = new DoubleCircularLinkedList<T>();
        list.head = (LinkedListNode<T>) from;
        list.tail = (LinkedListNode<T>) to;
        DoubleCircularLinkedList<T> listR = (DoubleCircularLinkedList<T>) list.clone();
        listR.tail.next = null;
        return listR;
    }

    @Override
    public T[] toArray() {
        Object[] arr = new Object[size()];
        int i = 0;
        Iterator iterator = iterator();
        while(iterator.hasNext()){
            LinkedListNode next = (LinkedListNode) iterator.next();
            arr[i++] = next.getObject();
        }
	return (T[]) arr;
    }

    @Override
    public boolean orderBy(char c) {
        boolean ack = false;
        try {
            if (size() <= 1) {
                return false;
            }
            
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                LinkedListNode<T> current = head;
                while (current.next != null) {
                    if (current.getObject().toString().compareTo(current.next.getObject().toString()) > 0) {
                        T temp = current.getObject();
                        current.setObject((T) current.next.getObject());
                        current.next.setObject(temp);
                        sorted = false;
                    }
                    current = current.next;
                }
            }
            
            ack = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }
    
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    LinkedListNode current = head;
    sb.append("[");
    if (current != null) {
        sb.append(current.getObject().toString());
        current = current.next;
    }
    while (current != head) {
        sb.append(", ");
        sb.append(current.getObject().toString());
        current = current.next;
    }
    sb.append("]");
    return sb.toString();
}

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public Iterator<Node> iterator() {
        Iterator<Node> iterator = new Iterator<>() {
            LinkedListNode<T> nodoActual = head;

            @Override
            public boolean hasNext() {
                return nodoActual.next != null;
            }

            @Override
            public Node next() {
                nodoActual = nodoActual.next;
                return nodoActual;
            }
        };
        return iterator;
    }

}
