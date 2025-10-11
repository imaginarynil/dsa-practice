package org.example.linked_lists;

public class intersection {
    static boolean solve(LinkedList list1, LinkedList list2){
        ListNode p1 = list1.getHead();
        ListNode p2 = list2.getHead();
        // without hopping
        while(p1.next != null) {
            p1 = p1.next;
        }
        while(p2.next != null) {
            p2 = p2.next;
        }
        return p1 == p2;
    }

    static void main(){
        ListNode node = new ListNode(-1);
        LinkedList list1 = new LinkedList(new int[]{1,2,3,4,5,6});
        LinkedList list2 = new LinkedList(new int[]{4,5,6});
        list2.insertNode(node);
        list1.insertNode(node);
        list1.print();
        list2.print();
        System.out.println(solve(list1, list2));
    }
}
