package com.company;
class BHeap{
    int[] arr;
    int sizeOfTree;

    //Constructor
    public BHeap(int size){
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Binary heap has been created!");
    }

    //IsEmpty
    public boolean isEmpty(){
        if (sizeOfTree == 0){
            return true;
        }else {
            return false;
        }
    }

    //Peek Method
    public Integer peek(){
        if (isEmpty()){
            System.out.println("There is nothing to display as the Binary heap is empty, OOPS!");
            return null;
        }
        return arr[1];
    }

    //Size Of Binary heap
    public int sizeofBH(){
        return sizeOfTree;
    }

    //Level Order Traversal
    public void levelOrder(){
        for (int i=1;i<=sizeOfTree;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

    //Heapify for insert Method
    public void heapifyBottomToTop(int index, String heaptype){
        int parent = index/2;
        if (index<=1){
            return;
        }
        if (heaptype == "Min"){
            if (arr[index]<arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }else if (heaptype == "Max"){
            if (arr[index]>arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }

        heapifyBottomToTop(parent, heaptype);
    }

    //Insertion Method
    public void insert(int value, String heapType){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println(value+" is successfully inserted in the heap");
    }

    // Heapify for Extraction of a node
    public void heapify(int index, String heapType){
        int left = index * 2;
        int right = index *2 + 1;
        int swapChild = 0;
        if (sizeOfTree<left){
            return;
        }
        if (heapType == "Max"){
            if (sizeOfTree == left){
                if (arr[index]<arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else {
                if (arr[left]>arr[right]){
                    swapChild = left;
                }else {
                    swapChild = right;
                }
                if (arr[index]<arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }else if (heapType == "Min"){
            if (sizeOfTree == left){
                if (arr[index]>arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else {
                if (arr[left]<arr[right]){
                    swapChild = left;
                }else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        heapify(swapChild, heapType);
    }

    //Extraction Method for heap
    public int extractHeap(String heaptype){
        if (isEmpty()){
            return -1;
        }else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree-- ;
            heapify(1, heaptype);
            return extractedValue;
        }
    }

    //Deleting Entire Binary heap
    public void deleteBH(){
        arr = null;
        System.out.println("\nBinary Heap has been successfully deleted");
    }
}
public class BinaryHeap {
    public static void main(String[] args) {
        BHeap b = new BHeap(5);
        b.insert(10,"Min");
        b.insert(5,"Min");
        b.insert(15,"Min");
        b.insert(1,"Min");
        System.out.println("\n");
        System.out.println("Peek Method:");
        Integer a = b.peek();
        System.out.println(a);
        System.out.println("\nLevel Order Traversal:");
        b.levelOrder();
        System.out.println("\n");
        System.out.println("Extraction Method in Heap:");
        b.extractHeap("Min");
        b.levelOrder();
        b.deleteBH();
    }

}
