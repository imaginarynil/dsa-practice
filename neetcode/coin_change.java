package org.example.neetcode;

import java.util.Arrays;
import java.util.HashMap;

public class coin_change {
    HashMap<Integer, Integer> hm;

    public int solve(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(hm.containsKey(amount)) {
            return hm.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for(int coin: coins) {
            if(amount - coin >= 0) {
                int take = solve(coins, amount - coin);
                if(take != Integer.MAX_VALUE) {
                    res = Math.min(take + 1, res);
                }
            }
        }
        hm.put(amount, res);
        return res;
    }

    // t: O()
    // s: O()
    public int coinChange(int[] coins, int amount) {
        hm = new HashMap<>();
        int res = solve(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

//    int coinChange_BottomUp(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//        for(int a = 1; a <= amount; a++) {
//            for(int j = 0; j < coins.length; j++) {
//                if(a - coins[j] >= 0) {
//                    dp[a] = Math.min(dp[a], dp[a - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

    void main() {
//        int res = coinChange_BottomUp(new int[]{1, 5, 10}, 12); // 3
//        res = coinChange_BottomUp(new int[]{2}, 3); // -1
    }
}
