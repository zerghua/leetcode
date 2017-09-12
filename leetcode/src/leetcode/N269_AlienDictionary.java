package leetcode;

/**
 * Created by Hua on 7/27/2017.

 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 You receive a list of non-empty words from the dictionary, where words are sorted lexicographically
 by the rules of this new language. Derive the order of letters in this language.

 Example 1:
 Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]

 The correct order is: "wertf".

 Example 2:
 Given the following words in dictionary,

 [
 "z",
 "x"
 ]

 The correct order is: "zx".

 Example 3:
 Given the following words in dictionary,

 [
 "z",
 "x",
 "z"
 ]

 The order is invalid, so return "".

 Note:

 You may assume all letters are in lowercase.
 You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.

 */

import java.util.*;
public class N269_AlienDictionary {
    // google, facebook, airbnb (Premium)
    // Topological sort, directed graph, no circle.
    // 117 / 117 test cases passed.
    // 10 ms
    public class Solution {
        public String alienOrder(String[] words) {
            HashMap<Character, HashSet<Character>> map = new HashMap();   // chars after this char
            HashMap<Character, Integer> in = new HashMap();      // how many chars before this char

            // init in map
            for(String s: words){
                for(char c: s.toCharArray()) in.put(c, 0);
            }

            // put input into graph
            for(int i=0; i<words.length-1; i++){
                String a = words[i], b = words[i+1];
                for(int j = 0; j< Math.min(a.length(), b.length()); j++){
                    char x = a.charAt(j), y = b.charAt(j);
                    if(x != y){
                        if(!map.containsKey(x)) map.put(x, new HashSet());

                        if(!map.get(x).contains(y)){    // important, to avoid duplicate edges
                            map.get(x).add(y);
                            in.put(y, in.get(y) + 1);
                        }
                        break;
                    }
                }
            }


            // BFS
            LinkedList<Character> list = new LinkedList();
            for(char c : in.keySet()){
                if(in.get(c) == 0) list.add(c);
            }

            String ret = "";
            while(!list.isEmpty()){
                char cur = list.removeFirst();
                ret += cur;

                // handle c's neighbours, which are after cur
                if(map.containsKey(cur)) {
                    for (char c : map.get(cur)) {
                        in.put(c, in.get(c) - 1);        // reduce one because parent is out
                        if (in.get(c) == 0) list.add(c);
                    }
                }
            }

            return ret.length() == in.size() ? ret : "";
        }
    }
}
