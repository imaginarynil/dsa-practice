package org.example.ctci.stacks_and_queues;

import java.util.EmptyStackException;

class StackMin {
    Node top = null;
    Node minNode = null;

    public void push(int data) {
        Node node = new Node(data);
        if (this.top == null) {
            this.top = node;
            this.minNode = node;
            return;
        }
        node.next = this.top;
        this.top = node;
        if (node.data < this.minNode.data) {
            Node currMinNode = this.minNode;
            node.minNext = currMinNode;
            currMinNode.minPrev = node;
            this.minNode = node;
        } else {
            Node p = this.minNode;
            while (p.minNext != null) {
                p = p.minNext;
            }
            p.minNext = node;
            node.minPrev = p;
        }
    }

    public int pop() {
        if (this.top == null) {
            throw new EmptyStackException();
        }
        Node poppedNode = this.top;
        if (poppedNode == this.minNode) {
            this.minNode = this.minNode.minNext;
        } else {
            poppedNode.minPrev.minNext = poppedNode.minNext;
            poppedNode.minPrev = null;
            poppedNode.minNext = null;
        }
        this.top = this.top.next;
        return poppedNode.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int min() {
        return this.minNode.data;
    }

    class Node {
        int data;
        Node next = null;
        Node minNext = null;
        Node minPrev = null;

        public Node(int data) {
            this.data = data;
        }
    }
}

public class stack_min {
    void main() {
        StackMin sm = new StackMin();
        sm.push(0);
        sm.push(1);
        sm.push(2);
        sm.push(-1);
        System.out.println("min: " + sm.min());
        while (!sm.isEmpty()) {
            System.out.println("min: " + sm.min());
            System.out.println(sm.pop());
        }
    }
}
