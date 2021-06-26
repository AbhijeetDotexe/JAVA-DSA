// Write a code to partition a linked list around x, such that all node less than x comes before all the nodes greater
// than or equal to x
package com.company;

public class LinkQuestion3 {
    Link Partition(Link l, int x){
        NodeL currentNode = l.head;
        l.tail = l.head;
        while(currentNode!=null){
            NodeL next = currentNode.next;
            if(currentNode.value<x){
                currentNode.next = l.head;
                l.head = currentNode;
            }else {
                l.tail.next = currentNode;
                l.tail = currentNode;
            }
            currentNode = next;
        }
        l.tail.next = null;
        return l;
    }

    public static void main(String[] args) {
        Link m = new Link();
        m.create(1);
        m.Insert(12);
        m.Insert(24);
        m.Insert(44);
        m.Insert(2);
        m.Insert(32);
        m.Insert(3);
        m.Insert(5);
        m.Insert(40);
        m.Traversal();
        LinkQuestion3 r = new LinkQuestion3();
        Link res = r.Partition(m,12);
        res.Traversal();
    }
}
