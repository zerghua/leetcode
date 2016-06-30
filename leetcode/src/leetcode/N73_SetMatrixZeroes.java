package leetcode;

/**
 * Created by Hua on 5/29/2016.

 Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 Do it in place.

 click to show follow up.
 Follow up:

 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?


 */
public class N73_SetMatrixZeroes {
    // matrix in place update status. simiar to N289 Game of Life.
    // o(1) space, use first row and col as indicator
    // store if first row and col should be set to 0
    // 2 ms
    public void setZeroes(int[][] matrix) {
        if(matrix ==null || matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;

        boolean shouldSetFirstRow = false;
        boolean shouldSetFirstCol = false;
        // record if first row and col should be set to 0
        for(int i=0;i<col;i++){
            if(matrix[0][i] == 0) {
                shouldSetFirstRow =true;
                break;
            }
        }

        // first col
        for(int i=0;i<row;i++){
            if(matrix[i][0] == 0) {
                shouldSetFirstCol =true;
                break;
            }
        }

        // check all cells and record should set as 0 on first row and col
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set 0 use marker on first row and col
        for(int i=1; i< row; i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0] ==0 || matrix[0][j]==0) matrix[i][j] = 0;
            }
        }

        // set first row
        if(shouldSetFirstRow){
            for(int i=0;i<col;i++) matrix[0][i] = 0;
        }

        // set first col
        if(shouldSetFirstCol){
            for(int i=0;i<row;i++) matrix[i][0] = 0;
        }

    }
}
