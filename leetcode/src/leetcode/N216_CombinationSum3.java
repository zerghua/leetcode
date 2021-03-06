package leetcode;
import java.util.*;

/**
 * Created by Hua on 5/28/2016.

 Find all possible combinations of k numbers that add up to a number n,
 given that only numbers from 1 to 9 can be used and each combination
 should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.

 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]


 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]


 */
public class N216_CombinationSum3 {
    // no company
    // backtracking
    // 18 / 18 test cases passed.
    // 1 ms
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ret = new ArrayList();
            dfs(ret, new LinkedList(), k, 1, n);  // k in [1,9]
            return ret;
        }

        public void dfs(List<List<Integer>> ret, LinkedList<Integer> list, int k, int start, int n){
            if(list.size() == k){
                if(n == 0) ret.add(new ArrayList(list));
                return;
            }
            for(int i=start; i<=9; i++){
                list.add(i);
                dfs(ret, list, k, i+1, n-i);
                list.removeLast();
            }
        }
    }



    // a few notes:
    // 1. no   1,4,4
    // 2. only 1,3,5, not 1,5,3
    // 1 ms
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        combinationSum3(k,n, 1, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void combinationSum3(int k, int n, int start,
                                 ArrayList<Integer> list, List<List<Integer>> ret) {
        if(k==0){
            if(n==0) ret.add(new ArrayList<>(list));
            return;
        }
        if(start > n) return;

        for(int i=start; i<=9; i++){
            list.add(i);
            combinationSum3(k-1, n-i, i+1, list, ret); //i+1 instead of start+1
            list.remove(list.size()-1);
        }
    }
}
