package org.example.leet_code;

public class merge_two_sorted_lists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return head;
    }

    public ListNode join(ListNode node1, ListNode node2) {
        node1.next = node2;
        return node1;
    }

    // optimal solution (lookup)
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode result = new ListNode(-1);
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                result = addNode(result, list1.val);
//                list1 = list1.next;
//            } else {
//                result = addNode(result, list2.val);
//                list2 = list2.next;
//            }
//        }
//        ListNode p = result;
//        while(p.next != null) {
//            p = p.next;
//        }
//        if(list1 != null) {
//            p = join(p, list1);
//        } else if(list2 != null) {
//            p = join(p, list2);
//        }
//        return result.next;
//    }

    // my solution
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result = addNode(result, list1.val);
                list1 = list1.next;
            } else {
                result = addNode(result, list2.val);
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            result = addNode(result, list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            result = addNode(result, list2.val);
            list2 = list2.next;
        }
        return result;
    }

    void main() {
        ListNode l1 = null;
        ListNode l2 = null;
        int[] arr1 = new int[]{1, 2, 4};
        int[] arr2 = new int[]{1, 3, 4};
        for (int i = 0; i < arr1.length; i++) {
            l1 = addNode(l1, arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            l2 = addNode(l2, arr2[i]);
        }
        var result = mergeTwoLists(l1, l2);
    }
}
