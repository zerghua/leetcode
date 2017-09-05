package leetcode;

/**
 * Created by Hua on 3/18/2016.

 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 this one needs analyze and code.




     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3

    void rotate(vector<vector<int> > &matrix) {
        reverse(matrix.begin(), matrix.end());
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }


     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7

    void anti_rotate(vector<vector<int> > &matrix) {
        for (auto vi : matrix) reverse(vi.begin(), vi.end());
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }


 */
public class N48_RotateImage {
    // Microsoft, Amazon, Apple
    // reverse and swap, see reason above
    // 21 / 21 test cases passed.  on 9/5/2017
    // 3 ms
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length, i=0, j = n-1;
            // reverse each row
            while(i < j){
                int[] tmp = matrix[i];
                matrix[i] = matrix[j];
                matrix[j] = tmp;
                i++;j--;
            }

            // swap each char in diagonal
            for(i=0; i<n; i++){
                for(j = i+1; j<n; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }




    // 20 / 20 test cases passed.
    // 2 ms
    //https://en.wikipedia.org/wiki/In-place_matrix_transposition
    //https://algorithmstuff.wordpress.com/2013/06/15/rotate-a-matrix-by-90-degrees/
    // 4-way rotation
    public class Solution2 {
        public void rotate(int[][] matrix) {
            int n=matrix.length;
            int layers=n/2;

            for(int i=0; i<layers;i++) {
                for (int j = i; j < n - 1 - i; j++) {
                    int tmp = matrix[i][j];
                    //left ->top
                    matrix[i][j] = matrix[n - j - 1][i];

                    // botton -> left
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];

                    // right -> botton
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];

                    // top -> right
                    matrix[j][n - i - 1] = tmp;
                }
            }
        }
    }

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




}
