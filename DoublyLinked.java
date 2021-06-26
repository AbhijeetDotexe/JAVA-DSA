package com.company;
class NodeD{
    int value;
    NodeD next;
    NodeD prev;
}
class DoubleL extends NodeD{
    int size;
    NodeD head;
    NodeD tail;
    public NodeD CreateDoubly(int value){
        head = new NodeD();
        NodeD n = new NodeD();
        n.value = value;
        n.next = null;
        n.prev = null;
        head = n;
        tail = n;
        size = 1;
        return head;
    }
    public void InsertDll(int val, int location){
        NodeD n = new NodeD();
        n.value = val;
        if(head == null){
            CreateDoubly(val);
            return;
        }else if (location==0){
            n.next = head;
            n.prev=null;
            head.prev = n;
            head = n;
        }else if(location>=size){
            n.prev = tail;
            n.next = null;
            tail.next = n;
            tail = n;
        }else{
            NodeD tempNode = head;
            int index = 0;
            while (index<location-1){
                tempNode = tempNode.next;
                index++;
            }
            n.next = tempNode.next;
            n.prev = tempNode;
            n.next.prev = n;
            tempNode.next = n;
        }
        size++;
    }
    public void TraversalDll(){
        if (head!=null){
        NodeD tempNode = head;
            for (int i=0;i<size;i++){
                System.out.print(tempNode.value);
                tempNode = tempNode.next;
                if(i<size-1){
                    System.out.print("->");
                }
            }
            System.out.println();
        }else {
            System.out.println("Doubly Linked List does not exists, OOPS!");
        }

    }
    public void ReverseTraversal(){
        if(head!=null){
            NodeD tempNode = tail;
            for(int i=0;i<size;i++){
                System.out.print(tempNode.value);
                tempNode = tempNode.prev;
                if(i!=size-1){
                    System.out.print("<-");
                }
            }
            System.out.println();
        }else {
            System.out.println("Doubly Linked List does not Exists");
        }
    }
    public void SearchDll(int val){
        NodeD tempNode = head;
        if(head!=null){
            for (int i=0;i<size;i++){
                if (tempNode.value==val){
                    System.out.println("Value is present in the Doubly Linked List at location "+i);
                }
                tempNode = tempNode.next;
            }
        }else {
            System.out.println("Value is not present in the doubly Linked list, OOPS!");
        }
    }
    public void DeleteNode(int location){
        if(head==null){
            System.out.println("Doubly Linked List does not exists");
            return;
        }else if (location==0){
            if (size==1){
                head=null;
                tail=null;
                size--;
                return;
            }else {
                head = head.next;
                head.prev = null;
                size--;
            }
        }else if(location>=size){
            NodeD tempNode = tail.prev;
            if(size==1){
                head=null;
                tail=null;
                size--;
                return;
            }else {
                tempNode.next = null;
                tail = tempNode;
                size--;
            }
        }else {
            NodeD tempNode = head;
            for(int i=0;i<location-1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }

    }
    public void DeleteDll(){
        NodeD tempNode = head;
        for (int i=0;i<size;i++){
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("Doubly Linked List Deleted Successfully");
    }

}
public class DoublyLinked {
    public static void main(String[] args) {
        DoubleL m = new DoubleL();
        m.CreateDoubly(8);
        //System.out.println(m.head.value);
        m.InsertDll(1,0);
        m.InsertDll(2,1);
        m.InsertDll(3,2);
        m.InsertDll(4,6);
//        System.out.println(m.head.next.value);
//        System.out.println(m.head.next.next.value);
//        System.out.println(m.head.next.next.next.value);
//        System.out.println(m.head.value);
        m.TraversalDll();
        m.ReverseTraversal();
        m.SearchDll(2);
        m.DeleteNode(2);
        m.TraversalDll();
        System.out.println("\n");
        m.DeleteDll();
        m.TraversalDll();
    }
}
