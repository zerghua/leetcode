package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/**
 * Created by HuaZ on 9/30/2017.
 Rank	    Name	Score	 Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	    Q4 (9)
 472 / 2615	zerghua	    8	 0:54:45	    0:14:43 	0:54:45
 N686, N687, N688, N689

 */
public class Contest_52 {
    // greedy repeat?
    // at least larger and equal than, two tries
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(sb.length() < B.length()){
                i++;
                sb.append(A);
            }
            if(isSubString(sb, B)) return i;
            sb.append(A);
            if(isSubString(sb, B)) return i+1;
            return -1;
        }

        // return true if b is substring of a.
        // a is longer than b
        public boolean isSubString(StringBuilder a, String b){
            for(int i=0; i<=a.length() - b.length(); i++){
                if(a.substring(i, b.length()+i).equals(b)) return true;
            }
            return false;
        }
    }


    // tree traversal
    class Solution2 {
        int max = 0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return max;
        }

        public int dfs(TreeNode node){
            if(node == null) return 0;

            int left= dfs(node.left);
            if(node.left != null && node.left.val == node.val) left += 1;
            else left = 0;

            int right = dfs(node.right);
            if(node.right != null && node.right.val == node.val) right += 1;
            else right = 0;

            max = Math.max(max, left + right);
            return Math.max(left, right);
        }
    }



    // remove nums.length - 3*k smallest?
    // return lexicographically smallest one 3 index?
    // [7,13,20,19,19,2,10,1,1,19]
    // 3
    // Expected:[1,4,7]
    class Solution4 {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            // int[] = new int[2], a[0] is val, and a[1] is index
            // remove smallest value first, if val the same, remove larger index
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)-> a[0]==b[0]?b[1]-a[1] : b[0]-a[0]);

            int n = nums.length - 3*k;
            for(int i=nums.length-1; i>=0; i--){
                if(heap.size() < n) heap.add(new int[]{nums[i], i});
                else{
                    if(nums[i] < heap.peek()[0]){
                        heap.remove();
                        heap.add(new int[]{nums[i], i});
                    }
                }
            }

            // now heap has n elements to remove
            ArrayList<Integer> list = new ArrayList();
            for(int[] a : heap) list.add(a[1]);
            Collections.sort(list);

            // construct return
            int[] ret = new int[3];
            int p = 0, i = 0;
            for(int j = 0; j < list.size(); j++){
                int index = list.get(j);
                if(i + k <= index) {
                    ret[p++] = i;
                    i += k;
                    j--;
                }
                else i= index + 1;
            }

            return ret;
        }
    }
}
