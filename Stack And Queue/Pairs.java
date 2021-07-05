package com.company;

public class Pairs {
    public static String pairSum(int[] myArray, int sum) {
        String s = "";
       try {
           for (int i = 0; i < myArray.length; i++) {
               for (int j = i+1; j < myArray.length; j++) {
                   if (myArray[i] + myArray[j] == sum) {
                      //System.out.print(myArray[i]+":"+myArray[j]+" ");
                        s +=Integer.toString(myArray[i])+":"+Integer.toString(myArray[j])+" ";
                   }
               }
           }
       }catch (Exception e){
           System.out.println("No Solutions Found!");
       }
        return s;
    }

    public static void main(String[] args) {
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println( pairSum(b, 10));
        //System.out.println(a);
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] + b[j] == 10) {
                    System.out.print( b[i] + ":" + b[j] + " ");
                }
            }
        }
    }
}
