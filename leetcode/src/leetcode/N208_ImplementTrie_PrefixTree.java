package leetcode;

/**
 * Created by Hua on 6/18/2016.

 Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 */

import java.util.*;
public class N208_ImplementTrie_PrefixTree {
    // Google, Facebook, Microsoft
    // basic trie
    // 14 / 14 test cases passed.
    // 191 ms
    public class Trie {
        class TrieNode{
            HashMap<Character, TrieNode> children;
            boolean isEnd;
            TrieNode(){
                children = new HashMap();
                isEnd = false;
            }
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(!node.children.containsKey(c))node.children.put(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = dfs(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return dfs(prefix) != null;
        }

        public TrieNode dfs(String s){
            TrieNode node = root;
            for(char c : s.toCharArray()){
                if(node.children.containsKey(c)) node = node.children.get(c);
                else return null;
            }
            return node;
        }
    }


    // https://leetcode.com/articles/implement-trie-prefix-tree/
    // 24 ms
    public class Trie2 {
        class TrieNode {
            TrieNode[] chilren;
            boolean isEnd;
            public TrieNode() {
                chilren = new TrieNode[26];
            }

            public boolean containsKey(char c){
                return chilren[c - 'a'] != null;
            }

            public TrieNode getChild(char c){
                return chilren[c - 'a'];
            }

            public void setChild(char c, TrieNode childNode){
                chilren[c - 'a'] = childNode;
            }

        }

        private TrieNode root;

        public Trie2() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(!node.containsKey(c)){
                    node.setChild(c, new TrieNode());
                }
                node = node.getChild(c);
            }
            node.isEnd = true;
        }

        public TrieNode searchPrefix(String word){
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if(node.containsKey(c))node = node.getChild(c);
                else return null;
            }
            return node;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

    // Your Trie object will be instantiated and called as such:
    // Trie trie = new Trie();
    // trie.insert("somestring");
    // trie.search("key");
}
