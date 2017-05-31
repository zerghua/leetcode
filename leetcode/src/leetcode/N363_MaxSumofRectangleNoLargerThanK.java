package leetcode;

/**
 * Created by Hua on 5/26/2017.

 Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix
 such that its sum is no larger than k.

 Example:

 Given matrix = [
 [1,  0, 1],
 [0, -2, 3]
 ]
 k = 2

 The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

 Note:

 The rectangle inside the matrix must have an area > 0.
 What if the number of rows is much larger than the number of columns?

 */
import java.util.*;
public class N363_MaxSumofRectangleNoLargerThanK {
    // BF is m^2 * n^2
    // treemap search, o(n) = m^2 * n * logn (m < n)
    // 27 / 27 test cases passed.
    // 171 ms
    public class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            if(matrix == null || matrix.length == 0) return 0;
            int row = matrix.length, col = matrix[0].length;
            int m = Math.min(row, col), n = Math.max(row, col);
            boolean isColLarger = col > row;
            int ret = Integer.MIN_VALUE;
            for(int i=0; i< m; i++){
                int[] a = new int[n];

                // sum from row/col i to row/col j, and do binary search.
                for(int j=i; j>=0; j--){
                    int val = 0;
                    TreeSet<Integer> set = new TreeSet(Arrays.asList(0));

                    for(int y=0; y<n;y++){
                        a[y] += (isColLarger? matrix[j][y] : matrix[y][j]);
                        val += a[y];
                        Integer tmp = set.ceiling(val - k);
                        if(tmp != null) ret = Math.max(ret, val - tmp);
                        set.add(val);
                    }
                }
            }
            return ret;
        }
    }
}
