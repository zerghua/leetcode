package leetcode;

import java.util.*;

/**
 * Created by Hua on 6/5/2017.

 Given a list of words (without duplicates), please write a program that returns all concatenated words
 in the given list of words.

 A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 Example:

 Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

 Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

 Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

 Note:

 The number of elements of the given array will not exceed 10,000
 The length sum of elements in the given array will not exceed 600,000.
 All the input string will only include lower case letters.
 The returned elements order does not matter.

 */
public class N472_ConcatenatedWords {
    // reuse DP solution from N139 word Break + some business logic, sort array and search from small words.
    // 44 / 44 test cases passed.
    // 605 ms
    // There is also a trie + DFS solution which might be faster.
    public class Solution {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Arrays.sort(words, (a,b) -> a.length() - b.length());
            List<String> ret = new LinkedList<>();
            Set<String> set = new HashSet();
            for(String word: words){
                if(canForm(word, set)) ret.add(word);
                set.add(word);
            }
            return ret;
        }

        public boolean canForm(String s, Set<String> set){
            if(set.isEmpty()) return false;
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            for(int i=1; i<= s.length(); i++){
                for(int j=0; j<i; j++){
                    if(dp[j] && set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }


}
