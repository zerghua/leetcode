package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 8/21/2016.

 Remove the minimum number of invalid parentheses in order to make the input string valid.
 Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Examples:

 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]


 */
public class N301_RemoveInvalidParentheses {
    // Facebook
    // BFS, remove chars level by level. (remove 0 ~ n chars), slower but easier to understand.
    // 125 / 125 test cases passed.
    // 105 ms
    public class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ret = new ArrayList<>();
            HashSet<String> visited = new HashSet<>(Arrays.asList(s));
            List<String> list = new ArrayList<>(Arrays.asList(s));
            boolean isFound = false;

            while(!list.isEmpty()){
                String cur = list.remove(0);
                if(isValidParentheses(cur)){
                    isFound = true;
                    ret.add(cur);
                }

                // if not found in this level, continue adding substring
                if(!isFound){
                    for(int i=0;i<cur.length();i++){
                        if(cur.charAt(i) == '(' || cur.charAt(i) == ')'){
                            String next = cur.substring(0,i) + cur.substring(i+1);
                            if(!visited.contains(next)){
                                visited.add(next);
                                list.add(next);
                            }
                        }
                    }
                }
            }
            return ret;
        }

        public boolean isValidParentheses(String s){
            int count = 0;
            for(char c: s.toCharArray()){
                if(c == '(') count++;
                else if(c == ')') count--;
                if(count < 0 ) return false;
            }
            return count == 0;
        }
    }



    // https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution
    // DFS
    // 125 / 125 test cases passed.
    // 3ms
    public class Solution2 {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
        }

        public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
            for (int stack = 0, i = last_i; i < s.length(); ++i) {
                if (s.charAt(i) == par[0]) stack++;
                if (s.charAt(i) == par[1]) stack--;
                if (stack >= 0) continue;
                for (int j = last_j; j <= i; ++j)
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                return;
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if (par[0] == '(') // finished left to right
                remove(reversed, ans, 0, 0, new char[]{')', '('});
            else // finished right to left
                ans.add(reversed);
        }
    }






}
