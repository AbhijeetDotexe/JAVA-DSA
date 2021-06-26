package com.company;
class Node1{
    int value;
    Node1 next;
}
class SinglyList extends Node1{
    int size;
    public Node1 head;
    public Node1 tail;
    public Node1 create(int val){
        head = new Node1();
        Node1 n = new Node1();
        n.value = val;
        n.next = null;
        head = n;
        tail = n;
        size = 1;
        return head;
    }
    public void Insertion(int value, int Location){
        Node1 n = new Node1();
        n.value = value;
        if(head==null){
            create(value);
            return;
        }
        else if(Location ==0){
            n.next = head;
            head = n;
        }
        else if(Location>=size){
            n.next = null;
            tail.next = n;
            tail = n;
        }else {
            Node1 tempNode = head;
            int index = 0;
            while (index < Location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node1 nextNode = tempNode.next;
            tempNode.next = n;
            n.next = nextNode;
        } size++;
    }
    public void Traverse(){
        if(head == null){
            System.out.println("Singly Linked List does Not exists, OOPS!");
        }else {
            Node1 tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if(i!=size-1){
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println();
    }
    public boolean Search(int val){
        if (head == null){
            System.out.println("Singly Linked List does not exists");
        }
        else {
            Node1 tempNode = head;
            for(int i=0;i<size;i++){
                if(tempNode.value==val){
                    System.out.println("Element "+val+ " Found at Location :"+i);
                    return true;
                }
                tempNode = tempNode.next;
            } System.out.println("Element is Not present in the Singly Linked List");
        }
        return false;
    }
    public void DeleteSll(){
        head = null;
        tail = null;
        System.out.println("Singly Linked List deleted Successfully");
    }
    public void DeleteElement(int location){
        if(head==null){
            System.out.println("Singly Linked List does not exists");
        }else if(location ==0){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        }else if(location>=size){
            Node1 tempNode = head;
            for (int i=0;i<size-1;i++){
                tempNode = tempNode.next;
            }
            if (tempNode==head){
                head = null;
                tail = null;
                size--;
                return;
            }
            tempNode.next =null;
            tail = tempNode;
            size--;
        }else {
            Node1 tempNode =head;
            for (int i=0;i<location-1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
        System.out.println("Element at Location "+location+" Deleted Successfully");
    }
}
public class LinkedList1 {
    public static void main(String[] args) {
        SinglyList Sl = new SinglyList();
        Sl.create(1);
        Sl.Insertion(2,1);
        Sl.Insertion(3,2);
        Sl.Insertion(4,3);
        Sl.Insertion(5,4);
        Sl.Insertion(6,5);
        Sl.Insertion(7,6);
        Sl.Insertion(8,7);
        Sl.Insertion(9,8);
        Sl.Traverse();
        Sl.Search(4);
        Sl.DeleteElement(6);
        Sl.Traverse();
        Sl.DeleteSll();
        Sl.Traverse();
    }
}
