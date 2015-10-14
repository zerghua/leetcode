package leetcode;
import java.util.*;
public class N36_ValidSudoku {
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
