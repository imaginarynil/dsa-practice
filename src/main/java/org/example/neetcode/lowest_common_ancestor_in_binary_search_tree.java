package org.example.neetcode;

import org.example.common.TreeNode;

public class lowest_common_ancestor_in_binary_search_tree {
    // t: O()
    // s: O()
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }
        if(Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    void main() {

    }
}
