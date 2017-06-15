package leetcode;

/**
 * Created by Hua on 6/15/2017.

 There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to
 adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most
 move N times. Find out the number of paths to move the ball out of grid boundary.
 The answer may be very large, return it after mod 10^9 + 7.


 Example 1:

 Input:m = 2, n = 2, N = 2, i = 0, j = 0
 Output: 6
 Explanation:

 Example 2:

 Input:m = 1, n = 3, N = 3, i = 0, j = 1
 Output: 12
 Explanation:

 Note:

 Once you move the ball out of boundary, you cannot move it back.
 The length and height of the grid is in range [1,50].
 N is in range [0,50].


 */
public class N576_OutofBoundaryPaths {
    // very interesting DP, update matrix of each iteration.
    // 94 / 94 test cases passed.
    // 33 ms
    public class Solution {
        public int findPaths(int m, int n, int N, int i, int j) {
            if(N <=0 ) return 0;
            int MOD = (int)Math.pow(10, 9) + 7,  ret = 0;
            int[][] count = new int[m][n];
            count[i][j] = 1;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

            for(int step = 0; step< N; step++){
                int[][] tmp = new int[m][n];
                for(int r = 0; r<m; r++){
                    for(int c = 0; c<n ; c++){
                        for(int[] dir: dirs){
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if(nr <0 || nr >=m || nc <0 || nc >=n){
                                ret = (ret + count[r][c]) % MOD;
                            }else{
                                tmp[nr][nc] = (tmp[nr][nc] + count[r][c]) % MOD ;
                            }
                        }
                    }
                }
                count = tmp;
            }
            return ret;
        }
    }

}
