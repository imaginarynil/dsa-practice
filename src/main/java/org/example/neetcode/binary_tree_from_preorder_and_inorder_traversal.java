package org.example.neetcode;

import org.example.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class binary_tree_from_preorder_and_inorder_traversal {
    // t: O(n^2)
    // s: O(n)
    public TreeNode buildTree_Solution1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree_Solution1(leftPre, leftIn);
        int[] rightPre = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
        root.right = buildTree_Solution1(rightPre, rightIn);
        return root;
    }

    int pi = 0;
    Map<Integer, Integer> m;

    TreeNode dfs(int[] preorder, int l, int r) {
        if(l > r) return null;
        int val = preorder[pi++];
        TreeNode root = new TreeNode(val);
        int mid = m.get(val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }

    // t: O(n), visit each element in preorder
    // s: O(n), hash map
    TreeNode buildTree_Solution2(int[] preorder, int[] inorder) {
        m = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    void main() {

    }
}
