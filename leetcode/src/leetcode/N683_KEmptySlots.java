package leetcode;
import java.util.*;

/**
 * Created by Hua on 9/26/2017.

 There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
 In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

 Given an array flowers consists of number from 1 to N.
 Each number in the array represents the place where the flower will open in that day.

 For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x,
 where i and x will be in the range from 1 to N.

 Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
 and also the number of flowers between them is k and these flowers are not blooming.

 If there isn't such day, output -1.

 Example 1:

 Input:
 flowers: [1,3,2]
 k: 1
 Output: 2
 Explanation: In the second day, the first and the third flower have become blooming.

 Example 2:

 Input:
 flowers: [1,2,3]
 k: 1
 Output: -1

 Note:

 The given array will be in the range [1, 20000].


 */
public class N683_KEmptySlots {
    // had trouble to understand the problem
    /*

    It seems that this question has some mistakes. I think there are two places that might lead to misunderstandings:

    flowers[i] = x should mean that the unique flower that blooms at day i+1 (not i) will be at position x.
    If you can get multiple possible results, then you need to return the minimum one.

    The idea is to use an array days[] to record each position's flower's blooming day.
    That means days[i] is the blooming day of the flower in position i+1.
    We just need to find a subarray days[left, left+1,..., left+k-1, right] which satisfies:
    for any i = left+1,..., left+k-1, we can have days[left] < days[i] && days[right] < days[i].
    Then, the result is max(days[left], days[right]).

    */

    // o(n)
    // 61 / 61 test cases passed.
    // 24 ms
    class Solution {
        public int kEmptySlots(int[] flowers, int k) {

            int[] days =  new int[flowers.length];
            for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;

            int left = 0, right = k + 1, res = Integer.MAX_VALUE;

            for(int i = 0; right < days.length; i++){
                if(days[i] < days[left] || days[i] <= days[right]){
                    if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                    left = i;
                    right = k + 1 + i;
                }
            }
            return (res == Integer.MAX_VALUE)?-1:res;
        }
    }



    /*
    If at the ith day, flower position is n and it satisfied the requirement,
    then at least one of the following should be true

    there's a flower at n-k-1 and no flowers between n-k-1 and n
    There's a flower at n+k+1 and no flowers between n and n+k+1

     */
    // nlogn
    // 61 / 61 test cases passed.
    // 153 ms
    class Solution2 {
        public int kEmptySlots(int[] flowers, int k) {
            TreeSet<Integer> set = new TreeSet<>();
            int i=0;
            for (int n:flowers){
                set.add(n);
                int prev=n-k-1,next=n+k+1;

                if (set.contains(prev)){
                    Integer prevNext=set.ceiling(prev+1);
                    if (prevNext!=null&&prevNext==n)return set.size();
                }
                if (set.contains(next)){
                    Integer nextPrev=set.floor(next-1);
                    if (nextPrev!=null&&nextPrev==n)return set.size();
                }
            }
            return -1;
        }
    }
}
