package org.example.ctci.linked_lists;

import org.example.common.ListNode;
import org.example.ctci.linked_lists.util.LinkedList;

public class intersection {
    ListNode advancePointer(LinkedList list, int x) {
        ListNode ptr = list.getHead();
        for (int i = 0; i < x; i++) {
            if (ptr == null) {
                return null;
            }
            ptr = ptr.next;
        }
        return ptr;
    }

    ListNode solve(LinkedList list1, LinkedList list2) {
        int l1Len = list1.length();
        int l2Len = list2.length();
        ListNode p1 = list1.getHead();
        ListNode p2 = list2.getHead();
        if (l1Len > l2Len) {
            p1 = advancePointer(list1, l1Len - l2Len);
        } else {
            p2 = advancePointer(list2, l2Len - l1Len);
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    void main() {
        // intersecting
        LinkedList list1 = new LinkedList(new int[]{3, 1, 5, 9, 7, 2, 1});
        LinkedList list2 = new LinkedList(new int[]{4, 6});
        ListNode intersection = list1.getNode(7);
        list2.pushBack(intersection);

        // no intersection
//        LinkedList list1 = new LinkedList(new int[]{3,1,5,9,7,2,1});
//        LinkedList list2 = new LinkedList(new int[]{4,6,7,2,1});

        list1.print();
        list2.print();
        ListNode result = solve(list1, list2);
        System.out.println(result == null ? null : result.val);
    }
}
