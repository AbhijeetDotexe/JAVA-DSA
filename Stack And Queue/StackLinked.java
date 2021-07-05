package com.company;
class StackLink{
    SinglyLinkedList StackLinkedList;
    public StackLink(){
        StackLinkedList = new SinglyLinkedList();
    }
    public void push(int val){
        StackLinkedList.Insertion(val,0);
        System.out.println("Inserted "+val+" in stack");
    }
    public boolean IsEmpty(){
        if(StackLinkedList.head==null){
            return true;
        }else {
            return false;
        }
    }
    public int pop(){
        int result = -1;
        if (IsEmpty()){
            System.out.println("There is nothing to delete");
            return result;
        }else {
            result = StackLinkedList.head.value;
            StackLinkedList.Deletion(0);
            System.out.println("Element deleted Successfully");
        }
        return result;
    }
    public int peek(){
        if (IsEmpty()){
            System.out.println("There is nothing to display");
            return -1;
        }else {
            return StackLinkedList.head.value;
        }
    }
    public void DeleteStack(){
        StackLinkedList.head = null;
        System.out.println("Stack Deleted Successfully!");
    }
}
public class StackLinked {
    public static void main(String[] args) {
        StackLink newStack = new StackLink();
        boolean b = newStack.IsEmpty();
        System.out.println(b);
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        boolean a = newStack.IsEmpty();
        System.out.println(a);
        int c = newStack.pop();
        System.out.println(c);
        int d = newStack.peek();
        System.out.println(d);
    }
}
