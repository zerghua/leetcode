package leetcode;

import java.util.*;

/**
 * Created by Hua on 9/27/2017.

 https://en.wikipedia.org/wiki/Longest_common_subsequence_problem


 The longest common subsequence (LCS) problem is the problem of finding the longest subsequence common
 to all sequences in a set of sequences (often just two sequences).

 It differs from problems of finding common substrings: unlike substrings,
 subsequences are not required to occupy consecutive positions within the original sequences.

 The longest common subsequence problem is a classic computer science problem,
 the basis of data comparison programs such as the diff utility, and has applications in bioinformatics.

 It is also widely used by revision control systems such as Git for reconciling multiple changes
 made to a revision-controlled collection of files.



 further optimization of space:
 1. need 2 * min(m,n) space
 2. use rolling array, only requires min(m,n) + 1  space.



 https://en.wikipedia.org/wiki/Longest_common_substring_problem
 In computer science, the longest common substring problem is to find the longest string (or strings)
 that is a substring (or are substrings) of two or more strings.

 Longest_common_substring_problem is very similar to Longest_common_subsequence_problem,
 check code below for difference.



 */
public class A_LCS_LongestCommonSubsequence {
    // return max length of longest common subsequence
    // 2D DP
    // o(m*n)
    public int LCS(String a, String b){
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m ; i++){       // potential bug, "<="
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]); //potential bug, b.charAt(j-1) rather than j
            }
        }
        return dp[m][n];
    }



    // return max length of longest common STRING
    // 2D DP
    // o(m*n)
    public int LCString(String a, String b){
        int m = a.length(), n = b.length(), max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m ; i++){       // potential bug, "<="
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? dp[i-1][j-1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


    // return one of the longest common subsequence string
    ///////////////////////////////////////////////////////////////////////
    public String LCS_string(String a, String b){
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m ; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // backtrack to return longest common string
        return dfs(a,b,dp, m, n);
    }

    public String dfs(String a, String b, int[][] dp, int i, int j){
        if(i == 0 || j == 0) return "";

        if(a.charAt(i-1) == b.charAt(j-1))return dfs(a,b, dp, i-1, j-1) + a.charAt(i-1);

        if(dp[i-1][j] > dp[i][j-1]) return dfs(a,b,dp, i-1, j);
        return dfs(a,b,dp, i, j-1);
    }
    ///////////////////////////////////////////////////////////////////////




    // return all of the longest common subsequence string
    ///////////////////////////////////////////////////////////////////////
    public List<String> LCS_all_string(String a, String b){
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m ; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // backtrack to return all of longest common string
        return new LinkedList(dfs_all(a,b,dp, m, n));

    }


    public Set<String>  dfs_all(String a, String b, int[][] dp, int i, int j){
        if(i == 0 || j == 0) return new HashSet(Arrays.asList(""));

        Set<String> ret = new HashSet();
        if(a.charAt(i-1) == b.charAt(j-1)){
            for(String s : dfs_all(a,b,dp, i-1, j-1)) ret.add(s + a.charAt(i-1));
            return ret;
        }


        if(dp[i-1][j] >= dp[i][j-1]) ret.addAll(dfs_all(a,b,dp, i-1, j));
        if(dp[i][j-1] >= dp[i-1][j]) ret.addAll(dfs_all(a,b,dp, i, j-1));

        return ret;
    }
    ///////////////////////////////////////////////////////////////////////


    public static void main(String[] args){
        A_LCS_LongestCommonSubsequence x = new A_LCS_LongestCommonSubsequence();
        System.out.println(x.LCS("abcdef", "accde"));  // 4
        System.out.println(x.LCS_string("abcdef", "accde"));  // acde
        System.out.println(Arrays.toString(x.LCS_all_string("abcdef", "accde").toArray()));  // [acde] use set get rid of duplicate
        System.out.println(Arrays.toString(x.LCS_all_string("abc", "acb").toArray()));  // [ab, ac]

        System.out.println(x.LCString("abcdef", "accde"));  // 3  cde
    }

}
