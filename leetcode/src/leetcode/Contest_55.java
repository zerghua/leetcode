package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/21/2017.

 Rank	    Name	Score	 Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	    Q4 (9)
 721 / 3036	zerghua	    7	     1:16:50			                1:11:50 1



 */
public class Contest_55 {
    // 713. Subarray Product Less Than K
    // BF
    // AC 90mins
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int n = nums.length;
            int ret = 0;
            for(int j=0; j<n;j++){
                if(nums[j] < k) {
                    ret++;
                    int sum = nums[j];
                    for(int i=j-1; i>=0; i--){
                        sum *= nums[i];
                        if(sum < k) ret++;
                        else break;
                    }
                }
            }
            return ret;
        }
    }


    // 714. Best Time to Buy and Sell Stock with Transaction Fee
    /*
    class Solution2 {
        public:
        int maxProfit(vector<int>& prices, int fee) {
            if(prices.empty()) return 0;
            int buy=-prices[0], sell=0;
            for(int i=1; i<prices.size(); i++) {
                int pre_buy=buy, pre_sell=sell;
                buy=max(pre_buy, pre_sell-prices[i]);
                sell=max(pre_sell, pre_buy+prices[i]-fee );
            }
            return sell;
        }
    };


    class Solution {
	    public int maxProfit(int[] prices, int fee) {
	        int n = prices.length;
	        int[] h = {0, Integer.MIN_VALUE + 60000};
	        for(int i = 0;i < n;i++){
	        	int[] nh = new int[2];
	        	nh[0] = Math.max(h[0], h[1] + prices[i] - fee);
	        	nh[1] = Math.max(h[1], h[0] - prices[i]);
	        	h = nh;
	        }
	        return h[0];
	    }
	}
    */
}
