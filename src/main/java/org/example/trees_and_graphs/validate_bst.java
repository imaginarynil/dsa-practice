package org.example.trees_and_graphs;

class ValidateBstSolution {
    public boolean isBst = false;

    void solve(BinaryTree.Node node) {
        if(node != null) {
            if(node.left != null && node.right != null) {
                this.isBst  = node.left.data <= node.data && node.right.data > node.data;
            }
            if(node.left != null) {
                this.isBst = node.left.data <= node.data;
            }
            if(node.right != null) {
                this.isBst = node.right.data > node.data;
            }
            solve(node.left);
            solve(node.right);
        }
    }
}

public class validate_bst {
    static boolean solve(BinaryTree bt) {
        var solution = new ValidateBstSolution();
        solution.solve(bt.getRoot());
        return solution.isBst;
    }

    static void main() {
        BinaryTree bt = new BinaryTree();
        bt.add(4);
        bt.add(2);
        bt.add(7);
        bt.add(1);
        bt.add(3);
        bt.add(5);
        bt.add(8);
        bt.add(0);
        bt.add(6);
        bt.add(9);
        System.out.println(solve(bt));
    }
}
