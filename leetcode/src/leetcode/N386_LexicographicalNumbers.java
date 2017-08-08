package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 8/25/2016.

 Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space.
 The input size may be as large as 5,000,000.

        1          2
       / \        / \
      10 11...   20 21...


 */
public class N386_LexicographicalNumbers {
    // Bloomberg
    // 197 ms DFS
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        dfs(0, n, ret);
        return ret;
    }

    public void dfs(int pre, int n, List ret){
        for(int i=0;i<=9;i++){
            int val = pre*10 + i;
            if(val > n) return;
            if(val > 0){
                ret.add(val);
                dfs(val, n, ret);
            }
        }
    }

}
