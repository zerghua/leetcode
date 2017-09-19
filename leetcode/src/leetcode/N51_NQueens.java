package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/26/2016.
 *
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement,

 where 'Q' and '.' both indicate a queen and an empty space respectively.

 */
public class N51_NQueens {
    // no company
    //10 ms
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        ArrayList<Integer> cols = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append(".");

        solveNQueens(0, n, ret, new ArrayList<String>(), sb, cols);
        return ret;
    }

    public void solveNQueens(int level, int n, List<List<String>> ret, List<String> solution, StringBuilder basic_row, ArrayList<Integer> cols){
        if(level == n){
            ret.add(new ArrayList<String>(solution));
            return;
        }

        for(int i=0; i<n;i++){
            if(isValidPosition(level, i, cols)){
                StringBuilder row = new StringBuilder(basic_row);
                row.setCharAt(i, 'Q');
                solution.add(row.toString());
                cols.add(i);
                solveNQueens(level+1, n, ret,solution, basic_row, cols);
                solution.remove(solution.size()-1);
                cols.remove(cols.size()-1);
            }
        }
    }

    // check diagonal and the same cols
    public boolean isValidPosition(int row_pos, int col_pos, ArrayList<Integer> cols){
        for(int i=0; i<cols.size(); i++){
            if(cols.get(i) == col_pos || Math.abs(i-row_pos) == Math.abs(cols.get(i) - col_pos))
                return false;
        }
        return true;
    }

}
