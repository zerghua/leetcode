package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.LinkedList;

/**
 * Created by HuaZ on 8/19/2017.
 * Rank	    Name	Score	Finish Time 	Q1 (3)	    Q2 (6)	    Q3 (8)	    Q4 (9)
 373 / 2389	zerghua	16	    1:23:58	        0:10:22 	1:08:58 	0:50:44 3
 1340 were accepted of solution 1

 N661, N662, N663, N664
 */
public class Contest_46 {
    class Solution {
        public int[][] imageSmoother(int[][] M) {
            int m = M.length, n = M[0].length;
            int[][] ret = new int[m][n];

            for(int i =0; i<m; i++){
                for(int j=0;j<n;j++){
                    ret[i][j] = get(M, i, j);
                }
            }
            return ret;
        }

        public int get(int[][] M, int x, int y){
            int count = 0, sum = 0, m = M.length, n = M[0].length;
            for(int i=x-1;i<=x+1; i++){
                for(int j=y-1;j<=y+1;j++){
                    if(i>=0 && i<m && j>=0 && j<n){
                        count++;
                        sum+=M[i][j];
                    }
                }
            }
            return sum/count;
        }
    }


    class Solution2 {
        class Node{
            TreeNode node;
            int count;
            Node(TreeNode node, int count){
                this.node = node;
                this.count = count;
            }
        }
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null) return 0;
            LinkedList<Node> list = new LinkedList();
            int ret = 1;
            list.add(new Node(root, 1));
            while(!list.isEmpty()){
                int size = list.size();
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for(int i=0; i<size; i++){
                    Node node = list.removeFirst();
                    min = Math.min(min, node.count);
                    max = Math.max(max, node.count);
                    if(node.node.left !=null) list.add(new Node(node.node.left, node.count*2-1));
                    if(node.node.right !=null) list.add(new Node(node.node.right, node.count*2));
                }
                ret = Math.max(ret, max - min + 1);
            }
            return ret;
        }
    }



    // check if exist cur_sum = total_sum/2;
    // o(2*n)
    class Solution3 {
        boolean ret = false;
        public boolean checkEqualTree(TreeNode root) {
            int sum = getSum(root);
            if(Math.abs(sum) % 2 == 1 || (root.left == null && root.right == null)) return false;
            dfs(root, sum/2);
            return ret;
        }

        public int getSum(TreeNode node){
            if(node == null) return 0;
            return node.val + getSum(node.left) + getSum(node.right);
        }

        public int dfs(TreeNode node, int sum){
            if(node == null) return 0;
            int left = dfs(node.left, sum);
            int right = dfs(node.right, sum);
            if(node.val + left + right == sum) ret = true;
            return node.val + left + right;
        }
    }

    // backtracking + greedy? hashmap<char, list<index>> to store index of char as list
    // each time to mark continuous index of that char,
    class Solution4 {
        public int strangePrinter(String s) {
            return 1;
        }
    }

}
