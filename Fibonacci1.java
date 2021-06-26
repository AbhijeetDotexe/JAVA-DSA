package com.company;

import java.util.Scanner;

public class Fibonacci1 {
    public static int fibo(int n){
        if(n<0){
            System.out.println("Fibonacci Series is not possible for numbers less than 0");
        }
        else if (n==0 || n==1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N");
        int n = sc.nextInt();
        int res = fibo(n);
        System.out.println(res);
    }
}
