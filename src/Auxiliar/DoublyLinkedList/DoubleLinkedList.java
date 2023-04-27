
package Auxiliar.DoublyLinkedList;

import java.util.Iterator;

public class DoubleLinkedList<T> implements List<T>{
    
    public LinkedListNode head;
    public LinkedListNode tail;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
    }
    
    public DoubleLinkedList(T object){
        this.head = tail = new LinkedListNode(object);
    }
    
    @Override
    public boolean add(T object) {
        boolean ack = false;
        try {
            if (object != null) {
                if (isEmpty()) {
                    head = tail = new LinkedListNode<>(object);
                } else {
                    tail.next = new LinkedListNode<>(object);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
                ack = true;
            }
            return ack;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Node node, T object) {
    	boolean ack = false;
        try {
            LinkedListNode<T> nodo = (LinkedListNode<T>) node;
            LinkedListNode<T> nodoNuevo = new LinkedListNode(object);
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
        boolean ack = false;
        try{
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            if (head == null) {
                head = nodoNuevo;
                tail = nodoNuevo;
            } else {
                nodoNuevo.next = head;
                head.prev = nodoNuevo;
                head = nodoNuevo;
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return ack;
        }
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
        DoubleLinkedList clon = new DoubleLinkedList();
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
            DoubleLinkedList list = new DoubleLinkedList();
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
        DoubleLinkedList<T> list = new DoubleLinkedList<T>();
        list.head = (LinkedListNode<T>) from;
        list.tail = (LinkedListNode<T>) to;
        DoubleLinkedList<T> listR = (DoubleLinkedList<T>) list.clone();
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
        String stringR = "";
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            LinkedListNode next = (LinkedListNode) iterator.next();
            stringR += next.toString();
            if (next.next != null) {
                stringR += " next=";
            }
        }
        return stringR;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public Iterator<Node> iterator() {
        Iterator<Node> iterator = new Iterator<>() {
            LinkedListNode nodoActual = head;
            LinkedListNode nodoTemp = null;

            int iteration = 0;
            @Override
            public boolean hasNext() {
                boolean ack = false;
                try{
                    if( nodoActual.next != null ){
                    ack = true;
                    }
                }catch(Exception e){
                    System.err.println(e.getStackTrace());
                }finally{
                    return ack;
                }
            }
            @Override
            public Node next() {
                try{
                    if(iteration != 0){nodoActual = nodoActual.next;}
                    iteration++;
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    return nodoActual;
                }
            }
        };
        return iterator;
    }
    
}
