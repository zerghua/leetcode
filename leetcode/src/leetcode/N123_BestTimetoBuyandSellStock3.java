package leetcode;

/**
 * Created by Hua on 6/19/2016.

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).


 [1,2,5,3,8,4,9,10,5]  return 13,   1-8, 4-10


 */
public class N123_BestTimetoBuyandSellStock3 {
    // no company
    // divide and conquer, two ways DP
    // profit before i and profit after i.
    // return sum of before i and after i.
    // 2 ms
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        for(int i=1; i<prices.length;i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }

        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max - prices[i]);
        }

        int profit =0 ;
        for(int i=0;i<prices.length;i++){
            profit = Math.max(left[i] + right[i], profit);
        }
        return profit;
    }

}
