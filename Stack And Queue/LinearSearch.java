package com.company;

public class LinearSearch {
    public void Linear(int[] a, int value){
        for(int i=0;i<a.length;i++){
            if(a[i] == value)
            {
                System.out.println("Element is Present in the Array at index location: "+i);
                return;
            }
        }
        System.out.println("Element is not present in the array, OOPS!");
    }

    public static void main(String[] args) {
        int[] Arr = {1,2,3,4,5,6,7,8,9,10};
        LinearSearch l = new LinearSearch();
        l.Linear(Arr,8);
    }
}
