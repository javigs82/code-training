package me.javigs82.training.datastructure.queues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Maximum of all subarrays of size k:</p>
 * <p>Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.</p>
 *
 * <ol>This class implement two methods:
 * <li>Looping over array, sliding between windows with a second loop {@code getSlidingWindowsMaximunByLoop}</li>
 * <li>Queues</li>
 * </ol>
 */
public class SlidingWindowMaximum {

    /**
     * This method prints max windows values looping over input array
     * <ul>Big O Analysis:
     * <li>Runtime --> T(n) = O(n-k+1) * O (k) = O (nk) </li>
     * <li>Space --> S (n) = O(1) </li>
     * </ul>
     *
     * @param arr
     * @param k
     * @return void
     */
    static void printMaxByLoop(int[] arr, int k) {
        //loop over array until (length-k) index
        for (int i = 0; i <= arr.length - k; i++) {
            //init var for each sliding windows
            int maxWindow = 0;
            //loop over window to search maximum
            for (int j = 0; j < k; j++) {
                if (arr[i + j] > maxWindow)
                    maxWindow = arr[i + j];
            }
            System.out.print(maxWindow);
        }
    }

    /**
     * This method prints max windows values working with Queues
     * <ul>Big O Analysis:
     * <li>Runtime --> T(n) = O(n)</li>
     * <li>Space --> S (n) = O(k) </li>
     * </ul>
     *
     * @param arr
     * @param k
     * @return
     */
    static void printMaxByQueue(int arr[], int n, int k) {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()]);

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();


            // Add current element at the rear of Qi
            Qi.addLast(i);

        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }


    public static void main(String args[]) {

        int[] input = {1, 2, 3, 1, 4, 5, 9, 7, 6};
        int k = 3;

        printMaxByLoop(input, k);
        System.out.println("");
        printMaxByQueue(input, input.length, k);

    }
}
