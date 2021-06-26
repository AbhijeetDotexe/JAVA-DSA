package com.company;

public class Permutation {
    public boolean permutate(int[] a, int[] b){
        int sum1=0;
        int sum2=0;
        int mul1=1;
        int mul2=1;
        if(a.length!=b.length){
            return false;
        }
        for(int i=0;i<a.length;i++){
            sum1+=a[i];
            sum2+=b[i];
            mul1*=a[i];
            mul2*=b[i];
        }
        if(sum1==sum2 && mul1==mul2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {9,8,7,6,5,4,3,2,1};
        boolean c = p.permutate(a,b);
        System.out.println(c);
    }
}
