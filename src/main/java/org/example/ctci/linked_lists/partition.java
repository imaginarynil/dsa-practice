package org.example.ctci.linked_lists;

public class partition {
    void solve(LinkedList list, int x) {
        ListNode p1 = null, p2 = list.getHead(), p3 = p2.next;
        if (p2.data < x) {
            p1 = p2;
        }
        while (p3 != null) {
            if (p3.data < x) {
                // move node to back
                p2.next = p3.next;
                if (p1 == null) {
                    p1 = p3;
                    p1.next = list.getHead();
                    list.setHead(p1);
                } else {
                    ListNode tmpNode = p1.next;
                    p1.next = p3;
                    p3.next = tmpNode;
                }
                p3 = p2.next; // update p3
            } else {
                p2 = p2.next;
                p3 = p3.next;
            }
        }
    }

    LinkedList partition_Solution(LinkedList list, int x) {
        LinkedList result = new LinkedList();
        ListNode p = list.getHead();
        while (p != null) {
            if (p.data < x) {
                ListNode newHead = new ListNode(p.data);
                result.setHead(newHead);
            } else {
                result.add(p.data);
            }
            p = p.next;
        }
        return result;
    }

    void main() {
//        LinkedList list = new LinkedList(new int[]{3,5,8,5,10,2,1});
        LinkedList list = new LinkedList(new int[]{10, 9, 8, 8, 1, 2, 3});
        int x = 5;

//        solve(list, x);
//        list.print();

        list.print();
        partition_Solution(list, x).print();
    }
}
