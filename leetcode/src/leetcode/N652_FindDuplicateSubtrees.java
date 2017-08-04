package leetcode;

/**
 * Created by Hua on 8/4/2017.


 Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees,
 you only need to return the root node of any one of them.

 Two trees are duplicate if they have the same structure with same node values.

 Example 1:

 1
 / \
 2   3
 /   / \
 4   2   4
 /
 4

 The following are two duplicate subtrees:

 2
 /
 4

 and

 4

 Therefore, you need to return above trees' root in the form of a list.

 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N652_FindDuplicateSubtrees {
    // google
    // very interesting problem, use hashmap(memo) and serialization string to identify duplicate subtree.
    // 167 / 167 test cases passed.
    // 45 ms
    public class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> ret = new ArrayList();
            dfs(root, ret, new HashMap());
            return ret;
        }

        public String dfs(TreeNode node, List<TreeNode> ret, HashMap<String, Integer> map){
            if(node == null) return "#";
            String str = node.val + "," + dfs(node.left, ret, map) + "," + dfs(node.right, ret, map);
            if(!map.containsKey(str)) map.put(str, 0);
            if(map.get(str) == 1) ret.add(node);
            map.put(str, map.get(str) + 1);
            return str;
        }
    }


}
