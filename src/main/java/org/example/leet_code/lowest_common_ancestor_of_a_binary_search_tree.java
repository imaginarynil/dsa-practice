package org.example.leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lowest_common_ancestor_of_a_binary_search_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean solve(ArrayList<TreeNode> path, TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == target) {
            return true;
        }
        boolean pathExists = solve(path, root.left, target) || solve(path, root.right, target);
        if (pathExists) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode getIntersection(ArrayList<TreeNode> pathP, ArrayList<TreeNode> pathQ) {
        ArrayList<TreeNode> longerPath, shorterPath;
        if (pathP.size() < pathQ.size()) {
            longerPath = pathQ;
            shorterPath = pathP;
        } else {
            longerPath = pathP;
            shorterPath = pathQ;
        }
        int i = shorterPath.size() - 1;
        while (i >= 0 && longerPath.get(i).val != shorterPath.get(i).val) {
            i -= 1;
        }
        if (i >= 0) {
            return longerPath.get(i);
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<>();
        solve(pathP, root, p.val);

        ArrayList<TreeNode> pathQ = new ArrayList<>();
        solve(pathQ, root, q.val);

        return getIntersection(pathP, pathQ);
    }

    public TreeNode lowestCommonAncestor_Optimal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor_Optimal(root.left, p, q);
        TreeNode right = lowestCommonAncestor_Optimal(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return (left == null) ? right : left;
    }

    void main() {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = q;
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode x;
        x = lowestCommonAncestor_Optimal(root, p, q);
    }
}
