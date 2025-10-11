package org.example.linked_lists;

import java.util.ArrayList;

class palindrome_testcase {
    LinkedList list;
    boolean answer;

    public palindrome_testcase(
            LinkedList list,
            boolean answer
    ) {
        this.list = list;
        this.answer = answer;
    }
}

public class palindrome {
    static void createReversedList(LinkedList newList, ListNode node) {
        if (node.next == null) {
            newList.add(node.data);
            return;
        }
        createReversedList(newList, node.next);
        newList.add(node.data);
    }

    static boolean solve(LinkedList list) {
        list.print();
        LinkedList newList = new LinkedList();
        createReversedList(newList, list.getHead());
        newList.print();
        ListNode p1 = list.getHead();
        ListNode p2 = newList.getHead();
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    static void main() {
        ArrayList<palindrome_testcase> testSet = new ArrayList<>();
        testSet.add(new palindrome_testcase(
                new LinkedList(new int[]{1, 2, 3, 2, 1}),
                true
        ));
        testSet.add(new palindrome_testcase(
                new LinkedList(new int[]{1, 2, 3, 3, 3}),
                false
        ));
        for (palindrome_testcase tc : testSet) {
            boolean result = solve(tc.list);
            System.out.printf("%b %b\n", result, result == tc.answer);
        }
    }
}
