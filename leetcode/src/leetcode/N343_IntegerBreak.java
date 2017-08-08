package leetcode;

/**
 * Created by Hua on 8/2/2016.

 Given a positive integer n, break it into the sum of at least two positive integers
 and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 Hint:

 There is a simple O(n) solution to this problem.
 You may check the breaking results of n ranging from 7 to 10 to discover the regularities.


 */
public class N343_IntegerBreak {
    // no company
    // 0ms
    // math
    public int integerBreak(int n) {
        if(n == 2 || n==3) return n-1;
        if(n%3 == 0) return (int)Math.pow(3, n/3);
        if(n%3 == 1) return 4* (int)Math.pow(3,(n-4)/3);
        return 2* (int)Math.pow(3,(n-2)/3);
    }

    public static void main(String[] args) {
        N343_IntegerBreak x = new N343_IntegerBreak();
        for(int i=2;i<10;i++){
            System.out.println(x.integerBreak(i));
        }

    }
}
