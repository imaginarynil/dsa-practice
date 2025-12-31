package org.example.leet_code;

import org.example.common.TreeNode;

public class balanced_binary_tree {
    int ERROR_CODE = -2;

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int _isBalanced_Optimal(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = _isBalanced_Optimal(root.left);
        if (left == ERROR_CODE) {
            return ERROR_CODE;
        }
        int right = _isBalanced_Optimal(root.right);
        if (right == ERROR_CODE) {
            return ERROR_CODE;
        }
        if (Math.abs(left - right) > 1) {
            return ERROR_CODE;
        }
        return Math.max(_isBalanced_Optimal(root.left), _isBalanced_Optimal(root.right)) + 1;
    }

    public boolean isBalanced_Optimal(TreeNode root) {
        int result = _isBalanced_Optimal(root);
        return result != ERROR_CODE;
    }

    void main() {
        TreeNode root;

//        root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

//        root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);

        boolean x;
        x = isBalanced(root);
    }
}
