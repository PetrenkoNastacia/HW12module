package Task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzMain {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(fizzBuzz::fizz);
        service.submit(fizzBuzz::buzz);
        service.submit(fizzBuzz::fizzbuzz);
        service.submit(fizzBuzz::number);
        service.submit(fizzBuzz::print);
        service.shutdown();
    }
}



