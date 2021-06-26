package com.company;

public class LinkQuestion4 {
    Link SumList(Link A, Link B){
        NodeL n1 = A.head;
        NodeL n2 = B.head;
        int carry = 0;
        Link result = new Link();
        while (n1!=null||n2!=null){
            int res = carry;
            if (n1!=null){
                res+=n1.value;
                n1 = n1.next;
            }if (n2!=null){
                res+=n2.value;
                n2 = n2.next;
            }
            result.Insert(res%10);
            carry = res/10;
        }
        return result;
    }

    public static void main(String[] args) {
        Link A = new Link();
        A.Insert(7);
        A.Insert(1);
        A.Insert(6);
        Link B = new Link();
        B.Insert(5);
        B.Insert(9);
        B.Insert(2);
        LinkQuestion4 r = new LinkQuestion4();
        Link s = r.SumList(A,B);
        s.Traversal();
    }
}
