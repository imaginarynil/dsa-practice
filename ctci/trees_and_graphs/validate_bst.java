package org.example.ctci.trees_and_graphs;

import org.example.common.TreeNode;

public class validate_bst {
    void _validateBst_Attempt_1(TreeNode root, boolean[] result) {
        if (root == null) {
            return;
        }
        if ((root.left != null && root.val <= root.left.val) || (root.right != null && root.val >= root.right.val)) {
            result[0] = false;
        }
        _validateBst_Attempt_1(root.left, result);
        _validateBst_Attempt_1(root.right, result);
    }

    // error: [5,4,6,null,null,3,7]
    boolean validateBst_Attempt_1(TreeNode root) {
        boolean[] result = new boolean[]{true};
        _validateBst_Attempt_1(root, result);
        return result[0];
    }

    boolean _validateBst_Solution_2(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val > max)) {
            return false;
        }
        return _validateBst_Solution_2(root.left, min, root.val) && _validateBst_Solution_2(root.right, root.val, max);
    }

    boolean validateBst_Solution_2(TreeNode root) {
        return _validateBst_Solution_2(root, null, null);
    }

    void main() {
        TreeNode root;
//        root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean x;
        x = validateBst_Solution_2(root);
    }
}
