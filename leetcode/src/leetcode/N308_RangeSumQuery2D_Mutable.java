package leetcode;

/**
 * Created by Hua on 7/28/2017.

 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
 by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
 and (row2, col2) = (4, 3), which contains sum = 8.

 Example:

 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 update(3, 2, 2)
 sumRegion(2, 1, 4, 3) -> 10

 Note:

 The matrix is only modifiable by the update function.
 You may assume the number of calls to update and sumRegion function is distributed evenly.
 You may assume that row1 ≤ row2 and col1 ≤ col2.

 */
public class N308_RangeSumQuery2D_Mutable {
    // google
    // dp, o(m) + o(n) time
    // 17 / 17 test cases passed.
    // 283 ms
    public class NumMatrix {
        int[][] matrix;
        int[][] colSum; // colSum[i][j] = sum(matrix[0 ~ i-1][j])

        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return;
            int row = matrix.length, col = matrix[0].length;
            this.matrix = matrix;
            colSum = new int[row+1][col];   // more concise code
            for(int i=1; i< row+1; i++){
                for(int j=0; j<col; j++){
                    colSum[i][j] = colSum[i-1][j] + matrix[i-1][j];
                }
            }
        }

        // o(row)
        public void update(int row, int col, int val) {
            for(int i = row + 1; i<colSum.length; i++) colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
            matrix[row][col] = val;
        }

        // o(col)
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ret = 0;
            for(int j = col1; j<= col2; j++) ret += colSum[row2+1][j] - colSum[row1][j];
            return ret;
        }
    }



    // 17 / 17 test cases passed.
    // 289 ms
    // time should be O(log(m) * log(n))
    // Explanation of Binary Indexed Tree :
    // https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
    public class NumMatrix2 {

        int[][] tree;
        int[][] nums;
        int m;
        int n;

        public NumMatrix2(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m+1][n+1];
            nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            if (m == 0 || n == 0) return;
            int delta = val - nums[row][col];
            nums[row][col] = val;
            for (int i = row + 1; i <= m; i += i & (-i)) {
                for (int j = col + 1; j <= n; j += j & (-j)) {
                    tree[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0) return 0;
            return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
        }

        public int sum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= i & (-i)) {
                for (int j = col; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }

}
