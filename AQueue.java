import java.util.Iterator;

class AQueue<E> implements Queue<E> {
    private class QueueIterator<E> implements Iterator<E> {
        public boolean hasNext() {
            return curr < tail;
        }
        public E next() {
            return (E)queue[curr++];
        }
        private int curr = head;
    }


    public Iterator<E> iterator() {
        return new QueueIterator<E>();
    }


    private Object[] queue = new Object[10]; // Array object to hold queue data structure
    private int head; // Integer to manage one end of the queue
    private int tail; // Integer to manage the other end of the queue


    public void enqueue(E data) { // Method to insert an element into the end of the queue
        if (head == (tail + 1) % queue.length) {
            grow(); // Managing end by calling grow() to expand data structure, preventing queue overflow
        }
        queue[tail] = data;
        tail = (tail + 1) % queue.length;
    }


    public E dequeue() { // Method to return an element from the front of the queue
        if (queue.length > 10 && (queue.length + tail - head) % queue.length <= queue.length / 3)
        {
            shrink(); // Managing end by calling shrink() to minimize data structure, de-allocating unused memory
        }
        E temp = null;
        if (head != tail) {
            temp = (E)queue[head];
            head = (head + 1) % queue.length;
        }
        return temp;
    }


    private void grow() { // Method to expand data structure
        Object[] temp = new Object[queue.length * 2];
        for (int i = 0; i < queue.length; ++i) {
            temp[i] = queue[(head + i) % queue.length];
        }
        head = 0;
        tail = queue.length - 1;
        queue = temp;
    }


    private void shrink() { // Method to minimize data structure
        Object[] temp = new Object[queue.length / 2];
        for (int i = 0; i < temp.length; ++i) {
            temp[i] = queue[(head + i) % queue.length];
        }
        head = 0;
        tail = queue.length / 3;
        queue = temp;
    }
}
