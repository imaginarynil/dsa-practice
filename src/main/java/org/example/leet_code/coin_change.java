package org.example.leet_code;

public class coin_change {
    public int _coinChange_Naive(int[] coins, int amount, int i) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || i >= coins.length) {
            return Integer.MAX_VALUE;
        }
        int use = _coinChange_Naive(coins, amount - coins[i], i);
        if (use != Integer.MAX_VALUE) {
            use++;
        }
        int noUse = _coinChange_Naive(coins, amount, i + 1); // skip current denominator, and use the next one
        return Math.min(use, noUse);
    }

    public int _coinChange_Optimal(int[] dp, int[] coins, int amount, int i) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || i >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        int use = _coinChange_Optimal(dp, coins, amount - coins[i], i);
        if (use != Integer.MAX_VALUE) {
            use++;
        }
        int noUse = _coinChange_Optimal(dp, coins, amount, i + 1); // skip current denominator, and use the next one
        if (i < coins.length) {
            dp[i] = Math.min(use, noUse);
        }
        return dp[i];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int min = _coinChange_Optimal(dp, coins, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void main() {
        int x;
//        x = coinChange(new int[]{1,2,5}, 11);
//        x = coinChange(new int[]{2}, 3);
//        x = coinChange(new int[]{1}, 0);
//        x = coinChange(new int[]{1,2}, 2);
        x = coinChange(new int[]{1, 2}, 3);
    }
}
