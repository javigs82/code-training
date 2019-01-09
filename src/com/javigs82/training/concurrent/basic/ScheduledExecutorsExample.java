package com.javigs82.training.concurrent.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Executing Task At " + System.nanoTime());

        Callable<String> callable = () -> {
            // Perform some computation
            Thread.sleep(2000);
            return "Return some result";

        };

        System.out.println("Submitting task at " + System.nanoTime() + " to be executed after 5 seconds.");
        scheduledExecutorService.scheduleAtFixedRate(task, 10, 5, TimeUnit.SECONDS);


        while (!scheduledExecutorService.isTerminated()) ;

        scheduledExecutorService.shutdown();
    }
}
