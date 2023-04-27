package Auxiliar.StackArray;

public class StackArray implements StackInterface {

    private Object[] array;
    private int size;
    private int top;

    public StackArray(int capacity) {
        array = new Object[capacity];
        size = 0;
        top = -1;
    }

    @Override
    public void clear() {
        size = 0;
        top = -1;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top];
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object object = array[top];
        array[top] = null;
        size--;
        top--;
        return object;
    }

    @Override
    public boolean push(Object object) {
        if (size == array.length) {
            return false;
        }
        top++;
        array[top] = object;
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
            if (array[i].equals(object)) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    @Override
    public void reverse() {
        Object[] reversedArray = new Object[array.length];
        int j = top;
        for (int i = 0; i < size; i++) {
            reversedArray[i] = array[j];
            j--;
        }
        array = reversedArray;
        top = size - 1;
    }

    @Override
    public void sort() {
        Object[] sortedArray = new Object[array.length];
        int j = 0;
        while (!isEmpty()) {
            Object smallest = pop();
            while (j > 0 && ((Comparable)sortedArray[j-1]).compareTo(smallest) > 0) {
                push(sortedArray[j-1]);
                j--;
            }
            sortedArray[j] = smallest;
            j++;
        }
        array = sortedArray;
        top = size - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack{size=").append(size).append(", array=[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

}
