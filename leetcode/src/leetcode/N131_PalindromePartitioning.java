package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/2/2016.

 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
     ["aa","b"],
     ["a","a","b"]
 ]


 */

    // java substring, start is inclusive, end is exclusive
    // but the end can be the length of string, return to the end
public class N131_PalindromePartitioning {
    //9 ms, backtracking
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<List<String>>();
        LinkedList<String> list = new LinkedList<>();
        partition(s, 0, list, ret);
        return ret;
    }

    private void partition(String s, int start, LinkedList<String> list, List<List<String>> ret) {
        if(start == s.length()){
            ret.add(new LinkedList<>(list));
            return;
        }

        for(int i=start; i<s.length();i++){
            String tmp = s.substring(start, i+1);
            if(isPalindrome(tmp)) {
                list.add(tmp);
                partition(s, i+1, list,ret);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s){
        if(s == null) return true;
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    //8 ms
    public List<List<String>> partition2(String s) {
        List<List<String>> ret = new LinkedList<List<String>>();
        LinkedList<String> list = new LinkedList<>();

        //pre-fill isPal[][] array
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }
        partition2(s, 0, isPal, list, ret);
        return ret;
    }

    private void partition2(String s, int start, boolean[][] isPal,
                            LinkedList<String> list, List<List<String>> ret) {
        if(start == s.length()){
            ret.add(new LinkedList<>(list));
            return;
        }

        for(int i=start; i<s.length();i++){
            if(isPal[start][i]) {
                list.add(s.substring(start, i+1));
                partition2(s, i+1, isPal, list,ret);
                list.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        String s = "abba";

        N131_PalindromePartitioning x= new N131_PalindromePartitioning();
        System.out.println(x.partition(s));

    }




    // version 3 added on 9/6/2016
    // 5 ms   22 / 22 test cases passed.
    // DFS + backtracking + DP. see the classic way to pre-check palindrome of all sub strings.
    public class Solution {
        public List<List<String>> partition(String s) {
            // o(n^2) check palindrome for all substring
            boolean[][]  isPal = new boolean[s.length()][s.length()];
            for(int j=0;j<s.length();j++){
                for(int i=0;i<=j;i++){
                    if(s.charAt(i) == s.charAt(j) && (j-i<=1 || isPal[i+1][j-1])) isPal[i][j] = true;
                }
            }

            List<List<String>> ret = new ArrayList<>();
            dfs(ret, s, isPal, new ArrayList<>(), 0);
            return ret;
        }

        public void dfs(List<List<String>> ret, String s, boolean[][] isPal, List<String> cur_list, int start){
            if(start == s.length()){
                ret.add(new ArrayList<>(cur_list));
                return;
            }

            for(int i=start; i<s.length();i++){
                if(isPal[start][i]){
                    cur_list.add(s.substring(start,i+1));
                    dfs(ret, s, isPal, cur_list, i+1);
                    cur_list.remove(cur_list.size()-1);
                }
            }
        }
    }






}
