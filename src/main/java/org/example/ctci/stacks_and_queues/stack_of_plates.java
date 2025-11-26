package org.example.ctci.stacks_and_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


public class stack_of_plates {
    void solve(int[] arr) {
        var ss = new SetOfStacks_Solution(3);
        for (int el : arr) {
            ss.push(el);
        }
        ss.popAt(0, true);
    }

    void main() {
        int[] arr = new int[]{3, 2, 1, 6, 5, 4, 7};
        solve(arr);
    }

    class SetOfStacks {
        private final Stack<Stack<Integer>> stacks;
        private final int threshold;

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

    class SetOfStacks_Solution {
        private final int capacity;
        ArrayList<org.example.ctci.stacks_and_queues.Stack> stacks = new ArrayList<>();

        public SetOfStacks_Solution(int capacity) {
            this.capacity = capacity;
        }

        public org.example.ctci.stacks_and_queues.Stack getLastStack() {
            if (this.stacks.size() == 0) {
                return null;
            }
            return this.stacks.get(stacks.size() - 1);
        }

        public void push(int data) {
            var stack = this.getLastStack();
            if (stack != null && !stack.isFull()) {
                stack.push(data);
                return;
            }
            var newStack = new org.example.ctci.stacks_and_queues.Stack(this.capacity);
            newStack.push(data);
            this.stacks.add(newStack);
        }

        public int pop() {
            var stack = this.getLastStack();
            if (stack == null) {
                throw new EmptyStackException();
            }
            int data = stack.pop();
            if (stack.isEmpty()) {
                this.stacks.remove(this.stacks.size() - 1);
            }
            return data;
        }

        public int popAt(int index, boolean popTop) {
            var stack = this.stacks.get(index);
            int removedItem;
            if (popTop) {
                removedItem = stack.pop();
            } else {
                removedItem = stack.removeBottom();
            }
            if (stack.isEmpty()) {
                this.stacks.remove(index);
            } else if (this.stacks.size() - 1 > index) {
                int data = this.popAt(index + 1, false);
                stack.push(data);
            }
            return removedItem;
        }

        public boolean isEmpty() {
            var stack = this.getLastStack();
            return stack == null || stack.isEmpty();
        }
    }
}
