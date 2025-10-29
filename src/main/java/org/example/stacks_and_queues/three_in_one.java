package org.example.stacks_and_queues;

import java.util.EmptyStackException;

class ThreeStacks {
    class StackInfo {
        int start;
        int end;
        int length;

        public StackInfo(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = 0;
        }
    }

    int[] array;
    StackInfo[] stackInfos = new StackInfo[3];
    int offset;

    public ThreeStacks(int arrayLength) {
        this.array = new int[arrayLength];
        int index = 0;
        this.offset = arrayLength / 3;
        for (int i = 0; i < this.stackInfos.length; i++) {
            stackInfos[i] = new StackInfo(index, index + this.offset - 1);
            index += this.offset;
        }
    }

    public int pop(int stackIndex) {
        var info = this.stackInfos[stackIndex];
        if (info.length == 0) {
            throw new EmptyStackException();
        }
        int data = this.array[info.start];
        for (int i = info.start + 1; i <= info.end; i++) {
            this.array[i - 1] = this.array[i];
        }
        info.length -= 1;
        return data;
    }

    public void push(int stackIndex, int data) {
        var info = this.stackInfos[stackIndex];
        if (info.length == this.offset) {
            throw new StackOverflowError();
        }
        for (int i = info.end; i > info.start; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[info.start] = data;
        info.length += 1;
    }

    public int peek(int stackIndex) {
        var info = this.stackInfos[stackIndex];
        if (info.length == 0) {
            throw new EmptyStackException();
        }
        return this.array[info.start];
    }

    public boolean isEmpty(int stackIndex) {
        var info = this.stackInfos[stackIndex];
        return info.length == 0;
    }

    public void print(int stackIndex) {
        var info = this.stackInfos[stackIndex];
        for(int i = 0; i < info.length; i++) {
            System.out.printf("%d ", this.array[info.start + i]);
        }
        System.out.println();
    }
}

public class three_in_one {
    static void main() {
        var threeStacks = new ThreeStacks(15);
        threeStacks.push(0, 1);
        threeStacks.push(1, 1);
        threeStacks.push(1, 2);
        threeStacks.push(2, 1);
        threeStacks.push(2, 2);
        threeStacks.push(2, 3);

        System.out.println(threeStacks.peek(0));
        System.out.println(threeStacks.peek(1));
        System.out.println(threeStacks.peek(2));

        threeStacks.print(0);
        threeStacks.print(1);
        threeStacks.print(2);
    }
}
