package leetcode;

/**
 * Created by Hua on 5/29/2016.

 Given a positive integer n, find the least number of perfect square numbers
 (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 return 2 because 13 = 4 + 9.


 */
public class N279_PerfectSquares {
    //https://en.wikipedia.org/wiki/Lagrange's_four-square_theorem
    //2 ms
    //math solution
    public int numSquares(int n) {
        if(n<=0) return 0;
        while(n%4 == 0) n/=4;  //math
        if(n%8 == 7) return 4; //math
        for(int i=0; i*i<=n;i++){
            int j = (int)Math.sqrt(n - i*i);
            if(i*i + j*j == n) {
                if(i==0 || j==0) return 1;
                return 2;
            }
        }
        return 3;
    }

    // DP
    // 69 ms
    public int numSquares2(int n) {
        if(n<=0) return 0;
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) dp[i] = Integer.MAX_VALUE;  // dp[0] = 0;

        for(int i=0;i<=n;i++){
            for(int j=1;i+j*j<=n;j++){
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
            }
        }
        return dp[n];
    }

}
