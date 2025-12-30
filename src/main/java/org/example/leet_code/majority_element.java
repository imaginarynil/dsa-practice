package org.example.leet_code;

import java.util.HashMap;

public class majority_element {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int result = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if(map.get(num) > max) {
                max = map.get(num);
                result = num;
            }
        }
        return result;
    }

    void main() {
        var x = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        x = majorityElement(new int[]{3, 2, 3});
    }
}
