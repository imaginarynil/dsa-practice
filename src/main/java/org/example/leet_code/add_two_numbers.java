package org.example.leet_code;

import org.example.common.ListNode;

public class add_two_numbers {
    public LinkedList toLinkedList(ListNode node) {
        LinkedList list = new LinkedList();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    public void addZeros(LinkedList list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(0);
        }
    }

    public void normalize(LinkedList list1, LinkedList list2) {
        if (list1.size() < list2.size()) {
            addZeros(list1, list2.size() - list1.size());
        } else {
            addZeros(list2, list1.size() - list2.size());
        }
    }

    public LinkedList addTwoLists(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        ListNode p1 = l1.getHead();
        ListNode p2 = l2.getHead();
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            int x = sum % 10;
            carry = sum / 10;
            result.add(x);
            p1 = p1.next;
            p2 = p2.next;
        }
        if (carry == 1) {
            result.add(1);
        }
        return result;
    }

    public ListNode addTwoNumbers_Attempt_1(ListNode l1, ListNode l2) {
        LinkedList list1 = toLinkedList(l1);
        LinkedList list2 = toLinkedList(l2);
        normalize(list1, list2);
        var result = addTwoLists(list1, list2);
        return result.getHead();
    }

    public ListNode addTwoNumbers_Optimal(ListNode l1, ListNode l2) {
        int sum;
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return result.next;
    }

    public ListNode addTwoNumbers_Optimal_No_Head(ListNode l1, ListNode l2) {
        int sum;
        int carry = 0;
        ListNode result = null;
        ListNode p = null;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + carry;
            int digit = sum % 10;
            if (result == null) {
                result = new ListNode(digit);
                p = result;
            } else {
                p.next = new ListNode(digit);
                p = p.next;
            }
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return result;
    }

    void main() {
        ListNode x;

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        x = addTwoNumbers_Optimal(l1, l2);

        l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        l2 = new ListNode(9, new ListNode(9));
        x = addTwoNumbers_Optimal(l1, l2);
    }

    class LinkedList {
        private ListNode head = null;
        private int size = 0;

        public ListNode getHead() {
            return head;
        }

        public void add(int data) {
            ListNode node = this.head;
            this.size += 1;
            if (node == null) {
                this.head = new ListNode(data);
                return;
            }
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(data);
        }

        public int size() {
            return this.size;
        }

        public void reverse() {
            ListNode p1 = null;
            ListNode p2 = this.head;
            while (p2 != null) {
                ListNode p2Next = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p2Next;
            }
            this.head = p1;
        }
    }
}




