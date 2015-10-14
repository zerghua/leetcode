package leetcode;
import leetcode.N0_data_strcture.*;

//284ms, 54%
public class N100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null) return true;
        else if(p==null || q == null) return false;
        else if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}
