package com.company;
class QArray{
    int[] arr;
    int TopOfQ;
    int BeginningOfQ;
    public QArray(int size){
        this.arr = new int[size];
        this.TopOfQ = -1;
        this.BeginningOfQ = -1;
        System.out.println("Queue is Successfully Created!, with size of: "+size);
    }
    public boolean IsFull(){
        if (TopOfQ == arr.length-1){
            return true;
        }else {
            return false;
        }
    }
    public boolean IsEmpty(){
        if (BeginningOfQ == -1 || BeginningOfQ == arr.length){
            return true;
        }else {
            return false;
        }
    }
    public void Enqueue(int val ){
        if (IsFull()){
            System.out.println("Cannot Add anymore elements to the queue!");
        }else if (IsEmpty()){
            BeginningOfQ = 0;
            TopOfQ++;
            arr[TopOfQ] = val;
            System.out.println(val+" Is successfully Inserted in the queue");
        }else {
            TopOfQ++;
            arr[TopOfQ] = val;
            System.out.println(val+" is Successfully Inserted in the queue");
        }
    }
    public int DeQueue() {
        if (IsEmpty()) {
            System.out.println("There is nothing to delete as the list is empty!");
            return -1;
        } else {
            int res = arr[BeginningOfQ];
            BeginningOfQ++;
            if (BeginningOfQ > TopOfQ) {
                BeginningOfQ = TopOfQ = -1;
            }
            return res;
        }
    }
    public int peek(){
        if (!IsEmpty()){
            return arr[BeginningOfQ];
        }else {
            System.out.println("The Queue is Empty, There is nothing to display");
            return -1;
        }
    }
    public void DeleteQ(){
        arr = null;
        System.out.println("Queue is Successfully deleted!");
    }
}
public class QueueArray {
    public static void main(String[] args) {
        QArray newQ = new QArray(5);
        boolean a = newQ.IsFull();
        System.out.println(a);
        boolean b = newQ.IsEmpty();
        System.out.println(b);
        newQ.Enqueue(1);
        newQ.Enqueue(2);
        newQ.Enqueue(3);
        newQ.Enqueue(4);
        newQ.Enqueue(5);
        newQ.Enqueue(6);
        int result = newQ.DeQueue();
        System.out.println(result);
        int r = newQ.peek();
        System.out.println(r);
        newQ.DeleteQ();
    }
}
