package com.company;
class QLinked{
    SinglyLinkedList List;

    public QLinked(){
        List = new SinglyLinkedList();
        System.out.println("The Queue is Successfully created!");
    }
    public boolean IsEmpty(){
        if (List.head == null){
            return true;
        }else {
            return false;
        }
    }
    public void enQueue(int val ){
        List.Insertion(val,List.size);
        System.out.println(val+" is successfully inserted in the queue");
    }
    public int deQueue(){
        int val = -1;
        if (IsEmpty()){
            System.out.println("There is nothing to delete as the list is empty!");
        }else {
            val = List.head.value;
            List.Deletion(0);
        }
        return val;
    }
    public int peek(){
        if (IsEmpty()){
            System.out.println("There is nothing to display!");
            return -1;
        }else {
            return List.head.value;
        }
    }
    public void DeleteQ(){
        List.head = null;
        List.Tail = null;
        System.out.println("Queue is successfully deleted!");
    }
}
public class QueueLinked {
    public static void main(String[] args) {
        QLinked newQ = new QLinked();
        boolean res = newQ.IsEmpty();
        System.out.println(res);
        newQ.enQueue(10);
        newQ.enQueue(20);
        newQ.enQueue(30);
        newQ.enQueue(40);
        newQ.enQueue(50);
        boolean res2 = newQ.IsEmpty();
        System.out.println(res2);
        int r = newQ.deQueue();
        System.out.println(r);
        int p = newQ.peek();
        System.out.println(p);
        newQ.DeleteQ();
    }
}
