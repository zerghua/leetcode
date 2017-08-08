package leetcode;
import sun.awt.image.ImageWatched;

import java.util.*;
/**
 * Created by Hua on 6/23/2016.

 Given two words (beginWord and endWord), and a dictionary's word list,
 find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list

 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.


 */
public class N127_WordLadder {
    // Amazon, Facebook
    // shortest path should use BFS, DFS will TLE
    // 90 ms  37 / 37 test cases passed.  on 9/13/2016
    static class bfs{
        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
            wordList.remove(beginWord);
            wordList.add(endWord); // important
            LinkedList<String> list = new LinkedList<>();
            list.add(beginWord);
            int level = 0;
            while(!list.isEmpty()){
                int level_size = list.size();
                // for each level of BFS
                while(level_size-- > 0) {
                    String word = list.remove(0);
                    if (word.equals(endWord)) return level + 1;
                    addNeighborsToList(word, list, wordList);
                }
                level++;
            }
            return 0;
        }

        // add neighbors of word to list
        // for each position of word replace with 'a' - 'z'
        public void addNeighborsToList(String word, LinkedList<String> list, Set<String> wordList ){
            char[] chars = word.toCharArray();
            for(int i=0;i<word.length();i++){
                for(int j=0;j<26;j++){
                    if((char)('a'+j) == word.charAt(i)) continue;

                    chars[i] = (char) ('a' + j) ;
                    String newWord = new String(chars); //important, chars.toString won't work
                    if(wordList.contains(newWord)){
                        wordList.remove(newWord);
                        list.add(newWord);
                    }
                    chars[i] = word.charAt(i);
                }
            }
        }


    }

    public static void main(String[] args) {
        bfs x = new bfs();
        System.out.println(x.ladderLength("a", "c", new HashSet<>(Arrays.asList("a", "b", "c"))));
        //System.out.println(x.ladderLength("hot", "dog", new HashSet<>(Arrays.asList("hot", "dog"))));
    }

    // TLE
    class dfs {
        int min_times = Integer.MAX_VALUE;
        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
            if (beginWord.equals(endWord)) return 1;
            dfs(beginWord, endWord, wordList, 1, new HashSet<>());
            return min_times == Integer.MAX_VALUE ? 0 : min_times;
        }

        public void dfs(String beginWord, String endWord, Set<String> wordList,
                        int changed_times, HashSet<String> visited) {
            int word_diff = wordDifference(beginWord, endWord);
            if (word_diff <= 1) {
                min_times = Math.min(min_times, changed_times + word_diff);
                return;
            }

            for (String next_word : wordList) {
                if (!beginWord.equals(next_word) && !visited.contains(next_word)
                        && wordDifference(beginWord, next_word) < 2) {
                    visited.add(next_word);
                    dfs(next_word, endWord, wordList, changed_times + 1, visited);
                    visited.remove(next_word);
                }
            }
        }

        public int wordDifference(String a, String b) {
            int letter_difference = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) letter_difference++;
                if (letter_difference > 1) return 2; //pruning
            }
            return letter_difference;
        }

        public void main(String[] args) {
            //System.out.println(x.ladderLength("a", "c", new HashSet<>(Arrays.asList("a", "b","c"))));
            System.out.println(ladderLength("hot", "dog", new HashSet<>(Arrays.asList("hot", "dog"))));
        }
    }



}
