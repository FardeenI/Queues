public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = Math.random() < 0.5 ? new AQueue<Integer>() : new RQueue<Integer>();
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;

        long start, stop;
        System.out.println(queue);
        System.out.println("enqueue");
        start = System.nanoTime();
        for (int i = 0; i < num; ++i) {
            queue.enqueue(i);
            System.out.print(i + " => ");
            for (Integer k : queue) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        stop = System.nanoTime();
        System.out.println(stop-start);

        Integer j;
        System.out.println("dequeue");
        start = System.nanoTime();
        while ((j = queue.dequeue()) != null) {
            System.out.print(j + " => ");
            for (Integer k : queue) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        stop = System.nanoTime();
        System.out.println(stop-start);
    }
}
