package leetcode;

/**
 * Created by Hua on 5/15/2017.

 Given a matrix of M x N elements (M rows, N columns),
 return all elements of the matrix in diagonal order as shown in the below image.

 Example:

 Input:
 [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
 ]
 Output:  [1,2,4,7,5,3,6,8,9]
 Explanation:

 Note:

 The total number of elements of the given matrix will not exceed 10,000.


 */
public class N498_DiagonalTraverse {
    // Google
    // up(i--, j++), down(i++, j--), up, down, ...
    // 32 / 32 test cases passed.  on 8/30/2017
    // 8 ms
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return new int[0];
            int m = matrix.length, n = matrix[0].length, d=1, i=0, j=0;
            int[] ret = new int[m * n];
            for(int k = 0; k< ret.length; k++){
                ret[k] = matrix[i][j];
                i -= d;
                j += d;

                if(i >= m){i = m-1; j += 2; d= -d;}         // exceed bottom
                else if(j >= n){j = n-1; i += 2; d= -d;}    // exceed right
                else if(i < 0){i = 0; d= -d;}               // exceed top
                else if(j < 0){j = 0; d= -d;}               // exceed left
            }
            return ret;
        }
    }



    // find walk pattern, need some time to figure it out.
    // 32 / 32 test cases passed.
    // 9 ms
    public class Solution2 {
        public int[] findDiagonalOrder(int[][] matrix) {
            if(matrix.length == 0) return new int[0];
            int row = matrix.length, col = matrix[0].length, i=0, j=0;
            int[] ret = new int[row * col];

            for(int k = 0; k < ret.length; k++){
                ret[k] = matrix[i][j];
                // sequence are important here
                if((i+j) % 2 == 0){ // moving up
                    if(j == col -1) i++;
                    else if(i == 0) j++;
                    else {i--; j++;}
                } else{  // moving down
                    if(i == row -1) j++;
                    else if(j == 0) i++;
                    else {i++; j--;}
                }
            }
            return ret;
        }
    }
}
