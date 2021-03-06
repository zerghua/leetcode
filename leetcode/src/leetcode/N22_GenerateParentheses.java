package leetcode;
import java.util.*;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"

 I guess the hard part is how to define well-formed parentheses.

 comments add on 8/31/2016

 */



public class N22_GenerateParentheses {
    // Google, Uber
    // DFS on number of remaining left and right parentheses.
    // backtracking 2 ms 51%
    public List<String> generateParenthesis(int n) {
        List<String>  ret = new ArrayList<String>();
        generateParenthesis_helper(ret, "",  n, n);
        return ret;
    }

    public void generateParenthesis_helper(List<String> ret, String s, int left, int right) {
        if(right < left) return ;

        if(left == 0 && right == 0) {
            ret.add(s);
            return ;
        }

        if(left >0) generateParenthesis_helper(ret, s + "(", left-1, right);
        if(right>0) generateParenthesis_helper(ret, s + ")", left, right-1);
    }
}


