package leetcode;

/**
 * Created by Hua on 8/10/2017.

 There are 1000 buckets, one and only one of them contains poison, the rest are filled with water.
 They all look the same. If a pig drinks that poison it will die within 15 minutes.
 What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

 Answer this question, and write an algorithm for the follow-up general case.

 Follow-up:

 If there are n buckets and a pig drinking poison will die within m minutes,
 how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.




 With 2 pigs, poison killing in 15 minutes, and having 60 minutes,
 we can find the poison in up to 25 buckets in the following way. Arrange the buckets in a 5×5 square:

 1  2  3  4  5
 6  7  8  9 10
 11 12 13 14 15
 16 17 18 19 20
 21 22 23 24 25

 Now use one pig to find the row (make it drink from buckets 1, 2, 3, 4, 5, wait 15 minutes,
 make it drink from buckets 6, 7, 8, 9, 10, wait 15 minutes, etc).
 Use the second pig to find the column (make it drink 1, 6, 11, 16, 21, then 2, 7, 12, 17, 22, etc).

 Having 60 minutes and tests taking 15 minutes means we can run four tests.
 If the row pig dies in the third test, the poison is in the third row.
 If the column pig doesn't die at all, the poison is in the fifth column
 (this is why we can cover five rows/columns even though we can only run four tests).

 With 3 pigs, we can similarly use a 5×5×5 cube instead of a 5×5 square and again
 use one pig to determine the coordinate of one dimension (one pig drinks layers from top to bottom,
 one drinks layers from left to right, one drinks layers from front to back). So 3 pigs can solve up to 125 buckets.

 In general, we can solve up to (minutesToTest / minutesToDie + 1)pigs buckets this way,
 so just find the smallest sufficient number of pigs for example like this:

 def poorPigs(self, buckets, minutesToDie, minutesToTest):
 pigs = 0
 while (minutesToTest / minutesToDie + 1) ** pigs < buckets:
 pigs += 1
 return pigs

 Or with logarithm like I've seen other people do it.
 That's also where I got the idea from (I didn't really try solving this problem on my own
 because the judge's solution originally was wrong and I was more
 interested in possibly helping to make it right quickly).

 */
public class N458_PoorPigs {
    // math
    // 6 / 6 test cases passed.
    // 1 ms
    public class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            int ret = 0;
            while(Math.pow(1+ minutesToTest/minutesToDie, ret) < buckets) ret++;
            return ret;
        }
    }

}
