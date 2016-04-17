package leetcode;
import javax.annotation.PostConstruct;
import java.util.*;
/**
 * Created by Hua on 4/17/2016.
 */

    //BFS, DFS will stack overflow?

public class N130_SurroundedRegions {
    public static class Pair{
        int x; int y;
        Pair(int x, int y){this.x=x; this.y=y;}
    }

    //24 ms
    public void solve(char[][] board) {
        if(board == null || board.length==0) return;
        Queue<Pair> list = new LinkedList<>();
        pushBoarderToQueue(board, list);
        bfs_neighbors(board, list);
        revertPToO(board);
    }

    private void revertPToO(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'P') board[i][j] = 'O';
            }
        }
    }

    private void bfs_neighbors(char[][] board, Queue<Pair> list) {
        int rows = board.length;
        int cols = board[0].length;

        while(!list.isEmpty()){
            Pair p = list.poll();
            int x= p.x;
            int y= p.y;

            if(x - 1 >=0 && board[x-1][y] == 'O') {
                board[x-1][y] = 'P';
                list.add(new Pair(x - 1, y));
            }
            if(x + 1 <rows && board[x+1][y] == 'O') {
                board[x+1][y] = 'P';
                list.add(new Pair(x + 1, y));
            }
            if(y - 1 >=0 && board[x][y-1] == 'O') {
                board[x][y-1] = 'P';
                list.add(new Pair(x, y - 1));
            }
            if(y + 1 <cols && board[x][y+1] == 'O') {
                board[x][y+1] = 'P';
                list.add(new Pair(x, y + 1));
            }
        }
    }

    private void pushBoarderToQueue(char[][] board, Queue<Pair> list) {
        int rows = board.length;
        int cols = board[0].length;
        //top and bottom
        for(int i=0; i<cols; i++) {
            if(board[0][i] == 'O') {
                board[0][i] = 'P';
                list.add(new Pair(0, i));
            }

            if (board[rows - 1][i] == 'O') {
                board[rows - 1][i] = 'P';
                list.add(new Pair(rows - 1, i));
            }
        }

        //left and right
        for(int j=0; j< rows ; j++){
            if(board[j][0] == 'O') {
                board[j][0] = 'P';
                list.add(new Pair(j, 0));
            }

            if (board[j][cols - 1] == 'O') {
                board[j][cols - 1] = 'P';
                list.add(new Pair(j, cols - 1));
            }

        }
    }

    // should be faster and less code
    // 10 ms
    public void solve2(char[][] board) {
        if(board == null || board.length==0) return;
        Queue<Pair> list = new LinkedList<>();
        bfs_along_board(board, list);
        revertPToO(board);
    }

    private void bfs_along_board(char[][] board, Queue<Pair> list) {
        int rows = board.length;
        int cols = board[0].length;
        //top and bottom
        for(int i=0; i<cols; i++) {
            if(board[0][i] == 'O')  bfs(board, list, 0, i);
            if(board[rows - 1][i] == 'O') bfs(board, list, rows-1, i);
        }

        //left and right
        for(int j=0; j< rows ; j++){
            if(board[j][0] == 'O') bfs(board, list, j, 0);
            if(board[j][cols - 1] == 'O') bfs(board, list, j, cols-1);
        }
    }

    private void bfs(char[][] board, Queue<Pair> list, int i, int j){
        updateCellToP(board, list, i, j);
        while(!list.isEmpty()){
            Pair p = list.poll();
            int x= p.x;
            int y= p.y;

            updateCellToP(board, list, x+1, y);
            updateCellToP(board, list, x-1, y);
            updateCellToP(board, list, x, y+1);
            updateCellToP(board, list, x, y-1);
        }
    }

    private void updateCellToP(char[][] board, Queue<Pair> list, int i, int j){
        int rows = board.length;
        int cols = board[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols || board[i][j] != 'O') return;
        board[i][j] = 'P';
        list.add(new Pair(i,j));
    }



    public static void main(String[] args) {
        char[][] table = new char[][] {
                "OO".toCharArray()
                , "OO".toCharArray()
        };

        N130_SurroundedRegions x= new N130_SurroundedRegions();
        //x.solve(table);

        Pair p = new Pair(1,2);
        System.out.println(p.x + " " + p.y);

    }

}
