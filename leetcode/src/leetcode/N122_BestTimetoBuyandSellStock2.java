package leetcode;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions
as you like (ie, buy one and sell one share of the stock multiple times). However,
you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
public class N122_BestTimetoBuyandSellStock2 {
    // Bloomberg
	//2 ms
    public int maxProfit(int[] prices) { 
        if(prices == null || prices.length <= 1) return 0;
        
        int ret = 0, start_price=prices[0];
        for(int i=1; i<prices.length;i++){
        	if(prices[i] < prices[i-1]) {
        		ret += prices[i-1] - start_price;
        		start_price = prices[i];
        	}
        }
        if(prices[prices.length-1] > start_price) ret += prices[prices.length-1] -start_price;
        
        return ret;
    }
    
    /*
		This problem can be viewed as finding all ascending sequences. 
		For example, given {5, 1, 2, 3, 4}, buy at 1 & sell at 4 is the same as 
		buy at 1 &sell at 2 & buy at 2& sell at 3 & buy at 3 & sell at 4.
		We can scan the array once, and find all pairs of elements that are in ascending order. 
     */
    //2 ms
    public int maxProfit2(int[] prices) {
    	if(prices == null || prices.length <= 1) return 0;
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i]-prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }

    // version 3 added on 9/13/2016
    // more concise code, greedy. add up all positive difference.
    // 2 ms  198 / 198 test cases passed.
    public class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1) return 0;
            int ret =0;
            for(int i=1;i<prices.length;i++){
                ret += Math.max(0, prices[i]-prices[i-1]);
            }
            return ret;
        }
    }
    
}
