package leetcode;

/**
 * Created by Hua on 5/18/2017.

 Let's play the minesweeper game (Wikipedia, online game)!

 You are given a 2D char matrix representing the game board.
 'M' represents an unrevealed mine,
 'E' represents an unrevealed empty square,
 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines,
 digit ('1' to '8') represents how many mines are adjacent to this revealed square,
 and finally 'X' represents a revealed mine.

 Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'),
 return the board after revealing this position according to the following rules:

 If a mine ('M') is revealed, then the game is over - change it to 'X'.

 If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of
 its adjacent unrevealed squares should be revealed recursively.

 If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 representing the number of adjacent mines.
 Return the board when no more squares will be revealed.

 Example 1:

 Input:

 [['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

 Click : [3,0]

 Output:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Explanation:

 Example 2:

 Input:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Click : [1,2]

 Output:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Explanation:

 Note:

 The range of the input matrix's height and width is [1,50].
 The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 The input board won't be a stage when game is over (some mines have been revealed).
 For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.

 */
public class N529_Minesweeper {
    // DFS
    // 54 / 54 test cases passed.
    // 12 ms
    public class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            // step on mine
            if(board[click[0]][click[1]] == 'M') {
                board[click[0]][click[1]] = 'X';
                return board;
            }

            // update board
            dfs(board, click[0], click[1]);
            return board;
        }

        public void dfs(char[][] board, int i, int j){
            int row = board.length, col = board[0].length;
            if(i < 0 || i>= row || j < 0 || j>= col || board[i][j] != 'E') return;
            int numOfMine = countNearByMine(board, i, j);
            if( numOfMine == 0){
                board[i][j] = 'B';
                int[][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1, 0}, {1,1}, {1,-1}, {-1,1}, {-1, -1}};
                for(int[] dir : dirs){
                    int a = i + dir[0], b= j + dir[1];
                    if(a >=0 && a < row && b>=0 && b<col && board[a][b] == 'E') dfs(board, a, b);
                }
            } else board[i][j] = (numOfMine + "").charAt(0);  // or board[i][j] = (char)('0' + numOfMine);
        }

        public int countNearByMine(char[][] board, int i, int j){
            int[][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1, 0}, {1,1}, {1,-1}, {-1,1}, {-1, -1}};
            int ret = 0, row = board.length, col = board[0].length;
            for(int[] dir : dirs){
                int a = i + dir[0], b= j + dir[1];
                if(a >=0 && a < row && b>=0 && b<col && board[a][b] == 'M') ret++;
            }
            return ret;
        }
    }
}
