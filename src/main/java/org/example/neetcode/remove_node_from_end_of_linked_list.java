package org.example.neetcode;

import org.example.common.ListNode;

public class remove_node_from_end_of_linked_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = head;
        for (int i = 0; i < n; i++) {
            p3 = p3.next;
        }
        while (p3 != null) {
            p1 = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        if (p1 == null) {
            if (p2.next == null) {
                return null;
            } else {
                head = p2.next;
            }
        } else {
            p1.next = p2.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd_TwoPointers(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p1 = res;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return res.next;
    }

    void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        var x = removeNthFromEnd_TwoPointers(head, 2);

//        ListNode head = new ListNode(1);
//        var x = removeNthFromEnd_TwoPointers(head, 1);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        var x = removeNthFromEnd_TwoPointers(head, 2);
    }
}
