package org.example.linked_lists;

public class LinkedList {
    private ListNode head;
    private int length = 0;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int[] arr) {
        for(int i: arr) {
            this.add(i);
        }
        this.length = arr.length;
    }

    public ListNode getHead() {
        return this.head;
    }

    public void setHead(ListNode head) {
        ListNode tmp = this.head;
        head.next = tmp;
        this.head = head;
    }

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        ListNode currentNode = this.head;
        if (currentNode == null) {
            this.head = newNode;
            return;
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        this.length += 1;
    }

    public ListNode getNode(int data) {
        ListNode node = this.head;
        while(node != null) {
            if(node.data == data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode getTail() {
        ListNode node = this.head;
        if(node == null) {
            return null;
        }
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }

    public boolean compare(LinkedList otherList) {
        ListNode p1 = this.getHead();
        ListNode p2 = otherList.getHead();
        while(p1 != null && p2 != null) {
            if(p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null && p2 == null;
    }

    public int length() {
        return length;
    }

    public void print() {
        ListNode currentNode = this.head;
        while(currentNode != null) {
            System.out.printf("%d ", currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void insertNode(ListNode node) {
        ListNode p = this.head;
        if(p==null) {
            return;
        }
        while(p.next != null) {
            p = p.next;
        }
        p.next = node;
        // node.next == null by constructor
    }
}