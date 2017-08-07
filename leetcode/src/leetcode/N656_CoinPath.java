package leetcode;

/**
 * Created by Hua on 8/7/2017.

 Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B.
 The integer B denotes that from any place (suppose the index is i) in the array A,
 you can jump to any one of the place in the array A indexed i+1, i+2, …, i+B if this place can be jumped to.
 Also, if you step on the index i, you have to pay Ai coins.
 If Ai is -1, it means you can’t jump to the place indexed i in the array.

 Now, you start from the place indexed 1 in the array A, and your aim is to reach the place indexed N
 using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you
 should take to get to the place indexed N using minimum coins.

 If there are multiple paths with the same cost, return the lexicographically smallest such path.

 If it's not possible to reach the place indexed N then you need to return an empty array.

 Example 1:

 Input: [1,2,4,-1,2], 2
 Output: [1,3,5]

 Example 2:

 Input: [1,2,4,-1,2], 1
 Output: []

 Note:

 Path Pa1, Pa2, ..., Pan is lexicographically smaller than Pb1, Pb2, ..., Pbm,
 if and only if at the first i where Pai and Pbi differ, Pai < Pbi; when no such i exists, then n < m.
 A1 >= 0. A2, ..., AN (if exist) will in the range of [-1, 100].
 Length of A is in the range of [1, 1000].
 B is in the range of [1, 100].

 */

import java.util.*;
public class N656_CoinPath {
    // Google
    // in order to return lexicographically small order, use next[] instead of prev[] to build path.
    // 226 / 226 test cases passed.
    // 26 ms
    public class Solution {
        public List<Integer> cheapestJump(int[] A, int B) {
            int n = A.length;
            long[] dp = new long[n];   // min price to the end.
            int[] next = new int[n];   // use next to greedily find lexicographically smaller rather than using prev to backtrack
            Arrays.fill(next, -1);

            for(int i=n-2;i>=0;i--){
                if(A[i] == -1) continue;
                long min_cost = Integer.MAX_VALUE;

                for(int j=i+1; j<n && j-i<=B; j++){
                    if(A[j] == -1) continue;

                    long cost = dp[j] + A[j];
                    if(cost < min_cost){
                        min_cost = cost;
                        next[i] = j;
                    }
                }
                dp[i] = min_cost;
            }

            // entirely for this tricky lexicographically order.
            LinkedList<Integer> ret = new LinkedList();
            int i;
            for(i=0; i<n && next[i]>0; i = next[i]) ret.add(i+1);
            if(i == n -1 && A[n-1] != -1) ret.add(n);
            else return new LinkedList();

            return ret;
        }
    }

}

