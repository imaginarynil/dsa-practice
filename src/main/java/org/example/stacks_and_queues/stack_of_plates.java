package org.example.stacks_and_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

class SetOfStacks {
    private Stack<Stack<Integer>> stacks;
    private int threshold;

    public SetOfStacks(int threshold) {
        this.stacks = new Stack<>();
        this.threshold = threshold;
    }

    public void push(int data) {
        if (this.stacks.isEmpty()) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(data);
            this.stacks.push(newStack);
            return;
        }
        Stack<Integer> latestStack = this.stacks.peek();
        if (latestStack.size() < this.threshold) {
            latestStack.push(data);
        } else {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(data);
            this.stacks.push(newStack);
        }
    }

    public int pop() {
        if (this.stacks.isEmpty()) {
            throw new EmptyStackException();
        }
        Stack<Integer> latestStack = this.stacks.peek();
        int data = latestStack.pop();
        if (latestStack.isEmpty()) {
            this.stacks.pop();
        }
        return data;
    }

    public int popAt(int index) {
        if (this.stacks.isEmpty() || index >= this.stacks.size()) {
            throw new EmptyStackException();
        }
        Stack<Integer> targetStack = this.stacks.get(index);
        int data = targetStack.pop();
        if (targetStack.isEmpty()) {
            this.stacks.remove(index);
        }
        return data;
    }
}

public class stack_of_plates {
    static void solve(int[] arr) {
        SetOfStacks ss = new SetOfStacks(4);
        for (int el : arr) {
            ss.push(el);
        }
        for(int i = 0; i < 4; i++) {
//            ss.pop();
            ss.popAt(1);
        }
//        int x = ss.popAt(1);
    }

    static void main() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        solve(arr);
    }
}
