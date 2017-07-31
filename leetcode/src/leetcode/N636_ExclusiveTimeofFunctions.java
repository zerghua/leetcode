package leetcode;

/**
 * Created by Hua on 7/31/2017.

 Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU,
 find the exclusive time of these functions.

 Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.

 A log is a string has this format : function_id:start_or_end:timestamp.
 For example, "0:start:0" means function 0 starts from the very beginning of time 0.
 "0:end:0" means function 0 ends to the very end of time 0.

 Exclusive time of a function is defined as the time spent within this function,
 the time spent by calling other functions should not be considered as this function's exclusive time.
 You should return the exclusive time of each function sorted by their function id.

 Example 1:

 Input:
 n = 2
 logs =
 ["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]

 Output:[3, 4]
 Explanation:
 Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1.
 Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
 Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time.
 So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.

 Note:

 Input logs will be sorted by timestamp, NOT log id.
 Your output should be sorted by function id,
 which means the 0th element of your output corresponds to the exclusive time of function 0.
 Two functions won't start or end at the same time.
 Functions could be called recursively, and will always end.
 1 <= n <= 100

 */
import java.util.*;
public class N636_ExclusiveTimeofFunctions {
    // facebook
    // greedy stack, store id in stack, calculate time for each neighbour segments and advance preStartTime
    // 120 / 120 test cases passed.
    // 51 ms
    public class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<Integer> stack = new Stack();  // id is stacked
            int[] ret = new int[n];
            int preStartTime = 0;
            for(String s: logs){
                String[] a = s.split(":");
                int id = Integer.parseInt(a[0]), time= Integer.parseInt(a[2]);

                if(a[1].equals("start")){
                    if(!stack.isEmpty()){
                        int preId = stack.peek();
                        ret[preId] += time - preStartTime;  // greedily add time between two start.
                    }
                    stack.push(id);
                    preStartTime = time;   //advance preStartTime
                }
                else{
                    int preId = stack.pop();
                    ret[preId] += time - preStartTime + 1;
                    preStartTime = time + 1;
                }
            }
            return ret;
        }
    }
}
