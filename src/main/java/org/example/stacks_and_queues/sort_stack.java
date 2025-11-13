package org.example.stacks_and_queues;

import org.example.linked_lists.ListNode;
import java.util.Stack;

import java.util.EmptyStackException;

class SortStack {
    ListNode head = null;

    public void push(int data) {
        if(this.head == null) {
            ListNode node = new ListNode(data);
            this.head = node;
            return;
        }
        ListNode node = this.head;
        ListNode newNode = new ListNode(data);
        if(data < node.data) {
            newNode.next = node;
            this.head = newNode;
            return;
        }
        while(node.next != null && node.next.data < data) {
            node = node.next;
        }
        if(node.next == null) {
            node.next = newNode;
        } else {
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public int pop() {
        if(this.head == null) {
            throw new EmptyStackException();
        }
        ListNode currentHead = this.head;
        this.head = currentHead.next;
        currentHead.next = null;
        return currentHead.data;
    }

    public int peek() {
        return this.head.data;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}

class SortStackBookSolution {
    Stack<Integer> stack = new Stack<>();

    public void sort() {
        Stack<Integer> tmpStack = new Stack<>();
        while(!this.stack.isEmpty()) {
            int top = this.stack.pop();
            while(!tmpStack.isEmpty() && tmpStack.peek() > top) {
                this.stack.push(tmpStack.pop());
            }
            tmpStack.push(top);
        }
        while(!tmpStack.isEmpty()) {
            this.stack.push(tmpStack.pop());
        }
    }

    public void push(int data) {
        this.stack.push(data);
    }

    public int pop() {
        return this.stack.pop();
    }

    public int peek() {
        return this.stack.peek();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}

public class sort_stack {
    static void solve(){
        var sortStack = new SortStackBookSolution();
        sortStack.push(1);
        sortStack.push(2);
        sortStack.push(3);
        sortStack.push(4);
        sortStack.push(5);
        sortStack.sort();
        int peek = sortStack.peek();
        int pop = sortStack.pop();
        boolean isEmpty = sortStack.isEmpty();
    }

    static void main(){
        solve();
    }
}
