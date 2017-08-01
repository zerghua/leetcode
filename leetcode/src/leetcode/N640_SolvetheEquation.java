package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 8/1/2017.

 Solve a given equation and return the value of x in the form of string "x=#value".
 The equation contains only '+', '-' operation, the variable x and its coefficient.

 If there is no solution for the equation, return "No solution".

 If there are infinite solutions for the equation, return "Infinite solutions".

 If there is exactly one solution for the equation, we ensure that the value of x is an integer.

 Example 1:

 Input: "x+5-3+x=6+x-2"
 Output: "x=2"

 Example 2:

 Input: "x=x"
 Output: "Infinite solutions"

 Example 3:

 Input: "2x=x"
 Output: "x=0"

 Example 4:

 Input: "2x+3x-6x=x+2"
 Output: "x=-1"

 Example 5:

 Input: "x=x+2"
 Output: "No solution"



 You can use Lookahead and Lookbehind. Like this:

 System.out.println(Arrays.toString("a;b;c;d".split("(?<=;)")));
 System.out.println(Arrays.toString("a;b;c;d".split("(?=;)")));
 System.out.println(Arrays.toString("a;b;c;d".split("((?<=;)|(?=;))")));

 And you will get:

 [a;, b;, c;, d]
 [a, ;b, ;c, ;d]
 [a, ;, b, ;, c, ;, d]

 System.out.println(Arrays.toString("-5x+2-x+3x-7x".split("(?=[+-])")));
 [-5x, +2, -x, +3x, -7x]

 */
public class N640_SolvetheEquation {
    // Amazon
    // split regex: lookbehind and some corner cases.
    // 52 / 52 test cases passed.
    // 10 ms
    public class Solution {
        public String solveEquation(String equation) {
            String[] str = equation.split("=");
            String[] leftSide = str[0].split("(?=[+-])");   //important, split regex: lookbehind includes delimiter
            String[] RightSide = str[1].split("(?=[+-])");  //important, split regex: lookbehind includes delimiter

            int left = 0, right = 0;
            for(String s : leftSide){
                if(s.charAt(s.length()-1) == 'x') left += getCoeff(s);
                else right -= Integer.parseInt(s);
            }


            for(String s : RightSide){
                if(s.charAt(s.length()-1) == 'x') left -= getCoeff(s);
                else right += Integer.parseInt(s);
            }

            if(left == 0 && right == 0) return "Infinite solutions";
            else if(left == 0) return "No solution";
            else return "x=" + (right/left);
        }

        // some corner cases.
        private int getCoeff(String s){
            int num = 0;
            if(s.length() == 1) num = 1;
            else if(s.length() == 2 && (s.charAt(0) == '+' || s.charAt(0) == '-')) num = Integer.parseInt(s.charAt(0) + "1");
            else num = Integer.parseInt(s.substring(0,s.length()-1));
            return num;
        }
    }
}
