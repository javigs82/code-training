package com.javigs82.training.algorithm;

public class InsertionSort {

   private static final int[] unsortedArray = {6,5,3,1,8,7,2,4};

  //  private static final int[] unsortedArray = {6,5};


    private static final int[] sort (int[] unsortedArray) {

        if (unsortedArray == null )
            return null;

        for (int i = 1; i < unsortedArray.length ; i ++) {

            int tmp = unsortedArray[i];
            int j = i - 1;

            while (j >= 0 && tmp < unsortedArray[j]){

                unsortedArray[j+1] = unsortedArray[j];
                j --;
            }

            unsortedArray[j+1] = tmp;

        }
        return unsortedArray;

    }

    public static void main (String args[]) {

        int [] orderArray = InsertionSort.sort(unsortedArray);

        for (int i = 0; i < orderArray.length; i ++){
            System.out.println(orderArray[i]);
        }

    }
}
