package leetcode;

/**
 * Created by Hua on 10/2/2017.


 On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
 The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

 A chess knight has 8 possible moves it can make, as illustrated below.
 Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

 Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 (even if the piece would go off the chessboard) and moves there.

 The knight continues moving until it has made exactly K moves or has moved off the chessboard.
 Return the probability that the knight remains on the board after it has stopped moving.

 Example:

 Input: 3, 2, 0, 0
 Output: 0.0625
 Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 From each of those positions, there are also two moves that will keep the knight on the board.
 The total probability the knight stays on the board is 0.0625.

 Note:
 N will be between 1 and 25.
 K will be between 0 and 100.
 The knight always initially starts on the board.

 */
public class N688_KnightProbabilityinChessboard {
    // multiple iterations of dp
    // borrowed from others solution, but quite straight forward.
    // multiple places need to be double instead of int
    // 21 / 21 test cases passed.
    // 18 ms
    class Solution {
        public double knightProbability(int N, int K, int r, int c) {
            int[][] dirs = {{-2,1}, {-2,-1}, {-1,2}, {-1,-2}, {1,2}, {1,-2}, {2,1}, {2,-1}};
            double[][] dp = new double[N][N];
            dp[r][c] = 1;

            for(int k=0; k<K; k++){  //each steps
                double[][] ndp = new double[N][N];

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        for(int[] dir : dirs){
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if(ni >= 0 && nj >= 0 && ni < N && nj < N){
                                ndp[ni][nj] += dp[i][j]/8;
                            }
                        }

                    }
                }
                dp = ndp;
            }

            double ret = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) ret += dp[i][j];
            }
            return ret;
        }
    }
}
