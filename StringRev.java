package com.company;

import java.util.Scanner;

public class StringRev {
    public static String reverse(String Str){
        if(Str.isEmpty()){
            return Str;
        }
        return reverse(Str.substring(1))+ Str.charAt(0) ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = sc.next();
        String b = reverse(s);
        System.out.println("The reverse of the given String is : "+b);
    }
}
