package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.LinkedList;

/**
 * Created by Hua on 3/21/2016.
 */
public class N129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;

        LinkedList<TreeNode> list = new LinkedList<>();
        int sum=0;
        list.add(root);

        while(list.size()>0){
            int current_size = list.size();

            for(int i=0; i<current_size; i++){
                TreeNode node = list.pop();

                if(node.left==null && node.right==null) {
                    sum+= node.val;
                }

                if(node.left != null){
                    node.left.val = node.val*10 + node.left.val;
                    list.add(node.left);
                }
                if(node.right != null){
                    node.right.val = node.val*10 + node.right.val;
                    list.add(node.right);
                }
            }
        }
        return sum;
    }

    public int sumNumbers_recursion_helper(TreeNode root, int num, int sum){
        if(root == null) return sum;

        num = num*10 + root.val;

        if(root.left==null && root.right==null) {
            sum+= num;
            return sum;
        }

        return sumNumbers_recursion_helper(root.left, num, sum) +
                sumNumbers_recursion_helper(root.right, num, sum);

    }

    public int sumNumbers_recursion(TreeNode root) {
        if(root == null) return 0;

        return sumNumbers_recursion_helper(root, 0, 0);
    }

}
