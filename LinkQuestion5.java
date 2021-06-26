package com.company;

public class LinkQuestion5 {
    NodeL GetKthNode(NodeL head, int k){
        NodeL current = head;
        while (current!=null||k>0){
            current = current.next;
            k--;
        }
        return current;
    }
    // Intersection Method
    NodeL Intersection(Link l1, Link l2){
        if(l1.head == null || l2.head==null){
            return null;
        }
        if (l1.tail!=l2.tail){
            return null;
        }
        NodeL shorter = new NodeL();
        NodeL longer = new NodeL();
        if(l1.size>l2.size){
            longer = l1.head;
            shorter = l2.head;
        }else {
            longer = l2.head;
            shorter = l1.head;
        }
        longer = GetKthNode(longer,Math.abs(l1.size-l2.size));
        while (shorter!=l1){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }
    public void AddSame(Link A, Link B, int value){
        NodeL n = new NodeL();
        n.value = value;
        A.tail.next = n;
        A.tail = n;
        B.tail.next = n;
        B.tail = n;
    }

    public static void main(String[] args) {
    }
}
