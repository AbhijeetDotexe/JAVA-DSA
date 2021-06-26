package com.company;

import java.util.Scanner;

public class Factorial1 {
    public static float fi(float n) {
        if (n < 0) {
            System.out.println("Enter a number Greater than 0");
            return -1;
        } else if (n == 0 || n == 1) {
            return 1;
        }
        return n * fi(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to find the factorial of : ");
        float n = sc.nextFloat();
        float res = fi(n);
        System.out.println(res);

    }
}