package com.company;

import java.util.Arrays;

class CircularQ{
    int size;
    int[] arr;
    int TopOfQ;
    int BeginningOfQ;
    public CircularQ(int size){
        this.arr = new int[size];
        this.size = size;
        this.BeginningOfQ = -1;
        this.TopOfQ = -1;
        System.out.println("Circular Queue is successfully created with size of "+size);
    }
    public boolean IsEmpty(){
        if (TopOfQ == -1){
            return true;
        }else {
            return false;
        }
    }
    public boolean IsFull(){
        if (TopOfQ+1 == BeginningOfQ){
            return true;
        }else if (BeginningOfQ == 0 && TopOfQ+1==size){
            return true;
        }else {
            return false;
        }
    }
    public void EnQ(int val){
        if (IsFull()){
            System.out.println("Cannot add anymore elements to the Circular Queue");
        }else if (IsEmpty()){
            BeginningOfQ = 0;
            TopOfQ++;
            arr[TopOfQ] = val;
            System.out.println("Successfully Inserted "+ val +" in the queue!");
        }else {
            if (TopOfQ+1 == size){
                TopOfQ = 0;
            }else {
                TopOfQ++;
            }
            arr[TopOfQ] = val;
            System.out.println("Successfully Inserted "+ val +" in the Queue!");
        }
    }
    public int DeQ(){
        if (IsEmpty()){
            System.out.println("There is nothing to delete as the Queue is Empty!");
            return -1;
        }else {
            int result = arr[BeginningOfQ];
            arr[BeginningOfQ] = 0;
            if (BeginningOfQ == TopOfQ){
                BeginningOfQ = TopOfQ = -1;
            }else if (BeginningOfQ+1 == size){
                BeginningOfQ = 0;
            }else {
                BeginningOfQ++;
            }
            return result;
        }
    }
    public int Peek(){
        if (IsEmpty()){
            System.out.println("There is nothing to Display");
            return -1;
        }else {
            return arr[BeginningOfQ];
        }
    }
    public void DeleteCq(){
        arr = null;
        System.out.println("Circular Queue is successfully deleted!");
    }
}
public class CircularQArray {
    public static void main(String[] args) {
        CircularQ cq = new CircularQ(5);
        boolean a = cq.IsEmpty();
        System.out.println(a);
        cq.EnQ(10);
        cq.EnQ(20);
        cq.EnQ(30);
        cq.EnQ(40);
        cq.EnQ(50);
        cq.EnQ(60);
        System.out.println(cq);
        int res = cq.DeQ();
        System.out.println(res);
        int res2 = cq.DeQ();
        System.out.println(res2);
        int d = cq.Peek();
        System.out.println(d);
        cq.DeleteCq();
    }
}
