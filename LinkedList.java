package com.company;
class Node{
    int value;
    Node next;
}
class SinglyLinkedList extends Node{
    public int size;
    public Node head;
    public Node Tail;
    public Node create(int value){
        head = new Node();
        Node n = new Node();
        n.value = value;
        n.next = null;
        head = n;
        Tail = n;
        size = 1;
        return head;
    }
    public void Insertion(int val, int location){
        Node m = new Node();
        m.value = val;
        if(head == null){
            create(val);
            return;
        }
        else if(location == 0){
            m.next = head;
            head = m;
        }else if(location>=size){
            m.next=null;
            Tail.next=m;
            Tail=m;
        }
        else {
            Node tempNode = head;
            int index = 0;
            while(index<location-1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = m;
            m.next = nextNode;
        }
        size++;
    }
    public void Traversal(){
        if(head == null){
            System.out.println("Singly Linked List does not exists, OOPS!");
        }else {
            Node tNode = head;
            for(int i =0;i<size;i++){
                System.out.print(tNode.value);
                if(i!=size-1){
                    System.out.print("->");
                }
                tNode = tNode.next;
            }
        }
        System.out.println();
    }
    public boolean Search(int Svalue){
        if(head != null){
            Node Snode = head;
            for (int i =0;i<size;i++){
                if(Snode.value == Svalue){
                    System.out.println("Found the Node at location "+i);
                    return true;
                }
                Snode = Snode.next;
            }
            System.out.println("Value is not present in the Singly Linked list");
        }
        return false;
    }
    public void Deletion(int location){
        if(head == null){
            System.out.println("Singly Linked List does not exist");
        }
        else if(location == 0){
            head = head.next;
            size--;
            if(size == 0){
                Tail = null;
            }
        }else if(location>=size){
            Node tempNode = head;
            for (int i=0;i<size-1;i++){
                tempNode = tempNode.next;
            }
            if (tempNode == head){
                Tail=head=null;
                size--;
                return;
            }
            tempNode.next = null;
            Tail = tempNode;
            size --;
        }
        else {
            Node tempNode = head;
            for (int i=0;i<location-1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
    public void DeleteSll(){
        head = null;
        Tail = null;
        System.out.println("Singly Linked List Deleted Successfully!");
    }
}
public class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.create(4);
        //System.out.println(Sll.head.value);
        Sll.Insertion(5,1);
        Sll.Insertion(6,2);
        Sll.Insertion(7,3);
        Sll.Insertion(8,4);
        Sll.Insertion(9,5);
        Sll.Insertion(3,0);
        Sll.Traversal();
        Sll.Search(4);
        Sll.Deletion(4);
        Sll.Traversal();
        Sll.DeleteSll();
        Sll.Traversal();

    }
}
