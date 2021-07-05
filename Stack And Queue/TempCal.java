package com.company;
import java.util.*;
public class TempCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How Many Day's Temperature: ");
        int n = sc.nextInt();
        int sum = 0;
        int[] temps = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Day " + (i + 1) + " Temperature:");
            temps[i] = sc.nextInt();
            sum += temps[i];
        }
        double average = sum / n;
        int above = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > average) {
                above++;
            }
        }
        System.out.println("Average Temperature = " + average);
        System.out.println("Number of Days Above Average Temperature are :" + above);

    }
}