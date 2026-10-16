package org.example.neetcode;

public class implement_prefix_tree {
    class PrefixTree {
        PrefixTreeNode root;

        class PrefixTreeNode {
            PrefixTreeNode[] arr = new PrefixTreeNode[26];
            boolean end;
        }

        public PrefixTree() {
            this.root = new PrefixTreeNode();
        }

        void insertUtil(PrefixTreeNode root, String word, int i) {
            if (i == word.length()) {
                root.end = true;
                return;
            }
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] == null) {
                root.arr[idx] = new PrefixTreeNode();
            }
            insertUtil(root.arr[idx], word, i + 1);
        }

        // t: O()
        // s: O()
        public void insert(String word) {
            PrefixTreeNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.arr[idx] == null) {
                    curr.arr[idx] = new PrefixTreeNode();
                }
                curr = curr.arr[idx];
            }
            curr.end = true;
        }

        // t: O()
        // s: O()
        public boolean search(String word) {
            PrefixTreeNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.arr[idx] == null) {
                    return false;
                }
                curr = curr.arr[idx];
            }
            return curr.end;
        }

        // t: O()
        // s: O()
        public boolean startsWith(String prefix) {
            PrefixTreeNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if (curr.arr[idx] == null) {
                    return false;
                }
                curr = curr.arr[idx];
            }
            return true;
        }
    }

    void main() {
        PrefixTree t = new PrefixTree();
//        t.insert("dog");
        boolean res = t.search("do");
//        res = t.startsWith("do");
        t.insertUtil(t.root, "dog", 0);
    }
}
