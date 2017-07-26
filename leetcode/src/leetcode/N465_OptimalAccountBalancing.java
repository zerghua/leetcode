package leetcode;

/**
 * Created by Hua on 7/26/2017.

 A group of friends went on holiday and sometimes lent each other money.
 For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride.
 We can model each transaction as a tuple (x, y, z) which means person x gave person y $z.
 Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID),
 the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

 Given a list of transactions between a group of people,
 return the minimum number of transactions required to settle the debt.

 Note:

 A transaction will be given as a tuple (x, y, z). Note that x ? y and z > 0.
 Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.

 Example 1:
 Input:
 [[0,1,10], [2,0,5]]

 Output:
 2

 Explanation:
 Person #0 gave person #1 $10.
 Person #2 gave person #0 $5.
 Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.



 Example 2:
 Input:
 [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

 Output:
 1

 Explanation:
 Person #0 gave person #1 $10.
 Person #1 gave person #0 $1.
 Person #1 gave person #2 $5.
 Person #2 gave person #0 $5.
 Therefore, person #1 only need to give person #0 $4, and all debt is settled.

 */

import java.util.*;
public class N465_OptimalAccountBalancing {
    // fair complex backtracking
    // 29 / 29 test cases passed.
    // 85 ms
    public class Solution {
        public int minTransfers(int[][] transactions) {
            HashMap<Integer, Long> map = new HashMap(); //balance of each person
            for(int[] t: transactions){
                if(!map.containsKey(t[0]))map.put(t[0], 0L);
                map.put(t[0], map.get(t[0]) - t[2]);

                if(!map.containsKey(t[1]))map.put(t[1], 0L);
                map.put(t[1], map.get(t[1]) + t[2]);
            }

            ArrayList<Long> list = new ArrayList();
            for(int person : map.keySet()){
                if(map.get(person) != 0 ) list.add(map.get(person));
            }

            return dfs(list, 0, 0);
        }

        public int dfs(ArrayList<Long> list, int start, int count){
            while(start < list.size() && list.get(start) == 0) start++;
            if(start >= list.size()) return count; // everyone are debt fre

            int ret = Integer.MAX_VALUE;
            for(int i=start+1; i<list.size(); i++){
                if(list.get(i) * list.get(start) < 0){
                    list.set(i, list.get(i) + list.get(start));
                    ret = Math.min(ret, dfs(list, start+1, count+1));
                    list.set(i, list.get(i) - list.get(start));
                }
            }

            return ret;
        }
    }
}
