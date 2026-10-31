package org.example.ctci.trees_and_graphs.util;

public class BinaryTree {
    private Node root = null;
    private int maxDepth = 0;

    // assumption: root is established
    public Node _add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data <= node.data) {
            node.left = _add(node.left, data);
        } else {
            node.right = _add(node.right, data);
        }
        return node;
    }

    public Node getRoot() {
        return this.root;
    }

    public void add(int data) {
        this.root = _add(this.root, data);
    }

    public void _printPreOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            _printPreOrder(node.left);
            _printPreOrder(node.right);
        } else {
            System.out.println("null");
        }
    }

    public void _updateDepthPreOrder(Node node, int depth) {
        if (node != null) {
            node.depth = depth;
            _updateDepthPreOrder(node.left, depth + 1);
            _updateDepthPreOrder(node.right, depth + 1);
        }
    }

    public void updateDepthPreOrder() {
        this._updateDepthPreOrder(this.root, 0);
    }

    public int _updateHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int height = Math.max(_updateHeight(node.left), _updateHeight(node.right)) + 1;
        node.height = height;
        return height;
    }

    public void updateHeight() {
        this._updateHeight(this.root);
    }

    public void _getMaxDepth(Node node) {
        if (node != null) {
            this._getMaxDepth(node.left);
            this._getMaxDepth(node.right);
            if (this.maxDepth < node.depth) {
                this.maxDepth = node.depth;
            }
        }
    }

    public int getMaxDepth() {
        this._getMaxDepth(this.root);
        return this.maxDepth;
    }

    public void printPreOrder() {
        _printPreOrder(this.root);
    }

    public class Node {
        public int data;
        public int depth;
        public int height;
        public Node left = null;
        public Node right = null;

        public Node(int data) {
            this.data = data;
        }
    }
}
