package leetcode;

/**
 * Created by Hua on 4/10/2016.
 */
public class N79_WordSearch {
    //16 ms
    //DFS, backtracking, similar to N200.
    public boolean exist(char[][] board, String word) {
        int rows= board.length;
        int cols= board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        for(int i=0; i<rows;i++) {
            for (int j = 0; j <cols; j++) {
                if(exist(board, word, 0, i, j, isVisited)) return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int word_pos, int i, int j,
                         boolean[][] isVisited ){
        if(word_pos >= word.length()) return true;

        // boundry checking
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;

        // conditional checking
        if(isVisited[i][j] || word.charAt(word_pos) != board[i][j]) return false;

        isVisited[i][j] = true;
        if(exist(board, word, word_pos+1, i-1, j, isVisited)) return true;
        if(exist(board, word, word_pos+1, i+1, j, isVisited)) return true;
        if(exist(board, word, word_pos+1, i, j-1, isVisited)) return true;
        if(exist(board, word, word_pos+1, i, j+1, isVisited)) return true;

        isVisited[i][j] = false;
        return false;
    }
}
