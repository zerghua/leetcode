package leetcode;

/**
 * Created by Hua on 5/4/2017.

 Given a list of positive integers, the adjacent integers will perform the float division.
 For example, [2,3,4] -> 2 / 3 / 4.

 However, you can add any number of parenthesis at any position to change the priority of operations.
 You should find out how to add parenthesis to get the maximum result, and return the corresponding expression
 in string format. Your expression should NOT contain redundant parenthesis.

 Example:

 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2

 Note:

 The length of the input array is [1, 10].
 Elements in the given array will be in range [2, 1000].
 There is only one optimal division for each test case.

 */
public class N553_OptimalDivision {
    // Amazon
    // stupid question
    // 93 / 93 test cases passed.
    // 9 ms
    // X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses.
    // i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator.
    // Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn.
    // So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
    public class Solution {
        public String optimalDivision(int[] nums) {
            if(nums.length == 1) return nums[0] + "";
            if(nums.length == 2) return nums[0] + "/" + nums[1];
            StringBuilder ret = new StringBuilder(nums[0] + "/(" + nums[1]);
            for(int i=2; i<nums.length; i++){
                ret.append("/" + nums[i]);
            }
            ret.append(")");
            return ret.toString();
        }
    }

}
