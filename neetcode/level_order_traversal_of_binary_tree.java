package org.example.neetcode;

import org.example.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class level_order_traversal_of_binary_tree {
    // t: O(n)
    // s: O(n), queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            List<Integer> l  = new ArrayList<>();
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if(cur != null) {
                    l.add(cur.val);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            if(l.size() > 0) {
                ans.add(l);
            }
        }
        return ans;
    }

    void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.right = new TreeNode(3);
        levelOrder(root);
    }
}
