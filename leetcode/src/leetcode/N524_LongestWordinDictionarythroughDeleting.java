package leetcode;

import java.util.*;

/**
 * Created by Hua on 5/10/2017.

 Given a string and a string dictionary, find the longest string in the dictionary
 that can be formed by deleting some characters of the given string.

 If there are more than one possible results, return the longest word with the smallest
 lexicographical order. If there is no possible result, return the empty string.

 Example 1:

 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"

 Example 2:

 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"

 Note:

 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.


 */
public class N524_LongestWordinDictionarythroughDeleting {
    // Google
    // time complexity o(nk) k is the length of string in dictionary
    // tricky implementation
    // 31 / 31 test cases passed.
    // 72 ms
    public class Solution {
        public String findLongestWord(String s, List<String> d) {
            String ret = "";
            char[] a = s.toCharArray();
            for(String dicString: d){
                int i=0;
                for(char c: a){
                    if(i<dicString.length() && c == dicString.charAt(i)) i++;
                }
                if(i == dicString.length() && dicString.length() >= ret.length()){
                    if(dicString.length() > ret.length() || dicString.compareTo(ret) < 0) // lexicographical order
                        ret = dicString;
                }
            }
            return ret;
        }
    }
}
