package leetcode;

/**
 * Created by HuaZ on 7/15/2017.

 Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

 Each process only has one parent process, but may have one or more children processes.
 This is just like a tree structure. Only one process has PPID that is 0, which means this
 process has no parent process. All the PIDs will be distinct positive integers.

 We use two list of integers to represent a list of processes, where the first list contains
 PID for each process and the second list contains the corresponding PPID.

 Now given the two lists, and a PID representing a process you want to kill, return a list of
 PIDs of processes that will be killed in the end. You should assume that when a process is killed,
 all its children processes will be killed. No order is required for the final answer.

 Example 1:

 Input:
 pid =  [1, 3, 10, 5]
 ppid = [3, 0, 5, 3]
 kill = 5
 Output: [5,10]
 Explanation:
      3
    /   \
   1     5
       /
     10
 Kill 5 will also kill 10.

 Note:

 The given kill id is guaranteed to be one of the given PIDs.
 n >= 1.



 */

import java.util.*;
public class N582_KillProcess {
    // Bloomberg (Premium)
    // hashtable + queue(BFS)
    // 166 / 166 test cases passed.
    // 88 ms
    public class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            List<Integer> ret = new ArrayList();
            // put into hash table
            HashMap<Integer, List<Integer>> map = new HashMap(); // map: parent-> list of pid
            for(int i=0; i< ppid.size(); i++){
                int parent = ppid.get(i), child = pid.get(i);
                if(!map.containsKey(parent)) map.put(parent, new ArrayList());
                map.get(parent).add(child);
            }

            // use queue to get all children of a pid
            LinkedList<Integer> list = new LinkedList();
            list.add(kill);
            while(!list.isEmpty()){
                int id = list.removeFirst();
                ret.add(id);
                if(map.containsKey(id)) list.addAll(map.get(id));
            }
            return ret;
        }
    }
}
