package org.example.trees_and_graphs;

class CheckBalancedSolution {
    public boolean flag = true;

    void solve(BinaryTree.Node node) {
        if(node == null) {
            return;
        }
        int leftHeight = node.left == null ? -1 : node.left.height;
        int rightHeight = node.right == null ? -1 : node.right.height;
        if(Math.abs(leftHeight - rightHeight) > 1) {
            this.flag = false;
            return;
        }
        solve(node.left);
        solve(node.right);
    }
}

public class check_balanced {
    static boolean solve(BinaryTree bt) {
        bt.updateHeight();
        var s = new CheckBalancedSolution();
        s.solve(bt.getRoot());
        return s.flag;
    }

    static void main() {
        BinaryTree bt = new BinaryTree();
        bt.add(4);
        bt.add(2);
        bt.add(7);
        bt.add(8);
        bt.add(9);
        System.out.println(solve(bt));
    }
}
