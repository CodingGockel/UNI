package Excercise10;

public class A1_a {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread_a = new Thread(new IncrRunnable(counter));
        Thread thread_b = new Thread(new IncrRunnable(counter));
        thread_a.start();
        thread_b.start();

        try {
            thread_a.join();
            thread_b.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getI());
    }
}

class Counter {
    private int i;

    public Counter() {
        this.i = 0;
    }

    public synchronized void increment() {
        i++;
    }

    public int getI() {
        return i;
    }
}

class IncrRunnable implements Runnable {
    Counter ct;

    public IncrRunnable(Counter ct) {
        this.ct = ct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            ct.increment();
        }
    }
}

