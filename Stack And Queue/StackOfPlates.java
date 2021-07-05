package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

class StackNode{
    public StackNode above;
    public StackNode below;
    public int value;

    public StackNode(int val){
        this.value = val;
    }
}
class Stack{
    public int size = 0;
    public int capacity;
    public StackNode top;
    public StackNode bottom;

    public Stack(int cap){
        this.capacity = cap;
    }

    public boolean isFull(){
        return capacity == size;
    }

    public void Join(StackNode above, StackNode below){
        if(below != null) below.above = above;
        if(above != null) above.below = below;
    }

    public boolean push(int val){
        if (size == capacity) return false;
        StackNode newNode = new StackNode(val);
        if (size == 1) bottom = newNode;
        Join(newNode, top);
        top = newNode;
        return true;
    }

    public int pop(){
        if (top == null) throw new EmptyStackException();
        int res = top.value;
        top = top.below;
        size--;
        return res;
    }
    public int RemoveBottom(){
        StackNode b = bottom;
        bottom = bottom.above;
        if (bottom!= null) bottom.below = null;
        size--;
        return b.value;

    }
}

class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack StackGetLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);

    }

    public void push(int val) {
        Stack Last = StackGetLastStack();
        if (Last != null && !Last.isFull()) {
            Last.push(val);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(val);
            stacks.add(stack);
        }
    }

    public int LeftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if (removeTop) removedItem = stack.pop();
        else removedItem = stack.RemoveBottom();

        if (stack.size == 0) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = LeftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }
    public int pop(){
        Stack last = StackGetLastStack();
        if (last == null) throw new EmptyStackException();
        int result = last.pop();
        if (last.size == 0){
            stacks.remove(stacks.size()-1);
        }
        return result;
    }
    public  int popAt(int index){
        return LeftShift(index, true);
    }

}

public class StackOfPlates {
    public static void main(String[] args) {
          Stack newStack = new Stack(3);
//        newStack.push(1);
//        newStack.push(2);
//        System.out.println(newStack.isFull());
//        System.out.println(newStack.pop());
        SetOfStacks ns = new SetOfStacks(3);
        ns.push(3);
        ns.push(4);
        ns.push(5);
        ns.push(6);
        ns.push(7);
        ns.push(8);
        System.out.println(ns.popAt(0));
        System.out.println(ns.popAt(0));
        System.out.println(ns.popAt(0));
    }
}
