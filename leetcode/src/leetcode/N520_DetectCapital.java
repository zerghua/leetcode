package leetcode;

/**
 * Created by HuaZ on 5/7/2017.

 Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".

 Otherwise, we define that this word doesn't use capitals in a right way.

 Example 1:

 Input: "USA"
 Output: True

 Example 2:

 Input: "FlaG"
 Output: False


 */
public class N520_DetectCapital {
    // String
    // 550 / 550 test cases passed.
    // 29 ms
    public class Solution {
        public boolean detectCapitalUse(String word) {
            int countOfCaptals=0;
            for(char c: word.toCharArray()){
                if(Character.isUpperCase(c)) countOfCaptals++;
            }
            if(countOfCaptals == 1) return Character.isUpperCase(word.charAt(0));
            return countOfCaptals == 0 || countOfCaptals == word.length();
        }
    }
}
