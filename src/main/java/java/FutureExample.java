package java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SquareCalculator {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> squareFuture = squareCalculator.calculate(25);
        while(!squareFuture.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = squareFuture.get();
        System.out.println("fetched result -> " + result);
    }
}
