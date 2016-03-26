package leetcode;

/**
 * Created by Hua on 3/26/2016.
 */
public class N63_UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows= obstacleGrid.length;
        int cols= obstacleGrid[0].length;

        int[][] ret = new int[rows][cols];
        if(obstacleGrid[0][0] == 1) return 0;
        else ret[0][0] = 1;

        //first row
        for(int i=1;i<cols;i++){
            if(obstacleGrid[0][i] ==1) ret[0][i] = 0;
            else ret[0][i] = ret[0][i-1];
        }

        //first cols
        for(int i=1;i<rows;i++){
            if(obstacleGrid[i][0] ==1) ret[i][0] = 0;
            else ret[i][0] = ret[i-1][0];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(obstacleGrid[i][j] == 1) ret[i][j]=0;
                else  ret[i][j] = ret[i-1][j] + ret[i][j-1];

            }
        }

        return ret[rows-1][cols-1];
    }
}
