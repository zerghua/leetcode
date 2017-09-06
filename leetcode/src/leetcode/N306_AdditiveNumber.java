package leetcode;
import java.math.BigInteger;

/**
 * Created by Hua on 6/10/2016.

 Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers.
 Except for the first two numbers, each subsequent number in the sequence
 must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form
 an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.

 1 + 99 = 100, 99 + 100 = 199

 Note: Numbers in the additive sequence cannot have leading zeros,
 so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine
 if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?

 111            false
 112358         true
 198019823962   true
 "199111992"    true,  1991 + 1 = 1992

 */
public class N306_AdditiveNumber {
    // Epic
    // iterative
    // 40 / 40 test cases passed.  on 9/6/2017
    // 4 ms
    class Solution {
        public boolean isAdditiveNumber(String num) {
            if(num == null || num.length()<3) return false;
            int n=num.length();
            for(int i=1;i<n;i++){
                if(i>1 && num.charAt(0) == '0') break; //pruning 0112
                for(int j=i+1;j<n;j++){
                    int first = 0, second = i, third = j;
                    if(num.charAt(i) == '0' && third >second+1) break; // pruning

                    while(third<n){
                        Long sum = Long.valueOf(num.substring(first,second)) + Long.valueOf(num.substring(second,third));

                        if(num.substring(third).startsWith(sum.toString())){
                            first=second;
                            second = third;
                            third += sum.toString().length();
                        }else break;
                    }
                    if(third == n) return true;
                }
            }
            return false;
        }
    }



}
