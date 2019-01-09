package concurrent.cigarrete;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorCigarrete {



    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable smoker1 = () -> {
            System.out.println("Smoker 1 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable smoker2 = () -> {
            System.out.println("Smoker 2 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable smoker3 = () -> {
            System.out.println("Somoker 3 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable agent = () -> {
            System.out.println("Agent inside : " + Thread.currentThread().getName());
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

        executorService.submit(smoker1);
        executorService.submit(smoker2);
        executorService.submit(smoker3);
        executorService.submit(agent);
        executorService.submit(callable);

        executorService.shutdown();
    }
}