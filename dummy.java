package org.example;

import org.example.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class dummy {
    int[] dp;

    public int rec(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(dp[amount] != -1) {
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(amount - coins[i] >= 0) {
                int cnt = rec(coins, amount - coins[i]);
                if(cnt != Integer.MAX_VALUE) {
                    ans = Math.min(ans, cnt + 1);
                }
            }
        }
        dp[amount] = ans;
        return ans;
    }

//    public int coinChange(int[] coins, int amount) {
//        dp = new int[amount + 1];
//        Arrays.fill(dp, -1);
//        int ans = rec(coins, amount);
//        return ans == Integer.MAX_VALUE ? -1 : ans;
//    }

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int c: coins) {
                if(i - c >= 0) {
                    int cnt = dp[i - c];
                    dp[i] = Math.min(dp[i], cnt < Integer.MAX_VALUE ? cnt + 1 : cnt);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    void main() {
        int ans = coinChange(new int[]{1,3,5}, 6);
    }
}
