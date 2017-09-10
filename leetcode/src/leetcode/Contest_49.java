package leetcode;

/**
 * Created by HuaZ on 9/9/2017.
 * Rank	    Name	Score	Finish Time 	Q1 (3)	    Q2 (6)	    Q3 (8)	    Q4 (9)
 624 / 2362	zerghua	   9	0:20:04	        0:09:00 1	0:15:04

 N673, N674, N675, N676
 */

import leetcode.N0_data_strcture.*;
import java.util.*;

public class Contest_49 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return 1;

            int ret =0, i = 0, j = 1, n = nums.length;
            while(j < n){
                if(nums[j] > nums[j-1])j++;
                else{
                    ret = Math.max(ret, j - i);
                    i = j;
                    j++;
                }
            }
            ret = Math.max(ret, j-i);
            return ret;
        }
    }


    // BF solution
    class MagicDictionary {
        ArrayList<String> list ;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            list= new ArrayList();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for(String s: dict) list.add(s);
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            for(String s : list){
                if(s.length() == word.length()){
                    if(isOneEdit(s, word)) return true;
                }
            }
            return false;
        }

        public boolean isOneEdit(String s, String t){
            int  diff =0;
            for(int i=0;i<s.length(); i++){
                if(s.charAt(i) != t.charAt(i)) diff++;
                if(diff > 1) return false;
            }
            return diff == 1;
        }
    }



/*
test case:
[1,2,4,3,5,4,7,2]

Your stdout

0 : 1  dp = 1
1 : 1  dp = 2
2 : 1  dp = 3
3 : 1  dp = 3
4 : 2  dp = 4
5 : 1  dp = 4
6 : 2  dp = 5
7 : 1  dp = 2


 */

    // DP, finally fixed, but 3 minutes passed over contest
    class Solution4 {
        public int findNumberOfLIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return 1;
            int n = nums.length, max = 0;
            int[] dp = new int[n];
            int[] count = new int[n];
            Arrays.fill(dp, 1);
            count[0] = 1;

            for(int j=1; j<n; j++){
                for(int i=j-1; i>=0; i--){
                    if(nums[j] > nums[i]) {
                        if(dp[j] == 1 + dp[i]) {
                            count[j] += count[i];
                        }else if(1 + dp[i] > dp[j]){
                            dp[j] = 1 + dp[i];
                            count[j] = count[i];
                        }
                    }
                    max = Math.max(max, dp[j]);
                }
                if(count[j] == 0) count[j] = 1;
            }

            //System.out.println("max =" +max);
            int ret = 0;
            for(int i=0;i<n; i++){
                //System.out.println(i + " : " + count[i]  + "  dp = " + dp[i]);
                if(dp[i] == max) ret += count[i];
            }
            return ret;
        }
    }
}
