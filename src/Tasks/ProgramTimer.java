package Tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProgramTimer {
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    private volatile long starter = System.currentTimeMillis();
    private int counter;

    public void print() {
            executorService.scheduleAtFixedRate(() -> {
                counter = (int) ((System.currentTimeMillis() - starter) / 1000);
                System.out.println("Програма працює " + counter + " секунд.");
                },
                    1, 1, TimeUnit.SECONDS);

            executorService.scheduleAtFixedRate(() -> System.out.println("Минуло 5 секунд."),
                    5, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ProgramTimer programTimer = new ProgramTimer();
        programTimer.executorService.submit(programTimer::print);
    }
}

