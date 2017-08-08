package leetcode;

/**
 * Created by HuaZ on 10/16/2016.

 Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise,
 we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.


 F0 = 0 + 1a1 + 2a2 + 3a3

 F1 = F0 + a0 + a1 + a2 - 3a3 = F0 + a0 + a1 + a2 + a3 - 4a3

 F2 = F1 + a3 + a0 + a1 - 3a2 = F1 + a0 + a1 + a2 + a3 - 4a2

 F3 = F2 + a2 + a3 + a0 - 3a1 = F2 + a0 + a1 + a2 + a3 - 4a1

 */
public class N396_RotateFunction {
    // Amazon
    // BF is o(n^2).
    // this is o(n) solution, with the math pattern for each F(n)
    // 6 ms  17 / 17 test cases passed.
    public class Solution {
        public int maxRotateFunction(int[] A) {
            int sum=0, F=0, n = A.length;
            for(int i=0;i<n;i++){
                sum += A[i];
                F += i* A[i];
            }
            int ret = F;
            for(int i=1; i<n;i++){
                F = F + sum - n * A[n-i];
                ret= Math.max(ret, F);
            }
            return ret;
        }
    }
}
