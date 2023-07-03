package Excercise10;

public class A1_b {
    public static void main(String[] args) {
        Counter2 counter2 = new Counter2();
        IncrThread2 thread_a = new IncrThread2(counter2);
        IncrThread2 thread_b = new IncrThread2(counter2);
        thread_a.start();
        thread_b.start();

        try {
            thread_a.join();
            thread_b.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter2.getI());
    }
}

class Counter2 {
    private int i;

    public Counter2() {
        this.i = 0;
    }

    public synchronized void increment() {
        i++;
    }

    public int getI() {
        return i;
    }
}

class IncrThread2 extends Thread {
    public IncrThread2(Counter2 ct) {
        super(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                ct.increment();
            }
        });
    }
}

