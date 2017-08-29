package leetcode;

/**
 * Created by Hua on 5/12/2016.
 *
 *  Given a string S, you are allowed to convert it to a palindrome
 *  by adding characters in front of it. Find and return the shortest palindrome
 *  you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".

 "adcd", return "dcdadcd"

 "acdcd" return "dcdcacdcd"
 */
public class N214_ShortestPalindrome {
    // Google
    // string, find suffix and reverse suffix to prefix, return prefix + dfs(s(0,i)) + suffix
    // 120 / 120 test cases passed.  on 8/28/2017
    // 4 ms
    class Solution {
        public String shortestPalindrome(String s) {
            int i=0;
            for(int j=s.length()-1; j>=0; j--){
                if(s.charAt(i)==s.charAt(j)) i++;
            }

            if(i==s.length())  return s;
            String suffix = s.substring(i);
            return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, i)) +suffix;
        }
    }

    // simple BF solution, but TLE on large data set.
    class Solution2 {
        public String shortestPalindrome(String s) {
            if(s == null || s.length() <= 1) return s;
            for(int j=s.length()-1; j>0; j--){
                if(isPal(s, 0, j)) return new StringBuilder(s.substring(j+1)).reverse().toString() +  s;
            }
            return new StringBuilder(s.substring(1)).reverse().toString() +  s;
        }

        public boolean isPal(String s, int i, int j){
            while(i < j) if(s.charAt(i++) != s.charAt(j--)) return false;
            return true;
        }
    }


    // 120 / 120 test cases passed.  on 8/28/2017
    // 5 ms
    // very smart solution
    class Solution3 {
        public String shortestPalindrome(String s) {
            int i=0;
            int j=s.length()-1;

            while(j>=0){
                if(s.charAt(i)==s.charAt(j)){
                    i++;
                }
                j--;
            }

            if(i==s.length())  return s;

            String suffix = s.substring(i);
            String prefix = new StringBuilder(suffix).reverse().toString();
            String mid = shortestPalindrome(s.substring(0, i));
            return prefix+mid+suffix;
        }
    }


    //TLE
    public String shortestPalindrome(String s) {
        if(s==null || s.length() <= 1) return s;
        int center_index = 0;
        for(int i=s.length()-1; i>=0;i--){
            if(isPalToLeftEnd(s, i)){
                center_index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=center_index+1; i<s.length();i++) sb.append(s.charAt(i));
        return sb.reverse().toString() + s;
    }

    private boolean isPalToLeftEnd(String s, int index) {
        int left=0;
        int right=index;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


    //memory limit exceed
    public String shortestPalindrome2(String s) {
        if(s==null || s.length() <= 1) return s;
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }

        int index = 0;
        for(int i=s.length()-1; i>=0;i--){
            if(isPal[0][i]){
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index+1; i<s.length();i++) sb.insert(0,s.charAt(i));
        return sb.toString() + s;
    }


}
