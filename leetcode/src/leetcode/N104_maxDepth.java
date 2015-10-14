package leetcode;

// 316 ms  87%
public class N104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
        	return 0;
        
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
