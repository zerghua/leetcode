package leetcode;

/**
 * Created by Hua on 8/14/2017.

 Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 judge if this robot makes a circle, which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character.
 The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 The output should be true or false representing whether the robot makes a circle.

 Example 1:

 Input: "UD"
 Output: true

 Example 2:

 Input: "LL"
 Output: false


 */
public class N657_JudgeRouteCircle {
    // 62 / 62 test cases passed.
    // 15 ms
    public class Solution {
        public boolean judgeCircle(String moves) {
            int a= 0, b =0;
            for(char c : moves.toCharArray()){
                if(c == 'U') a++;
                else if(c == 'D') a--;
                else if(c == 'L') b++;
                else b--;
            }
            return a == 0 && b == 0;
        }
    }
}
