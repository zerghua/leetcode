package leetcode;

import java.util.Scanner;

/**
 * Created by Hua on 6/20/2017.

 Given a string representing an expression of fraction addition and subtraction, you need to return the calculation
 result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2,
 you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

 Example 1:

 Input:"-1/2+1/2"
 Output: "0/1"

 Example 2:

 Input:"-1/2+1/2+1/3"
 Output: "1/3"

 Example 3:

 Input:"1/3-1/2"
 Output: "-1/6"

 Example 4:

 Input:"5/3+1/3"
 Output: "2/1"

 Note:

 The input string only contains '0' to '9', '/', '+' and '-'. So does the output.

 Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is
 positive, then '+' will be omitted.

 The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always
 be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer
 in a fraction format defined above.

 The number of given fractions will be in the range [1,10].

 The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.



 Keep the overall result in A / B, read the next fraction into a / b.
 Their sum is (Ab + aB) / Bb (but cancel their greatest common divisor).

 */
public class N592_FractionAdditionandSubtraction {
    // IXL
    // math + pattern match + gcd
    // 105 / 105 test cases passed.
    // 84 ms
    public class Solution {
        public String fractionAddition(String expression) {
            Scanner s = new Scanner(expression).useDelimiter("/|(?=[-+])");  // sign will be included in matched numbers
            int A = 0, B = 1;
            while(s.hasNext()){
                int a = s.nextInt(), b = s.nextInt();
                A = A*b + a*B;
                B = B*b;
                int g = gcd(Math.abs(A), Math.abs(B));
                A /= g;
                B /= g;
            }
            return A + "/" + B;
        }

        public int gcd(int a, int b){
            return a == 0? b : gcd(b%a, a);
        }
    }
}
