package com.company;

public class TwoBest {
    static String firstSecond(int[] myArray) {
        int m1 = 0;
        int m2 = 0;
        String s = "";
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > m1) {
                m1 = myArray[i];
            }
            for (int j = 0; j < myArray.length; j++) {
                if (  myArray[j]>m2 && m1>myArray[j]) {
                    m2 = myArray[j];
                }
            }
        }
        s = Integer.toString(m1) + " " + Integer.toString(m2);
        return s;
    }
    public static void main(String[] args) {
        int[] b={10,20,120,30,40,340,50,60,70,80,90};
        String result = firstSecond(b);
        System.out.println(result);
    }
}
