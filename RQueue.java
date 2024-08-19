import java.util.Iterator;

class RQueue<E> implements Queue<E> {
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext()
            {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            private Node<E> curr = head;
        };
    }

    private class Node<T> { // Node class objects to implement linked-list based queue data structure
        private T data;
        private Node(T data)
        {
            this.data = data;
        }
        private Node<T> next;
    }

    private Node<E> head; // Head node for management of one end of the queue
    private Node<E> tail; // Tail node for management of the other end of the queue

    public void enqueue(E data) { // Method to insert an element into the end of the queue
        Node<E> temp = new Node<E>(data);
        if (head == null) { // End management: Checking if the linked-list/If the data structure is empty
            head = tail = temp; // Establish the linked-list
        }
        else {
            tail.next = temp; // Otherwise establish a reference pointing from the tail node to the desired node to be inserted
            tail = tail.next; // Establish the newly linked node as the end of the queue
        }
    }

    public E dequeue() { // Method to return an element from the front of the queue
        E temp = null; // Establish a variable to store the desired data
        if (head != null) { // End management: Checking if the linked-list/If the data structure is empty
            temp = head.data; // Store data at the front of the queue in the temp variable
            if (head == tail) { // If there is a singular node in the list
                head = tail = null; // Establish that the head and tail now refer to each other as a singular node which point to nothing, effectively emptying the queue
            }
            else {
                head = head.next; // Otherwise, if there is more than a single node in the list, progress the reference to the head of the list to its subsequent node
            }
        }
        return temp; // Return the data at the head
    }
}