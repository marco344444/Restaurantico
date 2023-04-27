package Auxiliar.PrioridadQueue;
import java.util.Arrays;
import java.util.Collections;

public class QueuePrioridad implements QueueInterface {
    
	 private Comparable[] elements; // Array de elementos
	    private int size; // Tamaño actual de la cola

	    public QueuePrioridad(int capacity) {
	        elements = new Comparable[capacity];
	        size = 0;
	    }

	    @Override
	    public void clear() {
	        elements = new Comparable[elements.length];
	        size = 0;
	    }

	    @Override
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    @Override
	    public Object extract() {
	        if (isEmpty()) {
	            return null;
	        }
	        Comparable maxElement = elements[0];
	        for (int i = 0; i < size - 1; i++) {
	            elements[i] = elements[i + 1];
	        }
	        elements[size - 1] = null;
	        size--;
	        return maxElement;
	    }

	    @Override
	    public boolean insert(Object object) {
	        if (size == elements.length) {
	            return false; // La cola está llena
	        }
	        Comparable newElement = (Comparable) object;
	        int index = size - 1;
	        while (index >= 0 && newElement.compareTo(elements[index]) > 0) {
	            elements[index + 1] = elements[index];
	            index--;
	        }
	        elements[index + 1] = newElement;
	        size++;
	        return true;
	    }

	    @Override
	    public int size() {
	        return size;
	    }

	    @Override
	    public boolean search(Object object) {
	        for (int i = 0; i < size; i++) {
	            if (elements[i].equals(object)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    public void sort() {
	        Arrays.sort(elements, 0, size);
	    }

	    @Override
	    public void reverse() {
	        for (int i = 0; i < size / 2; i++) {
	            Comparable temp = elements[i];
	            elements[i] = elements[size - 1 - i];
	            elements[size - 1 - i] = temp;
	        }
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("[");
	        for (int i = 0; i < size; i++) {
	            sb.append(elements[i]);
	            if (i != size - 1) {
	                sb.append(", ");
	            }
	        }
	        sb.append("]");
	        return sb.toString();
	    }
	}