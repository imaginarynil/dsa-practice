package org.example.leet_code;

import java.util.Stack;

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    void transfer() {
        while(!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
    }

    public int pop() {
        if(this.s2.isEmpty()) {
            this.transfer();
        }
        return this.s2.pop();
    }

    public int peek() {
        if(this.s2.isEmpty()) {
            this.transfer();
        }
        return this.s2.peek();
    }

    public boolean empty() {
        return this.s2.size() + this.s1.size() == 0;
    }
}

public class implement_queue_using_stacks {
    void main() {
        MyQueue myQueue = new MyQueue();
        int x;
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        x = myQueue.peek(); // return 1
        x = myQueue.pop(); // return 1, queue is [2]
        boolean b;
        b = myQueue.empty(); // return false
    }
}
