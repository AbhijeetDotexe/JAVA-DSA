package com.company;

import java.util.Scanner;

public class Binary1 {
    public static int bin(int n){
        if(n==0){
            return 0;
        }
        else if(n<0){
            return -1;
        }
        return n%2+bin(n/2)*10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to find the binary value of :");
        int a = sc.nextInt();
        int res = bin(a);
        System.out.println("The Binary value of "+a+" is :"+res);
        System.out.println(13%3);
    }
}
