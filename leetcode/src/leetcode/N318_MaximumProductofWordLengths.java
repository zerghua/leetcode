package leetcode;

import java.util.HashSet;

/**
 * Created by HuaZ on 8/11/2016.

 Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 where the two words do not share common letters. You may assume that each word will contain
 only lower case letters. If no such two words exist, return 0.

 Example 1:

 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:

 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:

 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.

 */
public class N318_MaximumProductofWordLengths {
    // 288 ms
    // hashset o(n^2) time
    public int maxProduct(String[] words) {
        HashSet<Character>[]  map = new HashSet[words.length];
        for(int i=0; i<words.length;i++){
            char[] chars = words[i].toCharArray();
            map[i] = new HashSet<>();
            for(char c: chars) {
                map[i].add(c);
            }
        }

        int max = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                boolean isIntersected = false;
                for(char c: map[j]) {
                    if(map[i].contains(c)) {
                        isIntersected = true;
                        break;
                    }
                }
                if(!isIntersected) max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }

    // bit manipulation,  46 ms  o(n^2)
    // int has 64 bit, store 1 char as one bit.
    public int maxProduct2(String[] words) {
        int[]  map = new int[words.length];
        for(int i=0; i<words.length;i++){
            char[] chars = words[i].toCharArray();
            for(char c: chars) map[i] |= 1<< (c - 'a');
        }

        int max = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((map[i] & map[j]) == 0) max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
