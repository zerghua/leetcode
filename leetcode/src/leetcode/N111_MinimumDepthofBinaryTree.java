package leetcode;
import leetcode.N0_data_strcture.*;

public class N111_MinimumDepthofBinaryTree {
	//1 ms
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left ==null && root.right ==null) return 1;
        if(root.left !=null && root.right !=null) return 1 + Math.min(minDepth(root.left),  minDepth(root.right));
        else if( root.left !=null) return 1 + minDepth(root.left);
        else return 1 + minDepth(root.right);
    }
    
    //1 ms
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        if(root.left ==null) return 1 + minDepth(root.right);
        else if(root.right ==null) return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left),  minDepth(root.right));
    }    
}
