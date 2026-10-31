package org.example.neetcode;

import org.example.common.TreeNode;

public class binary_tree_diameter {
    private int res = 0;

    public int _diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = _diameterOfBinaryTree(root.left);
        int right = _diameterOfBinaryTree(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }


    int diameterOfBinaryTree(TreeNode root) {
        _diameterOfBinaryTree(root);
        return this.res;
    }
}
