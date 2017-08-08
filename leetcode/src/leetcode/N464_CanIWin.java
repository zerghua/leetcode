package leetcode;

/**
 * Created by HuaZ on 12/11/2016.

 In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 The player who first causes the running total to reach or exceed 100 wins.

 What if we change the game so that players cannot re-use integers?

 For example, two players might take turns drawing from a common pool of numbers of 1..15 without
 replacement until they reach a total >= 100.

 Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player
 to move can force a win, assuming both players play optimally.

 You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be
 larger than 300.

 Example

 Input:
 maxChoosableInteger = 10
 desiredTotal = 11

 Output:
 false

 Explanation:
 No matter which integer the first player choose, the first player will lose.
 The first player can choose an integer from 1 up to 10.
 If the first player choose 1, the second player can only choose integers from 2 up to 10.
 The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 Same with other integers chosen by the first player, the second player will always win.


 */

import java.util.*;
public class N464_CanIWin {
    // Linkedin
    // 736 ms 52 / 52 test cases passed.
    // DFS + backtracking + DP.
    public class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if(desiredTotal <= 0) return true;
            if(maxChoosableInteger * (maxChoosableInteger+1)/2 < desiredTotal) return false;
            return dfs(desiredTotal, new int[maxChoosableInteger], new HashMap());
        }

        public boolean dfs(int total, int[] state, HashMap<String, Boolean> map){
            String cur = Arrays.toString(state);
            if(map.containsKey(cur)) return map.get(cur);
            for(int i=0;i<state.length;i++){
                if(state[i] == 0) { // this number has not chosen
                    state[i] = 1;
                    if(total <= i+1 || !dfs(total - (i+1), state, map)) { // you win or the other loses
                        state[i] = 0;
                        map.put(cur, true);
                        return true;
                    }
                    state[i] = 0; // backtrack
                }
            }
            map.put(cur, false);
            return false;
        }
    }
}
