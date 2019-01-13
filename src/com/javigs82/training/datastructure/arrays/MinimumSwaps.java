package com.javigs82.training.datastructure.arrays;

import java.io.IOException;

/**
 * <p>Given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements.
 * You need to find the minimum number of swaps required to sort the array in ascending order.</p>
 * <ul>Constraints
 * <li>1<=N<=10^5</li>
 * <li>1<=arr[i]<=N</li>
 * </ul>
 */
public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] != i + 1) {
                int tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
                swaps++;
            }
        }
        return swaps;
    }


    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 4, 3};
        int res = minimumSwaps(arr);
        System.out.println("Minimum Number of Swaps is: " + res);
    }
}
