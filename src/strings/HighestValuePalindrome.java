package strings;

/**
 * Palindromes are strings that read the same from the left or right, for example madam or 0110.
 * <p>
 * You will be given a string representation of a number and a maximum number of changes you can make.
 * Alter the string, one digit at a time, to create the string representation of the largest number possible given the
 * limit to the number of changes. The length of the string may not be altered,
 * so you must consider 's left of all higher digits in your tests. For example `0110` is valid, `0011` is not.
 * <p/>
 */
public class HighestValuePalindrome {

    /**
     * Get highest value palindrome of a String given with a limited number of changes
     *
     * @param s  : String
     * @param n: String.length
     * @param k: number of allowed changes
     * @return highestValuePalindrome
     */
    static String highestValuePalindrome(String s, int n, int k) {

        StringBuilder strBuilder = new StringBuilder(s);

        if (s.length() == 1)
            return "9";


        for (int i = 0; i < (strBuilder.length() / 2); i++) {
            if (strBuilder.charAt(i) != strBuilder.charAt(strBuilder.length() - i - 1)) {

                if (k <= 0)
                    return "-1";

                if (strBuilder.charAt(i) != '9') {
                    k--;
                    strBuilder.replace(i, i + 1, "9");
                }

                if (strBuilder.charAt(strBuilder.length() - i - 1) != '9' && k > 0) {
                    k--;
                    strBuilder.replace(strBuilder.length() - i - 1, strBuilder.length() - i, "9");
                }


            }

        }

        if ((strBuilder.length() % 2) != 0 && k > 0)
            strBuilder.replace((strBuilder.length() / 2), ((strBuilder.length() / 2) + 1), "9");


        return strBuilder.toString();
    }


    public static void main(String[] args) {


        String s = "00110";

        int n = 6;

        int k = 3;

        String result = highestValuePalindrome(s, n, k);

        System.out.print(result);

    }
}
