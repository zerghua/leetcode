package leetcode;
import java.util.*;

/**
 * Created by HuaZ on 9/18/2017.

 Implement a MapSum class with insert, and sum methods.

 For the method insert, you'll be given a pair of (string, integer).
 The string represents the key and the integer represents the value.
 If the key already existed, then the original key-value pair will be overridden to the new one.

 For the method sum, you'll be given a string representing the prefix,
 and you need to return the sum of all the pairs' value whose key starts with the prefix.

 Example 1:

 Input: insert("apple", 3), Output: Null
 Input: sum("ap"), Output: 3
 Input: insert("app", 2), Output: Null
 Input: sum("ap"), Output: 5


 */
public class N677_MapSumPairs {
    // my trie solution, written after contest
    // key is save val of each string, and do dfs at the end of prefix
    // 30 / 30 test cases passed.
    // 167 ms
    class solution {
        class MapSum {
            TrieNode root;
            public MapSum() {
                root = new TrieNode();
            }

            // this will ensure duplicate value to be overwritten
            public void insert(String key, int val) {
                TrieNode node = root;
                for(char c: key.toCharArray()){
                    if(!node.children.containsKey(c)) node.children.put(c, new TrieNode());
                    node = node.children.get(c);
                }
                node.sum = val;
            }

            public int sum(String prefix) {
                TrieNode node = root;
                for(char c : prefix.toCharArray()){
                    if(node.children.containsKey(c)) node = node.children.get(c);
                    else return 0;
                }
                return dfs(node);
            }

            public int dfs(TrieNode node){
                int ret = 0;
                for(char c : node.children.keySet()){
                    ret += dfs(node.children.get(c));
                }
                return ret + node.sum;
            }
        }

        class TrieNode{
            HashMap<Character, TrieNode> children;
            int sum;
            TrieNode(){
                children = new HashMap();
                sum = 0;
            }
        }
    }


    // my contest 50 solution
    // map + string.startsWith()
    // 30 / 30 test cases passed.
    // 112 ms
    class solution2{
        class MapSum {
            HashMap<String, Integer> map ;
            /** Initialize your data structure here. */
            public MapSum() {
                map = new HashMap();
            }

            public void insert(String key, int val) {
                map.put(key, val);
            }

            public int sum(String prefix) {
                int ret = 0;
                for(String s: map.keySet()){
                    if(s.startsWith(prefix))  ret+= map.get(s);
                }
                return ret;
            }
        }
    }

}
