package leetcode;

import java.util.HashMap;

/**
 * Created by HuaZ on 11/22/2016.

 Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
 there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0


 */
public class N454_4SumII {
    // 160 ms 48 / 48 test cases passed.
    // hashmap,  o(n^2) time and o(n^2) space
    // BF is o(n^4)
    public class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int i=0;i<A.length;i++){
                for(int j=0;j<B.length;j++){
                    int sum = A[i] + B[j];
                    map.put(sum, map.getOrDefault(sum,0)+1);
                }
            }

            int ret = 0;
            for(int i=0;i<C.length;i++) {
                for (int j = 0; j < D.length; j++) {
                    ret += map.getOrDefault( -1*(C[i]+D[j]), 0);
                }
            }
            return ret;
        }
    }
}
