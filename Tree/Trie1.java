package com.company;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> Children;
    boolean endOfString;

    public TrieNode(){
        Children = new HashMap<>();
        endOfString = false;
    }
}

class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("The Trie has been successfully created!");
    }

    //Insert Method
    public void insert(String word){
        TrieNode current = root;
        for (int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.Children.get(ch);
            if (node == null){
                node = new TrieNode();
                current.Children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted "+word+" in Trie");
    }

    //Searching for a Word in Trie
    public boolean search(String word){
        TrieNode currentNode = root;
        for (int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = currentNode.Children.get(ch);
            if (node == null){
                System.out.println("There is no such word in the Trie, OOPS!");
                return false;
            }
            currentNode = node;
            }
            if (currentNode.endOfString == true){
            System.out.println(word+" is present in the Trie");
            return true;
            }
            else {
                System.out.println("Word "+word+" does not exists in the Trie but is a substring of a different Word");
            }
            return currentNode.endOfString;
    }

    //Deletion of a string Method in Trie
    private boolean delete(TrieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.Children.get(ch);
        boolean canThisNodeBeDeleted;
        if (currentNode.Children.size()>1){
            delete(currentNode,word,index+1);
            return false;
        }if (index == word.length()-1){
            if (currentNode.Children.size()>=1){
                currentNode.endOfString = false;
                return false;
            }else {
                parentNode.Children.remove(ch);
                return true;
            }
        }
        if (currentNode.endOfString == true){
            delete(currentNode, word, index+1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if (canThisNodeBeDeleted == true){
            parentNode.Children.remove(ch);
            return true;
        }else {
            return false;
        }
    }

    public void delete(String word){
        if (search(word)==true){
            delete(root, word, 0);
        }
    }
}
public class Trie1 {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("API");
        t.insert("APIS");
        t.search("API");
        t.delete("API");
        t.search("API");
    }
}
