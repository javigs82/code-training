package me.javigs82.training.datastructure.strings;

public class ReduceString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {

        String result = s;
        CharSequence reducedSecuence;

        int pt = 0; //pointer
        while (pt < result.length() - 1) { // no compare if only 1 element

            if (result.charAt(pt) == result.charAt(pt + 1)) {
                reducedSecuence = result.subSequence(pt, pt + 2);
                result = result.replace(reducedSecuence, "");
                pt = 0;
            } else {
                pt++;
            }
        }

        return (result.isEmpty()) ? "Empty String" : result;

    }

    public static void main(String[] args) {


        String s = "aaabccddd";

        String result = superReducedString(s);

        System.out.print(result);

    }
}
