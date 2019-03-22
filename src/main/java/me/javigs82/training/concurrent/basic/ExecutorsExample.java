package me.javigs82.training.concurrent.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task2 = () -> {
            System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task3 = () -> {
            System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Callable<String> callable = () -> {

            Thread.sleep(5);
            System.out.println(Thread.currentThread().getName());
            return "Return some result";

        };


        System.out.println("Submitting the tasks for execution...");

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(callable);

        executorService.shutdown();
    }
}