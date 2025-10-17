package org.example.linked_lists;

import java.util.ArrayList;
import java.util.Stack;

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

    static boolean book_solution_2(LinkedList list) {
        ListNode p1 = list.getHead();
        // empty or only 1 element
        // https://www.khanacademy.org/computing/computer-science/algorithms/recursive-algorithms/a/using-recursion-to-determine-whether-a-word-is-a-palindrome
        if(p1 == null || p1.next == null) {
            return true;
        }
        ListNode p2 = list.getHead();
        Stack<Integer> stack = new Stack<>();
        // 1 2 3 4 5
        // 1 2 3 4
        while(p2 != null && p2.next != null) {
            stack.push(p1.data);
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // odd number of elements
        if(p2 != null) {
            p1 = p1.next;
        }
        while(p1 != null) {
            int top = stack.pop();
            if(p1.data != top) {
                return false;
            }
            p1 = p1.next;
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

        testSet.add(new palindrome_testcase(
                new LinkedList(new int[]{1, 2, 2, 1}),
                true
        ));

        for (palindrome_testcase tc : testSet) {
//            boolean result = solve(tc.list);
            tc.list.print();
            boolean result = book_solution_2(tc.list);
            System.out.printf("%b passed: %b\n", result, result == tc.answer);
        }
    }
}
