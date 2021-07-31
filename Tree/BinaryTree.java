package com.company;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{
    public String value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;

    // Constructor
    BinaryNode(){
        this.height = 0;
    }
}
class BinaryTreeLL{
    BinaryNode root;

    public BinaryTreeLL(){
        this.root = null;
    }

    // PreOrder Traversal
    void PreOrder(BinaryNode node) {
        if (node == null){
            return;
        }
        System.out.print(node.value+ " ");
        PreOrder(node.left);
        PreOrder(node.right);

    }

    // InOrder Traversal
    void Inorder(BinaryNode node){
        if (node == null){
            return;
        }
        Inorder(node.left);
        System.out.print(node.value+" ");
        Inorder(node.right);
    }

    // Post order Traversal
    void PostOrder(BinaryNode node ){
        if (node == null){
            return;
        }
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.value+" ");
    }
    
    // Level Order Traversal
    void LevelOrder(){
        Queue<BinaryNode> Queue = new LinkedList<BinaryNode>();
        Queue.add(root);
        while (!Queue.isEmpty()){
            BinaryNode presentNode = Queue.remove();
            System.out.print(presentNode.value+" ");
            if (presentNode.left!=null){
                Queue.add(presentNode.left);
            }if (presentNode.right!=null){
                Queue.add(presentNode.right);
            }
        }
    }

    // Searching
    public void Search(String value){
        Queue<BinaryNode> Queue = new LinkedList<BinaryNode>();
        Queue.add(root);
        while (!Queue.isEmpty()){
            BinaryNode presentNode = Queue.remove();
            if (presentNode.value == value){
                System.out.println("The value "+value+" is present in the tree ");
                return;
            }else {
                if (presentNode.left!=null){
                    Queue.add(presentNode.left);
                }
                if (presentNode.right!=null){
                    Queue.add(presentNode.right);
                }
            }
        }
        System.out.println("The value is not present in the tree, OOPS!");
    }

    // Inserting a Node
    void Insert(String val){
        BinaryNode newNode = new BinaryNode();
        newNode.value = val;
        if (root == null){
            root = newNode;
            System.out.println("Successfully Inserted New Node at Root");
            return;
        }
        Queue<BinaryNode> Queue = new LinkedList<BinaryNode>();
        Queue.add(root);
        while(!Queue.isEmpty()){
            BinaryNode presentNode = Queue.remove();
            if (presentNode.left == null){
                presentNode.left = newNode;
                System.out.println("Successfully Inserted new node ");
                break;
            }else if (presentNode.right == null){
                presentNode.right = newNode;
                System.out.println("Successfully INserted new node");
                break;
            }else {
                Queue.add(presentNode.left);
                Queue.add(presentNode.right);
            }
        }
    }

    // Get Deepest Node
    public BinaryNode getDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()){
            presentNode = queue.remove();
            if (presentNode.left != null){
                queue.add(presentNode.left);
            }
            if (presentNode.right !=null){
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    // Deletion of Deepest Node
    void deleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode,presentNode = null;
        while (!queue.isEmpty()){
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null){
                previousNode.right = null;
                return;
            }if (presentNode.right == null){
                previousNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    // Deletion of a given Node
    void deleteNode(String val){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()){
         BinaryNode presentNode = queue.remove();
         if (presentNode.value == val){
             presentNode.value = getDeepestNode().value;
             deleteDeepestNode();
             System.out.println("The node has been successfully deleted !");
             return;
         }else {
             if (presentNode.left!=null) queue.add(presentNode.left);
             if (presentNode.right!=null) queue.add(presentNode.right);
         }
        }
        System.out.println("The node is not present in this Binary tree");
    }

    // Delete Binary Tree
    void delete(){
        root = null;
        System.out.println("Binary Tree has been Successfully deleted" );
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeLL b = new BinaryTreeLL();
        BinaryNode N1 = new BinaryNode();
        N1.value = "N1";
        BinaryNode N2 = new BinaryNode();
        N2.value = "N2";
        BinaryNode N3 = new BinaryNode();
        N3.value = "N3";
        BinaryNode N4 = new BinaryNode();
        N4.value = "N4";
        BinaryNode N5 = new BinaryNode();
        N5.value = "N5";
        BinaryNode N6 = new BinaryNode();
        N6.value = "N6";
        BinaryNode N7 = new BinaryNode();
        N7.value = "N7";
        BinaryNode N8 = new BinaryNode();
        N8.value = "N8";
        BinaryNode N9 = new BinaryNode();
        N9.value = "N9";
        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N3.left = N6;
        N3.right = N7;
        N4.left = N8;
        N4.right = N9;
        b.root = N1;
        System.out.println();
        System.out.println("PreOrder Traversal : ");
        b.PreOrder(b.root);
        System.out.println("\n\nInorder Traversal : ");
        b.Inorder(b.root);
        System.out.println("\n\nPostOrder Traversal : ");
        b.PostOrder(b.root);
        System.out.println("\n\nLevelOrder Traversal : ");
        b.LevelOrder();
        System.out.println("\n");
        b.Search("N5");

        BinaryTreeLL bt = new BinaryTreeLL();
        bt.Insert("M1");
        bt.Insert("M2");
        bt.Insert("M3");
        bt.Insert("M4");
        bt.Insert("M5");
        bt.Insert("M6");
        bt.Insert("M7");
        System.out.println("\n");
        bt.LevelOrder();
        System.out.println();
        System.out.println(bt.getDeepestNode().value);
        bt.deleteDeepestNode();
        System.out.println("\n");
        bt.LevelOrder();
        System.out.println("\n");
        bt.deleteNode("M3");
        bt.LevelOrder();
        System.out.println("\n");
        bt.delete();
    }
}
