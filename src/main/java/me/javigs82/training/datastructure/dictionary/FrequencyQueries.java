package me.javigs82.training.datastructure.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    static Map<Integer, Integer> lookup = new HashMap<>();
    static Map<Integer, Integer> freq = new HashMap<>();

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(BufferedReader bufferedReader, int q) {
        return bufferedReader.lines().map(line -> {
            String[] query = line.split(" ");
            return getFromQuery(Integer.parseInt(query[0]), Integer.parseInt(query[1]));
        }).filter(output -> output.isPresent())
                .map(output -> output.get())
                .collect(toList());
    }


    //return empty for command 1 and 2
    private static Optional<Integer> getFromQuery(Integer command, Integer value) {
        switch (command) {
            case 1:
                int oldFreq = (freq.get(value) != null) ? freq.get(value) : 0;
                lookup.computeIfPresent(oldFreq, (k, v) -> (v - 1));

                int newFreq = freq.merge(value, 1, Integer::sum);
                lookup.merge(newFreq, 1, Integer::sum);

                return Optional.empty();

            case 2: //remove number
                int currentFreq = (freq.get(value) != null) ? freq.get(value) : 0;
                lookup.computeIfPresent(currentFreq, (k, v) -> (v - 1));
                freq.computeIfPresent(value, (k, v) -> (v > 0) ? (v - 1) : 0);

                currentFreq = (freq.get(value) != null) ? freq.get(value) : 0;
                lookup.computeIfPresent(currentFreq, (k, v) -> v + 1);
                return Optional.empty();
            //return 1 if frequency of a number equals value
            case 3:
                return (lookup.get(value) != null && lookup.get(value) > 0)
                        ? Optional.of(1)
                        : Optional.of(0);

            default:
                return Optional.empty();
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ans = freqQuery(bufferedReader, q);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }

}

