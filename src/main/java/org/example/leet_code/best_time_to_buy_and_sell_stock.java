package org.example.leet_code;

public class best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    void main() {
        int[] prices = new int[]{2,4,1};
//        int[] prices = new int[]{7,6,4,3,1};
        int result = maxProfit(prices);
    }
}
