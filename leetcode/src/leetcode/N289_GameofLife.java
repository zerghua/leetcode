package leetcode;

/**
 * Created by Hua on 5/28/2016.

 According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 using the following four rules (taken from the above Wikipedia article):

 1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 2.Any live cell with two or three live neighbors lives on to the next generation.
 3.Any live cell with more than three live neighbors dies, as if by over-population..
 4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

 Write a function to compute the next state (after one update) of the board given
 its current state.

 Follow up:

 Could you solve it in-place? Remember that the board needs to be updated at the same time:
 You cannot update some cells first and then use their updated values to update other cells.
 In this question, we represent the board using a 2D array. In principle, the board is
 infinite, which would cause problems when the active area encroaches the border of the array.
 How would you address these problems?


 */
public class N289_GameofLife {
    // Google, Snapchat
    // with o(m*n) space
    // 1 ms
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        int[][] new_board = new int[row][col];

        // count each cell's neighbors, and play with rule.
        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                int num = get_num_of_live_neighbors(i,j,board);
                if(num==3) new_board[i][j]= 1;
                else if(num==2) new_board[i][j] = board[i][j];
                else new_board[i][j]=0;
            }
        }

        // copy it back
        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                board[i][j] = new_board[i][j];
            }
        }
    }

    // at most 8 neighbors
    public int get_num_of_live_neighbors(int x, int y, int[][] board){
        int ret=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i==x && j==y) continue;
                if(i<0 || i>=board.length || j<0 || j>=board[0].length) continue;
                ret+=board[i][j];
            }
        }
        return ret;
    }

    // in place, use second bit in int to store updated status.
    // 0 -> 00 or 10  which is 0 or 2 integer
    // 1 -> 01 or 11  which is 1 or 3 integer
    // 1 ms
    // needs to change how to count live neighbors
    public void gameOfLife2(int[][] board) {
        if(board == null || board.length==0) return;
        int row = board.length;
        int col = board[0].length;

        // count each cell's neighbors, and play with rule.
        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                int num = get_num_of_live_neighbors(i,j,board);
                if(board[i][j] == 1 && (num==3 || num==2)) board[i][j] = 3; //live->live
                if(board[i][j] == 0 && num==3) board[i][j] = 2; // dead->live
            }
        }

        // move 1 bit right
        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                board[i][j] >>= 1; // or board[i][j]%2
            }
        }
    }

    // at most 8 neighbors
    public int get_num_of_live_neighbors2(int x, int y, int[][] board){
        int ret=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i==x && j==y) continue;
                if(i<0 || i>=board.length || j<0 || j>=board[0].length) continue;
                ret+=board[i][j]%2; // get previous live/die state, equals board[i][j]>>1,
            }
        }
        return ret;
    }



}
