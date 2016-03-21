package leetcode;

/**
 * Created by Hua on 3/21/2016.
 */


// obviously use binary search
// new on how to implement it on matrix rather than array
public class N74_Searcha2DMatrix {

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
}
