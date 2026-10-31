package org.example.ctci.linked_lists.util;

import org.example.common.ListNode;

public class LinkedList {
    private ListNode head = null;
    private ListNode tail = null;
    private int length = 0;

    public LinkedList() {

    }

    public LinkedList(int[] arr) {
        for (int i : arr) {
            this.add(i);
        }
        this.length = arr.length;
    }

    public ListNode getHead() {
        return this.head;
    }

    public void setHead(ListNode head) {
        ListNode currentHead = this.head;
        head.next = this.head;
        this.head = head;
        if (currentHead == null) {
            this.tail = this.head;
        }
    }

    public void pushBack(ListNode node) {
        if (this.tail != null) {
            this.tail.next = node;
        }
        int add = 0;
        ListNode currNode = this.tail.next;
        while (currNode != null) {
            add += 1;
            currNode = currNode.next;
        }
        this.length += add;
    }

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        ListNode currentNode = this.head;
        if (currentNode == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        this.length += 1;
    }

    public ListNode getNode(int data) {
        ListNode node = this.head;
        while (node != null) {
            if (node.val == data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode getTail() {
//        ListNode node = this.head;
//        if(node == null) {
//            return null;
//        }
//        while(node.next != null) {
//            node = node.next;
//        }
//        return node;
        return this.tail;
    }

    public boolean compare(LinkedList otherList) {
        ListNode p1 = this.head;
        ListNode p2 = otherList.getHead();
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null && p2 == null;
    }

//    ListNode p1 = this.getHead();
//    ListNode p2 = otherList.getHead();
//        while (p1 != null && p2 != null) {
//        if (p1.data != p2.data) {
//            return false;
//        }
//        p1 = p1.next;
//        p2 = p2.next;
//    }
//        return p1 == null && p2 == null;

    public int length() {
        return length;
    }

    public void print() {
        ListNode currentNode = this.head;
        while (currentNode != null) {
            System.out.printf("%d ", currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // add a "node" object instead of a value
    public void insertNode(ListNode node) {
        ListNode p = this.head;
        if (p == null) {
            return;
        }
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        this.length += 1;
        // node.next == null by constructor
    }

    // 1 2 3 4 5
    public void reverse() {
        // iterative
        ListNode prevNode = null;
        ListNode currentNode = this.head;
        if (this.head == null) {
            return;
        }
        ListNode oldNext = null;
        while (currentNode != null) {
            oldNext = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = oldNext;
        }
        this.head = prevNode;
    }

    void main() {
        LinkedList list = new LinkedList(new int[]{10, 9, 8, 8, 1, 2, 3});
        list.reverse();
        list.print();
    }
}
