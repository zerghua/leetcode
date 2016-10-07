package leetcode;

/**
 * Created by Hua on 4/2/2016.
 Given a string S, find the longest palindromic substring in S.
 You may assume that the maximum length of S is 1000,
 and there exists one unique longest palindromic substring.

 */
public class N5_LongestPalindromicSubstring {
    //38 ms, time O(n^2), space O(1)
    public String longestPalindrome(String s) {
        if(s==null || s.length()==1) return s;

        String longest="";
        for(int i=0;i<s.length();i++){
            String tmp = findPalindromeAroundCenter(s,i,i);
            if(tmp.length() > longest.length()) longest = tmp;

            tmp = findPalindromeAroundCenter(s,i,i+1);
            if(tmp.length() > longest.length()) longest = tmp;
        }
        return longest;
    }

    private String findPalindromeAroundCenter(String s, int start, int end) {
        while(start>=0 && end<s.length() ){
            if(s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }else break;
        }
        return s.substring(start+1, end); // important
    }

    // added on 10/7/2016
    // 42 ms 89 / 89 test cases passed.
    public class Solution {
        public String longestPalindrome(String s) {
            if(s == null) return s;
            String ret = "";
            for(int i=0;i<s.length();i++){
                String cur = isPal(s, i, i);
                if(cur.length() > ret.length()) ret = cur;

                cur = isPal(s, i, i+1);
                if(cur.length() > ret.length()) ret = cur;
            }
            return ret;
        }

        public String isPal(String s, int left, int right){
            while(left>=0 && right<s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    left--; right++;
                }else break;
            }
            return s.substring(left+1, right);
        }
    }



    //DP 66 ms time O(n^2), space O(n^2)
    public String longestPalindrome2(String s) {
        if(s==null || s.length()==1) return s;

        int start=0, end=0, max_len=0;
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if( s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])) {
                    isPal[i][j] = true;
                    if (j - i + 1 > max_len) {
                        max_len = j - i + 1;
                        start = i; end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }

    // Manacher's Algorithm o(n)  TODO

}
