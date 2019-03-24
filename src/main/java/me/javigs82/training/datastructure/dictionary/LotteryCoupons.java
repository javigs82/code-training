package me.javigs82.training.datastructure.dictionary;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryCoupons {

    static Map<Integer, Integer> freq = new HashMap<>();

    public static int lotteryCoupons(int n) {
        List<Integer> aux = IntStream.rangeClosed(1, n).boxed().map(number ->
                sumDigits(number)
        ).collect(Collectors.toList());

        int maxOccurrence = IntStream.rangeClosed(1, n).boxed().mapToInt(person -> {
            int occurrence = Collections.frequency(aux, person);
            freq.merge(occurrence, 1, Integer::sum);
            return occurrence;

        }).max().getAsInt();

        return freq.get(maxOccurrence);
    }

    private static int sumDigits(int m) {
        int sum = 0;
        int n = 0;
        while (m > 0) {
            n = m % 10;
            sum = sum + n;
            m = m / 10;
        }
        return sum;
    }

    public static final void main(String args[]) {
        System.out.println(lotteryCoupons(12));
    }

}
