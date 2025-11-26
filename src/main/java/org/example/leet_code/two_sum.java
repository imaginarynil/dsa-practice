package org.example.leet_code;

import java.util.HashMap;
import java.util.Map;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

//    O(n^2)
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for(int i = 0; i < nums.length - 1; i++) {
//            for(int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//        return result;
//    }

    void main() {
        var x = twoSum(new int[]{2,7,11,15}, 9);
        x = twoSum(new int[]{3,2,4}, 6);
        x = twoSum(new int[]{3,3}, 6);
    }
}
