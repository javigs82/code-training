package me.javigs82.training.regex;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoggerUtil {


    private static final String REGEX = "^(.+)(\\s\\-\\s\\-\\s)(.+)$";

    private void printLines(String fileName) throws IOException, URISyntaxException {

        Path path = Paths.get(getClass().getClassLoader()
                .getResource(fileName).toURI());

        Stream<String> lines = Files.lines(path);
        Pattern p = Pattern.compile(REGEX);
        //filter, map and collect
        List<String> hostList = lines.map(p::matcher)
                .filter(matcher -> matcher.find())
                .map(matcher -> matcher.group(1))
                .collect(Collectors.toList());

        //close file stream
        lines.close();

        //groupBy, Sum and print
        hostList.stream()
                .collect(Collectors.groupingBy(s -> s,Collectors.summingInt(x -> Integer.parseInt("1"))))
                .forEach((k,v) -> System.out.println(k + " " + v));
    }

    public static void main (String[] args) throws IOException, URISyntaxException {
        LoggerUtil loggerUtil = new LoggerUtil();
        loggerUtil.printLines("log.txt");
    }
}


