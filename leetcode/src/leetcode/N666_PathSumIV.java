package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 8/27/2017.

 If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

 For each integer in this list:

 The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8.
 The position is the same as that in a full binary tree.
 The units digit represents the value V of this node, 0 <= V <= 9.

 Given a list of ascending three-digits integers representing a binary with the depth smaller than 5.
 You need to return the sum of all paths from the root towards the leaves.

 Example 1:

 Input: [113, 215, 221]
 Output: 12
 Explanation:
 The tree that the list represents is:
   3
  / \
 5   1

 The path sum is (3 + 5) + (3 + 1) = 12.

 Example 2:

 Input: [113, 221]
 Output: 4
 Explanation:
 The tree that the list represents is:
 3
  \
   1

 The path sum is (3 + 1) = 4.


 */
public class N666_PathSumIV {
    // need to find a way to determine if node has children or not.
    // using formula:  For node xy, its left child is (x+1)(y*2-1) and right child is (x+1)(y*2)
    // better code than mine
    // 195 / 195 test cases passed.
    // 17 ms
    class Solution {
        int sum = 0;
        Map<Integer, Integer> tree = new HashMap<>();

        public int pathSum(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            for (int num : nums) {
                int key = num / 10;
                int value = num % 10;
                tree.put(key, value);
            }
            traverse(nums[0] / 10, 0);
            return sum;
        }

        private void traverse(int root, int preSum) {
            int level = root / 10;
            int pos = root % 10;
            int left = (level + 1) * 10 + pos * 2 - 1;
            int right = (level + 1) * 10 + pos * 2;

            int curSum = preSum + tree.get(root);

            if (!tree.containsKey(left) && !tree.containsKey(right)) {
                sum += curSum;
                return;
            }

            if (tree.containsKey(left)) traverse(left, curSum);
            if (tree.containsKey(right)) traverse(right, curSum);
        }
    }


    // my code
    // 195 / 195 test cases passed.
    // 15 ms
    class Solution2 {
        public int pathSum(int[] nums) {
            // convert input to full binary tree
            int[] tree = new int[16]; // at most 4 level, tree range[1,15], 0 is ignored
            Arrays.fill(tree, -1);    // important, or can't handle 0 value
            for(int i=0;i<nums.length; i++){
                int val = nums[i] % 10;
                int index =  (int)Math.pow(2, nums[i]/100 - 1) + nums[i]/10%10 - 1;
                tree[index] = val;
            }

            int ret = 0;
            for(int i=1;i<=15;i++){
                if(tree[i] == -1) continue;  // important, or will be wrong

                if(i >= 8) ret +=  tree[i]== -1 ? 0 : tree[i];  //     leaf node
                else{
                    if(tree[2*i] ==-1 && tree[2*i+1]== -1) ret+= tree[i];  // no children
                    else{
                        if(tree[2*i] != -1 ) tree[2*i] += tree[i];       // pass parent down to left
                        if(tree[2*i+1] != -1 ) tree[2*i+1] += tree[i];   // pass parent down to right
                    }
                }
            }
            return ret;
        }
    }
}
