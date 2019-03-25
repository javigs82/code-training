package me.javigs82.training.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByValue;

public class CustomSort {

    static Map<Integer, Integer> freq = new TreeMap<>();


    public static void customSort(List<Integer> arr) {

        arr.stream().forEach(value -> freq.merge(value, 1, Integer::sum));

        freq.entrySet()
                .stream()
                .sorted(comparingByValue())
                .forEach( e ->  IntStream.range(0, e.getValue())
                        .forEach( i -> System.out.println(e.getKey())));
    }

    public static final void main(String[] arg) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(2);
        input.add(2);
        input.add(3);
        input.add(3);
        input.add(3);
        customSort(input);
    }


}
