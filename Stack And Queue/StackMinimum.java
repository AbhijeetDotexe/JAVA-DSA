package com.company;
class NodeMin{
    int value;
    NodeMin next;

    public NodeMin(int val, NodeMin next){
       this.value = val;
       this.next = next;
    }
}
class StackMin{
    NodeMin top;
    NodeMin min;

    public StackMin(){
        top = null;
        min = null;
    }

    public int min(){
        return min.value;
    }

    public void push(int val){
        if (min == null){
            min = new NodeMin(val,min);
        }else if(min.value<val){
            min = new NodeMin(min.value, min);
        }else {
            min = new NodeMin(val, min);
        }
        top = new NodeMin(val, top);
    }

    public int pop(){
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }
}
public class StackMinimum {
    public static void main(String[] args) {
        StackMin newStack = new StackMin();
        newStack.push(3);
        newStack.push(2);
        newStack.push(5);
        newStack.push(1);
        System.out.println(newStack.min());
        newStack.pop();
        System.out.println(newStack.min());
    }
}
