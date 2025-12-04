import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random r = new Random();
        while (true) {
            int num = r.nextInt(100); 
            System.out.println("Generated: " + num);

            if (num % 2 == 0) {
                new SquareThread(num).start();
            } else {
                new CubeThread(num).start();
            }

            try {
                Thread.sleep(1000); 
            } catch (Exception e) {
            }
        }
    }
}

class SquareThread extends Thread {
    int n;
    SquareThread(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("Square: " + (n * n));
    }
}

class CubeThread extends Thread {
    int n;
    CubeThread(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("Cube: " + (n * n * n));
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        NumberGenerator ng = new NumberGenerator();
        ng.start();
    }
}
