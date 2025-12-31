package org.example.ctci.trees_and_graphs;

import org.example.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class check_subtree {
    ArrayList<TreeNode> toBfsArray(TreeNode root) {
        ArrayList<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        result.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            TreeNode[] children = {node.left, node.right};
            for (TreeNode child : children) {
                if (child != null) {
                    q.add(child);
                    result.add(child);
                }
            }
        }
        return result;
    }

    boolean isSubTree(ArrayList<TreeNode> t1Arr, ArrayList<TreeNode> t2Arr, int t1Index) {
        int i = 0;
        while (i < t2Arr.size() && t1Index < t1Arr.size()) {
            if (t1Arr.get(t1Index).val != t2Arr.get(i).val) {
                return false;
            }
            i++;
            t1Index++;
        }
        // t2Arr is finished but t1Arr is not finished
        return i >= t2Arr.size() || t1Index < t1Arr.size();
    }

    boolean checkSubtree_Attempt_1(TreeNode t1Root, TreeNode t2Root) {
        ArrayList<TreeNode> t1Arr = toBfsArray(t1Root);
        ArrayList<TreeNode> t2Arr = toBfsArray(t2Root);
        for (int i = 0; i < t1Arr.size(); i++) {
            if (t1Arr.size() - i < t2Arr.size()) {
                return false;
            }
            if (isSubTree(t1Arr, t2Arr, i)) {
                return true;
            }
        }
        return false;
    }

    void getInOrderStr(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("x");
            return;
        }
        sb.append(root.val + " ");
        getInOrderStr(root.left, sb);
        getInOrderStr(root.right, sb);
    }

    /*
     * store t1 and t2 as strings. traverse each tree in-order. check if t2 is a substring of t1 */
    boolean checkSubtree_Solution_Simple(TreeNode t1Root, TreeNode t2Root) {
        StringBuilder t1Sb = new StringBuilder();
        StringBuilder t2Sb = new StringBuilder();
        getInOrderStr(t1Root, t1Sb);
        getInOrderStr(t2Root, t2Sb);
        return t1Sb.indexOf(t2Sb.toString()) != -1;
    }

    boolean matchTree(TreeNode t1Node, TreeNode t2Node) {
        if (t1Node == null || t2Node == null) {
            return false;
        }
        if (t1Node == null && t2Node == null) {
            return true;
        }
        if (t1Node.val != t2Node.val) {
            return false;
        }
        return matchTree(t1Node.left, t2Node.left) && matchTree(t1Node.right, t2Node.right);
    }

    boolean isSubTree(TreeNode root, TreeNode t2Root) {
        if (root == null) {
            return false;
        }
        if (root.val == t2Root.val && matchTree(root, t2Root)) {
            return true;
        }
        return isSubTree(root.left, t2Root) || isSubTree(root.right, t2Root);
    }

    boolean checkSubtree_Solution_Alternative(TreeNode t1Root, TreeNode t2Root) {
        if (t2Root == null) {
            return true;
        }
        return isSubTree(t1Root, t2Root);
    }

    void main() {
        TreeNode t1Root = new TreeNode(4);
        t1Root.left = new TreeNode(2);
        t1Root.right = new TreeNode(7);
//        t1Root.left.left = new TreeNode(1);
//        t1Root.left.right = new TreeNode(3);
//        t1Root.right.left = new TreeNode(5);
//        t1Root.right.right = new TreeNode(8);
//        t1Root.right.right.right = new TreeNode(9);

        TreeNode t2Root = new TreeNode(7);
//        t2Root.left = new TreeNode(5);
//        t2Root.right = new TreeNode(8);
//        t2Root.right.right = new TreeNode(9);

        var x = checkSubtree_Solution_Alternative(t1Root, t2Root);
    }
}
