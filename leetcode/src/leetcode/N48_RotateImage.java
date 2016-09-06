package leetcode;

/**
 * Created by Hua on 3/18/2016.

 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 this one needs analyze and code.

 */
public class N48_RotateImage {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] ret = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                ret[j][n-1-i] = matrix[i][j]; //important
            }
        }

        //copy back as result
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = ret[i][j];
            }
        }
    }

    //https://en.wikipedia.org/wiki/In-place_matrix_transposition
    //https://algorithmstuff.wordpress.com/2013/06/15/rotate-a-matrix-by-90-degrees/
    public void rotate_inplace(int[][] matrix){
        int n=matrix.length;
        int layers=n/2;

        for(int i=0; i<layers;i++)
            for(int j=i; j<n-1-i;j++){
                int tmp = matrix[i][j];
                //left ->top
                matrix[i][j] = matrix[n-j-1][i];

                // botton -> left
                matrix[n-j-1][i] =  matrix[n-i-1][n-j-1];

                // right -> botton
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];

                // top -> right
                matrix[j][n-i-1] = tmp;
            }
    }


}
