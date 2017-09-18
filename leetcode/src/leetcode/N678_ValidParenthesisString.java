package leetcode;

/**
 * Created by HuaZ on 9/18/2017.

 Given a string containing only three types of characters: '(', ')' and '*',
 write a function to check whether this string is valid. We define the validity of a string by these rules:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 An empty string is also valid.

 Example 1:

 Input: "()"
 Output: True

 Example 2:

 Input: "(*)"
 Output: True

 Example 3:

 Input: "(*))"
 Output: True

 Note:

 The string size will be in the range [1, 100].


 */
public class N678_ValidParenthesisString {
    // recursion
    // 58 / 58 test cases passed.
    // 675 ms
    class Solution {
        public boolean checkValidString(String s) {
            return isValid(s, 0);
        }

        public boolean isValid(String s, int leftCount){
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(') leftCount++;
                else if(c == ')') {
                    if(leftCount < 1) return false;
                    leftCount--;
                } else{ // c =='*'
                    return isValid(s.substring(i+1), leftCount)
                            || isValid(s.substring(i+1), leftCount+1)
                            || isValid(s.substring(i+1), leftCount-1);
                }
            }
            return leftCount == 0;
        }
    }

    // others greedy o(n) solution
    // this solution to tricky to come up.
    // lo and hi of left brackets variable to store count
    // 58 / 58 test cases passed.
    // 5 ms
    /*

    Intuition

    When checking whether the string is valid, we only cared about the "balance":
    the number of extra, open left brackets as we parsed through the string.
    For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0
    as we parse through the string: '(' has 1 left bracket, '((' has 2, '(()' has 1, and so on.
    This means that after parsing the first i symbols, (which may include asterisks,)
    we only need to keep track of what the balance could be.

    For example, if we have string '(***)', then as we parse each symbol, the set of possible
    values for the balance is [1] for '(';
    [0, 1, 2] for '(*';
    [1, 2, 3] for '(**';
    [0, 1, 2, 3, 4] for '(***',
    and [0, 1, 2, 3] for '(***)'.

    Furthermore, we can prove these states always form a contiguous interval.
    Thus, we only need to know the left and right bounds of this interval.
    That is, we would keep those intermediate states described above
    as [lo, hi] = [1, 1], [0, 2], [1, 3], [0, 4], [0, 3].

    Algorithm

    Let lo, hi respectively be the smallest and largest possible number of open left brackets
    after processing the current character in the string.

    If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--.
    If we encounter what can be a left bracket (c != ')'), then hi++, otherwise we must write a right bracket,
    so hi--. If hi < 0, then the current prefix can't be made valid no matter what our choices are.
    Also, we can never have less than 0 open left brackets. At the end,
    we should check that we can have exactly 0 open left brackets.

     */
    class Solution2 {
        public boolean checkValidString(String s) {
            int lo = 0, hi = 0;
            for (char c: s.toCharArray()) {
                lo += (c == '(' ? 1 : -1);
                hi += (c != ')' ? 1 : -1);
                if (hi < 0) break;
                lo = Math.max(lo, 0);
            }
            return lo == 0;
        }
    }
}
