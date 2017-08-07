package leetcode;
import java.util.*;

/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


version 2 added on 9/2/2016

 */

public class N36_ValidSudoku {
    // Apple, Uber
	// 4 ms 501 / 501 test cases passed.
	// concise and fast code.
	public boolean isValidSudoku2(char[][] board) {
		int row_size = board[0].length;
		int col_size = board.length;

		boolean[][] row = new boolean[row_size][col_size];
		boolean[][] col = new boolean[row_size][col_size];
		boolean[][] box = new boolean[row_size][col_size];

		for(int i=0;i<row_size;i++){
			for(int j=0;j<col_size;j++){
				if(board[i][j] != '.'){
					int num = board[i][j] - '0' -1; // change [1,9] to [0,8] to match index
					int k = (i/3)*3 + j/3;          // smart part transfer box to [0,8] according to its index
					if(row[i][num] || col[j][num] || box[k][num]) return false;
					row[i][num] = col[j][num] = box[k][num] = true;
				}
			}
		}
		return true;
	}


	//15 ms
    public boolean isValidSudoku(char[][] board) {
    	int row_size = board.length;
    	int col_size = board[0].length;    	
    	//row 
    	for(int i=0; i< row_size;i++){
    		HashSet<Character> hs = new HashSet<Character>();
    		for(int j=0;j<col_size;j++)
    			if(hs.contains(board[i][j]) && board[i][j] != '.') return false;
    			else hs.add(board[i][j]);
    	}  	
    	//column
    	for(int i=0; i< col_size;i++){
    		HashSet<Character> hs = new HashSet<Character>();
    		for(int j=0;j<row_size;j++)
    			if(hs.contains(board[j][i]) && board[j][i] != '.') return false;
    			else hs.add(board[j][i]);
    	}
    	//sub 9 squares
    	for(int a=0;a<row_size;a+=3){
    		for(int b=0;b<col_size;b+=3){
    			//one square
    			HashSet<Character> hs = new HashSet<Character>();
    			for(int i=a;i<a+3;i++)
    				for(int j=b;j<b+3;j++){
    	    			if(hs.contains(board[i][j]) && board[i][j] != '.') return false;
    	    			else hs.add(board[i][j]);
    				}
    		}
    	}
    	return true;
    }


}
