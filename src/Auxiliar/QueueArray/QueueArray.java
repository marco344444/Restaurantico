package Auxiliar.QueueArray;

public class QueueArray implements QueueInterface {
    private Object[] array;
    private int front;
    private int rear;
    private int size;

    public QueueArray() {
        this.array = new Object[10];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.array = new Object[10];
    }

	@Override
    public boolean isEmpty() {
        return size == 0;
    }

	@Override
    public Object extract() {
        if (isEmpty()) {
            return null;
        } else {
            Object item = array[front];
            front = (front + 1) % array.length;
            size--;
            return item;
        }
    }

	@Override
    public boolean insert(Object object) {
        if (size == array.length) {
            // si el array está lleno, se debe hacer una copia con el doble de capacidad
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(front + i) % array.length];
            }
            array = newArray;
            front = 0;
            rear = size - 1;
        }
        rear = (rear + 1) % array.length;
        array[rear] = object;
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
            int index = (front + i) % array.length;
            if (array[index].equals(object)) {
                return true;
            }
        }
        return false;
    }

	@Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (((Comparable) array[j]).compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Object temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

	@Override
    public void reverse() {

        int i = front;
        int j = rear;
        while (i < j) {
            Object temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i = (i + 1) % array.length;
            j = (j - 1 + array.length) % array.length;
        }
    }
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Queue{size=").append(size).append(", array=[");
	        for (int i = 0; i < size; i++) {
	            int index = (front + i) % array.length;
	            sb.append(array[index]);
	            if (i < size - 1) {
	                sb.append(", ");
	            }
	        }
	        sb.append("]}");
	        return sb.toString();
	    }

}
