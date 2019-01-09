package com.javigs82.training.datastructure.arrays;

import java.util.ArrayList;

public class arrays {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(3);

        list.add("javi");
        list.add("maria");
        list.add("arancha"); //resizing
        list.add("cris");

        list.parallelStream().forEach(s -> {
            System.out.println(s);
        });


    }


}
