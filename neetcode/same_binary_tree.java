package org.example.neetcode;

import org.example.common.TreeNode;

public class same_binary_tree {
    boolean res = true;

    public void isSameTreeUtil(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        }
        if (p == null || q == null || p.val != q.val) {
            res = false;
            return;
        }
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        isSameTreeUtil(p, q);
        return this.res;
    }

    public boolean isSameTree_DFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree_DFS(p.left, q.left) && isSameTree_DFS(p.right, q.right);
    }

    void main() {
        // true
//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2);
//        p.right = new TreeNode(3);
//        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
//        q.right = new TreeNode(3);

        // false
//        TreeNode p = new TreeNode(4);
//        p.left = new TreeNode(7);
//        TreeNode q = new TreeNode(4);
//        q.right = new TreeNode(7);

        // true
//        TreeNode p = null;
//        TreeNode q = null;

        // false
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(3);
        q.right = new TreeNode(2);

        var x = isSameTree(p, q);
    }
}
