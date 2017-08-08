package leetcode;

/**
 * Created by Hua on 4/3/2016.

 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i
 to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once,
 otherwise return -1.

 Note:
 The solution is guaranteed to be unique.

 */
public class N134_GasStation {
    // no company
    // greedy
    // find the start point which can circulate the cycle.
    // read problem description carefully, because guaranteed solution to be unique
    // if failed at i, we can give up all start index [0,i], start checking from i+1.
    //1 ms
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int net_sum=0, cur_sum=0, start=0;
        for(int i=0;i<gas.length;i++){
            cur_sum += gas[i] - cost[i];
            net_sum += gas[i] - cost[i];
            if(cur_sum < 0) {
                start = i+1;
                cur_sum = 0;
            }
        }
        if(net_sum < 0) return -1;
        return start;
    }
}
