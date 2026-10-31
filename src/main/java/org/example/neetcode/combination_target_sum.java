package org.example.neetcode;

import java.util.ArrayList;
import java.util.List;

public class combination_target_sum {
    List<List<Integer>> res;

    public void solve(List<Integer> arr, int[] nums, int target, int sum, int i) {
        if (sum == target) {
            // add res
            res.add(new ArrayList<>(arr));
            return;
        }
        if (sum > target || i >= nums.length) {
            return;
        }
        arr.add(nums[i]);
        solve(arr, nums, target, sum + nums[i], i); // include nums[i]
        arr.remove(arr.size() - 1);
        solve(arr, nums, target, sum, i + 1); // exclude nums[i]
    }

    // t: O()
    // s: O()
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        solve(new ArrayList<>(), nums, target, 0, 0);
        return res;
    }

    void main() {
        List<List<Integer>> x = combinationSum(new int[]{2, 5, 6, 9}, 9);
        x = combinationSum(new int[]{1,2,3}, 6);
    }
}
