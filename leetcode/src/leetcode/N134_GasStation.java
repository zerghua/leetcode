package leetcode;

/**
 * Created by Hua on 4/3/2016.
 */
public class N134_GasStation {
    //greedy
    //find the start point which can circulate the cycle.
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
