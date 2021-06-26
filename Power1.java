package com.company;
import java.util.Scanner;
public class Power1 {
    public static int pow(int n, int p){
        if(n<0 ||p<0){
            System.out.println("Please Enter Positive integers ");
            return -1;
        }
        else if (n==1 || p == 0){
            return 1;
        }
        else if (n==0){
            return 0;
        }
        return n*pow(n,p-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Base value :");
        int n = sc.nextInt();
        System.out.println("Enter the exponential value ");
        int p = sc.nextInt();
        int res = pow(n,p);
        System.out.println("The value of "+n+" raised to the power "+p+" is : "+res);
    }
}
