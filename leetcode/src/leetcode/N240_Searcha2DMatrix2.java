package leetcode;

/**
 * Created by Hua on 3/18/2016.

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.

 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]

 Given target = 5, return true.

 Given target = 20, return false.

 */
public class N240_Searcha2DMatrix2 {
    // Amazon, Google, Apple.
    // binary search in each row, o(mlogn)  24%, means testing data is small
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row=0; row<matrix.length; row++){
            int i=0, j=matrix[0].length-1;
            while(i<=j){
                int mid = (j-i)/2 + i;
                if(matrix[row][mid] == target) return true;
                else if (matrix[row][mid] > target) j = mid-1;
                else i = mid+1;
            }
        }
        return false;
    }

    // start from top right,  o(m+n)  93%
    public boolean searchMatrix2(int[][] matrix, int target) {
        int col=matrix[0].length-1, row=0;

        while(col>=0 && row<matrix.length){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }

        return false;
    }




}
