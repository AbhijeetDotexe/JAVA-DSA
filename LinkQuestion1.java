// Write a java program to delete duplicate elements from a Linked List
package com.company;
import java.util.HashSet;
public class LinkQuestion1 {
    public void RemoveDuplicate(Link ll){
        HashSet<Integer> hs = new HashSet<>();
        NodeL current = ll.head;
        NodeL prev = null;
        while (current!=null){
            int Cval = current.value;
            if (hs.contains(Cval)){
                prev.next = current.next;
                ll.size--;
            }else {
                hs.add(Cval);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Link l = new Link();
        l.create(4);
        l.Insert(1);
        l.Insert(3);
        l.Insert(4);
        l.Insert(5);
        l.Insert(6);
        l.Insert(7);
        l.Traversal();
        LinkQuestion1 r = new LinkQuestion1();
        r.RemoveDuplicate(l);
        l.Traversal();

    }
}
