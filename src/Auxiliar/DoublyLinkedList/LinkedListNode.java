
package Auxiliar.DoublyLinkedList;


public class LinkedListNode<T> implements Node<T> {

    private T object;
    
    public LinkedListNode next;
    public LinkedListNode prev;

    public LinkedListNode() {
        this.object = null;
        this.prev = null;
        this.next = null;
    }

    public LinkedListNode(T object) {
        this.object = object;
    }
    
    @Override
    public boolean setObject(T object) {
        this.object = object;
        return true;
    }

    @Override
    public T getObject() {
        return this.object;
    }

    @Override
    public boolean isEquals(T object) {
        return this.object.toString().equals(object.toString());
    }

    @Override
    public String toString() {
        return "[ "+object.toString()+" ]";
    }

    
    
}
