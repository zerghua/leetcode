package leetcode;
import java.util.*;
/**
 * Created by Hua on 8/14/16.

 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Return ["eat","oath"].

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 click to show hint.

 You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

 If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not?
 How about a Trie? If you would like to learn how to implement a basic trie,
 please work on this problem: Implement Trie (Prefix Tree) first.

 https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00/2
 */
public class N212_WordSearch2 {
    // 20 ms
    // use '#' in board instead of another visited[][] array.
    // trie, dfs and backtracking.
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        TrieNode trie = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, trie, i, j, ret);
            }
        }
        return ret;
    }

    public void dfs(char[][] board, TrieNode trie, int i, int j, List<String> ret){
        char c = board[i][j];
        int index = c -'a';
        if(c == '#' || trie.children[index] == null) return;
        trie = trie.children[index];
        if(trie.word != null){
            ret.add(trie.word);
            trie.word = null;
        }
        board[i][j] = '#';
        if(i>0) dfs(board,trie, i-1,j, ret);
        if(j>0) dfs(board,trie, i,j-1, ret);
        if(i<board.length-1) dfs(board, trie, i+1, j, ret);
        if(j<board[0].length-1) dfs(board,trie, i, j+1, ret);
        board[i][j] = c;
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s: words){
            TrieNode node = root;
            for(char c: s.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.word = s;
        }
        return root;
    }


}
