package leetcode;

/**
 * Created by Hua on 7/14/2017.

 Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
     [ 1, 0, 0],
     [-1, 0, 3]
 ]

 B = [
     [ 7, 0, 0 ],
     [ 0, 0, 0 ],
     [ 0, 0, 1 ]
 ]


      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
      | 0 0 1 |



 The idea is derived from a CMU lecture.

 A sparse matrix can be represented as a sequence of rows, each of which is a sequence of (column-number, value)
 pairs of the nonzero values in the row.

 So let's create a non-zero array for A, and do multiplication on B.


 */

import java.util.*;
public class N311_SparseMatrixMultiplication {
    // Facebook, Linkedin
    // math. not trivia
    // 12 / 12 test cases passed.
    // 69 ms
    public class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length, n = A[0].length, nB = B[0].length;
            int[][] C = new int[m][nB];

            for(int i = 0; i < m; i++) {
                for(int k = 0; k < n; k++) {
                    if (A[i][k] != 0) {
                        for (int j = 0; j < nB; j++) {
                            if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
            return C;
        }
    }

    public class Solution2 {
        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length, n = A[0].length, nB = B[0].length;
            int[][] result = new int[m][nB];

            List[] indexA = new List[m];
            for(int i = 0; i < m; i++) {
                List<Integer> numsA = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    if(A[i][j] != 0){
                        numsA.add(j);
                        numsA.add(A[i][j]);
                    }
                }
                indexA[i] = numsA;
            }

            for(int i = 0; i < m; i++) {
                List<Integer> numsA = indexA[i];
                for(int p = 0; p < numsA.size() - 1; p += 2) {
                    int colA = numsA.get(p);
                    int valA = numsA.get(p + 1);
                    for(int j = 0; j < nB; j ++) {
                        int valB = B[colA][j];
                        result[i][j] += valA * valB;
                    }
                }
            }

            return result;
        }
    }

}
