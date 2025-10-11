package org.example.linked_lists;

public class loop_detection {
    static boolean isCircular(LinkedList list){
        ListNode p1 = list.getHead();
        if(p1.next == p1) return true;
        ListNode p2 = p1.next;
        if(p2 == null || p2.next == null) return false;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                System.out.println(p1.data);
                return true;
            }
        }
        return false;
    }

    static void main(){
        // cyclical list
//        LinkedList list = new LinkedList(new int[]{1,2,3,4,5});
//        ListNode node3 = list.getNode(3);
//        ListNode node5 = list.getNode(5);
//        node5.next = node3;

//        LinkedList list = new LinkedList(new int[]{1});
//        ListNode node1 = list.getNode(1);
//        node1.next = list.getHead();

//        LinkedList list = new LinkedList(new int[]{1,2});
//        ListNode node2 = list.getNode(2);
//        node2.next = list.getHead();

        for(int i = 1; i <= 9; i++) {
            LinkedList list = new LinkedList(new int[]{1,2,3,4,5,6,7,8,9});
            ListNode corrupted = list.getNode(i);
            list.getTail().next = corrupted;
            System.out.printf("%d %b\n",i, isCircular(list));
        }

//        System.out.println(isCircular(list));
    }
}
