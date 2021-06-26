package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class array1 {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        System.out.println(Arrays.toString(arr));
//        for(int element:arr){
//            System.out.println(element);
//        }
        String[] sArr = {"a","b","c"};
        System.out.println(Arrays.toString(sArr));
    }
}
