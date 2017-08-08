package leetcode;

/**
 * Created by HuaZ on 7/16/2017.

 Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
 = 2 x 4.

 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:

 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.

 Examples:
 input: 1
 output:

 []

 input: 37
 output:

 []

 input: 12
 output:

 [
     [2, 6],
     [2, 2, 3],
     [3, 4]
 ]

 input: 32
 output:

 [
     [2, 16],
     [2, 2, 8],
     [2, 2, 2, 4],
     [2, 2, 2, 2, 2],
     [2, 4, 4],
     [4, 8]
 ]


 12
 2*6 ->  2* dfs(6) -> 2* 2*3
 3*4
 every dfs start>= last start, made sure it's sorted.

 */

import java.util.*;
public class N254_FactorCombinations {
    // Linkedin, Uber
    // 20 / 20 test cases passed.
    // 2 ms
    // DFS + backtracking, a trick to made the list sorted, every dfs next start >= last start
    public class Solution {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> ret = new LinkedList();
            if(n <= 1) return ret;
            dfs(ret, new LinkedList(), 2, n);
            return ret;
        }

        public void dfs(List<List<Integer>> ret, LinkedList<Integer> list, int start, int num){
            for(int i = start; i<= Math.sqrt(num); i++){
                int remain = num / i;
                if(num % i == 0){
                    list.add(i);
                    list.add(remain);
                    ret.add(new LinkedList(list));
                    list.removeLast();
                    dfs(ret, list, i, remain);
                    list.removeLast();
                }
            }
        }
    }
}
