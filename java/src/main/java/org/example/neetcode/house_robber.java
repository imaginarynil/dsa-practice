package org.example.neetcode;

import java.util.Arrays;

public class house_robber {
    int[] dp;

    // t: O()
    // s: O()
    public int solve(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(solve(nums, i + 1), solve(nums, i + 2) + nums[i]);
        return dp[i];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }

    public int rob_bottomUp(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[2] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    void main() {
        int x;
        x = rob_bottomUp(new int[]{1,1,3,3}); // 4
        x = rob_bottomUp(new int[]{2,9,8,3,6}); // 16
        x = rob_bottomUp(new int[]{2,1,1,2}); // 4
    }
}
