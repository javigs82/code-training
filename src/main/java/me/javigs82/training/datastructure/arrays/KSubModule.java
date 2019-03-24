package me.javigs82.training.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

public class KSubModule {

    public static long kSub(int k, List<Integer> nums) {
        long numberKSec = 0;

        for (int i=0; i <nums.size(); i++)
        {
            // Pick ending point
            for (int j=i; j<nums.size(); j++)
            {
                int counter = 0;
                for (int x=i; x<=j; x++) {
                    //System.out.print(nums.get(x));
                    counter += nums.get(x);
                }
                if ((counter % k) == 0)
                    numberKSec ++;
               // System.out.println("*****");
            }
        }

        return numberKSec;
    }


    public static final void main (String args[]){
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        System.out.println(kSub(2, input));

    }

}
