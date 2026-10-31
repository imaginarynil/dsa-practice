package org.example.neetcode;

import java.util.*;

public class three_integer_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // TODO: add checks
            // all negatives are gone, can't make a 0 with only positive numbers
            if (nums[i] > 0) {
                break;
            }
            // skip duplicates of the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l < r && (nums[l] == nums[l - 1] && nums[r] == nums[r + 1])) {
                        l++;
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    void main() {
//        int[] in = {-1, 0, 1, 2, -1, -4};
//        int[] in = {0, 1, 1};
//        int[] in = {0, 0, 0};
        int[] in = {-2, 0, 1, 1, 1, 1, 1};
        var x = threeSum(in);
    }
}
