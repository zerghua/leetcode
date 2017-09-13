package leetcode;

/**
 * Created by HuaZ on 7/15/2017.

 Write a function to generate the generalized abbreviations of a word.

 Example:

 Given word = "word", return the following list (order does not matter):

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 "1or1", "w1r1", "1o2","2r1", "3d", "w3", "4"]


 */
import java.util.*;
public class N320_GeneralizedAbbreviation {
    // Google (Premium)
    // o(2^n) time complexity
    // DFS + backtracking, not easy
    // 49 / 49 test cases passed.
    // 21 ms
    public class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> ret = new ArrayList();
            dfs(ret, word, 0, "", 0);
            return ret;
        }

        public void dfs(List<String> ret, String word, int start, String cur, int count){
            if(start == word.length()){
                if(count > 0) cur += count;
                ret.add(cur);
                return;
            }
            dfs(ret, word, start + 1, cur, count + 1);                                          // skip char
            dfs(ret ,word, start + 1, cur + (count > 0 ? count: "") + word.charAt(start), 0);   // not skip char
        }
    }
}
