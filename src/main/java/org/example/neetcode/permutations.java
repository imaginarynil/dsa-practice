package org.example.neetcode;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    List<List<Integer>> res;

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void solve(int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            solve(nums, i + 1);
            swap(nums, i, j); // swap back, backtrack
        }
    }

    // t: O()
    // s: O()
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        solve(nums, 0);
        return res;
    }

    void main() {
        List<List<Integer>> res = permute(new int[]{1, 2});
        res = permute(new int[]{1, 2, 3});
    }
}
