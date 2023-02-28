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

    public synchronized void print() {
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

