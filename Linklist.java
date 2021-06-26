package com.company;
class NodeL{
    int value;
    NodeL next;
    NodeL prev;
}
class Link extends NodeL{
    int size;
    NodeL head;
    NodeL tail;
    public void create(int val){
        NodeL n = new NodeL();
        n.value = val;
        head = n;
        tail = n;
        n.next = null;
        size = 1;
    }
    public void Insert(int val){
        if (head==null){
            create(val);
            return;
        }
        NodeL newNode = new NodeL();
        newNode.value = val;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public void Traversal(){
        NodeL tempNode = head;
        for (int i=0;i<size;i++){
            System.out.print(tempNode.value);
            if(i!=size-1){
                System.out.print(" -> ");
            }
            tempNode =tempNode.next;
        }
        System.out.println();
    }

}
public class Linklist {
    public static void main(String[] args) {
        Link l = new Link();
        l.create(0);
        l.Insert(1);
        l.Insert(2);
        l.Insert(3);
        l.Insert(4);
        l.Insert(5);
        l.Insert(2);
        l.Traversal();
        LinkQuestion1 a = new LinkQuestion1();
        a.RemoveDuplicate(l);
        l.Traversal();
    }
}
