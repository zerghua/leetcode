package leetcode;
import java.util.Arrays;

/**
 * Created by HuaZ on 7/30/2016.

 You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 One envelope can fit into another if and only if both the width and height of one envelope
 is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes
 you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 */
public class N354_RussianDollEnvelopes {
    // dp, o(n^2)  481 ms
    // longest increasing sequence.
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (int[] a,int[] b)->(a[0] == b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int j=1;j<envelopes.length;j++){
            for(int i=0;i<j;i++){
                if(envelopes[j][0]>envelopes[i][0] && envelopes[j][1] > envelopes[i][1]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(dp[j], max);
        }
        return max;
    }
}
