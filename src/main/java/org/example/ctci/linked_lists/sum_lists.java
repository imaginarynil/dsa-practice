package org.example.ctci.linked_lists;

import org.example.ctci.linked_lists.util.LinkedList;
import org.example.ctci.linked_lists.util.ListNode;

public class sum_lists {
    void normalize(LinkedList list1, LinkedList list2) {
        LinkedList shorterList = list1;
        if (list1.length() > list2.length()) {
            shorterList = list2;
        }
        int diff = Math.abs(list1.length() - list2.length());
        for (int i = 0; i < diff; i++) {
            shorterList.add(0);
        }
    }

    LinkedList addTwoLists(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        ListNode p1 = list1.getHead();
        ListNode p2 = list2.getHead();
        int carryOver = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.data + p2.data;
            result.add((sum + carryOver) % 10);
            carryOver = sum / 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (carryOver > 0) {
            result.add(1);
        }
        return result;
    }

    int convertListToInt(LinkedList list) {
        int sum = 0;
        int pow = 0;
        ListNode node = list.getHead();
        while (node != null) {
            sum += node.data * Math.powExact(10, pow);
            node = node.next;
            pow += 1;
        }
        return sum;
    }

    int solve(LinkedList list1, LinkedList list2) {
        normalize(list1, list2);
        return convertListToInt(addTwoLists(list1, list2));
    }

    void main() {
//        LinkedList list1 = new LinkedList(new int[]{9,9,9});
//        LinkedList list2 = new LinkedList(new int[]{5,9,2});

        // follow up
        LinkedList list1 = new LinkedList(new int[]{6, 1, 7});
        list1.reverse();
        LinkedList list2 = new LinkedList(new int[]{2, 9, 5});
        list2.reverse();

        System.out.println(solve(list1, list2));
    }
}
