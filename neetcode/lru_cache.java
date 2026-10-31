package org.example.neetcode;

import java.util.HashMap;

public class lru_cache {
    class LRUCache {
        class Node {
            Node prev;
            Node next;
            int key;
            int val;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        HashMap<Integer, Node> c;
        int cap;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.c = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        void insert(Node n) {
            Node prev = this.tail.prev;
            Node next = this.tail;
            // prev -> n -> next
            prev.next = n;
            n.next = next;
            // prev <- n <- next
            n.prev = prev;
            next.prev = n;
        }

        void remove(Node n) {
            Node prev = n.prev;
            Node next = n.next;
            prev.next = next;
            next.prev = prev;
        }

        public int get(int key) {
            if(this.c.containsKey(key)) {
                Node n = this.c.get(key);
                remove(n);
                insert(n);
                return n.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(this.c.containsKey(key)) {
                remove(this.c.get(key));
            }
            Node n = new Node(key, value);
            this.c.put(key, n);
            insert(n);
            if(this.c.size() > this.cap) {
                Node lru = this.head.next;
                // remove from cache
                this.c.remove(lru.key);
                // remove from list
                remove(lru);
            }
        }
    }


    void main() {
        LRUCache c = new LRUCache(2);
        int x;
        c.put(1, 10);
        x = c.get(1);
        c.put(2,20);
        c.put(3,30);
        x = c.get(1);
    }
}
