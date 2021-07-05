package com.company;
public class MaxProd {
    public String MaxP(int[] a){
        int max = 0;
        String s = "";
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]*a[j]>max){
                    max = a[i]*a[j];
                    s = Integer.toString(a[i])+", "+Integer.toString(a[j]);
                }
            }
        }
        return s;
    }
    public static void main(String[] args) {
        MaxProd m = new MaxProd();
     int [] b = {10,20,30,40,50,210,60,70,80,90,120,};
     String res = m.MaxP(b);
        System.out.println("The Maximum Product Can be obtained by Multiplying These Two Numbers in the Array "+res);
    }
}
