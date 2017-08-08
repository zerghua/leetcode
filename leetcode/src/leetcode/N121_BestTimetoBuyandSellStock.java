package leetcode;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */
public class N121_BestTimetoBuyandSellStock {
    // Amazon, Facebook, Microsoft
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

    // version 2 added on 9/13/2016
    // greedy. only need to store previous min value.
    // 3 ms  200 / 200 test cases passed.
    public class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <=0) return 0;
            int min = prices[0], ret = 0;
            for(int i=1;i<prices.length;i++){
                min = Math.min(min, prices[i]);
                ret = Math.max(ret, prices[i] - min);
            }
            return ret;
        }
    }


    // return index rather than max profit
    public class solution_return_index{
        public int[] maxProfit(int[] prices) {
            int min = prices[0], max = 0, possible_min_index=0;
            int[] ret = {0, 0};
            for(int i=1;i<prices.length;i++){
                if(min > prices[i]){
                    min = prices[i];
                    possible_min_index = i;
                }
                if(max < prices[i] - min){
                    ret[0] = possible_min_index;
                    ret[1] = i;
                    max = prices[i] - min;
                }
            }
            return ret;
        }
    }


    public static void main(String[] args){
        N121_BestTimetoBuyandSellStock.solution_return_index x= new N121_BestTimetoBuyandSellStock().new solution_return_index();
        printArray(x.maxProfit(new int[]{2,6,8,10}));
        printArray(x.maxProfit(new int[]{2,6,4,3,1}));
        printArray(x.maxProfit(new int[]{2,6,4,3,1,9}));
        printArray(x.maxProfit(new int[]{5,20,1,2,9}));
    }

    public static void printArray(int[] a){
        System.out.println(a[0] + " " + a[1]);
    }




}
