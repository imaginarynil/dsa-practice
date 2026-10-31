package org.example.neetcode;

import org.example.common.TreeNode;

public class valid_binary_search_tree {

    boolean isValidBSTUtil(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
    }

    // t: O()
    // s: O()
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    void main() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        boolean res = isValidBST(root);
    }
}
