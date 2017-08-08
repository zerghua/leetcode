package leetcode;

/**
 * Created by Hua on 7/11/2017.

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */

import java.util.*;
public class N243_ShortestWordDistance {
    // Linkedin
    // binary search, o(nlogn)
    // 26 / 26 test cases passed.
    // 5 ms
    public class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            TreeSet<Integer> set = new TreeSet();
            for(int i=0; i<words.length; i++){
                if(words[i].equals(word1)) set.add(i);
            }

            int ret = Integer.MAX_VALUE;
            for(int i=0; i<words.length; i++){
                if(words[i].equals(word2)){
                    if(set.floor(i) != null) ret = Math.min(ret, Math.abs(i - set.floor(i)));
                    if(set.ceiling(i) != null) ret = Math.min(ret, Math.abs(i - set.ceiling(i)));
                }
            }
            return ret;
        }
    }


    // o(n)
    // 26 / 26 test cases passed.
    // 3 ms
    public class Solution2 {
        public int shortestDistance(String[] words, String word1, String word2) {
            int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) p1 = i;
                if (words[i].equals(word2)) p2 = i;
                if (p1 != -1 && p2 != -1) min = Math.min(min, Math.abs(p1 - p2));
            }

            return min;
        }
    }
}
