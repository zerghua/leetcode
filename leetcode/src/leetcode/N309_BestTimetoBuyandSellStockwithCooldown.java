package leetcode;

/**
 * Created by Hua on 5/26/2016.

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell
 one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]


 buy[i] = max(sell[i-2]-price, buy[i-1])
 sell[i] = max(buy[i-1]+price, sell[i-1])


 */
public class N309_BestTimetoBuyandSellStockwithCooldown {

    // 2 ms
    // 2 parameters dp
    public int maxProfit(int[] prices) {
        int pre_buy=0, pre_sell=0, buy=Integer.MIN_VALUE, sell=0;
        for(int price: prices){
            pre_buy = buy;
            buy = Math.max(pre_buy, pre_sell - price);  // rest or sell previous and buy
            pre_sell = sell;
            sell = Math.max(pre_sell, pre_buy + price); // rest or sell previous buy
        }
        return sell;
    }
}
