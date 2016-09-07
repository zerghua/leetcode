package leetcode;
/*
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


 */
public class N59_SpiralMatrix2 {
    //0 ms 14.9%
    public int[][] generateMatrix(int n) {
        if(n<1) return new int[0][0];
        
        int nums=1;
        int[][] matrix = new int[n][n];
        int row_start=0, row_end=n-1, col_start=0, col_end=n-1;
        while(nums<=n*n){
            for(int i=col_start; i<=col_end; i++) matrix[row_start][i] = nums++;
            row_start++;
            
            for(int i=row_start; i<=row_end; i++) matrix[i][col_end] = nums++;
            col_end--;
            
            for(int i=col_end; i>=col_start; i--) matrix[row_end][i] = nums++;
            row_end--;
            
            for(int i=row_end; i>=row_start; i--) matrix[i][col_start] = nums++;
            col_start++;
        }
        return matrix;
    }


    // 0 ms  21 / 21 test cases passed.
    // very similar to Spiral Matrix 54, 4 sides of 4 loops.
    public class Solution {
        public int[][] generateMatrix(int n) {
            if(n<1) return new int[0][0];
            int num = 1, top = 0, left =0, bottom = n-1, right = n-1;
            int[][] ret = new int[n][n];
            while(num<= n*n){
                // top side
                for(int i=left; i<=right; i++) ret[top][i] = num++;
                top++;

                // right side
                for(int i=top; i<= bottom; i++) ret[i][right] = num++;
                right--;

                // bottom side
                for(int i=right; i>=left; i--) ret[bottom][i] = num++;
                bottom--;

                //left side
                for(int i=bottom; i>=top; i--) ret[i][left] = num++;
                left++;
            }
            return ret;
        }
    }

}
