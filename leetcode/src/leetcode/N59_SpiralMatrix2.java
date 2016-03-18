public class Solution {
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
}
