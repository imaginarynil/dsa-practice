package org.example.ctci.trees_and_graphs;

import org.example.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class bst_sequences {
    ArrayList<LinkedList<Integer>> bstSequences(TreeNode root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);
        ArrayList<LinkedList<Integer>> leftSeq = bstSequences(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = bstSequences(root.right);
        for (LinkedList<Integer> leftList : leftSeq) {
            for (LinkedList<Integer> rightList : rightSeq) {
                ArrayList<LinkedList<Integer>> results = new ArrayList<>();
                weave(results, leftList, rightList, prefix);
                result.addAll(results);
            }
        }
        return result;
    }

    void weave(
            ArrayList<LinkedList<Integer>> results,
            LinkedList<Integer> first,
            LinkedList<Integer> second,
            LinkedList<Integer> prefix
    ) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int firstHead = first.removeFirst();
        prefix.add(firstHead);
        weave(results, first, second, prefix);
        prefix.removeLast();
        first.addFirst(firstHead);

        int secondHead = second.removeFirst();
        prefix.add(secondHead);
        weave(results, first, second, prefix);
        prefix.removeLast();
        second.addFirst(secondHead);
    }

    void main() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(25);
        var result = bstSequences(root);
    }
}
