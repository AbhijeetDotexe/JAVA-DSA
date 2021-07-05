package com.company;
import java.util.*;
import java.util.Stack;

class QueueViaStack{
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStack(){
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size(){
        return stackOldest.size() + stackNewest.size();
    }

    public void enQueue(int val){
            stackNewest.push(val);
    }

    public void ShiftStack(){
        if (stackOldest.isEmpty()){
            while (!stackNewest.isEmpty()){
                int poppedOut = stackNewest.pop();
                stackOldest.push(poppedOut);
            }
        }
    }

    public int deQueue(){
        ShiftStack();
        return stackOldest.pop();
    }

    public int peek(){
        ShiftStack();
        return stackOldest.peek() ;
    }
}
public class QueueUsingStacks {
    public static void main(String[] args) {
        QueueViaStack newQ = new QueueViaStack();
        newQ.enQueue(1);
        newQ.enQueue(2);
        newQ.enQueue(3);
        System.out.println(newQ.deQueue());
        newQ.enQueue(4);
        System.out.println(newQ.deQueue());

    }
}
