package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 8/5/2017.
 Rank	Name	Score	Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	   Q4 (9)
 579 / 2272	zerghua	15	1:44:15	        0:09:17 	0:19:57 	1:29:15 3
 1323 were accepted of solution 1

 */
public class Contest_44 {
    public class Solution {
        public boolean findTarget(N0_data_strcture.TreeNode root, int k) {
            return dfs(root, k, new HashSet());
        }

        public boolean dfs(N0_data_strcture.TreeNode node, int k, HashSet<Integer> set){
            if(node == null) return false;
            if(set.contains(k - node.val)) return true;
            set.add(node.val);
            if(dfs(node.left, k, set) || dfs(node.right, k, set)) return true;
            return false;
        }
    }

    public class Solution2 {
        public N0_data_strcture.TreeNode constructMaximumBinaryTree(int[] nums) {
            return dfs(nums, 0, nums.length-1);
        }

        public N0_data_strcture.TreeNode dfs(int[] nums, int lo, int hi){
            if(lo > hi) return null;
            // find max
            int max_index = lo;
            for(int i=lo; i<=hi; i++){
                if(nums[i] > nums[max_index]) max_index = i;
            }
            N0_data_strcture.TreeNode root = new N0_data_strcture.TreeNode(nums[max_index]);
            root.left = dfs(nums, lo, max_index-1);
            root.right = dfs(nums, max_index+1, hi);
            return root;
        }
    }

    public class Solution3 {
        public List<List<String>> printTree(N0_data_strcture.TreeNode root) {
            int h = dfs(root); // get height of tree
            int col = (int)Math.pow(2, h) - 1;

            List<List<String>> ret = new ArrayList();
            build(root, ret, 0, col-1, 0);
            // add trailing ""
            for(List<String> list : ret){
                if(list.size() < col){
                    int size = list.size();
                    for(int i=size;i<col;i++) list.add("");
                }
            }
            return ret;
        }

        public void build(N0_data_strcture.TreeNode node, List<List<String>> ret, int lo, int hi, int level){
            int mid = lo + (hi - lo)/2;
            if(ret.size() <= level) ret.add(new ArrayList());
            if(ret.get(level).size() < lo){
                for(int i=ret.get(level).size(); i<lo; i++) ret.get(level).add("");
            }

            for(int i=lo; i<mid; i++) ret.get(level).add("");
            ret.get(level).add(node != null ?"" + node.val : "");
            for(int i=lo; i<mid; i++) ret.get(level).add("");

            if(node == null || (node.left == null && node.right == null)) return;
            build(node.left, ret, lo, mid-1, level+1);
            if(ret.get(level+1).size() <= mid){
                for(int i=ret.get(level+1).size(); i<=mid; i++) ret.get(level+1).add("");
            }
            build(node.right, ret, mid+1, hi, level+1);
        }

        public int dfs(N0_data_strcture.TreeNode node){
            if(node == null) return 0;
            return 1 + Math.max(dfs(node.left), dfs(node.right));
        }
    }
}
