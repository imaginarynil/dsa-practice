package org.example.algorithm;

public class binary_search_tree {
    TreeNode createTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val <= root.val) {
            root.left = createTree(root.left, val);
        } else {
            root.right = createTree(root.right, val);
        }
        return root;
    }

    void main() {
        int[] arr = new int[]{8, 3, 10, 1, 4};
        TreeNode root = null;
        for (int x : arr) {
            root = createTree(root, x);
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
