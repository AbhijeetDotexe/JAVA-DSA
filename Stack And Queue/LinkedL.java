package com.company;
class NodeL{
    int value;
    NodeL next;
    NodeL prev;
}
class LinkedLists extends NodeL{
    int size;
    NodeL head;
    NodeL tail;
    public  void Create(int val){
        NodeL n = new NodeL();
        n.value = val;
        n.next = null;
        head = n;
        tail = n;
        size=1;
    }
    public void Insert(int val){
        if(head == null){
            Create(val);
            return;
        }
        NodeL n = new NodeL();
        n.value = val;
        n.next = null;
        tail.next = n;
        tail = n;
        size++;
    }
    public void Traverse(){
        NodeL tempNode = head;
        for (int i =0;i<size;i++){
            System.out.print(tempNode.value);
            if (i!=size-1){
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
public class LinkedL {
    public static void main(String[] args) {
        LinkedLists m = new LinkedLists();
        m.Create(1);
        m.Insert(2);
        m.Insert(3);
        m.Insert(4);
        m.Insert(5);
        m.Insert(6);
        m.Insert(7);
        m.Traverse();
    }
}
