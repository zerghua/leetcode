package leetcode;

/**
 * Created by HuaZ on 12/8/2016.

 Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime
 list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence
 of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

 */
public class N313_SuperUglyNumber {
    // 29 ms 83 / 83 test cases passed.
    // math. similar to N264. ugly number 2
    public class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ugly = new int[n];
            int[] index = new int[primes.length];
            ugly[0] = 1;
            for(int i=1;i<n;i++){

                ugly[i] = Integer.MAX_VALUE;
                // find next min
                for(int j=0; j<primes.length; j++)
                    ugly[i] = Math.min(ugly[i], primes[j] * ugly[index[j]]);

                // update index
                for(int j=0; j<primes.length; j++) {
                    while (primes[j] * ugly[index[j]] <= ugly[i]) index[j]++;
                }
            }
            return ugly[n-1];
        }
    }
}
