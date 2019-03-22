package me.javigs82.training.datastructure.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DateFormatter {

    private static final Map<String,String> MONTHS = new HashMap<String,String>() {{
        put("Jan", "01");
        put("Feb", "02");
        put("Mar", "03");
        put("Apr", "04");
        put("May", "05");
        put("Jun", "06");
        put("Jul", "07");
        put("Aug", "08");
        put("Sep", "09");
        put("Oct", "10");
        put("Nov", "11");
        put("Dic", "12");

    }};


    public static void reformatDate (String[] args) {

        //input date: 1st Mar 1984
        //output date: 1984-03-1
        Arrays.stream(args).map( date -> {
            String year = date.substring(date.length()-4, date.length());
            String month = date.substring(date.length()-8, date.length()-5);
            String day = date.substring(0, date.length()-9);
            return new StringBuffer().append(year).append("-").append(MONTHS.get(month)).append("-")
                    .append(day.substring(0, day.length()-2));
        }).forEach(formatted -> System.out.println(formatted));



    }

    public static void main(String[] args)  {

        String[] input = {"1st Mar 1984","30st Sep 2012"};
        reformatDate(input);
    }
}
