package leetcode;

/**
 * Created by HuaZ on 7/15/2016.
 *
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

 Example:

 n = 10, I pick 6.

 Return 6.

 */

public class N374_GuessNumberHigherorLower {
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num);
*/
    public int guess(int num){
        return 0;
    }

    // 1  ms
    // simple binary search
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left <= right){
            int mid = (right - left)/2 + left;
            int guess_result = guess(mid);
            if( guess_result == 0) return mid;
            else if(guess_result < 0 ) right = mid-1;
            else left = mid + 1;
        }
        return 0;
    }

}
