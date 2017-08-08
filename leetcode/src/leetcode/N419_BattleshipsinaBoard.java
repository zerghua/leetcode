package leetcode;

/**
 * Created by HuaZ on 10/17/2016.

 Given an 2D board, count how many different battleships are in it.
 The battleships are represented with 'X's, empty slots are represented with '.'s.
 You may assume the following rules:

 You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically. In other words,
 they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column),
 where N can be of any size.

 At least one horizontal or vertical cell separates between two battleships -
 there are no adjacent battleships.

 Example:

 X..X
 ...X
 ...X

 In the above board there are 2 battleships.

 Invalid Example:

 ...X
 XXXX
 ...X

 This is not a valid board - as battleships will always have a cell separating between them.

 Your algorithm should not modify the value of the board.

 */
public class N419_BattleshipsinaBoard {
    // Microsoft
    // DFS + backtracking(visited array)
    // 4 ms 28 / 28 test cases passed.
    public class Solution {
        public int countBattleships(char[][] board) {
            int row = board.length, col = board[0].length;
            boolean[][] visited = new boolean[row][col];
            int ret = 0;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(!visited[i][j] && board[i][j]== 'X') {
                        ret++;
                        dfs(board, visited, i, j);
                    }
                }
            }
            return ret;
        }

        public void dfs(char[][] board, boolean[][] visited, int i, int j){
            int row = board.length, col = board[0].length;
            if(i>=row || j>=col || board[i][j] == '.') return;

            visited[i][j] = true;
            dfs(board, visited, i+1, j);
            dfs(board, visited, i, j+1);
        }
    }

    // simpler solution
    // 4 ms 28 / 28 test cases passed.
    public class Solution2 {
        public int countBattleships(char[][] board) {
            int m = board.length;
            if (m==0) return 0;
            int n = board[0].length;

            int ret=0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (board[i][j] == '.') continue;
                    if (i > 0 && board[i-1][j] == 'X') continue;
                    if (j > 0 && board[i][j-1] == 'X') continue;
                    ret++;
                }
            }
            return ret;
        }
    }


}
