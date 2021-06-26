package com.company;

import java.util.Scanner;

public class SumOfDigits {
    public static int sod(int n){
        if(n<0 || n==0){
            return 0;
        }
        return n%10+ sod(n/10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number Whose sum of digit You want to find ");
        int n = sc.nextInt();
        int res = sod(n);
        System.out.println("The sum of digits of the given number is : "+res);
    }
}
