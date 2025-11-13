package org.example.stacks_and_queues;

import java.util.Stack;

class QueueViaStacksBookSolution {
    Stack<Integer> stackNewest = new Stack<>();
    Stack<Integer> stackOldest = new Stack<>();

    public int size() {
        return this.stackNewest.size() + this.stackOldest.size();
    }

    public void add(int data) {
        this.stackNewest.push(data);
    }

    private void moveToOldest() {
        if(this.stackOldest.isEmpty()) {
            while(!this.stackNewest.isEmpty()) {
                this.stackOldest.push(this.stackNewest.pop());
            }
        }
    }

    public int peek() {
        this.moveToOldest();
        return this.stackOldest.peek();
    }

    public int pop() {
        this.moveToOldest();
        return this.stackOldest.pop();
    }
}

public class queue_via_stacks {
    static void solve() {
        var queue = new QueueViaStacksBookSolution();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        int x = queue.peek();
        x = queue.pop();
        queue.add(5);
    }

    static void main() {
        solve();
    }
}
