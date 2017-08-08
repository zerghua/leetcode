package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Hua on 5/25/2017.

 Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
 LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
 it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize
 its total capital after finishing at most k distinct projects.

 You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to
 start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain
 its pure profit and the profit will be added to your total capital.

 To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital,
 and output your final maximized capital.

 Example 1:

 Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

 Output: 4

 Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 After finishing it you will obtain profit 1 and your capital becomes 1.
 With capital 1, you can either start the project indexed 1 or the project indexed 2.
 Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.

 Note:

 You may assume all numbers in the input are non-negative integers.
 The length of Profits array and Capital array will not exceed 50,000.
 The answer is guaranteed to fit in a 32-bit signed integer.

 */
public class N502_IPO {
    // no company
    // two heaps, one sort by capital increasing, another sort by profit decreasing.
    // very interesting
    // 31 / 31 test cases passed.
    // 141 ms
    public class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            PriorityQueue<int[]> heapProfit = new PriorityQueue<>((a,b) -> b[0] - a[0]);
            PriorityQueue<int[]> heapCapital = new PriorityQueue<>((a,b) -> a[1] - b[1]);

            for(int i=0; i<Profits.length; i++) heapCapital.add(new int[]{Profits[i], Capital[i]});

            for(int i=0; i<k ; i++){
                while(!heapCapital.isEmpty() && W >= heapCapital.peek()[1]){
                    heapProfit.add(heapCapital.remove());
                }
                if(heapProfit.isEmpty())break;
                W += heapProfit.remove()[0];  // add max possible profit
            }

            return W;
        }
    }

}
