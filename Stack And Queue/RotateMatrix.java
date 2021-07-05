package com.company;

import java.util.Arrays;

public class RotateMatrix {
    public boolean Rotate(int[][] m){
        if(m.length == 0 ||m.length!=m[0].length){
            return false;
        }
        int n = m.length;
        for(int layer = 0;layer<n/2;layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i =first;i<last;i++){
                int offset = i - first;
                int top =m[first][i];
                m[first][i]=m[last-offset][first];
                m[last-offset][first]=m[last][last-offset];
                m[last][last-offset]=m[i][last];
                m[i][last]=top;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        boolean result = r.Rotate(a);
        System.out.println(result);
        System.out.println(Arrays.deepToString(a));
    }
}
