package org.example.leet_code;

public class reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head = p1;
        return head;
    }

    void main() {
        ListNode head;
        head = reverseList(null);
        head = reverseList(new ListNode(1));
        head = reverseList(new ListNode(1, new ListNode(2)));
        head = reverseList(new ListNode(1, new ListNode(2, new ListNode(3))));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
