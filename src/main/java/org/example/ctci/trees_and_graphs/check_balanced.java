package org.example.ctci.trees_and_graphs;


import org.example.ctci.trees_and_graphs.util.TreeNode;

public class check_balanced {
    int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    boolean checkBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return checkBalanced(root.left) && checkBalanced(root.right);
    }

    int _checkBalanced_Solution_2(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = _checkBalanced_Solution_2(root.left);
        if (left == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int right = _checkBalanced_Solution_2(root.right);
        if (right == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (Math.abs(left - right) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(left, right) + 1;
    }

    boolean checkBalanced_Solution_2(TreeNode root) {
        return _checkBalanced_Solution_2(root) != Integer.MIN_VALUE;
    }

    void main() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
//        root.right.right.right.right = new TreeNode(10);
        boolean x;
        x = checkBalanced_Solution_2(root);
    }
}
