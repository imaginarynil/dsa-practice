package org.example.ctci.trees_and_graphs;

import org.example.common.TreeNode;
import org.example.ctci.trees_and_graphs.util.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class list_of_depths {
    void updateLists(BinaryTree.Node node, ArrayList[] lists) {
        if (node != null) {
            lists[node.depth].add(node.data);
            updateLists(node.left, lists);
            updateLists(node.right, lists);
        }
    }

    void solve(BinaryTree bt) {
        bt.updateDepthPreOrder();
        int depth = bt.getMaxDepth();
        ArrayList<Integer>[] lists = new ArrayList[depth + 1]; // includes 0
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        updateLists(bt.getRoot(), lists);
        for (int i = 0; i < lists.length; i++) {
            System.out.printf("%d ", i);
            for (int data : lists[i]) {
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
    }

    void _listOfDepths_Solution(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int depth) {
        if (root == null) {
            return;
        }
        if (lists.size() == depth) {
            lists.add(new LinkedList<>());
        }
        lists.get(depth).add(root);
        _listOfDepths_Solution(root.left, lists, depth + 1);
        _listOfDepths_Solution(root.right, lists, depth + 1);
    }

    ArrayList<LinkedList<TreeNode>> listOfDepths_Solution(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        _listOfDepths_Solution(root, lists, 0);
        return lists;
    }

    void main() {
//        BinaryTree bt = new BinaryTree();
//        bt.add(4);
//        bt.add(2);
//        bt.add(7);
//        bt.add(1);
//        bt.add(3);
//        bt.add(5);
//        bt.add(8);
//        bt.add(0);
//        bt.add(6);
//        bt.add(9);
//        solve(bt);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        ArrayList<LinkedList<TreeNode>> x;
        x = listOfDepths_Solution(root);
    }
}
