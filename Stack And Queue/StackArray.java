package com.company;

import java.util.Arrays;

class StackA{
    int[] arr;
    int TopOfStack;
    StackA(int size){
        this.arr = new int[size];
        TopOfStack = -1;
        System.out.println("Stack Successfully Created with the size of : "+size);
    }
    public boolean IsEmpty(){
        if (TopOfStack==-1){
            return true;
        }else {
            return false;
        }
    }
    public boolean IsFull(){
        if (TopOfStack== arr.length-1){
            System.out.println("The Stack is full ");
            return true;
        }else {
            return false;
        }
    }
    public void Push(int val ){
        if (IsFull()){
            System.out.println("Cannot add anymore elements as the stack is already full");
        }else {
            arr[TopOfStack+1] = val;
            TopOfStack++;
            System.out.println("The value is Successfully Inserted");
        }
    }
    public int Pop(){
        if (IsEmpty()){
            System.out.println("There is nothing to delete ");
            return -1;
        }else {
            int TopStack = arr[TopOfStack];
            TopOfStack--;
            System.out.println("Top Element of the stack is deleted Successfully");
            return TopStack;
        }
    }
    public int peek(){
        if (IsEmpty()){
            System.out.println("There is nothing to display as the stack is empty");
            return -1;
        }else {
            return arr[TopOfStack];
        }
    }
    public void DeleteStack(){
        arr = null;
        System.out.println("Stack is deleted successfully");
    }
}
public class StackArray {
    public static void main(String[] args) {
        StackA newStack = new StackA(4);
        boolean a = newStack.IsEmpty();
        System.out.println(a);
        boolean b = newStack.IsFull();
        System.out.println(b);
        newStack.Push(5);
        newStack.Push(1);
        newStack.Push(2);
        newStack.Push(3);
        newStack.Push(6);
        int c = newStack.Pop();
        System.out.println(c);
        int d = newStack.Pop();
        System.out.println(d);
        int e = newStack.peek();
        System.out.println(e);
        newStack.DeleteStack();
    }
}
