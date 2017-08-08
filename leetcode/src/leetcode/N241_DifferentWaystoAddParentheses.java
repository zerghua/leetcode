package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hua on 5/27/2016.

 Given a string of numbers and operators, return all possible results
 from computing all the different possible ways to group numbers and operators.
 The valid operators are +, - and *.

 Example 1

 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2

 Output: [0, 2]

 Example 2

 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10

 Output: [-34, -14, -10, -10, 10]


 */
public class N241_DifferentWaystoAddParentheses {
    // no company
    // backtracking, divide string into 2 parts, and compute them.
    // 10 ms
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<Integer>();
        if(input ==null || input.length()==0) return ret;

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(!isOperater(c)) continue;

            List<Integer> left = diffWaysToCompute(input.substring(0,i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1));

            for(int x: left){
                for(int y: right){
                    ret.add(getValue(x,y,c));
                }
            }
        }
        if(ret.isEmpty()) ret.add(Integer.valueOf(input));
        return ret;
    }

    public boolean isOperater(char c){
        return (c=='-') || (c=='+') || (c=='*');
    }

    public int getValue(int x, int y, char operator){
        switch (operator){
            case '+': return x+y;
            case '-': return x-y;
            case '*': return x*y;
            default: return 0;
        }
    }

}
