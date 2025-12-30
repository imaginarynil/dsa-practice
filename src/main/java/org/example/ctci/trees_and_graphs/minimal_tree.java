package org.example.ctci.trees_and_graphs;

import org.example.ctci.trees_and_graphs.util.BinaryTree;
import org.example.ctci.trees_and_graphs.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class minimal_tree {
    BinaryTree solve(int[] arr) {
        Queue<Range> rangeQueue = new LinkedList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        nodes.add(mid);
        rangeQueue.add(new Range(0, mid - 1));
        rangeQueue.add(new Range(mid + 1, end));
        while (!rangeQueue.isEmpty()) {
            Range r = rangeQueue.remove();
            start = r.start;
            end = r.end;
            mid = start + (end - start) / 2;
            if (start > end) {
                continue;
            }
            nodes.add(mid);
            rangeQueue.add(new Range(start, mid - 1));
            rangeQueue.add(new Range(mid + 1, end));
        }
        BinaryTree bt = new BinaryTree();
        for (int x : nodes) {
            bt.add(x);
        }
        return bt;
    }

    TreeNode _minimalTree_Solution(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = _minimalTree_Solution(arr, start, mid - 1);
        node.right = _minimalTree_Solution(arr, mid + 1, end);
        return node;
    }

    TreeNode minimalTree_Solution(int[] arr) {
        return _minimalTree_Solution(arr, 0, arr.length - 1);
    }

    void main() {
        int[] arr = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        TreeNode root = minimalTree_Solution(arr);
    }

    public class Range {
        public int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
