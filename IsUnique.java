package com.company;

public class IsUnique {
    public boolean Unique(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    return false;
                }
            }
        }return true;
    }

    public static void main(String[] args) {
        int[] c = {1,2,3,4,5,6,2};
        IsUnique d = new IsUnique();
        boolean result = d.Unique(c);
        System.out.println(result);
    }
}
