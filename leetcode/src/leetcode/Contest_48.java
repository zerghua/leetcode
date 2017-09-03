package leetcode;

/**
 * Created by HuaZ on 9/2/2017.
 * Rank	    Name	Score	Finish Time 	Q1 (3)	    Q2 (6)	    Q3 (8)	    Q4 (9)
 812 / 2668	zerghua	15	1:49:48	0:22:47 2	1:19:48 	0:59:02 4



 */

import leetcode.N0_data_strcture.*;
public class Contest_48 {
    class Solution {
        int min, ret;
        public int findSecondMinimumValue(TreeNode root) {
            if(root == null) return -1;
            min = root.val;
            ret = Integer.MAX_VALUE;
            dfs(root);
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }

        public void dfs(TreeNode node){
            if(node == null) return;
            if(node.val > min && node.val < ret) ret = node.val;

            dfs(node.left);
            dfs(node.right);
        }
    }


    class Solution2 {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if(root == null) return null;
            if(root.val < L) return trimBST(root.right, L, R);
            else if(root.val > R) return trimBST(root.left, L, R);

            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }


    // o(n^2)
    class Solution3 {
        public int maximumSwap(int num) {
            char[] s = Integer.toString(num).toCharArray();
            int n = s.length;
            for(int i=0; i<n;i++){
                int k = i+1;
                // find max index
                for(int j=i+1; j<n;j++){
                    if(s[j] >= s[k] )k = j;
                }
                if(k< n && s[k] > s[i]) {
                    swap(s, k, i);
                    break;
                }
            }
            return Integer.parseInt(new String(s));
        }

        public void swap(char[] s, int i, int j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

}
