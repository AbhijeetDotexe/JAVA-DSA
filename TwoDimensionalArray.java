package com.company;

import java.util.Arrays;

class TwoDimensional{
    int[][] arr = null;

    public TwoDimensional(int NumberOfRow, int NumberOfCol){
        this.arr = new int[NumberOfRow][NumberOfCol];
        for(int row = 0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                arr[row][col]=Integer.MIN_VALUE;
            }
        }
    }


    //Insertion in a 2D Array
    public void Insertion(int row, int col, int value){
        try {
            if(arr[row][col]==Integer.MIN_VALUE){
                arr[row][col]=value;
                System.out.println("Value Inserted Successfully");
            }else {
                System.out.println("Cell is already Occupied, Better luck next time ");
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index value for a 2d Array, OOPS!");
        }
    }
    public void Access(int row, int col){
        System.out.println("\n Accessing Row#"+row+", Col#"+col);
        try {
            System.out.println("Cell Value is "+ arr[row][col]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Cannot Access The specified element");
        }
    }
    public void Traverse(){
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
    public void Search(int value){
        for (int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                if(arr[row][col]==value){
                    System.out.println("Element Found at Row: "+row+" and Column: "+ col);
                    return;
                }
            }
        }
        System.out.println("Element is not present in the array ");
    }

    public void Delete(int row, int col){
        try {
            System.out.println("Element at Row:"+row+" and Col:"+col+" is deleted Successfully");
            arr[row][col]=Integer.MIN_VALUE;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index Value is not accessible, OOPS!");
        }
    }
}

public class TwoDimensionalArray {
    public static void main(String[] args) {
//        int[][] TwoDimensional = new int[2][2];
//        TwoDimensional[0][0]=1;
//        TwoDimensional[0][1]=2;
//        TwoDimensional[1][0]=3;
//        TwoDimensional[1][1]=4;
//        System.out.println(Arrays.deepToString(TwoDimensional));
//
//        String[][] s2DArray = {{"a","b"},{"c","d"}};
//        System.out.println(Arrays.deepToString(s2DArray)); // It has a time complexity of O(1) compared to O(MN)
          TwoDimensional lakshay = new TwoDimensional(2,2);
          lakshay.Insertion(0,0,4);
          lakshay.Insertion(0,1,20);
          lakshay.Insertion(1,0,24);
        System.out.println(Arrays.deepToString(lakshay.arr));
        lakshay.Access(0,0);
        lakshay.Traverse();
        lakshay.Search(4);
        lakshay.Search(14);
        lakshay.Delete(1,0);
        lakshay.Traverse();
    }
}
