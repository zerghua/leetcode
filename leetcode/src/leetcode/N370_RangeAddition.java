package leetcode;

/**
 * Created by HuaZ on 7/12/2017.

 Assume you have an array of length n initialized with all 0's and are given k update operations.

 Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments
 each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

 Return the modified array after all k operations were executed.

 Example:

 Given:

 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]

 Explanation:

 Initial state:
 [ 0, 0, 0, 0, 0 ]

 After applying operation [1, 3, 2]:
 [ 0, 2, 2, 2, 0 ]

 After applying operation [2, 4, 3]:
 [ 0, 2, 5, 5, 3 ]

 After applying operation [0, 2, -2]:
 [-2, 0, 3, 5, 3 ]


 */
public class N370_RangeAddition {
    // Google (Premium)
    // 18 / 18 test cases passed.
    // 3 ms
    // rather than update val in range[i, j]
    // we set val in range[i, n]
    // make a rule that if ret[i] = val, means ret[i ~ n] = val
    // then we set ret[start] += val, and ret[end+1] += -val for each ops
    public class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] ret = new int[length];
            for(int[] up : updates){
                int start = up[0], end = up[1], val = up[2];
                ret[start] += val;
                if(end + 1 < length) ret[end + 1] -= val;
            }

            int sum = 0;
            for(int i=0; i<length; i++){
                sum += ret[i];
                ret[i] = sum;
            }
            return ret;
        }
    }
}
