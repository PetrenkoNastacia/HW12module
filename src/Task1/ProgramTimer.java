package Task1;

//Напишіть програму, яка кожну секунду відображає на екрані дані про час,
// що минув від моменту запуску програми.
//Другий потік цієї ж програми кожні 5 секунд виводить повідомлення
// Минуло 5 секунд.
public class ProgramTimer {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 30; i++) {
            System.out.println("Програма працює " + i + " секунд.");
            if (i % 5 == 0) {
                new Thread(() -> System.out.println("Минуло 5 секунд.")).start();
            }
            Thread.sleep(1000);
        }
    }
}

