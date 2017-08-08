package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.HashMap;

/**
 * Created by HuaZ on 8/22/2016.

 The thief has found himself a new place for his thievery again.
 There is only one entrance to this area, called the "root." Besides the root,
 each house has one and only one parent house. After a tour, the smart thief realized
 that "all houses in this place forms a binary tree". It will automatically contact
 the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

      3
     / \
    2   3
     \   \
     3   1

 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:

      3
     / \
    4   5
   / \   \
  1   3   1

 Maximum amount of money the thief can rob = 4 + 5 = 9.

 https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/2

 */
public class N337_HouseRobber3 {
    // Uber
    // naive, no DP.
    // 1199 ms
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = 0;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right!= null) val += rob(root.right.left) + rob(root.right.right);

        return Math.max(val+ root.val,  rob(root.left) + rob(root.right));
    }

    // DP with hashmap  9 ms
    class dp {
        public int rob(TreeNode root) {
            return rob(root, new HashMap());
        }

        public int rob(TreeNode root, HashMap<TreeNode, Integer> map) {
            if (root == null) return 0;
            if(map.containsKey(root)) return map.get(root);

            int val = 0;
            if (root.left != null) val += rob(root.left.left, map) + rob(root.left.right, map);
            if (root.right != null) val += rob(root.right.left, map) + rob(root.right.right, map);
            val =Math.max(val + root.val, rob(root.left, map) + rob(root.right,map));
            map.put(root, val);
            return val;
        }
    }

    // use int[]
    // 1 ms
    class dp2{
        private final int NOTROB = 0;
        private final int ROB = 1;

        public int rob(TreeNode root) {
            int[] ret = dp(root);
            return Math.max(ret[NOTROB], ret[ROB]);
        }

        public int[] dp(TreeNode node){
            if(node == null) return new int[]{0,0};
            int[] left = dp(node.left);
            int[] right = dp(node.right);
            int robThisNode = node.val + left[NOTROB] + right[NOTROB];
            int notRobThisNode = Math.max(left[NOTROB], left[ROB]) + Math.max(right[NOTROB], right[ROB]);
            return new int[]{notRobThisNode, robThisNode};
        }

    }

}
