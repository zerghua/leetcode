package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 6/14/2016.

 You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up
 that amount. If that amount of money cannot be made up by any combination of the coins,
 return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.

 */


public class N322_CoinChange {
    // backtracking, TLE
    // [176,6,366,357,484,226,1,104,160,331]
    // 5557
    int min_coin = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length-1, 0);
        return min_coin;
    }

    public void coinChange(int[] coins, int amount, int start, int num_change){
        if(start < 0 )return;

        for(int i = start; i>=0; i--){
            int remain = amount % coins[start];
            if(remain == 0){
                min_coin = Math.min(min_coin, num_change + amount/coins[start]);
                return;
            }
            coinChange(coins, remain, start-1, num_change+ amount/coins[start]);
        }
    }


    // DP  dp[i+ coin] = min(dp[i+coin], dp[i] + 1)
    // on 9/24/2016  19 ms  181 / 181 test cases passed.
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i<=amount;i++) dp[i] = Integer.MAX_VALUE;
        for(int i=0;i<amount;i++){
            for(int coin: coins){
                if(i+coin <= amount && dp[i] != Integer.MAX_VALUE)
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }

}
