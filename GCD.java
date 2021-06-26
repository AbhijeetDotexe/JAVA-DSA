package com.company;

import java.util.Scanner;

public class GCD {
    public static int gcd(int a, int b){
        if(a<0 ||b<0){
            return -1;
        }
        else if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number 1 ");
        int a = sc.nextInt();
        System.out.println("Enter Number 2 ");
        int b = sc.nextInt();
        int res = gcd(a,b);
        System.out.println("The GCD of "+a+" and "+b+" is : "+res);
    }
}
