package com.company;
import java.util.ArrayList;
class TreeNode{
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void AddChildren(TreeNode node){
        this.children.add(node);
    }

    public String print(int level){
        String ret;
        ret = "  ".repeat(level)+data+"\n";
        for (TreeNode node:this.children){
            ret += node.print(level+1);
        }
        return ret;
    }
}
public class Tree1 {
    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode tea = new TreeNode("Tea");
        TreeNode Pepsi = new TreeNode("Pepsi");
        TreeNode fanta = new TreeNode("Fanta");
        drinks.AddChildren(hot);
        drinks.AddChildren(cold);
        hot.AddChildren(tea);
        hot.AddChildren(coffee);
        cold.AddChildren(Pepsi);
        cold.AddChildren(fanta);
        System.out.println(drinks.print(0));
    }
}
