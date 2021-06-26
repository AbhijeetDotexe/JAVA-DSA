package com.company;

import java.util.Arrays;

public class TwoSum {
    public static int[] TwoS(int[] num, int target) {
        try {
            for (int i = 0; i < num.length; i++) {
                for (int j = i + 1; j < num.length; j++) {
                    if (num[i] + num[j] == target) {
                        return new int[]{i,j};
                    }
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println("No Solutions Found, OOPS!");
        }
        return num;
    }
    public static void main(String[] args) {
        int[] n ={2,7,9,11,13,16,24,44};
        int t=9;
        TwoSum s = new TwoSum();
        int[] res = s.TwoS(n,40);
        System.out.println(Arrays.toString(res));
    }
}
