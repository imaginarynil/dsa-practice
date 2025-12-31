package org.example.ctci.linked_lists;

import org.example.common.ListNode;
import org.example.ctci.linked_lists.util.LinkedList;

public class delete_middle_node {
    void solve(LinkedList list, ListNode node) {
        ListNode p1 = node, p2 = node.next;
        while (p1 != null) {
            if (p2 == null) {
                return;
            }
            p1.val = p2.val;
            if (p2.next == null) {
                p1.next = null;
                return;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }

    void deleteMiddleNode_Solution(LinkedList list, ListNode node) {
        if (node == null || node.next == null) return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    void main() {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode targetNode = list.getNode(2);
        deleteMiddleNode_Solution(list, targetNode);
        list.print();
    }
}
