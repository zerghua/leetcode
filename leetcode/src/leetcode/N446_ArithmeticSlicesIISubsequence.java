package leetcode;

import java.util.HashMap;

/**
 * Created by Hua on 6/12/2017.

 A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 any two consecutive elements is the same.

 For example, these are arithmetic sequences:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9

 The following sequence is not arithmetic.

 1, 1, 2, 5, 7


 A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of
 integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

 A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk]
 is arithmetic. In particular, this means that k ≥ 2.

 The function should return the number of arithmetic subsequence slices in the array A.

 The input contains N integers. Every integer is in the range of -2^31 and 2^31-1 and 0 ≤ N ≤ 1000.
 The output is guaranteed to be less than 2^31-1.

 Example:

 Input: [2, 4, 6, 8, 10]

 Output: 7

 Explanation:
 All arithmetic subsequence slices are:
 [2,4,6]
 [4,6,8]
 [6,8,10]
 [2,4,6,8]
 [4,6,8,10]
 [2,4,6,8,10]
 [2,6,10]


 Quick explanation:

 res is the final count of all valid arithmetic subsequence slices; map will store the intermediate results T(i, d),
 with i indexed into the array and d as the key of the corresponding HashMap.

 For each index i, we find the total number of "generalized" arithmetic subsequence slices ending at it with
 all possible differences. This is done by attaching A[i] to all slices of T(j, d) with j less than i.

 Within the inner loop, we first use a long variable diff to filter out invalid cases, then get the counts of all valid
 slices (with element >= 3) as c2 and add it to the final count. At last we update the count of all "generalized" slices
 for T(i, d) by adding the three parts together: the original value of T(i, d), which is c1 here, the counts from
 T(j, d), which is c2 and lastly the 1 count of the "two-element" slice (A[j], A[i]).

 */
public class N446_ArithmeticSlicesIISubsequence {
    // Baidu
    // DP, hard to code it right
    // 101 / 101 test cases passed.
    // 378 ms
    public class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            HashMap<Integer, Integer>[] map = new HashMap[A.length];  //list of hashmaps
            int ret = 0;
            for(int i = 0; i<A.length; i++){
                map[i] = new HashMap();
                for(int j=0; j<i; j++){
                    if((long)A[i] - A[j] < Integer.MIN_VALUE || (long)A[i] - A[j] > Integer.MAX_VALUE) continue;

                    int diff = A[i] - A[j];
                    int c1 = map[i].getOrDefault(diff, 0); // calculate repeat number before i
                    int c2 = map[j].getOrDefault(diff, 0);
                    ret += c2;
                    map[i].put(diff, c1 + c2 + 1);
                }
            }
            return ret;
        }
    }
}
