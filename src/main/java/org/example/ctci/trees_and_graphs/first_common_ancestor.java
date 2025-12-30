package org.example.ctci.trees_and_graphs;

import org.example.ctci.trees_and_graphs.util.BinaryTree;

public class first_common_ancestor {
    void firstCommonAncestor(BinaryTree bt) {
        var solution = new FirstCommonAncestor();
        solution.solve(bt.getRoot(), 5, 18);
        var result = solution.commonAncestor;
    }

    BinaryTree.Node firstCommonAncestor_Optimal(BinaryTree.Node root, BinaryTree.Node p, BinaryTree.Node q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        BinaryTree.Node left = firstCommonAncestor_Optimal(root.left, p, q);
        BinaryTree.Node right = firstCommonAncestor_Optimal(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    void main() {
        BinaryTree bt = new BinaryTree();
//        bt.add(4);
//        bt.add(2);
//        bt.add(6);
//        bt.add(1);
//        bt.add(3);
//        bt.add(5);
//        bt.add(17);
//        bt.add(8);
//        bt.add(18);
//        BinaryTree.Node root = firstCommonAncestor_Optimal(
//                bt.getRoot(),
//                bt.getRoot().right.left,
//                bt.getRoot().right.right.right
//        );
        bt.add(4);
        bt.add(2);
        bt.add(6);
        bt.add(1);
        bt.add(3);
        BinaryTree.Node root = firstCommonAncestor_Optimal(
                bt.getRoot(),
                bt.getRoot().left,
                bt.getRoot().left.right
        );
    }

    class FirstCommonAncestor {
        public BinaryTree.Node commonAncestor;
        boolean n1Found = false;
        boolean n2Found = false;

        void traverseSubTree(BinaryTree.Node node, int val1, int val2) {
            if (node == null) {
                return;
            }
            if (node.data == val1) {
                n1Found = true;
            }
            if (node.data == val2) {
                n2Found = true;
            }
            this.traverseSubTree(node.left, val1, val2);
            this.traverseSubTree(node.right, val1, val2);
        }

        void resetFlags() {
            this.n1Found = false;
            this.n2Found = false;
        }

        void solve(BinaryTree.Node node, int val1, int val2) {
            if (node == null) {
                return;
            }
            this.resetFlags();
            this.traverseSubTree(node, val1, val2);
            if (this.n1Found && this.n2Found) {
                this.commonAncestor = node;
            } else {
                return;
            }
            this.solve(node.left, val1, val2);
            this.solve(node.right, val1, val2);
        }
    }
}
