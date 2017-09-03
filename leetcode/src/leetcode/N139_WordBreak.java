package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/7/2016.

 Given a string s and a dictionary of words dict,
 determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 */

public class N139_WordBreak {
    // Google, Facebook, Amazon
    // dp[j+1] = true when dp[i] == true && s(i,j+1) is in dict.
    // 34 / 34 test cases passed.  on 8/16/2017
    // 11 ms
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet(wordDict);
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            for(int j=0;j<s.length();j++){
                for(int i=j; i>=0; i--){
                    if(dp[i] && set.contains(s.substring(i,j+1))){
                        dp[j+1] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }



    // verions 3 added on 9/14/2016
    // 5 ms  34 / 34 test cases passed.
    // DP, dp[i+1] = true if dp[j]==true && dict.contains(substring[j,i+1)) for j in [0,i]
    public class Solution3 {
        public boolean wordBreak(String s, Set<String> wordDict) {
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            for(int i=0;i<s.length();i++){
                for(int j=i;j>=0;j--){
                    if(dp[j] && wordDict.contains(s.substring(j,i+1))) {  //important it's dp[j] instead of dp[i]
                        dp[i+1] = true;
                        break; // pruning
                    }
                }
            }
            return dp[s.length()];
        }
    }


    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreak(0,s,wordDict);
    }

    // TLE
    public boolean wordBreak(int start, String s, Set<String> wordDict){
        if(start >= s.length()) return true;

        boolean isFound= false;
        for(int i=start; i<s.length(); i++){
            String tmp = s.substring(start,i+1);
            if(wordDict.contains(tmp)) isFound= wordBreak(i+1, s, wordDict);
            if(isFound) return true;
        }

        return false;
    }

    //6 ms
    public boolean wordBreak_dp(String s, Set<String> wordDict) {
        boolean[] isbreakable = new boolean[s.length()+1];
        isbreakable[0] = true;
        for(int i=0;i<s.length();i++){
            for(int j=i; j>=0; j--){
                String tmp = s.substring(j,i+1);
                if(isbreakable[j] && wordDict.contains(tmp)){
                    isbreakable[i+1] = true;
                    break;
                }
            }
        }
        return isbreakable[s.length()];
    }



    // added on 10/2/2016
    // 16 ms  34 / 34 test cases passed
    public class Solution2 {
        public boolean wordBreak(String s, Set<String> wordDict) {
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            for(int i=0;i<s.length();i++){
                for(int j=0;j<=i;j++){
                    if(dp[j] && wordDict.contains(s.substring(j,i+1))) {  //important it's dp[j] instead of dp[i]
                        dp[i+1] = true;
                        break; // pruning
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
