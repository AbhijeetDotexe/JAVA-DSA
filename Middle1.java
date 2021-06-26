package com.company;

import java.util.Arrays;

public class Middle1 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = new int[a.length-2];
        for (int i = 1; i < (a.length - 1); i++) {
            b[i-1]=a[i];
        }
        System.out.println(Arrays.toString(b));
    }
}
