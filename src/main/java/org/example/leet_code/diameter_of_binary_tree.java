package org.example.leet_code;

import org.example.common.TreeNode;

public class diameter_of_binary_tree {
    int maxDiameter = 0;

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public int getDiameter(TreeNode root) {
        int leftHeight = getHeight(root.left) + 1;
        int rightHeight = getHeight(root.right) + 1;
        return leftHeight + rightHeight;
    }

    public void getMaxDiameter(TreeNode root, int[] max) {
        if (root == null) {
            return;
        }
        getMaxDiameter(root.left, max);
        getMaxDiameter(root.right, max);
        int diameter = getDiameter(root);
        max[0] = Math.max(diameter, max[0]);
    }

    public int diameterOfBinaryTree_Attempt_1(TreeNode root) {
        int[] max = {0};
        getMaxDiameter(root, max);
        return max[0];
    }

    public int _diameterOfBinaryTree_Solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // at the current node, find the max diameter (including the current node)
        int left = _diameterOfBinaryTree_Solution(root.left);
        int right = _diameterOfBinaryTree_Solution(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);

        // this is for returning to the **parent**
        return Math.max(_diameterOfBinaryTree_Solution(root.left), _diameterOfBinaryTree_Solution(root.right)) + 1;
    }

    public int diameterOfBinaryTree_Solution(TreeNode root) {
        _diameterOfBinaryTree_Solution(root);
        return maxDiameter;
    }

    void main() {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        var x = diameterOfBinaryTree(root);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        var x = diameterOfBinaryTree_Solution(root);
    }
}
