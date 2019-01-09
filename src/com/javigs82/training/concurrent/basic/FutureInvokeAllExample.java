package com.javigs82.training.concurrent.basic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureInvokeAllExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = () -> {
            System.out.println("ThreadName: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            System.out.println("ThreadName: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            System.out.println("ThreadName: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            return "Result of Task3";
        };

        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);

        List<Future<String>> futures = executorService.invokeAll(taskList);

        for(Future<String> future: futures) {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}