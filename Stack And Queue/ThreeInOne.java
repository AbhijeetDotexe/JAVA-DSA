package com.company;
class TIO{
    private int numberOfStacks = 3;
    private int Capacity;
    private int[] size;
    private int[] values;
    public TIO(int stacksize){
        Capacity = stacksize;
        size = new int[stacksize];
        values = new int[numberOfStacks * stacksize];
    }
    public boolean isFull(int stackNum){
        if (size[stackNum] == Capacity){
            return true;
        }else {
            return false;
        }
    }
    public boolean isEmpty(int stackNum){
        if (size[stackNum] == 0){
            return true;
        }else {
            return false;
        }
    }
    private int indexOfTop(int stackNum){
        int offset = stackNum * Capacity;
        int s = size[stackNum];
        return offset + s - 1;
    }
    public void push(int stackNum, int val){
        if (isFull(stackNum)){
            System.out.println("The Stack is already full, Cannot add anymore elements to it ");
        }else {
            size[stackNum]++;
            values[indexOfTop(stackNum)] =val;
        }
    }
    public int pop(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("There is nothing to delete as the stack is already empty!");
            return -1;
        }else {
            int topIndex = indexOfTop(stackNum);
            int val = values[topIndex];
            values[topIndex] = 0;
            size[stackNum]--;
            return val;
        }
    }
    public int peek(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("There is nothing to display as the stack is empty!");
            return -1;
        }else {
            int top = values[indexOfTop(stackNum)];
            return top;
        }
    }
}
public class ThreeInOne {
    public static void main(String[] args) {
        TIO newStack = new TIO(3);
        boolean e = newStack.isEmpty(0);
        System.out.println(e);
        boolean f = newStack.isFull(0);
        System.out.println(f);
        newStack.push(0,1);
        newStack.push(0,2);
        newStack.push(1,4);
        newStack.push(1,5);
        newStack.push(2,8);
        int p = newStack.pop(0);
        System.out.println(p);
        int r = newStack.peek(0);
        System.out.println(r);

    }
}
