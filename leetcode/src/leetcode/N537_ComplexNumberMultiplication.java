package leetcode;

/**
 * Created by HuaZ on 5/6/2017.

 Given two strings representing two complex numbers.

 You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

 Example 1:

 Input: "1+1i", "1+1i"
 Output: "0+2i"
 Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

 Example 2:

 Input: "1+-1i", "1+-1i"
 Output: "0+-2i"
 Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

 Note:

 The input strings will not have extra blank.
 The input strings will be given in the form of a+bi, where the integer a and b will both
 belong to the range of [-100, 100]. And the output should be also in this form.



 */
public class N537_ComplexNumberMultiplication {
    // This solution relies on the fact that (a+bi)(c+di) = (ac - bd) + (ad+bc)i.
    // 55 / 55 test cases passed.
    // 8 ms
    public class Solution {
        public String complexNumberMultiply(String a, String b) {
            int[] valA = getValue(a);
            int[] valB = getValue(b);
            return (valA[0] * valB[0] - valA[1] * valB[1]) + "+" + (valA[0] * valB[1] + valA[1] * valB[0]) + "i";
        }

        private int[] getValue(String s) {
            String[] str = s.split("\\+");
            int[] val = new int[2];
            val[0] = Integer.valueOf(str[0]);
            int indexOfI = str[1].indexOf("i");
            val[1] = Integer.valueOf(str[1].substring(0, indexOfI));

            return val;
        }
    }

}
