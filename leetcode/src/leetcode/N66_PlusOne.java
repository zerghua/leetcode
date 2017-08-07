package leetcode;

/**
 * Created by Hua on 5/21/2016.

 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 */
public class N66_PlusOne {
    // Google
    // corner case, extra digit after plus 1
    // 0 ms
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        int carry=1;
        while(i>=0){
            int sum = digits[i] + carry;
            if(sum<10){
                digits[i] = sum;
                carry=0;
                break;
            }else{
                digits[i] = 0;
                i--;
            }
        }

        //corner case
        if(carry == 1) {
            int[] ret = new int[digits.length+1];
            ret[0]=1;
            for(int j=1;j<ret.length;j++) ret[j] = digits[j-1];
            return ret;
        }
        return digits;
    }


    // optimised code
    // 0 ms
    public int[] plusOne2(int[] digits) {
        int i=digits.length-1;
        int carry=1;
        while(i>=0){
            int sum = digits[i] + carry;
            if(sum<10){
                digits[i] = sum;
                return digits;
            }else{
                digits[i] = 0;
                i--;
            }
        }

        //corner case, must be like this: 999+1=1000
        int[] ret = new int[digits.length+1];
        ret[0]=1;
        return ret;
    }

    // version 3 added on 9/9/2016
    // 0ms  108 / 108 test cases passed.
    // find pattern. test case, 199, 999, 288
    public class Solution {
        public int[] plusOne(int[] digits) {
            for(int i=digits.length-1;i>=0;i--){
                if(digits[i] != 9 ){
                    digits[i]++;
                    return digits;
                }
                digits[i]=0;
            }
            // create new array if comes to here. like 999+1, return 1000
            int[] ret = new int[digits.length+1];
            ret[0]=1;
            return ret;
        }
    }
}
