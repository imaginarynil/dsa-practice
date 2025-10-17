package org.example.linked_lists;

public class delete_middle_node {
    static void solve(LinkedList list, ListNode node) {
        ListNode p1 = node, p2 = node.next;
        while (p1 != null) {
            if(p2 == null) {
                return;
            }
            p1.data = p2.data;
            if(p2.next == null) {
                p1.next = null;
                return;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }

    static void book_solution(LinkedList list, ListNode node) {
        if(node == null || node.next == null) return;
        ListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
    }

    static void main() {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode targetNode = list.getNode(2);
        book_solution(list, targetNode);
        list.print();
    }
}
