package leetcode;

/**
 * Created by Hua on 7/10/2017.

 There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.


 We divided it into two cases.

 the last two posts have the same color, the number of ways to paint in this case is sameColorCounts.

 the last two posts have different colors, and the number of ways in this case is diffColorCounts.

 The reason why we have these two cases is that we can easily compute both of them, and that is all I do.
 When adding a new post, we can use the same color as the last one (if allowed) or different color.
 If we use different color, there're k-1 options, and the outcomes shoule belong to the diffColorCounts category.
 If we use same color, there's only one option, and we can only do this when the last two have different colors
 (which is the diffColorCounts). There we have our induction step.

 Here is an example, let's say we have 3 posts and 3 colors. The first two posts we have 9 ways to do them,
 (1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3). Now we know that

 diffColorCounts = 6;

 And

 sameColorCounts = 3;

 Now for the third post, we can compute these two variables like this:

 If we use different colors than the last one (the second one), these ways can be added into diffColorCounts,
 so if the last one is 3, we can use 1 or 2, if it's 1, we can use 2 or 3, etc.
 Apparently there are (diffColorCounts + sameColorCounts) * (k-1) possible ways.

 If we use the same color as the last one, we would trigger a violation
 in these three cases (1,1,1), (2,2,2) and (3,3,3). This is because they already used the same color
 for the last two posts. So is there a count that rules out these kind of cases? YES, the diffColorCounts.
 So in cases within diffColorCounts, we can use the same color as the last one without worrying about triggering
 the violation. And now as we append a same-color post to them,
 the former diffColorCounts becomes the current sameColorCounts.


 Then we can keep going until we reach the n. And finally just sum up these two variables as result.

 Hope this would be clearer.

 */
public class N276_PaintFence {
    // Google (Premium)
    // 79 / 79 test cases passed.
    // 0 ms
    // DP, check last two can be the same color
    // similar problem.  House Robber, House Robber II, Paint House, Paint House II
    public class Solution {
        public int numWays(int n, int k) {
            if(n == 0 || k == 0) return 0;
            if(n == 1) return k;
            int diff = k*(k-1), same = k;  //for example, k = 3
            for(int i=2; i<n; i++){
                int tmp = diff;
                diff = (same + diff) * (k-1);
                same = tmp;
            }
            return same + diff;
        }
    }
}
