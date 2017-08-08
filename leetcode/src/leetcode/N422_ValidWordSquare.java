package leetcode;

/**
 * Created by Hua on 7/11/2017.

 Given a sequence of words, check whether it forms a valid word square.

 A sequence of words forms a valid word square if the kth row and column read the exact same string,
 where 0 ≤ k < max(numRows, numColumns).

 Note:

 The number of words given is at least 1 and does not exceed 500.
 Word length will be at least 1 and does not exceed 500.
 Each word contains only lowercase English alphabet a-z.

 Example 1:

 Input:
 [
 "abcd",
 "bnrt",
 "crmy",
 "dtye"
 ]

 Output:
 true

 Explanation:
 The first row and first column both read "abcd".
 The second row and second column both read "bnrt".
 The third row and third column both read "crmy".
 The fourth row and fourth column both read "dtye".

 Therefore, it is a valid word square.

 Example 2:

 Input:
 [
 "abcd",
 "bnrt",
 "crm",
 "dt"
 ]

 Output:
 true

 Explanation:
 The first row and first column both read "abcd".
 The second row and second column both read "bnrt".
 The third row and third column both read "crm".
 The fourth row and fourth column both read "dt".

 Therefore, it is a valid word square.

 Example 3:

 Input:
 [
 "ball",
 "area",
 "read",
 "lady"
 ]

 Output:
 false

 Explanation:
 The third row reads "read" while the third column reads "lead".

 Therefore, it is NOT a valid word square.

 */

import java.util.*;
public class N422_ValidWordSquare {
    // Google
    // 35 / 35 test cases passed.
    // 28 ms
    // compare each char in diagonal, it'd be easier with matrix[][] rather than list of words.
    public class Solution {
        public boolean validWordSquare(List<String> words) {
            for(int i=0; i<words.size(); i++){
                String row = words.get(i);
                for(int j=0; j<row.length(); j++){
                    if( i >= words.get(j).length() || row.charAt(j) != words.get(j).charAt(i)) return false;
                }
            }
            return true;
        }
    }
}
