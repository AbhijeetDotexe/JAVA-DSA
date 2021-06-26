package com.company;
public class MissingNum {
    public void Missing(int[] a){
        int sum1 = 0;
        int sum2 = 0;
        for (int element:a){
          sum1+=element;
        }
        sum2 = (20*21)/2;
        int d = sum2 - sum1;
        System.out.println("The Missing Number in the Array is : "+d);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19,20};
        MissingNum m = new MissingNum();
        m.Missing(array);
    }
}
