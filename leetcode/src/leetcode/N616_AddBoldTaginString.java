package leetcode;

/**
 * Created by Hua on 7/19/2017.

 Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap
 the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by
 only one pair of closed bold tag.
 Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

 Example 1:
 Input:
 s = "abcxyz123"
 dict = ["abc","123"]
 Output:
 "<b>abc</b>xyz<b>123</b>"


 Example 2:
 Input:
 s = "aaabbcc"
 dict = ["aaa","aab","bc"]
 Output:
 "<b>aaabbc</b>c"

 Note:

 The given dict won't contain duplicates, and its length won't exceed 100.
 All the strings in input have length in range [1, 1000].

 */
public class N616_AddBoldTaginString {
    // Google (Premium)
    // 70 / 70 test cases passed.
    // 26 ms
    // key is to solve the overlap wrap.
    // tricky string problem
    // I think loop through each dict can be optimized with trie
    public class Solution {
        public String addBoldTag(String s, String[] dict) {
            boolean[] isBold = new boolean[s.length()];
            for(int i=0, end = 0; i<s.length(); i++){
                for(String word: dict){
                    if(s.startsWith(word, i)) end = Math.max(end, i+word.length()); // end is one step ahead of last bold char.
                }
                isBold[i] = (end > i);  // mark true for each bold char, mainly to solve the overlap problem.
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(!isBold[i]) sb.append(s.charAt(i));
                else{  // put all bold together
                    int j = i ;
                    while(j<s.length() && isBold[j]) j++;
                    sb.append("<b>" + s.substring(i,j) + "</b>");
                    i = j-1;       // to counter i++ at the end of loop
                }
            }
            return sb.toString();
        }
    }
}
