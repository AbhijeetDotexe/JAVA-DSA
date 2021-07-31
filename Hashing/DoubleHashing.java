package com.company;

import java.util.ArrayList;

class DoubleHash{
    String[] hashtable;
    int usedCellNumber;

    DoubleHash(int size){
        hashtable = new String[size];
        usedCellNumber = 0;
    }

    public int modASCIIFunction(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i,sum;
        for (sum=0,i=0;i<word.length();i++){
            sum = sum+ch[i];
        }
        return sum % M;
    }

    //Get Load Factor
    public double getLoadFactor(){
        double lf = usedCellNumber * 1.0/hashtable.length;
        return lf;
    }

    //Rehash
    public void rehashKeys(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s: hashtable){
            if (s!= null){
                data.add(s);
            }
            data.add(word);
            hashtable = new String[hashtable.length*2];
            for (String e:data){
                //InsertIn Hash Table
                insertKeyInHashTable(e);
            }
        }
    }

    //Display
    public void display(){
        if (hashtable == null){
            System.out.println("\n Hash Table does not exists");
            return;
        }else {
            System.out.println("\n-------------------Hash Table------------------------");
            for (int i=0;i<hashtable.length;i++){
                System.out.println("Index: "+i+", Key: "+hashtable[i]);

            }
        }
    }

    //Search
    public boolean search(String word){
        int index = modASCIIFunction(word, hashtable.length);
        for (int i = index;i<index+hashtable.length;i++){
            int newIndex = i % hashtable.length;
            if (hashtable[newIndex]!=null && hashtable[newIndex].equals(word)){
                System.out.println(word+" is present in the Hash Table at location: "+ newIndex);
                return true;
            }
        }
        System.out.println(word+" is not present in the hash table");
        return false;
    }

    //Delete Function
    public void deleteFun(String word){
        int index = modASCIIFunction(word, hashtable.length);
        for (int i= index;i<index+hashtable.length;i++) {
            int newIndex = i % hashtable.length;
            if (hashtable[newIndex] != null && hashtable[newIndex].equals(word)) {
                hashtable[newIndex] = null;
                System.out.println(word+" has been Successfully deleted");
                return;
            }
        }
        System.out.println(word+" is not present in the hash table");
    }

    private int addAllDigitsTogether(int sum){
        int val = 0;
        while (sum>0){
            val = sum %10;
            sum = sum / 10;
        }
        return val;
    }

    public int secondHashFunction(String x, int M){
        char ch[];
        ch = x.toCharArray();
        int i,sum;
        for (sum=0,i=0;i<x.length();i++){
            sum+=ch[i];
        }
        while (sum>hashtable.length){
            sum = addAllDigitsTogether(sum);
        }
        return sum % M;
    }

    public void insertKeyInHashTable(String value){
        double loadFactor = getLoadFactor();
        if (loadFactor>0.75){
            rehashKeys(value);
        }else {
            int x = modASCIIFunction(value, hashtable.length);
            int y = secondHashFunction(value,hashtable.length);
            for (int i=0;i<hashtable.length;i++){
                int newIndex = (x+ i*y)%hashtable.length;
                if (hashtable[newIndex] == null){
                    hashtable[newIndex] = value;
                    System.out.println(value+" inserted at index :"+newIndex);
                    break;
                }else {
                    System.out.println(newIndex+" is already occupied Trying new Index.....");
                }
            }
        }
        usedCellNumber++;
    }
}

public class DoubleHashing {
    public static void main(String[] args) {
        DoubleHash d = new DoubleHash(13);
        d.insertKeyInHashTable("The");
        d.insertKeyInHashTable("quick");
        d.insertKeyInHashTable("brown");
        d.insertKeyInHashTable("fox");
        d.insertKeyInHashTable("over");
        d.insertKeyInHashTable("lazy");
        d.display();    
    }
}
