package org.example.neetcode;

import org.example.common.TreeNode;

public class subtree_of_a_binary_tree {
    boolean res = false;

    // t: O()
    // s: O()
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public void isSubtreeUtil(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return;
        }
        if(isSame(root, subRoot)) {
            res = true;
            return;
        }
        isSubtreeUtil(root.left, subRoot);
        isSubtreeUtil(root.right, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        isSubtreeUtil(root, subRoot);
        return this.res;
    }

    public boolean isSubtree_DFS(TreeNode root, TreeNode subRoot) {
        // an empty tree is a subtree of a tree
        if(subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(isSame(root, subRoot)) {
            return true;
        }
        return isSubtree_DFS(root.left, subRoot) || isSubtree_DFS(root.right, subRoot);
    }

    void main() {
        // true
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right = new TreeNode(3);
//
//        TreeNode subRoot = new TreeNode(2);
//        subRoot.left = new TreeNode(4);
//        subRoot.right = new TreeNode(5);

        // false
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(4);
        subRoot.right = new TreeNode(5);

        // true
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        TreeNode subRoot = new TreeNode(1);
//        subRoot.left = new TreeNode(2);
//        subRoot.right = new TreeNode(3);

        var x = isSubtree(subRoot, subRoot);
    }
}
