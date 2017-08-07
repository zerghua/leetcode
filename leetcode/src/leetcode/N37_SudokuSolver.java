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
    // 17 ms
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
        x.solveSudoku(table);
    }
}
