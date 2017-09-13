package leetcode;

/**
 * Created by Hua on 7/20/2017.

 Given a binary tree, return the vertical order traversal of its nodes' values.
 (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:

 Given binary tree [3,9,20,null,null,15,7],

    3
   /\
  /  \
 9   20
     /\
    /  \
   15   7

 return its vertical order traversal as:

 [
     [9],
     [3,15],
     [20],
     [7]
 ]

 Given binary tree [3,9,8,4,0,1,7],

         3
        /\
       /  \
      9    8
     /\   /\
    /   \/  \
   4   01   7

 return its vertical order traversal as:

 [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
 ]

 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),

       3
      /\
     /  \
    9   8
    /\  /\
   /  \/  \
  4  01   7
     /\
    /  \
   5   2

 return its vertical order traversal as:

 [
     [4],
     [9,5],
     [3,0,1],
     [8,2],
     [7]
 ]


 */

import java.util.*;
import leetcode.N0_data_strcture.*;
public class N314_BinaryTreeVerticalOrderTraversal {
    // Google, Facebook (Premium)
    // VIP, I can't test now.
    public class Solution {
        class Node{
            TreeNode node;
            int index;
            Node(TreeNode node, int index){
                this.node = node;
                this.index = index;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList();
            if(root == null) return ret;

            HashMap<Integer, ArrayList<Integer>> map = new HashMap();
            LinkedList<Node> list = new LinkedList();
            list.add(new Node(root, 0));
            int min = 0, max = 0;

            while(!list.isEmpty()){
                Node node = list.removeFirst();
                min = Math.min(min, node.index);
                max = Math.max(max, node.index);

                if(node.node.left != null ) list.add(new Node(node.node.left, node.index - 1));
                if(node.node.right != null ) list.add(new Node(node.node.right, node.index + 1));

                if(!map.containsKey(node.index)) map.put(node.index, new ArrayList());
                map.get(node.index).add(node.node.val);
            }

            for(int i=min; i<=max; i++) if(map.containsKey(i))ret.add(map.get(i));
            return ret;
        }
    }


    // level-order traversal with a little trick to track column index
    // 212 / 212 test cases passed.
    // 4 ms
    public class Solution2 {
        class Node{
            TreeNode node;
            int index;
            Node(TreeNode node, int index){
                this.node = node;
                this.index = index;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            int min_index = 0;
            List<List<Integer>> ret = new LinkedList();
            if(root == null) return ret;
            LinkedList<Node> q = new LinkedList();
            q.add(new Node(root, 0));

            while(!q.isEmpty()){
                Node node = q.removeFirst();
                if(node.index < min_index) {
                    ret.add(0, new LinkedList());
                    min_index = node.index;
                }
                else if(node.index - min_index >= ret.size()) ret.add(new LinkedList());

                ret.get(node.index - min_index).add(node.node.val);
                if(node.node.left != null) q.add(new Node(node.node.left, node.index - 1));
                if(node.node.right != null) q.add(new Node(node.node.right, node.index + 1));
            }
            return ret;
        }
    }

    // easier to implement, store index level in hashmap
    public class Solution3 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (root == null) return result;

            // level and list
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            LinkedList<Integer> level = new LinkedList<Integer>();

            queue.offer(root);
            level.offer(0);

            int minLevel = 0;
            int maxLevel = 0;

            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                int cur_level = level.poll();

                //track min and max levels
                minLevel = Math.min(minLevel, cur_level);
                maxLevel = Math.max(maxLevel, cur_level);

                if (map.containsKey(cur_level)) {
                    map.get(cur_level).add(p.val);
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(p.val);
                    map.put(cur_level, list);
                }

                if (p.left != null) {
                    queue.offer(p.left);
                    level.offer(cur_level - 1);
                }

                if (p.right != null) {
                    queue.offer(p.right);
                    level.offer(cur_level + 1);
                }
            }

            for (int i = minLevel; i <= maxLevel; i++) {
                if (map.containsKey(i)) result.add(map.get(i));
            }
            return result;
        }
    }
}
