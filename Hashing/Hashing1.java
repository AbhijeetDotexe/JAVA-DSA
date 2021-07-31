package com.company;

import java.util.LinkedList;

class DirectChaining{
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size){
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunction(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i,sum;
        for (sum = 0,i=0;i<word.length();i++){
            sum = sum = ch[i];
        }
        return sum % M;
    }

    //Insert Method
    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[newIndex] == null){
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        }else {
            hashTable[newIndex].add(word);
        }
    }

    //Display Hash Table
    public void displayHashTable(){
        if (hashTable == null){
            System.out.println("\nHash Table does not exists");
            return;
        }else {
            System.out.println("\n--------------------HashTable-----------------------------");
            for (int i=0;i<hashTable.length;i++){
                System.out.println("Index: "+i+", Key: "+hashTable[i]);
            }
        }
    }

    //Search Hash Table
    public boolean searchHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[newIndex]!=null && hashTable[newIndex].contains(word)){
            System.out.println( word+" is present int the hash table at location at :"+ newIndex);
            return true;
        }else {
            System.out.println(word+" is not found in the hash table");
            return false;
        }
    }

    //Delete Method
    public void deleteHashFunction(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        boolean result = searchHashTable(word);
        if (result){
            hashTable[newIndex].remove(word);
            System.out.println(word+" has been deleted Successfully");
        }
    }
}
public class Hashing1 {
    public static void main(String[] args) {
        DirectChaining d = new DirectChaining(13);
        d.insertHashTable("The");
        d.insertHashTable("quick");
        d.insertHashTable("brown");
        d.insertHashTable("fox");
        d.insertHashTable("jumps");
        d.insertHashTable("over");
        d.displayHashTable();
        d.searchHashTable("fox");
        d.searchHashTable("ox");
        d.deleteHashFunction("fox");
        d.searchHashTable("fox");
    }
}
