package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/29/2016.
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.
 */
public class N37_SudokuSolver {
    // Uber, Snapchat
    // backtracking, try all possible input
    // 6 / 6 test cases passed.  on 9/19/2017
    // 15 ms
    class Solution {
        public void solveSudoku(char[][] board) {
            solveSudoku(board, 0);
        }

        // range from [0, 80]
        private boolean solveSudoku(char[][] board, int sequence) {
            System.out.println(sequence);
            if( sequence >= 81 ) return true;
            int row = sequence/9;
            int col = sequence%9;
            if(board[row][col] != '.') {
                if (solveSudoku(board, sequence + 1)) return true; //pruning, early return
            }
            else{
                for(char i='1'; i<='9';i++){
                    if(isValid(board, row, col, i)){
                        board[row][col] = i;
                        if(solveSudoku(board,sequence+1)) return true; //pruning, early return
                        board[row][col] = '.';
                    }
                }
            }
            return false;
        }


        private boolean isValid(char[][] board, int row, int col, char num) {
            // check row
            for(int i=0;i<9;i++){
                if(board[row][i] == num) return false;
            }

            // check col
            for(int i=0;i<9;i++){
                if(board[i][col] == num) return false;
            }

            // check square
            row = 3 * (row/3);
            col = 3 * (col/3);
            for(int i=row; i<row+3; i++){
                for(int j=col; j<col+3;j++){
                    if(board[i][j] == num) return false;
                }
            }
            return true;
        }
    }



    // another solution
    // 6 / 6 test cases passed.  on 9/19/2017
    // 25 ms
    public class Solution2 {
        public void solveSudoku(char[][] board) {
            if(board == null || board.length == 0)
                return;
            solve(board);
        }

        public boolean solve(char[][] board){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == '.'){
                        for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                            if(isValid(board, i, j, c)){
                                board[i][j] = c; //Put c for this cell

                                if(solve(board))
                                    return true; //If it's the solution return true
                                else
                                    board[i][j] = '.'; //Otherwise go back
                            }
                        }

                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c){
            for(int i = 0; i < 9; i++) {
                if(board[i][col] != '.' && board[i][col] == c) return false; //check row
                if(board[row][i] != '.' && board[row][i] == c) return false; //check column
                if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                        board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
            }
            return true;
        }
    }


    public static void main(String[] args) {
        String[] s = new String[]{
                "..9748...","7........",".2.1.9...",
                "..7...24.",".64.1.59.",".98...3..",
                "...8.3.2.","........6","...2759.."
        };

        char[][] table = new char[9][9];
        for(int i=0;i<9;i++){
            table[i] = s[i].toCharArray();
        }

        N37_SudokuSolver x= new N37_SudokuSolver();
        //x.solveSudoku(table);
    }
}
