package org.example.neetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class last_stone_weight {
    // t: O()
    // s: O()
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) {
            pq.add(stone);
        }
        while(pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();
            if(x > y) {
                pq.add(x - y);
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }

    void main() {
        int res = lastStoneWeight(new int[]{1,2,3});
        res = lastStoneWeight(new int[]{7});
        res = lastStoneWeight(new int[]{2,3,6,2,4});
    }
}
