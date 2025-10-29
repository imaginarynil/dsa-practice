package org.example.trees_and_graphs;

import java.util.ArrayList;

public class list_of_depths {


    static void updateLists(BinaryTree.Node node, ArrayList[] lists) {
        if(node != null) {
            lists[node.depth].add(node.data);
            updateLists(node.left, lists);
            updateLists(node.right, lists);
        }
    }

    static void solve(BinaryTree bt){
        bt.updateDepthPreOrder();
        int depth = bt.getMaxDepth();
        ArrayList<Integer>[] lists = new ArrayList[depth + 1]; // includes 0
        for(int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        updateLists(bt.getRoot(), lists);
        for(int i = 0; i < lists.length; i++) {
            System.out.printf("%d ", i);
            for(int data: lists[i]) {
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
    }

    static void main(){
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
        solve(bt);
    }
}
