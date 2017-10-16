package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/14/2017.
 Rank	    Name	Score	 Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	    Q4 (9)
 630 / 3232	zerghua	    8	     0:34:00	0:19:28 	0:34:00
 N696, N697, N698, N699

 */
public class Contest_54 {
    // map
    class Solution {
        class Node{
            int count, start, end;
            Node(){
                start= Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
            }
        }

        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, Node> map = new HashMap();
            int max = 0;
            for(int i=0; i<nums.length; i++) {
                int e = nums[i];
                if (!map.containsKey(e)) map.put(e, new Node());
                map.get(e).count++;
                map.get(e).start = Math.min(i, map.get(e).start);
                map.get(e).end = Math.max(i, map.get(e).end);
                max = Math.max(max, map.get(e).count);
            }

            int ret = nums.length;
            for(int e : map.keySet()){
                if(map.get(e).count == max){
                    ret = Math.min(ret, map.get(e).end - map.get(e).start + 1);
                }
            }
            return ret;
        }
    }


    // coding? two pointers?
    class Solution2 {
        // if 0, -1, else +1
        public int countBinarySubstrings(String s) {
            char[] a = s.toCharArray();
            int ret = 0;
            for(int i=0;i<a.length; i++){
                int count = (a[i] == '0' ? -1 : 1);
                int diff = 1;
                for(int j=i+1; j<a.length; j++){
                    if(a[j] != a[j-1]) diff++;
                    if(diff > 2) break;

                    if(a[j] == '0') count -= 1;
                    else count +=1;
                    if(count == 0){
                        ret++;
                        break;
                    }
                }
            }
            return ret;
        }
    }


    // backtracking, BF  TLE when search from smallest to largest
    // AC when search from largest to smallest
    // 141 / 141 test cases passed.
    // 12 ms
    class Solution3 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for(int e : nums) sum += e;
            if(sum % k != 0 ) return false;
            int p = sum / k;
            Arrays.sort(nums);
            if(nums[nums.length - 1] > p || nums.length < k) return false;

            return dfs(nums, 0, p, new boolean[nums.length], 0, k);
        }

        public boolean dfs(int[] nums, int cur, int p, boolean[] isUsed, int count, int k){
            if(k == count) return true;
            if(cur > p) return false;

            for(int i=nums.length-1; i>=0;i--){
                if(isUsed[i]) continue;

                isUsed[i] = true;
                if(cur + nums[i] == p){
                    if(dfs(nums, 0, p, isUsed, count + 1, k)) return true;
                }
                if(dfs(nums, cur + nums[i], p, isUsed, count, k)) return true;
                isUsed[i] = false;

            }
            return false;
        }
    }


    // borrowed from others solution
    // has to backtrack from the largest number
    // 141 / 141 test cases passed.
    // 36 ms
    class Solution3_try_to_improve {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for(int e : nums) sum += e;
            if(sum % k != 0 ) return false;
            int p = sum / k;
            Arrays.sort(nums);
            int[] target = new int[k];
            return dfs(nums, p, target, nums.length-1);
        }

        public boolean dfs(int[] nums, int p, int[] target, int start){
            if(start == -1) return true;
            for(int i=0; i< target.length; i++){
                if(target[i] + nums[start] <= p){
                    target[i] += nums[start];
                    if(dfs(nums, p, target, start-1)) return true;
                    target[i] -= nums[start];
                }
            }
            return false;
        }
    }


}
