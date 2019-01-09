package com.javigs82.training.datastructure.strings;

/**
 * This class implements proper functions to check if a input string contains repeated chars.
 * At least it must implements a solution with and without auxiliary data structures
 *
 * @author javigs82@gmail.com
 */
public class UniqueChar {

    private static final String INPUT = "";


    //O(n)
    private static boolean isUniqueCharsWithDS(String input) {

        if (input.length() > 128)
            return false; //it is not possible to build String with unique chars (128 characters) greater than 128.

        boolean[] checker = new boolean[128]; //assuming 128 ASCII

        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (checker[val]) {
                return false;
            }
            checker[val] = true;

        }
        return true;
    }

    //O(n^2)
    private static boolean isUniqueCharsWithOutDS(String input) {

        if (input.length() > 128)
            return false; //it is not possible to build String with unique chars (128 characters) greater than 128.

        for (int i = 0; i < input.length(); i++) {

            for (int j = 0 ; j < input.length(); j++){

                if (i!=j && input.charAt(i) == input.charAt(j))
                    return false;

            } //end for

        } //end for
        return true;
    }



    public static void main(String[] args) {

        System.out.println("is unique char in string with data structure: " + isUniqueCharsWithDS(INPUT));
        System.out.println("is unique char in string with no data structure: " + isUniqueCharsWithOutDS(INPUT));

    }
}
