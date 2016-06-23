package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/**
 * Created by Hua on 6/22/2016.

 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.

 For example,
 Given the following binary tree,

      1
    /  \
   2    3
  / \    \
 4   5    7

 After calling your function, the tree should look like:

      1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \    \
 4-> 5 -> 7 -> NULL


 */
public class N117_PopulatingNextRightPointersinEachNode2 {
    // 7 ms
    // tree BFS, level by level, store size of each level and traverse within size.
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        ArrayList<TreeLinkNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            int n = list.size();
            TreeLinkNode cur, next;
            for(int i=0;i<n;i++){
                cur= list.remove(0);
                if(i<n-1) {
                    next = list.get(0);
                    cur.next = next;
                }
                if(cur.left != null) list.add(cur.left);
                if(cur.right != null) list.add(cur.right);
            }
        }
    }
}
