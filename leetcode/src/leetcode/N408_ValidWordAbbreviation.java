package leetcode;

/**
 * Created by Hua on 7/11/2017.

 Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

 A string such as "word" contains only the following valid abbreviations:

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 Notice that only the above abbreviations are valid abbreviations of the string "word".
 Any other string is not a valid abbreviation of "word".

 Note:
 Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

 Example 1:

 Given s = "internationalization", abbr = "i12iz4n":

 Return true.

 Example 2:

 Given s = "apple", abbr = "a2e":

 Return false.

 Test cases:
 "internationalization"
 "i5a11o1"
 Expected:true


 "a"
 "01"
 Expected:false




 */
public class N408_ValidWordAbbreviation {
    // Google
    // 315 / 315 test cases passed.
    // 29 ms
    // string
    public class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int i=0, j=0;
            while(i < word.length() && j<abbr.length()){
                if(word.charAt(i) == abbr.charAt(j)){
                    i++;j++;
                    continue;
                }
                if(abbr.charAt(j) == '0') return false;
                int start = j;
                while(j<abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    j++;
                }
                if(j == start) return false; // it's not digit
                int num = Integer.parseInt(abbr.substring(start, j));
                i += num;
            }
            return i == word.length() && j == abbr.length();
        }
    }

    // minor improvement
    // 315 / 315 test cases passed.
    // 26 ms
    public class Solution2 {
        public boolean validWordAbbreviation(String word, String abbr) {
            int i=0, j=0;
            while(i < word.length() && j<abbr.length()){
                if(word.charAt(i) == abbr.charAt(j)){
                    i++;j++;
                    continue;
                }
                if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') { // it's not digit or start with 0
                    return false;
                }

                int start = j;
                while(j<abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    j++;
                }

                int num = Integer.parseInt(abbr.substring(start, j));
                i += num;
            }
            return i == word.length() && j == abbr.length();
        }
    }

}
