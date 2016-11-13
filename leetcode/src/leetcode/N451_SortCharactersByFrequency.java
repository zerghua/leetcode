package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HuaZ on 11/13/2016.

 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.

 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.


 */


// Google and Amazon
public class N451_SortCharactersByFrequency {
    // bucket sort o(n)
    // 29 ms 34 / 34 test cases passed.
    public class Solution {
        public String frequencySort(String s) {
            if(s == null || s.length() <= 2) return s;

            // count how many times each char exists
            int char_size = 256;  //assume ascii
            int[] count = new int[char_size];
            for(char c: s.toCharArray()) count[c]++;

            // link the same count char into a list and put into hashmap for o(1) access
            HashMap<Integer, List<Character>> map = new HashMap();
            for(int i=0; i<char_size; i++){
                int n = count[i];
                if( n == 0) continue;
                if(!map.containsKey(n)) map.put(n, new ArrayList());
                map.get(n).add((char)i);
            }

            // go through count from [n,0], add to result
            StringBuilder ret = new StringBuilder();
            for(int i=s.length(); i>0 ;i--){
                if(!map.containsKey(i)) continue;
                for(Character c: map.get(i)){
                    for(int j=0;j<i;j++) ret.append(c);
                }
            }
            return ret.toString();
        }
    }

    // instead of using hashmap, let's use String[]
    // bucket sort o(n)
    // 20 ms 34 / 34 test cases passed.
    public class Solution2 {
        public String frequencySort(String s) {
            if(s == null || s.length() <= 2) return s;

            // count how many times each char exists
            int char_size = 256, max=0;  //assume ascii
            int[] count = new int[char_size];
            for(char c: s.toCharArray()) {
                count[c]++;
                max = Math.max(max, count[c]);
            }

            // link the same count char into a list and put into map for o(1) access
            String[] map = new String[max+1];
            for(int i=0; i<char_size; i++){
                int n = count[i];
                if( n == 0) continue;
                map[n] = (map[n] == null) ? "" + (char)i : "" + map[n] + (char)i;
            }

            // go through count from [n,0], add to result
            StringBuilder ret = new StringBuilder();
            for(int i=max; i>0 ;i--){
                if(map[i] == null) continue;
                for(Character c: map[i].toCharArray()){
                    for(int j=0;j<i;j++) ret.append(c);
                }
            }
            return ret.toString();
        }
    }


    // heap sort o(nlogn)
}
