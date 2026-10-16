package org.example.neetcode;

import org.example.common.TreeNode;

public class invert_a_binary_tree {
    public void invertTreeUtil(TreeNode root) {
        if(root == null) {
            return ;
        }
        invertTreeUtil(root.left);
        invertTreeUtil(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    // t: O()
    // s: O()
    public TreeNode invertTree(TreeNode root) {
        invertTreeUtil(root);
        return root;
    }
}
