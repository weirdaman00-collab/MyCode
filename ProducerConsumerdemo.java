import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final Queue<Integer> q = new LinkedList<>();
    private final int capacity;

    Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (q.size() == capacity) {
            wait();
        }
        q.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (q.isEmpty()) {
            wait();
        }
        int val = q.remove();
        System.out.println("Consumed: " + val);
        notifyAll();
        return val;
    }
}

class Producer implements Runnable {
    private final Buffer buffer;
    private final int id;

    Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                int item = id * 100 + i; // produce a distinct item
                buffer.put(item);
                Thread.sleep(100); // simulate time to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;
    private final int id;

    Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    public void run() {
        try {
            for (;;) {
                int item = buffer.get();
                // process item
                Thread.sleep(150); // simulate time to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(5);

        Thread p1 = new Thread(new Producer(buffer, 1));
        Thread p2 = new Thread(new Producer(buffer, 2));
        Thread c1 = new Thread(new Consumer(buffer, 1));
        Thread c2 = new Thread(new Consumer(buffer, 2));

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        // let the producers finish producing then stop consumers after a delay
        p1.join();
        p2.join();

        Thread.sleep(2000);
        c1.interrupt();
        c2.interrupt();
    }
}
