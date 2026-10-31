package org.example.algorithm;

public class tree_height_and_depth {
    int calculateHeight(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.height != -1) {
            return root.height;
        }
        int height = Math.max(calculateHeight(root.left), calculateHeight(root.right)) + 1;
        if (root.height == -1) {
            root.height = height;
        }
        return height;
    }

    void calculateDepth(Node root, int depth) {
        if (root == null) {
            return;
        }
        root.depth = depth;
        calculateDepth(root.left, depth + 1);
        calculateDepth(root.right, depth + 1);
    }

    void getHeight(Node root, int val, int[] result) {
        if (root == null) {
            return;
        }
        if (result[0] != -1) {
            return;
        }
        if (root.val == val) {
            result[0] = root.height;
            return;
        }
        getHeight(root.left, val, result);
        getHeight(root.right, val, result);
    }

    Node buildTree(Node root) {
        root = new Node(5);
        Node p = root;
        p.left = new Node(2);
        p.right = new Node(7);
        // left subtree
        p = p.left;
        p.left = new Node(1);
        p.right = new Node(3);
        p = p.right;
        p.right = new Node(4);
        // right subtree
        p = root.right;
        p.left = new Node(6);
        p.right = new Node(18);
        p = p.right;
        p.left = new Node(10);
        p.right = new Node(9);
        p = p.left;
        p.right = new Node(13);
        return root;
    }

    void main() {
        Node root = null;
        root = buildTree(root);
        calculateHeight(root);
        int[] result = new int[1];
        result[0] = -1;
        getHeight(root, 18, result);
        result[0] = -1;
        getHeight(root, 4, result);
        result[0] = -1;
        getHeight(root, 5, result);
        calculateDepth(root, 0);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public int height = -1;
        public int depth = -1;

        public Node(int val) {
            this.val = val;
        }
    }
}
