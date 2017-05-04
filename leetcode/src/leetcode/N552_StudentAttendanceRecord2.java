package leetcode;

import java.security.Policy;

/**
 * Created by Hua on 5/4/2017.

 Given a positive integer n, return the number of all possible attendance records with length n,
 which will be regarded as rewardable. The answer may be very large, return it after mod 10e9 + 7.

 A student attendance record is a string that only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.

 A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 Example 1:

 Input: n = 2
 Output: 8
 Explanation:
 There are 8 records with length 2 will be regarded as rewardable:
 "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 Only "AA" won't be regarded as rewardable owing to more than one absent times.

 Note: The value of n won't exceed 100,000.

 */
public class N552_StudentAttendanceRecord2 {
    // DP + math, hard
    // 58 / 58 test cases passed.
    // 50 ms
    public class Solution {
        static final long M = 1000000007;
        public int checkRecord(int n) {
            long[] PorL = new long[n+1];   // end with P or L, no A
            long[] P = new long[n+1];      // end with p, no A
            PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;
            for(int i=2; i<=n; i++){
                P[i] = PorL[i-1];
                PorL[i] = (PorL[i-1] + P[i-1] + P[i-2]) % M;
            }

            long ret = PorL[n];
            for(int i=0; i<n; i++){
                long s = (PorL[i] * PorL[n-i-1]) % M;  // inserting A into (n-1)-length strings
                ret = (ret + s) % M ;
            }
            return (int)ret;
        }
    }

}
