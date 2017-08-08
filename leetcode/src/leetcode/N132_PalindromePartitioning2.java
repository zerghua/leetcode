package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hua on 5/8/2016.
 *
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class N132_PalindromePartitioning2 {
    // no company
    // DP
    // 29 / 29 test cases passed.
    // 34 ms
    public class Solution {
        public int minCut(String s) {
            boolean[][] isPal = new boolean[s.length()][s.length()];
            int[] cut = new int[s.length()];
            for(int j=0;j<s.length();j++){
                cut[j] = j; // max cut at j
                for(int i=0;i<=j;i++){
                    if(s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])){
                        isPal[i][j] = true;

                        if(i == 0) cut[j] = 0; // first row
                        else cut[j] = Math.min(cut[j], cut[i-1] + 1);
                    }
                }
            }
            return cut[s.length()-1];
        }
    }


    int min_cut = Integer.MAX_VALUE;

    // TLE "ababababababababababababcbabababababababababababa"
    public int minCut(String s) {
        //pre-fill isPal[][] array
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }

        partition(s, 0, isPal, 0);
        return min_cut-1;
    }

    private void partition(String s, int start, boolean[][] isPal, int cut) {
        if(start == s.length()){
            min_cut = Math.min(min_cut, cut);
            return;
        }

        for(int i=start; i<s.length();i++){
            if(isPal[start][i]) {
                partition(s, i + 1, isPal, cut + 1);
            }
        }
    }


}
