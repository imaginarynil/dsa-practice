package org.example.leet_code;

public class maximum_subarray {
    public int maxSubArray_Naive(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
            for (int j = 0; j < i; j++) {
                result = Math.max(result, dp[i] - dp[j]);
            }
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > sum) {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArray_Alternative(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    void main() {
        int x;
        x = maxSubArray_Alternative(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        x = maxSubArray_Alternative(new int[]{1});
        x = maxSubArray_Alternative(new int[]{5, 4, -1, 7, 8});
    }
}
