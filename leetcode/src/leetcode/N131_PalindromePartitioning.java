package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/2/2016.
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

    public static void main(String[] args) {
        String s = "abba";

        N131_PalindromePartitioning x= new N131_PalindromePartitioning();
        System.out.println(x.partition(s));

    }
}
