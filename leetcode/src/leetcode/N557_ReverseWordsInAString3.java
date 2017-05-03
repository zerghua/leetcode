package leetcode;

/**
 * Created by Hua on 5/3/2017.

 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 whitespace and initial word order.

 Example 1:

 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.

        */
public class N557_ReverseWordsInAString3 {
    // stupid question
    // 30 / 30 test cases passed.
    // 16 ms
    public class Solution {
        public String reverseWords(String s) {
            StringBuilder ret = new StringBuilder();
            String[] arr = s.split(" ");
            for(int i=0; i<arr.length; i++){
                ret.append(new StringBuilder(arr[i]).reverse() + " ");
            }
            return ret.toString().trim();
        }
    }
}
