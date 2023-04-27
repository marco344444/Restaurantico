
package Auxiliar.StackList;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements List<T>{
    
    public LinkedListNode head;
    public LinkedListNode tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }
    
    public LinkedList(T object){
        this.head = tail = new LinkedListNode(object);
    }
    
    @Override
    public boolean add(T object) {
        boolean ack = false;
        try{
            if(object != null){
                if(isEmpty()){
                    head = new LinkedListNode(object);
                    tail = head;
                } else {
                    tail.next = new LinkedListNode(object);
                    tail = tail.next;
                }
                ack = true;
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean add(Node node, T object) {
        boolean ack = false;
        try{
            LinkedListNode nodo = (LinkedListNode) node;
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            if(nodo.next == null){
                nodo.next = nodoNuevo;
                tail = nodoNuevo;
            }else{
                nodoNuevo.next = nodo.next;
                nodo.next = nodoNuevo;
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean add(Node node, Node next) {
        boolean ack = false;
        try{
            LinkedListNode nodo = (LinkedListNode) node;
            LinkedListNode nodoNuevo = (LinkedListNode) next;
            if(nodo.next == null){
                nodo.next = nodoNuevo;
                tail = nodoNuevo;
            }else{
                nodoNuevo.next = nodo.next;
                nodo.next = nodoNuevo;
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean add(T[] objects) {
        boolean ack = false;
        try{
            for (T object : objects) {
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            tail.next = nodoNuevo;
            tail = nodoNuevo;
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean add(Node node, T[] objects) {
        boolean ack = false;
        try{
            LinkedListNode nodo = (LinkedListNode) node;
            if(nodo.next != null){
                for (T object : objects) {
                    LinkedListNode nodoNuevo = new LinkedListNode(object);
                    nodoNuevo.next = nodo.next;
                    nodo.next = nodoNuevo;
                    nodo = nodoNuevo;
                }
            }else{
                for (T object : objects) {
                    LinkedListNode nodoNuevo = new LinkedListNode(object);
                    tail.next = nodoNuevo;
                    tail = nodoNuevo;
                }
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean addFirst(T object) {
        boolean ack = false;
        try{
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            nodoNuevo.next = head;
            head = nodoNuevo;
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
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
                nodoNuevo.next = head;
                head = nodoNuevo;
            }
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return ack;
        }
    }

    @Override
    public boolean addLast(T object) {
        boolean ack = false;
        try{
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            tail.next = nodoNuevo;
            tail = nodoNuevo;
            ack = true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
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
            tail.next = nodoNuevo;
            tail = nodoNuevo;
            ack = true;
        }
        } catch (Exception e){
            e.printStackTrace();
            return false;
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
        LinkedList clon = new LinkedList();
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
    public T getPrevious(Node node) {
        if (isEmpty() ) {
            return null;
        }

        Iterator<Node> iterator = iterator();
        LinkedListNode<T> currentNode = (LinkedListNode<T>) iterator.next();
        while (iterator.hasNext()) {
            LinkedListNode<T> nextNode = (LinkedListNode<T>) iterator.next();
            if (nextNode.equals(node)) {
                return currentNode.getObject();
            }
            currentNode = nextNode;
        }
        return null;
    }

    @Override
    public T getNext(Node node) {
        LinkedListNode nodo = (LinkedListNode) node;
        return (T) nodo.next.getObject();
    }

    @Override
    public T getFirst() {
        return (T) head.getObject();
    }

    @Override
    public T[] getFirst(int n) {
        T[] a = null;
        ArrayList<T> arrR = new ArrayList<>();
        Iterator iterator = iterator();
        
        while(iterator.hasNext()){
            LinkedListNode nodo = (LinkedListNode) iterator.next();
            arrR.add((T) nodo.getObject());
        }
        return arrR.toArray(a);
    }

    @Override
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return (T) tail.getObject();
    }
    @Override
    public T[] getLast(int n) {
        Object[] elements = new Object[n];
            int i = 0;
            int j = 0;
            for (LinkedListNode<T> x = head; x != null; x = x.next) {
                if( j  >= size() - n ) {
                    elements[i++] = x.getObject();
                }	
                j++;
            }
        return (T[]) elements;
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
        boolean ack = false;
        try {
            LinkedListNode<T> eliminar = (LinkedListNode<T>) nodeOf(object);
            LinkedListNode<T> prev = (LinkedListNode<T>) nodeOf(getPrevious(eliminar));
            prev.next = eliminar.next;
            ack = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return ack;
        }
    }

    @Override
    
    	public boolean remove(Node node) {
    	    if (isEmpty() || node == null) {
    	        return false;
    	    }
    	    
    	    LinkedListNode<T> eliminar = (LinkedListNode<T>) node;
    	    if (eliminar == head) {
    	        head = eliminar.next;
    	       
    	        return true;
    	    }
    	    
    	    LinkedListNode<T> prev = (LinkedListNode<T>) nodeOf(getPrevious(eliminar));
    	    if (prev == null) {
    	        return false;
    	    }
    	    
    	    prev.next = eliminar.next;
    	   
    	    return true;
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
            LinkedList list = new LinkedList();
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
        LinkedList<T> list = new LinkedList<T>();
        list.head = (LinkedListNode<T>) from;
        list.tail = (LinkedListNode<T>) to;
        LinkedList<T> listR = (LinkedList<T>) list.clone();
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
        boolean ack=false;
        try{
            LinkedList list = new LinkedList();
            if (list.size() <= 1) {
                    return false;
                }
                boolean flag = true;
                while (flag) {
                    flag = false;
                    LinkedListNode<T> current = list.head;
                    while (current.next != null) {
                        if (current.getObject().toString().compareTo(current.next.getObject().toString()) > 0) {
                            T temp = current.getObject();
                            current.setObject((T) current.next.getObject());
                            current.next.setObject(temp);
                            flag = true;
                        }
                        current = current.next;
                    }
                }
            ack = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return ack;
        }
    }
    
    @Override
    public String toString() {
        String stringR="";
        Iterator iterator = iterator();
        while(iterator.hasNext()){
            LinkedListNode next = (LinkedListNode) iterator.next();
            stringR += next.toString() + " next=";
        }
        stringR += null;
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
