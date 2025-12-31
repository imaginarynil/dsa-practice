package org.example.ctci.trees_and_graphs;

public class successor {
    TreeNodeBidirectional successor(TreeNodeBidirectional root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return getLeftMostNode(root.right);
        }
        TreeNodeBidirectional node = root;
        TreeNodeBidirectional parent = root.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    TreeNodeBidirectional getLeftMostNode(TreeNodeBidirectional root) {
        TreeNodeBidirectional n = root;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    void main() {
        TreeNodeBidirectional root = new TreeNodeBidirectional(8);
        TreeNodeBidirectional target;

//        target = new TreeNodeBidirectional(3);
//        root.left = target;
        root.left = new TreeNodeBidirectional(3);
        root.left.parent = root;

        root.left.left = new TreeNodeBidirectional(1);
        root.left.left.parent = root.left;

        root.left.right = new TreeNodeBidirectional(6);
        root.left.right.parent = root.left;

        root.left.right.left = new TreeNodeBidirectional(4);
        root.left.right.left.parent = root.left.right;

        target = new TreeNodeBidirectional(7);
        root.left.right.right = target;
//        root.left.right.right = new TreeNodeBidirectional(7);
        root.left.right.right.parent = root.left.right;

        root.right = new TreeNodeBidirectional(10);
        root.right.parent = root;

        root.right.right = new TreeNodeBidirectional(14);
        root.right.right.parent = root.right;

        root.right.right.left = new TreeNodeBidirectional(13);
        root.right.right.left.parent = root.right.right;

        TreeNodeBidirectional x;
        x = successor(target);
    }

    public class TreeNodeBidirectional {
        public TreeNodeBidirectional parent;
        public TreeNodeBidirectional left;
        public TreeNodeBidirectional right;
        public int val;

        public TreeNodeBidirectional(int val) {
            this.val = val;
        }
    }
}
