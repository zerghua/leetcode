package leetcode;

/**
 * Created by Hua on 5/21/2016.

 Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.
 Some hints:

 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction
 of using extra space.

 You could also try reversing an integer. However, if you have solved
 the problem "Reverse Integer", you know that the reversed integer might overflow.
 How would you handle such case?

 There is a more generic way of solving this problem.


 */
public class N9_PalindromeNumber {
    // no company
    // 13 ms
    // math. get left and right digit of int, and compare/update.
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int div=1;
        while(x/div>=10) div*=10;

        while(x!=0){
            int left = x/div;
            int right = x%10;
            if(left!=right) return false;
            x = (x%div)/10; // update x, remove left and right digit
            div /=100;      // update div.
        }
        return true;
    }

}

