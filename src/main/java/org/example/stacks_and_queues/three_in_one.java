package org.example.stacks_and_queues;

import java.util.ArrayList;

class ThreeStacks {
    class StackLimit {
        int start;
        int end;

        public StackLimit(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    int[] array;
    StackLimit[] limits = new StackLimit[3];

    public ThreeStacks(int arraySize) {
        array = new int[arraySize];
        int index = 0;
        int offset = arraySize / 3;
        for(int i = 0; i < this.limits.length; i++) {
            limits[i] = new StackLimit(index, index + offset - 1);
            index += arraySize;
        }
    }

    public int pop(int stackIndex) {
        var limit = this.limits[stackIndex];
        int data = this.array[limit.start];
        for(int i = 1; i <= limit.end; i++) {
            this.array[i - 1] = this.array[i];
        }
        return data;
    }

    
}

public class three_in_one {
}
