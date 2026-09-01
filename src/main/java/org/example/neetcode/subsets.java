package org.example.neetcode;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public void solve(List<List<Integer>> res, ArrayList<Integer> subset, int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[i]);
        solve(res, subset, nums, i + 1);
        subset.remove(subset.size() - 1);
        solve(res, subset, nums, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res, new ArrayList<>(), nums, 0);
        return res;
    }

    void main() {
        List<List<Integer>> x = subsets(new int[]{});
        x = subsets(new int[]{1});
        x = subsets(new int[]{1,2});
        x = subsets(new int[]{1,2,3});
    }
}
