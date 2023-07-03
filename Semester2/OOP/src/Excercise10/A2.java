package Excercise10;

import java.util.Random;

public class A2 {
    public static final Object signal_monitor = new Object();
    public static final Object player_monitor = new Object();
    public static final PlayerChoice choice_a = new PlayerChoice();
    public static final PlayerChoice choice_b = new PlayerChoice();

    public static void main(String[] args) {
        Thread threadA = new Thread(new PlayerThread("Player A", choice_a));
        Thread threadB = new Thread(new PlayerThread("Player B", choice_b));
        Thread threadC = new Thread(new SignalThread());

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class PlayerChoice {
    static String[] names = {"Rock", "Paper", "Scissors"};

    int choice;
    public boolean chosen;

    public PlayerChoice() {
        this.choice = -1;
        chosen = false;
    }

    synchronized void chooseRandom() {
        Random random = new Random();
        choice = random.nextInt(3);
        chosen = true;
    }

    static String getWinner(PlayerChoice a, PlayerChoice b) {
        if (a.choice == b.choice) {
            return "Draw";
        }
        boolean a_wins = a.choice == 0 && b.choice == 2 ||
                a.choice == 1 && b.choice == 0 ||
                a.choice == 2 && b.choice == 1;
        if (a_wins) { return "A won!"; }
        return "B won!";
    }
}

class PlayerThread implements Runnable {
    private final String name;
    private final PlayerChoice choice;

    public PlayerThread(String name, PlayerChoice choice) {
        this.name = name;
        this.choice = choice;
    }

    public void run() {
        while (true)
        {
            synchronized (A2.signal_monitor) {
                try {
                    A2.signal_monitor.wait();
                    choice.chooseRandom();
                    System.out.println(this.name + " chose " + PlayerChoice.names[choice.choice]);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (A2.player_monitor) {
                A2.player_monitor.notifyAll();
            }
        }
    }
}

class SignalThread implements Runnable {
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (A2.signal_monitor) {
                A2.signal_monitor.notifyAll();
            }
            synchronized (A2.player_monitor) {
                while (true) {
                    try {
                        System.out.println("Wait for PSIG");
                        A2.player_monitor.wait();
                        if (A2.choice_a.chosen && A2.choice_b.chosen) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            A2.choice_a.chosen = false;
            A2.choice_b.chosen = false;
            System.out.println("Result: " + PlayerChoice.getWinner(A2.choice_a, A2.choice_b) + " \n");
        }
    }
}
