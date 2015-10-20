package leetcode;

public class N122_BestTimetoBuyandSellStock2 {
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
    
}
