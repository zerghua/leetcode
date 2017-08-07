package leetcode;

/**
 * Created by Hua on 3/21/2016.

 Write an efficient algorithm that searches for a value in an m x n matrix.
 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 For example,

 Consider the following matrix:

 [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
 ]

 Given target = 3, return true.

 */


// obviously use binary search
// new on how to implement it on matrix rather than array
public class N74_Searcha2DMatrix {
    // no company
    // n start from 1
    public int get_matrix_value(int[][] matrix, int n){
        int col_size = matrix[0].length;

        int row = (n-1)/col_size;
        int col = (n-1)%col_size;

        return matrix[row][col];
    }


    //switch to array representation
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 1, right = matrix.length * matrix[0].length;
        while(left <= right){
            int mid = (right-left)/2 + left;
            int val = get_matrix_value(matrix,mid);

            if(val == target) return true;
            else if (val < target) left = mid+1;
            else right = mid-1;
        }

        return false;
    }

    // version 2 added on 9/9/2016
    // binary search in 2-d matrix, val=matrix[mid/col][mid%col]
    // this solution is guaranteed by problem description
    // 0 ms  134 / 134 test cases passed.
    // time log(m+n)
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length, col = matrix[0].length;
            int left = 0, right= row * col - 1;
            while(left <= right){
                int mid = (right-left)/2 + left;
                int midValue = matrix[mid/col][mid%col];
                if (midValue == target) return true;
                else if (midValue >target) right = mid -1;
                else left = mid + 1;
            }
            return false;
        }
    }
}
