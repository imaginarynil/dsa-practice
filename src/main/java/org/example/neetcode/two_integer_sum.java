package org.example.neetcode;

import java.util.HashMap;
import java.util.Map;

public class two_integer_sum {
    /*
     * Only one valid answer exists -> {1,1,1} is not possible because 2 solutions */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        // update map with the latest index to handle duplicates. example: {3, 0, 3}, last 3 is at 2. problem only asks for 2 numbers
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            // if p location is == i, p is a duplicate
            if (m.containsKey(p) && m.get(p) != i) {
                return new int[]{i, m.get(p)};
            }
        }
        return new int[]{};
    }

    public int[] twoSum_HashMap_OnePass(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>(); // stores the latest visited element with its index
        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            if (m.containsKey(p)) {
                return new int[]{m.get(p), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{};
    }

    void main() {
//        var x = twoSum(new int[]{3,4,5,6}, 7); // [0,1]
//        var x = twoSum(new int[]{4,5,6}, 10); // [0,2]
        var x = twoSum(new int[]{5, 5}, 10); // [0,1]
    }
}
