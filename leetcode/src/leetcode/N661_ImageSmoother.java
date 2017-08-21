package leetcode;

/**
 * Created by Hua on 8/21/2017.

 Given a 2D integer matrix M representing the gray scale of an image,
 you need to design a smoother to make the gray scale of each cell becomes the average gray scale
 (rounding down) of all the 8 surrounding cells and itself.
 If a cell has less than 8 surrounding cells, then use as many as you can.

 Example 1:

 Input:
 [[1,1,1],
 [1,0,1],
 [1,1,1]]
 Output:
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 Explanation:
 For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 For the point (1,1): floor(8/9) = floor(0.88888889) = 0

 Note:

 The value in the given matrix is in the range of [0, 255].
 The length and width of the given matrix are in the range of [1, 150].


 */
public class N661_ImageSmoother {
    // BF?
    // 202 / 202 test cases passed.
    // 26 ms
    class Solution {
        public int[][] imageSmoother(int[][] M) {
            int m = M.length, n = M[0].length;
            int[][] ret = new int[m][n];

            for(int i =0; i<m; i++){
                for(int j=0;j<n;j++){
                    ret[i][j] = get(M, i, j);
                }
            }
            return ret;
        }

        public int get(int[][] M, int x, int y){
            int count = 0, sum = 0, m = M.length, n = M[0].length;
            for(int i=x-1;i<=x+1; i++){
                for(int j=y-1;j<=y+1;j++){
                    if(i>=0 && i<m && j>=0 && j<n){
                        count++;
                        sum+=M[i][j];
                    }
                }
            }
            return sum/count;
        }
    }
}
