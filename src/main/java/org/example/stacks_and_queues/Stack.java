package org.example.stacks_and_queues;

import java.util.EmptyStackException;

public class Stack {
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private Node bottom;
    private int capacity = 0;
    private int size = 0;

    public Stack() {}

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void push(int data) {
        Node node = new Node(data);
        this.size += 1;
        if(this.top == null) {
            this.top = node;
            this.bottom = node;
            return;
        }
        node.next = this.top;
        this.top.prev = node;
        this.top = node;
    }

    public int pop() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        Node top = this.top;
        if(this.top.next != null) {
            this.top.next.prev = null;
        } else {
            this.bottom = null;
        }
        this.top = this.top.next;
        this.size -= 1;
        return top.data;
    }

    public int removeBottom() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        Node bottom = this.bottom;
        this.bottom = this.bottom.prev;
        if(this.bottom == null) {
            this.top = null;
        } else {
            this.bottom.next = null;
        }
        this.size -= 1;
        return bottom.data;
    }

    public int peek() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.top.data;
    }

    public int getBottom() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.bottom.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }
}
