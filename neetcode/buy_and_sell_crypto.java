package org.example.neetcode;

public class buy_and_sell_crypto {
    // time: O(n), space: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int res = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - buy);
            if (prices[i] < buy) {
                buy = prices[i];
            }
        }
        return res;
    }

    public int maxProfit_TwoPointers(int[] prices) {
        int l = 0;
        int r = 1;
        int res = 0;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                res = Math.max(res, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return res;
    }

    void main() {
        int[] arr = {2, 1, 3, 2, 4}; // 3
//        int[] arr = {10,1,5,6,7,1}; // 6
//        int[] arr = {10,8,7,5,2}; // 0
//        int[] arr = {0, 0, 0, 0}; // 0
        var x = maxProfit_TwoPointers(arr);
    }
}
