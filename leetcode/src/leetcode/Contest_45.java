package leetcode;

/**
 * Created by HuaZ on 8/12/2017.  9:30PM - 11:00PM EST
 Rank	    Name	Score	Finish Time 	Q1 (3)	    Q2 (6)	  Q3 (8)	Q4 (9)
 413 / 2292	zerghua	9	    0:14:26	        0:04:06 	0:14:26
 1535 were accepted of solution 1

 N657, N658, N659, N660

 */

import java.util.*;
public class Contest_45 {
    public class Solution {
        public boolean judgeCircle(String moves) {
            int a= 0, b =0;
            for(char c : moves.toCharArray()){
                if(c == 'U') a++;
                else if(c == 'D') a--;
                else if(c == 'L') b++;
                else b--;
            }
            return a == 0 && b == 0;
        }
    }

    // a[0] is abs diff value, a[1] is num
    public class Solution2 {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
            for(Integer num : arr){
                if(heap.size() < k) heap.add(new int[]{Math.abs(num-x), num});
                else{
                    int diff = Math.abs(num - x);
                    if(diff < heap.peek()[0]){
                        heap.remove();
                        heap.add(new int[]{diff, num});
                    }
                }
            }
            List<Integer> ret = new LinkedList();
            while(!heap.isEmpty()) ret.add(heap.remove()[1]);
            Collections.sort(ret);
            return ret;
        }
    }

    // int{max, count}
    public class Solution3 {
        public boolean isPossible(int[] nums) {

            return false;
    }


    }
}
