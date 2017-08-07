package leetcode;
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
//fibonacci sequence
public class N70_climbStairs {
	// Apple, Adobe
	// 208 ms  62%
    public int climbStairs(int n) {
    	if (n<3) return n;
    	int[] a = {1,2};
    	for(int i=3;i<=n;i++){
    		int c = a[0] + a[1];
    		a[0] = a[1];
    		a[1] = c; 
    	}
    	return a[1];
    }
    
    //196 ms  79%
    public int climbStairs2(int n) {
    	if (n == 0) return 0;
    	int a=1, b=1;
    	for(int i=2;i<=n;i++){
			int c= a+b;
			a= b;
			b= c;
    	}
    	return b;
    }

    // version 3 added on 9/9/2016
    // DP, dp[i] = dp[i-2] + dp[i-1]
    // 0 ms  45 / 45 test cases passed.
    public class Solution {
        public int climbStairs(int n) {
            if(n<0) return 0;
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 1;
            for(int i=2;i<=n;i++) dp[i] = dp[i-2] + dp[i-1];
            return dp[n];
        }
    }
        
    
}
