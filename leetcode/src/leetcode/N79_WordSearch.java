package leetcode;

/**
 * Created by Hua on 4/10/2016.

 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 */
public class N79_WordSearch {
    // Facebook, Microsoft
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
