package org.example.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class minimal_tree {
    static BinaryTree solve(int[] arr) {
        Queue<Range> rangeQueue = new LinkedList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        nodes.add(mid);
        rangeQueue.add(new Range(0, mid - 1));
        rangeQueue.add(new Range(mid + 1, end));
        while(!rangeQueue.isEmpty()) {
            Range r = rangeQueue.remove();
            start = r.start;
            end = r.end;
            mid = start + (end - start) / 2;
            if(start > end) {
                continue;
            }
            nodes.add(mid);
            rangeQueue.add(new Range(start, mid - 1));
            rangeQueue.add(new Range(mid + 1, end));
        }
        BinaryTree bt = new BinaryTree();
        for(int x: nodes) {
            bt.add(x);
        }
        return bt;
    }

    static void main() {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        var bt = solve(arr);
    }
}
