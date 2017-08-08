package leetcode;

/**
 * Created by Hua on 6/2/2017.

 For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

 Now given a string representing n, you should return the smallest good base of n in string format.

 Example 1:

 Input: "13"
 Output: "3"
 Explanation: 13 base 3 is 111.

 Example 2:

 Input: "4681"
 Output: "8"
 Explanation: 4681 base 8 is 11111.

 Example 3:

 Input: "1000000000000000000"
 Output: "999999999999999999"
 Explanation: 1000000000000000000 base 999999999999999999 is 11.

 Note:

 The range of n is [3, 10^18].
 The string representing n is always valid and will not have leading zeros.

 First things first. Let's see the math behind it.

 From given information, we can say one thing- Numbers will be of form-

 n = k^m + k^(m-1) + ... + k + 1
 => n-1 = k^m + k^(m-1) + ... + k
 => n-1 = k (k^(m-1) + k^(m-2) + ... + k + 1) ...... [1]

 Also, from n = k^m + k^(m-1) + ... + k + 1, we can say,
 n-k^m = k^(m-1) + k^(m-2) + ... + k + 1 ...... [2]

 from [1] and [2],

 n-1 = k (n - k^m)
 =>k^(m+1) = nk - n + 1

 if you shuffle sides you will end up getting following form,

 (k^(m+1) - 1)/(k - 1) = n .... [3]

 Also from [1] note that, (n - 1) must be divisible by k.

 We know that, n = k^m + k^(m-1) + ... + k + 1

 => n > k^m
 => m-th root of n > k .... [4]

 [EDIT] -->

 With inputs from @StefanPochmann we can also say, from binomial thorem, n = k^m + ... + 1 < (k+1)^m .... [5]
 Therefore, k+1 > m-th root of n > k. .... from [4] and [5]
 Thus [m-th root of n] is the only candidate that needs to be tested. [6]

 <--

 So our number should satisfy this equation where k will be our base and m will be (number of 1s - 1)

 This brings us to the search problem where we need to find k and m.

 Linear search from 1 to n does not work. it gives us TLE. So it leaves us with performing some optimization on search space.

 From [6] we know that the only candidate that needs to be tested is, [m-th root of n]

 We also know that the smallest base is 2 so we can find our m must be between 2 and log2n else m is (n-1) [7]





 To begin with, the whole problem is equivalent to solving the following equation with smallest k (assuming k >= 2 and m >= 1):

 f(k, m) = n

 where k is the base of the numbers, m is the number of digit 1's in this base,
 f(k, m) = 1 + k + k^2 + ... + k^(m-1) = (k^m - 1)/(k-1) is the numeric value of the number in base 10,
 and n is the numeric value of the given input string in base 10.

 Before we jump into solutions of the equation, let's first dig up some properties of the function f(k, m) = (k^m - 1)/(k-1).

 If m is fixed, f(k, m) is monotonically increasing on k.
 If k is fixed, f(k, m) is also monotonically increasing on m.

 Now suppose we have two different solutions for the above equation: (k1, m1) and (k2, m2).
 Without loss of generality, let's assume m1 > m2,
 then we can show k1 < k2 as follows: n = f(k2, m2) = f(k1, m1) > f(k1, m2) ==> k2 > k1.
 Similarly for the other case: m1 < m2 ==> k1 > k2.
 Therefore k and m will be inversely related provided the equation is held true.


 The conclusion above suggests that if we can simply find a solution to the equation f(k, m) = n with the largest
 possible m, then the corresponding k is guaranteed to be the smallest. So now we need to figure out the upper and lower
 limit on m to impose constraint on our searching range. (Strictly speaking, we may also proceed in the other way round,
 i.e., to find the smallest k directly but that turns out to be O(n).)

 Note that if the equation is held true, smaller k will correspond to larger m. Since the minimum of k is 2, we know
 the maximum of m will be log(n + 1) (logarithm of (n+1) in base 2). What about the lower limit? Note that n >= 3,
 therefore m cannot be 1 (otherwise the numeric value would be 1 and the equation will have no solutions).
 To summarize, we have: 2 <= m <= log(n + 1).

 So our solution will go like this, starting from the upper limit of m, check if we can find a k so that the equation
 f(k, m) = n is held true. If so, return the corresponding k as the solution. Otherwise decrease the value of m by 1 and
 repeat the process until either a solution is found or all values of m has been exhausted. Note that for any n >= 3,
 there is a trivial solution where k = n - 1 and m = 2,
 therefore our searching process above is guaranteed to find at least one solution.

 The last part is how to find the solution to the equation with m fixed. A straightforward way would be doing
 binary search. One point worth noting here is the upper and lower limits for the searching range of k.
 For the upper limit, note that n = f(k, m) = 1 + k + ... + k^(m-1) > k^(m-1) ==> k < n^(1/(m-1)). For the lower limit,
 note that n = f(k, m) = (k^m - 1)/(k-1) <= (k^m - 1) ==> k >= (n+1)^(1/m). To summarize: (n+1)^(1/m) <= m <= n^(1/(m-1)).

 So here comes our final solution based on the analyses above. Note that the range of the input n is [3, 10^18],
 so n can fit into a long type variable. Also if for each m, k is in the searching range specified above,
 we won't have overflow problem. As for the time complexity, in the worst case, we need to scan the whole range of m,
 which is O(logn); for each m, the binary search is O(logn) too; therefore our solution will run at O((logn)^2).
 */
public class N483_SmallestGoodBase {
    // Google
    // math, binary search
    // 106 / 106 test cases passed.
    // 15 ms
    public class Solution {
        public String smallestGoodBase(String n) {
            long num = Long.valueOf(n);

            for (int m = (int)(Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
                long l = (long)(Math.pow(num + 1, 1.0 / m));
                long r = (long)(Math.pow(num, 1.0 / (m - 1)));

                while (l <= r) {
                    long k = l + ((r - l) >> 1);
                    long f = 0L;
                    for (int i = 0; i < m; i++, f = f * k + 1);

                    if (num == f) {
                        return String.valueOf(k);
                    } else if (num < f) {
                        r = k - 1;
                    } else {
                        l = k + 1;
                    }
                }
            }

            return String.valueOf(num - 1);
        }
    }
}
