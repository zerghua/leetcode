package leetcode;

/**
 * Created by HuaZ on 7/30/2017.

 A string such as "word" contains the following abbreviations:

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 Given a target string and a set of strings in a dictionary,
 find an abbreviation of this target string with the smallest possible length such that
 it does not conflict with abbreviations of the strings in the dictionary.

 Each number or letter in the abbreviation is considered length = 1.
 For example, the abbreviation "a32bc" has length = 4.

 Note:

 In the case of multiple answers as shown in the second example below,
 you may return any one of them.
 Assume length of target string = m, and dictionary size = n.
 You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.

 Examples:

 "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

 "apple", ["plain", "amber", "blade"] -> "1p3"
 (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").


 */

import java.util.*;
public class N411_MinimumUniqueWordAbbreviation {
    // google
    // too complex dfs. abbrGenerator is similar to N320, but improved.
    // trie + dfs
    // 46 / 46 test cases passed.
    // 113 ms
    public class Solution {
        class Trie{
            Trie[] next = new Trie[26];
            boolean isEnd = false;
        }
        Trie root = new Trie();
        List<String> abbrs;
        public String minAbbreviation(String target, String[] dictionary) {
            for(String s:dictionary) {
                addTrie(s);
            }
            for(int i=0; i<target.length(); i++) {
                abbrs = new ArrayList<>();
                abbrGenerator(target, 0, "", 0, i+1);
                for(String s:abbrs) {
                    if(search(s, root, 0, 0)==false) return s;
                }
            }
            return "";
        }
        public void addTrie(String s) {
            Trie cur = root;
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(cur.next[c-'a']==null) {
                    cur.next[c-'a']=new Trie();
                }
                cur = cur.next[c-'a'];
            }
            cur.isEnd = true;
        }
        public boolean search(String target, Trie root, int i, int loop) {
            if(root==null) return false;

            if(loop!=0) {
                for(int a=0; a<26; a++) {
                    if(search(target, root.next[a], i, loop-1)) return true;
                }
                return false;
            }
            if(i==target.length()) {
                if(root.isEnd) return true;
                return false;
            }
            if(Character.isDigit(target.charAt(i))) {
                int tmp = 0;
                while(i<target.length()&&Character.isDigit(target.charAt(i))) {
                    tmp = tmp*10 + target.charAt(i)-'0';
                    i++;
                }
                return search(target, root, i, tmp);
            } else {
                return search(target, root.next[target.charAt(i)-'a'], i+1, 0);
            }
        }
        public void abbrGenerator(String target, int i, String tmp, int abbr, int num) {
            if(i==target.length()) {
                if(num==0&&abbr==0) abbrs.add(tmp);
                if(num==1&&abbr!=0) abbrs.add(tmp+abbr);
                return;
            }
            if(num<=0) return;
            char cur = target.charAt(i);
            abbrGenerator(target, i+1, abbr==0?tmp+cur:tmp+abbr+cur, 0, abbr==0?num-1:num-2);
            abbrGenerator(target, i+1, tmp, abbr+1, num);
        }
    }
}
