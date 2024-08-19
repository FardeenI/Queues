interface Queue<E> extends Iterable<E> {
    E dequeue();
    void enqueue(E data);
}
