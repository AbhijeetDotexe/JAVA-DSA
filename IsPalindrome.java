package com.company;

import java.util.Scanner;

public class IsPalindrome {
    public static boolean palindrome(String s){
        if(s.length()==0||s.length()==1){
            return true;
        }
        else if (s.charAt(0)==s.charAt(s.length()-1)){
            return palindrome(s.substring(1,s.length()-1));
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The String ");
        String s = sc.next();
        boolean a = palindrome(s);
        System.out.println(a);
    }
}
