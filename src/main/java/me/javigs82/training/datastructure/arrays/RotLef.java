package me.javigs82.training.datastructure.arrays;

import java.io.IOException;

public class RotLef {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int position = i - d;
            if (position < 0) {
                position = a.length + position;
            }
            result[position] = a[i];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        int[] a = {1, 2, 3, 4, 5, 6};

        int[] result = rotLeft(a, 4);

        for (int x : result) {
            System.out.print(x);
        }
    }
}
