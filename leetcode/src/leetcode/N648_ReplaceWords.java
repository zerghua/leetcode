package leetcode;

/**
 * Created by Hua on 8/3/2017.

 Now, given a dictionary consisting of many roots and a sentence.
 You need to replace all the successor in the sentence with the root forming it.
 If a successor has many roots can form it, replace it with the root with the shortest length.

 You need to output the sentence after the replacement.

 Example 1:

 Input: dict = ["cat", "bat", "rat"]
 sentence = "the cattle was rattled by the battery"
 Output: "the cat was rat by the bat"

 Note:

 The input will only have lower-case letters.
 1 <= dict words number <= 1000
 1 <= sentence words number <= 1000
 1 <= root length <= 100
 1 <= sentence words length <= 1000

 */

import java.util.*;
public class N648_ReplaceWords {
    // Uber
    // Trie, maybe it's also ok to use hashset to solve it.
    // 124 / 124 test cases passed.
    // 42 ms
    public class Solution {
        class TrieNode{
            String val;
            HashMap<Character, TrieNode> children;
            boolean isEnd;
            TrieNode(){
                val = "";
                children = new HashMap();
                isEnd = false;
            }
        }

        private void add(TrieNode root, List<String> dict){
            for(String s : dict){
                TrieNode cur = root;
                for(char c : s.toCharArray()){
                    if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
                    cur = cur.children.get(c);
                }
                cur.isEnd = true;
                cur.val = s;
            }
        }

        private String searchPrefix(TrieNode root, String s){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                if(cur.children.get(c) == null) return s;
                cur = cur.children.get(c);
                if(cur.isEnd) return cur.val;  // early return for shortest word
            }
            return s;
        }

        public String replaceWords(List<String> dict, String sentence) {
            StringBuilder sb = new StringBuilder();
            TrieNode root = new TrieNode();
            add(root, dict);
            for(String s : sentence.split(" ")) sb.append(searchPrefix(root, s)).append(" ");
            return sb.toString().trim();
        }
    }
}
