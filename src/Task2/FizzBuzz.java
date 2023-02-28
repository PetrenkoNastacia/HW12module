package Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz extends Thread{
    private final int n = 50;
    private static volatile AtomicInteger number = new AtomicInteger(1);
    private boolean isAlive = true;

    public BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public synchronized void add(String element) {
        queue.add(element);
    }

    public synchronized void fizz() {
        FizzBuzz A = new FizzBuzz();
        A.start();
        while (isAlive && number.get() < n) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                add("fizz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        FizzBuzz B = new FizzBuzz();
        B.start();
        while (isAlive && number.get() < n) {
            if (number.get() % 3 != 0 && number.get() % 5 == 0) {
                add("buzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        FizzBuzz C = new FizzBuzz();
        C.start();
        while (isAlive && number.get() < n) {
            if (number.get() % 3 == 0 && number.get() % 5 == 0) {
                add("fizzbuzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public synchronized void number() {
        FizzBuzz D = new FizzBuzz();
        D.start();
        while (isAlive && number.get() < n) {
            if (number.get() % 3 != 0 && number.get() % 5 != 0) {
                add(String.valueOf(number));
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void print() {
        FizzBuzz printThread = new FizzBuzz();
        printThread.start();
        while (isAlive) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (!queue.isEmpty()) {
                setAlive(false);
                System.out.println(queue.poll());
            }
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}

