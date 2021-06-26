package com.company;
class NodeCD{
    int value;
    NodeCD next;
    NodeCD prev;
}
class CircularDoubly extends NodeCD{
    int size;
    NodeCD head;
    NodeCD tail;
    public NodeCD CreateCDLL(int value){
        head = new NodeCD();
        NodeCD n = new NodeCD();
        n.value = value;
        head = n;
        tail = n;
        n.next = n;
        n.prev = n;
        size = 1;
        System.out.println("Circular Doubly Linked List Created Successfully");
        return head;
    }
    public void InsertCDLl(int value, int location){
        NodeCD tempNode = new NodeCD();
        tempNode.value = value;
        if (head==null){
            CreateCDLL(value);
            return;
        }else if (location==0){
            tempNode.next = head;
            tempNode.prev = tail;
            head.prev = tempNode;
            tail.next = tempNode;
            head = tempNode;
        }else if (location>=size){
            tempNode.next = head;
            head.prev = tempNode;
            tail.next = tempNode;
            tempNode.prev = tail;
            tail = tempNode;
        }else {
            NodeCD c = head;
            int index = 0;
            while(index<location-1){
                c = c.next;
                index++;
            }
            tempNode.prev = c;
            tempNode.next = c.next;
            c.next = tempNode;
            tempNode.next.prev = tempNode;
        }
        size++;
    }
    public void TraverseCDLL(){
        if (head!=null){
            NodeCD tempNode = head;
            for (int i=0;i<size;i++){
                System.out.print(tempNode.value);
                if (i!=size-1){
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }else {
            System.out.println("Circular Doubly Linked list does not exists");
        }
        System.out.println();
    }
    public void ReverseTraverseCDLL(){
        if(head!=null){
            NodeCD tempNode = tail;
            for(int i=0;i<size;i++){
                System.out.print(tempNode.value);
                if (i!=size-1){
                    System.out.print("<-");
                }
                tempNode =tempNode.prev;
            }
        }else {
            System.out.println("Circular Doubly Linked List does not exists");
        }
        System.out.println();
    }
    public void SearchCDLL(int val){
        if (head!=null){
            NodeCD tempNode = head;
            for(int i =0;i<size;i++){
                if(tempNode.value == val){
                    System.out.println("value is present in the Circular Doubly Linked List at location "+i);
                    return;
                }
                tempNode = tempNode.next;
            }
        }else {
            System.out.println("Value is not present in the Circular doubly linked list");
        }
    }
    public void DeleteNodeCDll(int location) {
        if (head == null) {
            System.out.println("There is nothing to delete, Circular double linked list does not exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head.next = null;
                head.prev = null;
                tail = head = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        }else if(location>=size){
            if (size==1){
                head.next = null;
                head.prev = null;
                head =tail = null;
                size--;
                return;
            }else{
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
    }else {
            NodeCD tempNOde = head;
            for (int i=0;i<location-1;i++){
                tempNOde = tempNOde.next;
            }
            tempNOde.next = tempNOde.next.next;
            tempNOde.next.prev = tempNOde;
            size--;
        }
    }
    public void DeleteCDLL(){
        NodeCD tempNode = head;
        for(int i=0;i<size;i++){
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("Circular Doubly Linked List deleted Successfully");
    }
}
public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        CircularDoubly m = new CircularDoubly();
        m.CreateCDLL(14);
        m.InsertCDLl(3,0);
        m.InsertCDLl(4,2);
        m.InsertCDLl(5,3);
        m.InsertCDLl(6,4);
        m.InsertCDLl(7,5);
        m.InsertCDLl(8,6);
        System.out.println(m.head.value);
        System.out.println(m.head.next.value);
        m.TraverseCDLL();
        System.out.println(m.tail.next.value);
        m.ReverseTraverseCDLL();
        m.SearchCDLL(6);
        m.DeleteNodeCDll(3);
        m.TraverseCDLL();
        m.DeleteCDLL();
        m.TraverseCDLL();
    }
}
