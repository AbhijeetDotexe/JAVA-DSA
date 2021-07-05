package com.company;

public class SumDiagonal {
 public static int sum(int[][] a){
     int s = 0;
     for(int i=0;i<a.length;i++){
         for (int j=0;j<a.length;j++){
             if(i==j){
                 s+=a[i][j];
             }
         }
     }return s;
 }

    public static void main(String[] args) {
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}};
        int result = sum(b);
        System.out.println(result);
    }
}