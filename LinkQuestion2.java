// Write a java program to print the Nth element from the last of the linked list
package com.company;

public class LinkQuestion2 {
    public NodeL NthToLast(Link l, int n){
        NodeL p1 = l.head;
        NodeL p2 = l.head;
        for (int i=0;i<n;i++){
            if(p2 == null){
                return null;
            }
            p2 = p2.next;
        }while (p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        Link l = new Link();
        l.create(1);
        l.Insert(2);
        l.Insert(3);
        l.Insert(4);
        l.Insert(5);
        l.Insert(6);
        l.Insert(7);
        l.Traversal();
        LinkQuestion2 r = new LinkQuestion2();
        NodeL a = r.NthToLast(l,3);
        System.out.println(a.value);
    }
}
