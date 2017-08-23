package leetcode;

import java.util.HashMap;

/**
 * Created by HuaZ on 7/22/2017.

 Given a rows x cols screen and a sentence represented by a list of non-empty words,
 find how many times the given sentence can be fitted on the screen.

 Note:

 A word cannot be split into two lines.
 The order of words in the sentence must remain unchanged.
 Two consecutive words in a line must be separated by a single space.
 Total words in the sentence won't exceed 100.
 Length of each word is greater than 0 and won't exceed 10.
 1 ≤ rows, cols ≤ 20,000.

 Example 1:

 Input:
 rows = 2, cols = 8, sentence = ["hello", "world"]

 Output:
 1

 Explanation:
 hello---
 world---

 The character '-' signifies an empty space on the screen.

 Example 2:

 Input:
 rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

 Output:
 2

 Explanation:
 a-bcd-
 e-a---
 bcd-e-

 The character '-' signifies an empty space on the screen.

 Example 3:

 Input:
 rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

 Output:
 1

 Explanation:
 I-had
 apple
 pie-I
 had--

 The character '-' signifies an empty space on the screen.

BF TLE
 Last executed input:["a","bc"]
 20000
 20000




 */
public class N418_SentenceScreenFitting {
    // google
    // string, greedy.
    // example:  rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
    // [I had apple pie ]; n =15; start = [[5], [10, 6], [11], [16,15]]
    //  0123456789012345
    // 51 / 51 test cases passed.
    // 20 ms
    public class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            String s = String.join(" ", sentence) + " ";
            int start = 0, n = s.length();
            for(int i=0; i<rows; i++){ // try to fit each row as much as possible
                start += cols;
                if(s.charAt(start % n) == ' ') start++; // all previous chars fit in one row
                else{
                    while(start > 0 && s.charAt((start - 1)%n) != ' ') start--; //prepare for the next start char
                }
            }
            return start / n;
        }
    }

    // BF, TLE
    public class Solution2 {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int i = 1, j=0, remainSpaces = cols;
            while(i <= rows) {
                String s = sentence[j % sentence.length];
                if (remainSpaces >= s.length()) {
                    remainSpaces -= (s.length() + 1);
                    j++;
                } else {
                    i++;
                    remainSpaces = cols;
                }
            }
            return j / sentence.length;
        }
    }



}
