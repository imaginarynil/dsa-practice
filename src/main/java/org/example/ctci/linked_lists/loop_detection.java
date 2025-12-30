package org.example.ctci.linked_lists;

import org.example.ctci.linked_lists.util.LinkedList;
import org.example.ctci.linked_lists.util.ListNode;

public class loop_detection {
    ListNode findMeetingPoint(ListNode p1, ListNode p2) {
        while (p2 != null && p2.next != null) { // note
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return p1;
            }
        }
        return null;
    }

    ListNode loopDetection_Solution(LinkedList list) {
        ListNode p1 = list.getHead();
        ListNode p2 = list.getHead();
        if (p1 == null || p1.next == null) {
            return null;
        }
        ListNode meetingPoint = findMeetingPoint(p1, p2);
        if (meetingPoint == null || meetingPoint.next == null) {
            return null;
        }
        p1 = list.getHead(); // note
        p2 = meetingPoint;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next; // note
            if (p1 == p2) {
                return p1;
            }
        }
        return null;
    }

    void main() {
        // cyclical list
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
//        ListNode loopStartNode = list.getNode(5);
//        ListNode corruptedNode = list.getNode(0);
//        corruptedNode.next = loopStartNode;
        ListNode result = loopDetection_Solution(list);
        System.out.println(result != null ? result.data : null);

//        LinkedList list = new LinkedList(new int[]{1});
//        ListNode node1 = list.getNode(1);
//        node1.next = list.getHead();

//        LinkedList list = new LinkedList(new int[]{1,2});
//        ListNode node2 = list.getNode(2);
//        node2.next = list.getHead();

//        for(int i = 1; i <= 9; i++) {
//            LinkedList list = new LinkedList(new int[]{1,2,3,4,5,6,7,8,9});
//            ListNode corrupted = list.getNode(i);
//            list.getTail().next = corrupted;
//            System.out.printf("%d %b\n",i, isCircular(list));
//        }
    }
}
