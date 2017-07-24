package leetcode;

/**
 * Created by Hua on 7/24/2017.


 Given a set of words (without duplicates), find all word squares you can build from them.

 A sequence of words forms a valid word square if the kth row and column read the exact same string,
 where 0 ≤ k < max(numRows, numColumns).

 For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads
 the same both horizontally and vertically.

 b a l l
 a r e a
 l e a d
 l a d y

 Note:

 There are at least 1 and at most 1000 words.
 All words will have the exact same length.
 Word length is at least 1 and at most 5.
 Each word contains only lowercase English alphabet a-z.

 Example 1:

 Input:
 ["area","lead","wall","lady","ball"]

 Output:
 [
 [ "wall",
 "area",
 "lead",
 "lady"
 ],
 [ "ball",
 "area",
 "lead",
 "lady"
 ]
 ]

 Explanation:
 The output consists of two word squares.
 The order of output does not matter (just the order of words in each word square matters).

 Example 2:

 Input:
 ["abat","baba","atan","atal"]

 Output:
 [
 [ "baba",
 "abat",
 "baba",
 "atan"
 ],
 [ "baba",
 "abat",
 "baba",
 "atal"
 ]
 ]

 Explanation:
 The output consists of two word squares.
 The order of output does not matter (just the order of words in each word square matters).


 public class Solution {
 public List<List<String>> wordSquares(String[] words) {

 }
 }



 My first approach is brute-force, try every possible word sequences,
 and use the solution of Problem 422 (https://leetcode.com/problems/valid-word-square/) to check each sequence.
 This solution is straightforward, but too slow (TLE).

 A better approach is to check the validity of the word square while we build it.
 Example: ["area","lead","wall","lady","ball"]
 We know that the sequence contains 4 words because the length of each word is 4.
 Every word can be the first word of the sequence, let's take "wall" for example.
 Which word could be the second word? Must be a word start with "a" (therefore "area"),
 because it has to match the second letter of word "wall".
 Which word could be the third word? Must be a word start with "le" (therefore "lead"),
 because it has to match the third letter of word "wall" and the third letter of word "area".
 What about the last word? Must be a word start with "lad" (therefore "lady"). For the same reason above.

 The picture below shows how the prefix are matched while building the sequence.


 In order for this to work, we need to fast retrieve all the words with a given prefix. There could be 2 ways doing this:

 Using a hashtable, key is prefix, value is a list of words with that prefix.
 Trie, we store a list of words with the prefix on each trie node.

 The implemented below uses Trie.


 */

import java.util.*;
public class N425_WordSquares {
    // google
    // non-trivia backtracking + trie code
    // 16 / 16 test cases passed.
    // 134 ms
    public class Solution {
        class TrieNode {
            List<String> startWith;
            TrieNode[] children;

            TrieNode() {
                startWith = new ArrayList<>();
                children = new TrieNode[26];
            }
        }

        class Trie {
            TrieNode root;

            Trie(String[] words) {
                root = new TrieNode();
                for (String w : words) {
                    TrieNode cur = root;
                    for (char ch : w.toCharArray()) {
                        int idx = ch - 'a';
                        if (cur.children[idx] == null)
                            cur.children[idx] = new TrieNode();
                        cur.children[idx].startWith.add(w);
                        cur = cur.children[idx];
                    }
                }
            }

            List<String> findByPrefix(String prefix) {
                List<String> ans = new ArrayList<>();
                TrieNode cur = root;
                for (char ch : prefix.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        return ans;

                    cur = cur.children[idx];
                }
                ans.addAll(cur.startWith);
                return ans;
            }
        }

        public List<List<String>> wordSquares(String[] words) {
            List<List<String>> ans = new ArrayList<>();
            if (words == null || words.length == 0)
                return ans;
            int len = words[0].length();
            Trie trie = new Trie(words);
            List<String> ansBuilder = new ArrayList<>();
            for (String w : words) {
                ansBuilder.add(w);
                search(len, trie, ans, ansBuilder);
                ansBuilder.remove(ansBuilder.size() - 1);
            }

            return ans;
        }

        private void search(int len, Trie tr, List<List<String>> ans,
                            List<String> ansBuilder) {
            if (ansBuilder.size() == len) {
                ans.add(new ArrayList<>(ansBuilder));
                return;
            }

            int idx = ansBuilder.size();
            StringBuilder prefixBuilder = new StringBuilder();
            for (String s : ansBuilder)
                prefixBuilder.append(s.charAt(idx));
            List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
            for (String sw : startWith) {
                ansBuilder.add(sw);
                search(len, tr, ans, ansBuilder);
                ansBuilder.remove(ansBuilder.size() - 1);
            }
        }
    }
}
