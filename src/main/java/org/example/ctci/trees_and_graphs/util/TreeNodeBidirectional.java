package org.example.ctci.trees_and_graphs.util;

public class TreeNodeBidirectional {
    public TreeNodeBidirectional parent;
    public TreeNodeBidirectional left;
    public TreeNodeBidirectional right;
    public int val;

    public TreeNodeBidirectional(int val) {
        this.val = val;
    }
}
