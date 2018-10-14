package java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Gaurav";
        }).thenApply(name -> {
            return "Hello " + name;
        }).thenApply(greeting -> {
            return greeting + ", Welcome to the CalliCoder Blog";
        });


        CompletableFuture<Void> whatsYourAgeFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Gaurav's";
        }).thenApply(name -> {
            return name + " age is: ";
        }).thenApply(greeting -> {
            return greeting + "32";
        }).thenAccept(result -> {
            System.out.println(result);
        });

        System.out.println(whatsYourNameFuture.get());
        System.out.println(whatsYourAgeFuture.get());
    }

}
