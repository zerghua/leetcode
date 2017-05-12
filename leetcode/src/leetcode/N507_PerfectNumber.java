package leetcode;

/**
 * Created by Hua on 5/11/2017.

 We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.

 Example:

 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14

 Note: The input number n will not exceed 100,000,000. (1e8)

 */
public class N507_PerfectNumber {
    // math.
    // 156 / 156 test cases passed.
    // 13 ms
    public class Solution {
        public boolean checkPerfectNumber(int num) {
            if(num == 1) return false;
            int sum = 1;
            for(int i=2; i<Math.sqrt(num);i++){
                if(num % i == 0){
                    sum += i + num/i;
                }
            }
            return num == sum;
        }
    }
}
