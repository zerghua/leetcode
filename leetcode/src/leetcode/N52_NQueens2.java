package leetcode;
import java.util.*;

/**
 * Created by Hua on 6/21/2016.

 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.

 */
public class N52_NQueens2 {
    //5 ms
    //backtracking, time o(n!), space o(n)
    int ret = 0;
    public int totalNQueens(int n) {
        findNQueens(0,n, new ArrayList<>());
        return ret;
    }

    public void findNQueens(int start_row, int n, List<Integer> visited_cols){
        if(start_row >= n) {
            ret++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isValidPosition(start_row, i, visited_cols)){
                visited_cols.add(i);
                findNQueens(start_row+1, n, visited_cols);
                visited_cols.remove(visited_cols.size() - 1);
            }
        }
    }

    // interesting way to check diagonal
    // if i and j in diagonal, ab(i_row - j_row) == ab(i_col - j_col)
    public boolean isValidPosition(int row_index, int col_index, List<Integer> visited_cols){
        for(int i=0;i<visited_cols.size();i++){
            if(col_index == visited_cols.get(i) ||
                    Math.abs(row_index - i) == Math.abs(col_index - visited_cols.get(i)))
                return false;
        }
        return true;
    }

}
