package me.javigs82.training;

import java.util.stream.IntStream;

public class Tester {


    public static final void main(String[] args) {

        IntStream.rangeClosed(1, 15)
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(i));

        for (int i = 1; i <= 15; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }


    }
}
