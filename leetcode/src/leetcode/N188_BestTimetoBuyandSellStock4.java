package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 7/9/2016.

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).


 The key function is:

 sell[i]=max(sell[i],buy[i]+price)
 buy[i]=max(buy[i],sell[i-1]-price)

 The first function means that we are now at price, and we are in the ith transaction,
 and we are gonna ending with a sell, we can either do nothing which refers to sell[i],
 or we can sell the stock which means we must do buy[i] first
 and thus refers to buy[i]+price.

 The second function works in the similar way, we can either do nothing
 which refers to buy[i] or we can sell the stock in transaction i-1 first
 and buy the stock now, which refers to sell[i-1]-price, apparently,
 we need the max value of the two.

 The initial value of buy and sell can be thought as follows:
 we init buy to Integer.MIN_VALUE to confirm that it will be updated in the loop
 because of the Math.max function

 we init sell to 0 because we actually has nothing to sell and at first we got 0 money,
 the result will be our pure profit
 the return value is sell[k] which means we end with the sell of the kth transaction
 */



public class N188_BestTimetoBuyandSellStock4 {
    // no company
    // 7 ms
    public int maxProfit(int k, int[] prices) {
        if(k<0 || prices.length <= 1) return 0;
        if(k >= prices.length/2) {
            int profit = 0;
            for(int i=1; i<prices.length; i++){
                profit += Math.max(prices[i]-prices[i-1], 0);
            }
            return profit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                sell[i] = Math.max(sell[i], buy[i] + price);
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
            }
        }
        return sell[k];
    }

}
