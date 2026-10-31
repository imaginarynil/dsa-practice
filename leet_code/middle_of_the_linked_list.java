package org.example.leet_code;

import org.example.common.ListNode;

public class middle_of_the_linked_list {
    public ListNode middleNode_Attempt_1(ListNode head) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode middleNode_Solution(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        var x = middleNode_Solution(head);
    }
}
