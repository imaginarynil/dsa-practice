package org.example.leet_code;

public class validate_binary_search_tree {
    public boolean _isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return _isValidBST(root.left, min, root.val) && _isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
