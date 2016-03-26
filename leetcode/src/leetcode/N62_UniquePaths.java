package leetcode;

/**
 A robot is located at the top-left corner of a m x n grid
 (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid
 (marked 'Finish' in the diagram below).

 Note: m and n will be at most 100.

 How many possible unique paths are there?
 */
public class N62_UniquePaths {
    //1 ms
    public int uniquePaths2(int m, int n) {
        // corner cases
        if(m< 1 || n< 1) return 0;
        if(m==1 || n==1) return 1;

        int[][] map = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n;j++){
                if(i==1 || j==1) map[i][j] = 1;
                else map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m][n];
    }

    //Time Limit Exceeded, should work for small numbers
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 0;
        if(m==1) return 1;
        if(n==1) return 1;
        return uniquePaths(m-1, n) +  uniquePaths(m, n-1);
    }
}
