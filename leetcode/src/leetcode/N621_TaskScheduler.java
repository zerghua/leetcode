package leetcode;

/**
 * Created by Hua on 6/23/2017.

 Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 represent different tasks.Tasks could be done without original order. Each task could be done in one interval.
 For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks,
 there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.

 Example 1:

 Input: tasks = ['A','A','A','B','B','B'], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

 Note:

 The number of tasks is in the range [1, 10000].
 The integer n is in the range [0, 100].



test case:
 ['A','A','A','A','A','A','B','C','D','E','F','G']
 2

 */

import java.util.*;
public class N621_TaskScheduler {
    // Facebook
    // kind of custom made sorted hashmap.
    // 64 / 64 test cases passed.
    // 62 ms
    public class Solution {
        public int leastInterval(char[] tasks, int n) {
            Integer[] a = new Integer[26];
            Arrays.fill(a, 0);                //important when work with Integer[], it needs to be initialized first.
            for(char c : tasks) a[c - 'A']++;

            int total = tasks.length, ret = tasks.length;
            while(total != 0){
                Arrays.sort(a, Collections.reverseOrder());
                int countOfType = 0;
                for(int i=0;i<26;i++){
                    if(a[i] == 0 || countOfType == n + 1) break;
                    a[i]--;
                    countOfType++;
                    total--;
                }
                if(total != 0)ret += Math.max(0, n + 1 - countOfType);  // to trim last one idle
            }
            return ret;
        }
    }
}
