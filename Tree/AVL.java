package com.company;

import java.util.LinkedList;
import java.util.Queue;

class AvlTree{
    BinarySearchNode root;

    AvlTree(){
        root = null;
    }

    // PreOrder Traversal
    public void preOrder(BinarySearchNode node){
        if (node == null){
            return;
        }
        System.out.print(node.value+"  ");
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
            }if (presentNode.right!=null){
                queue.add(presentNode.right);
            }
        }
    }

    // Search Method
    public BinarySearchNode search(BinarySearchNode node, int value){
        if (node == null){
            System.out.println(value+" is not found in Avl Tree");
            return null;
        }else if(node.value == value){
            System.out.println(value+" is present in the Avl Tree");
            return node;
        }else if(value < node.value){
            return search(node.left, value);
        }else {
            return search(node.right, value);
        }
    }
    // Get height
    public int getHeight(BinarySearchNode node){
        if (node == null){
            return 0;
        }
        return node.height;
    }
    // Rotate Right
    private BinarySearchNode rotateRight(BinarySearchNode disbalancedNode){
        BinarySearchNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // Rotate Left
    private BinarySearchNode rotateLeft(BinarySearchNode disbalancedNode){
        BinarySearchNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1+ Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // Get Balanace Node
    public int getBalance(BinarySearchNode node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //Insert Method
    private BinarySearchNode insertNode(BinarySearchNode node, int val){
        if (node == null){
            BinarySearchNode newNode = new BinarySearchNode();
            newNode.value = val;
            newNode.height = 1;
            return newNode;
        }
        else if(val< node.value){
            node.left = insertNode(node.left,val);
        }
        else {
            node.right = insertNode(node.right,val);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        if (balance>1 && val<node.left.value){
            return rotateRight(node);
        }
        if (balance>1 && val>node.left.right.value){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance< -1 && val>node.right.value ){
            return rotateLeft(node);
        }
        if (balance< -1 && val<node.right.value){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    // Insert Method
     public void insert(int value){
        root = insertNode(root, value);
     }

     // Minimum Node
    public static BinarySearchNode minimum(BinarySearchNode root){
        if (root.left == null){
            return null;
        }
        return minimum(root.left);
    }

    // Deletion of node
    public BinarySearchNode deleteNode(BinarySearchNode node, int val){
        if (node == null){
            System.out.println("Value is not present in the avl tree, OOPS!");
            return node;
        }
        if (val<node.value){
            node.left = deleteNode(node.left, val);
        }
        else if (val> node.value){
            node.right = deleteNode(node.right, val);
        }
        else {
            if (node.left != null && node.right != null) {
                BinarySearchNode temp = node;
                BinarySearchNode minNodeForRight = minimum(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
            int balance = getBalance(node);
            if (balance>1 && getBalance(node.left)>=0){
                return rotateRight(node);
            }
            if (balance>1 && getBalance(node.left)<0){
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
            if (balance< -1 && getBalance(node.right)<=0){
                return rotateLeft(node);
            }
            if (balance< -1 && getBalance(node.right)>0){
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        return node;
    }

    // Delete method
    public void delete(int val){
        root = deleteNode(root, val);
    }

    // Delete Entire Avl Tree
    public void deleteAvl(){
        root = null;
        System.out.println("AVL Tree has been successfully deleted ");
    }
}
public class AVL {
    public static void main(String[] args) {

        AvlTree a = new AvlTree();
        a.insert(5);
        a.insert(10);
        a.insert(15);
        a.insert(20);
        System.out.println("Level Order Traversal:");
        a.levelOrder();
        System.out.println("\n\nAfter deletion:");
        a.delete(5);
        a.levelOrder();
        System.out.println("\n");
        a.deleteAvl();

    }
}
