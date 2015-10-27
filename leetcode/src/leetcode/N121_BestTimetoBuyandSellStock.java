package leetcode;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */
public class N121_BestTimetoBuyandSellStock {
    //2 ms
    public int maxProfit(int[] prices) {
        int previous_min = Integer.MAX_VALUE;
        int max_profit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < previous_min) previous_min = prices[i];
            if(prices[i] - previous_min > max_profit) max_profit = prices[i] - previous_min;
        }
        return max_profit;
    }
}
