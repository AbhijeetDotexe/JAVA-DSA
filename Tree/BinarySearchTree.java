package com.company;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchNode{
    public int value;
    public int height;
    public BinarySearchNode left;
    public BinarySearchNode right;
}
class BinarySTree{
    BinarySearchNode root;
    // Constructor
    public BinarySTree(){
        root = null;
        System.out.println("\nBinary Search Tree has been created Successfully");
    }

    // Insert Method in Binary search Tree
    public BinarySearchNode insert(BinarySearchNode currentNode, int value){
        if (currentNode == null){
            BinarySearchNode newNode = new BinarySearchNode();
            newNode.value = value;
            //System.out.println("Value Successfully Inserted");
            return newNode;
        }else if(value<=currentNode.value){
            currentNode.left = insert(currentNode.left,value);
            return currentNode;
        }else {
            currentNode.right = insert(currentNode.right,value);
            return currentNode;
        }
    }

    // Basic Insert Method
    void insert(int value){
       root = insert(root,value);
    }

    // PreOrder Traversal
    public void preOrder(BinarySearchNode node){
        if (node == null){
            return;
        }
        System.out.print(node.value +"  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InOrder Traversal
    public void inOrder(BinarySearchNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+"  ");
        inOrder(node.right);
    }

    //PostOrder Traversal
    public void postOrder(BinarySearchNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"  ");
    }

    //LevelOrder Traversal
    public void levelOrder(){
        Queue<BinarySearchNode> queue = new LinkedList<BinarySearchNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinarySearchNode presentNode = queue.remove();
            System.out.print(presentNode.value+"  ");
            if (presentNode.left!=null){
                queue.add(presentNode.left);
            }
            if (presentNode.right!=null){
                queue.add(presentNode.right);
            }
        }
    }

    // Searching a node
    public BinarySearchNode search(BinarySearchNode node, int value){
        if (node==null){
            System.out.println(value+" is not present in the Tree");
            return null;
        }else if (node.value == value){
            System.out.println(value+" is present in the Binary Search Tree");
            return node;
        }else if(value< node.value){
            return search(node.left,value);
        }else {
            return search(node.right,value);
        }
    }

    // Minimum Node
    public static BinarySearchNode minimum(BinarySearchNode root){
        if (root.left == null){
            return root;
        }else {
            return minimum(root.left);
        }
    }

    // Deletion Of a Node
    public BinarySearchNode deleteNode(BinarySearchNode root, int val){
        if (root == null){
            System.out.println(val+" not found in the Binary Search Tree");
            return null;
        }
        if (val< root.value){
            root.left = deleteNode(root.left,val);
        }else if(val> root.value){
            root.right = deleteNode(root.right,val);
        }else {
            if (root.left!=null && root.right!=null){
                BinarySearchNode temp = root;
                BinarySearchNode minNodeForRight = minimum(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right,minNodeForRight.value);
            }else if (root.left!=null){
                root = root.left;
            }else if (root.right!=null){
                root = root.right;
            }else {
                root = null;
            }
        }
        return root;
    }

    // Deletion of Entire Binary Search Tree
    public void deleteBST(){
        root = null;
        System.out.println("Binary Search Tree has been deleted Successfully");
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySTree b = new BinarySTree();
        b.insert(70);
        b.insert(50);
        b.insert(90);
        b.insert(30);
        b.insert(60);
        b.insert(80);
        b.insert(100);
        b.insert(20);
        b.insert(40);
        System.out.println("PreOrder Traversal:");
        b.preOrder(b.root);
        System.out.println("\n\nInOrder Traversal:");
        b.inOrder(b.root);
        System.out.println("\n\nPostOrder Traversal: ");
        b.postOrder(b.root);
        System.out.println("\n\nLevelOrder Traversal: ");
        b.levelOrder();
        System.out.println("\n\nSearch Method:");
        b.search(b.root,40);
        b.deleteNode(b.root,90);
        System.out.println("\nTree After Deletion:");
        b.inOrder(b.root);
        System.out.println("\n");
        b.deleteBST();
    }
}
