package com.company;
class NodeCs{
    public int value;
    public NodeCs next;
}
class CircularSinglyLinked extends NodeCs {
    public NodeCs head;
    public NodeCs tail;
    int size;

    public NodeCs CreateCs(int val) {
        head = new NodeCs();
        NodeCs n = new NodeCs();
        n.value = val;
        n.next = n;
        size = 1;
        head = n;
        tail = n;
        return head;
    }
    public void InsertCs(int value, int location){
        NodeCs n = new NodeCs();
        n.value = value;
        if (head==null){
            CreateCs(value);
            return;
        }else if (location ==0){
            n.next=head;
            head=n;
            tail.next=head;
        }else if(location>=size){
            tail.next = n;
            tail= n;
            tail.next=head;
        }else{
            NodeCs tempNode = new NodeCs();
            int index = 0;
            tempNode=head;
            while(index<location-1){
                tempNode = tempNode.next;
                index++;
            }
            n.next = tempNode.next;
            tempNode.next = n;
        }
        size++;
    }
    public void TraversCs(){
        if(head!=null){
            NodeCs tempNode = head;
            for(int i=0;i<size;i++){
                System.out.print(tempNode.value);
                if(i!=size-1){
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }else {
            System.out.println("Circular Linked List does not exists, OOPS!");
        }
    }
    public boolean Search(int value){
        if(head!=null){
            NodeCs tempNode = head;
            for (int i=0;i<size;i++){
                if(tempNode.value==value){
                    System.out.println("Value Found at Location "+i);
                    return true;
                }
                tempNode = tempNode.next;
            }
            System.out.println("Element is not present in the array");
        }
        return false;
    }
}
public class CircularSingly {
    public static void main(String[] args) {
        CircularSinglyLinked C = new CircularSinglyLinked();
        C.CreateCs(4);
        System.out.println(C.head.value);
        //System.out.println(C.head.next.value);
        C.InsertCs(5,1);
        C.InsertCs(6,2);
        C.InsertCs(7,3);
        C.InsertCs(8,7);
        C.InsertCs(3,0);
        System.out.println(C.head.next.next.next.value);
        C.TraversCs();
        C.Search(7);
        C.Search(3);
    }

    }
