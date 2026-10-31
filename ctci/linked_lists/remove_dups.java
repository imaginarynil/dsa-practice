package org.example.ctci.linked_lists;

import org.example.common.ListNode;
import org.example.ctci.linked_lists.util.LinkedList;

import java.util.ArrayList;

/**
 * insight
 * p1 and p2, p1 = null and p2 = head
 * if not in the set, p1 is updated to p2
 * p2 moves every iteration
 * this is to deal with consecutive duplicates, e.g., 333
 */

public class remove_dups {
    void solve(LinkedList list) {
        boolean[] flag = new boolean[128];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }
        // fill here
        ListNode prevNode = null;
        ListNode currNode = list.getHead();
        while (currNode != null) {
            if (!flag[currNode.val]) {
                flag[currNode.val] = true;
                prevNode = currNode; // move p1 when not flagged
            } else {
                prevNode.next = currNode.next;
            }
            currNode = currNode.next;
        }
    }

    void removeDups_Solution(LinkedList list) {
        ListNode p1 = list.getHead();
        ListNode p2;
        while (p1 != null) {
            p2 = p1;
            while (p2.next != null) {
                if (p2.next.val == p1.val) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
    }

    void test() {
        ArrayList<TestCase> testSet = new ArrayList<>();
        testSet.add(new TestCase(new LinkedList(new int[]{3, 3}), new LinkedList(new int[]{3})));
        testSet.add(new TestCase(new LinkedList(new int[]{1, 3, 3}), new LinkedList(new int[]{1, 3})));
        testSet.add(new TestCase(new LinkedList(new int[]{3, 1, 3}), new LinkedList(new int[]{3, 1})));
        testSet.add(new TestCase(new LinkedList(new int[]{3, 3, 1, 1}), new LinkedList(new int[]{3, 1})));
        testSet.add(new TestCase(new LinkedList(new int[]{1, 3, 3, 3, 4, 4, 4}), new LinkedList(new int[]{1, 3, 4})));
        for (TestCase tc : testSet) {
            tc.input.print();
            tc.output.print();

//            solve(tc.input);
            removeDups_Solution(tc.input);

            System.out.println("result:");
            tc.input.print();

            System.out.println(tc.input.compare(tc.output));
        }
    }

    void main() {
        test();
    }

    class TestCase {
        public LinkedList input;
        public LinkedList output;

        public TestCase(
                LinkedList input,
                LinkedList output
        ) {
            this.input = input;
            this.output = output;
        }
    }
}

