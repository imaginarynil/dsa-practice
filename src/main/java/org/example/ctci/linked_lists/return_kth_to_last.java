package org.example.ctci.linked_lists;

import org.example.ctci.linked_lists.util.LinkedList;
import org.example.ctci.linked_lists.util.ListNode;

public class return_kth_to_last {
    private ListNode result = null;

    int traverse(ListNode currNode, int k) {
        if (currNode == null) {
            return 0;
        }
        int i = traverse(currNode.next, k) + 1;
        if (i == k) {
            result = currNode;
        }
        return i;
    }

    ListNode returnKthToLast_Solution_3(LinkedList list, int k) {
        ListNode p1 = list.getHead();
        ListNode p2 = p1;
        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    void solve(LinkedList list, int k) {
        traverse(list.getHead(), k);
    }

    void main() {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        int k = 6;

//        solve(list, k);
//        System.out.println(result.data);

        System.out.println(returnKthToLast_Solution_3(list, k).data);
    }
}
