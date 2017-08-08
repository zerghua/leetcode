package leetcode;

/**
 * Created by HuaZ on 7/16/2016.

 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x.
 You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.

 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 Hint:

 1. The best strategy to play the game is to minimize the maximum loss you could possibly face.
 2. Another strategy is to minimize the expected loss.
 Here, we are interested in the first scenario.

 3. Take a small example (n = 3). What do you end up paying in the worst case?

 4. Check out this article if you're still stuck.

 5. The purely recursive implementation of minimax would be worthless for even a small n.
 You MUST use dynamic programming.

 6. As a follow-up, how would you modify your code to solve the problem of
 minimizing the expected loss, instead of the worst-case loss?

 */
public class N375_GuessNumberHigherorLower2 {
    // Google
    // 16 ms
    // 2d dp, dp[1][n] = min{ k+ max(dp[1][k-1], dp[k+1][n])} for k = [1,n]
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int j=2;j<=n;j++){
            for(int i=j-1;i>0;i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    globalMin = Math.min(globalMin, k + Math.max(dp[i][k==i?k:k-1], dp[k==j?k:k+1][j]));
                }
                dp[i][j] = globalMin;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount2(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=1;i<j;i++){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++){
                    int localMax = k + Math.max(table[i][k==i?k:k-1], table[k==j?k:k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                    System.out.println("table["+ i + "]["+j+"]="+globalMin + " k="+k);
                }
                table[i][j] = globalMin;

            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        return table[1][n];
    }

    public static void main(String[] args){
        N375_GuessNumberHigherorLower2 x = new N375_GuessNumberHigherorLower2();
        x.getMoneyAmount(6);

        int a = Integer.MIN_VALUE;
        System.out.println(-a);
    }
}
