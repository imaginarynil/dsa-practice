package org.example.leet_code;

public class linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        if (p1.next == null) {
            return false;
        }
        ListNode p2 = head.next.next;
        if (p2 == null) {
            return false;
        }
        while (p1.next != null && p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }

    public boolean hasCycle_Optimal(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    void main() {
        ListNode head;

        head = new ListNode(3);
        head.next = new ListNode(2);
        var p = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = p;

//        head = new ListNode(1);
//        head.next = new ListNode(2);

//        int[] arr = new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
//        ListNode head = new ListNode(arr[0]);
//        ListNode p = head;
//        for(int i = 1; i < arr.length; i++) {
//            p.next = new ListNode(arr[i]);
//            p = p.next;
//        }

        boolean x;
        x = hasCycle_Optimal(head);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
