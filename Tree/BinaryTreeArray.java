package com.company;

class BinaryTreeArr{
    String[] arr;
    public int lastUsedIndex;

    public BinaryTreeArr(int size){
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Blank Tree of Size "+size+" has been created");
    }

    // IsFull Method
    boolean isFull(){
        if (arr.length-1 == lastUsedIndex){
            return true;
        }else {
            return false;
        }
    }

    // Insert Method
    void Insert(String value){
        if (!isFull()){
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println(value + " has been successfully Inserted!");
        }else {
            System.out.println("Binary Tree is full, OOPS!");
        }

    }

    // PreOrder Traversal
    void preOrder(int index){
        if (index>lastUsedIndex){
            return;
        }
        System.out.print(arr[index]+ " ");
        preOrder(index*2);
        preOrder((index*2) + 1);
    }

    // InOrder Traversal
    void inOrder(int index){
        if (index > lastUsedIndex){
            return;
        }
        inOrder(index*2);
        System.out.print(arr[index]+" ");
        inOrder(index*2 +1);
    }

    // PostOrder Traversal
    void postOrder(int index){
        if (index>lastUsedIndex){
            return;
        }
        postOrder(index*2);
        postOrder(index*2 +1);
        System.out.print(arr[index]+" ");
    }

    // Level Order Traversal
    void levelOrder(){
        for (int i =1;i<=lastUsedIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }

    // Search Method
    int search(String val){
        for (int i=1;i<=lastUsedIndex;i++){
            if (arr[i]==val){
                System.out.println(val+" is present in the Tree at location :"+i);
                return i;
            }
        }
        System.out.println(val+" is not present in the Binary Tree");
        return -1;
    }

    // Deletion of a Node
    public void delete(String val){
        int location = search(val);
        if (location == -1){
            System.out.println("There is nothing to delete");
            return;
        }else{
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println(val+" has been successfully deleted");
        }
    }

    // Deleting the entire binary tree
    void deleteBt(){
        try {
            arr = null;
            System.out.println("The Binary tree has been successfully deleted");
        }catch (Exception e){
            System.out.println("The was an Error in deleting the binary tree");
        }
    }
}
public class BinaryTreeArray {
    public static void main(String[] args) {
        BinaryTreeArr bt = new BinaryTreeArr(9);
        bt.Insert("N1");
        bt.Insert("N2");
        bt.Insert("N3");
        bt.Insert("N4");
        bt.Insert("N5");
        bt.Insert("N6");
        bt.Insert("N7");
        bt.Insert("N8");
        bt.Insert("N9");
        System.out.println("\nPreOrder Traversal:");
        bt.preOrder(1);
        System.out.println("\n\nInOrder Traversal:");
        bt.inOrder(1);
        System.out.println("\n\nPostOrder Traversal:");
        bt.postOrder(1);
        System.out.println("\n\nLevelOrder Traversal:");
        bt.levelOrder();
        System.out.println("\n");
        int res = bt.search("N5");
        System.out.println(res);
        System.out.println("\n");
        bt.search("N10");
        System.out.println();
        System.out.println("\n");
        bt.delete("N5");
        bt.levelOrder();
        System.out.println("\n\n");
        bt.deleteBt();
    }
}
