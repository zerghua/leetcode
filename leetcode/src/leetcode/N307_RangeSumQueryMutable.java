package leetcode;

/**
 * Created by Hua on 6/16/2016.

 The update(i, val) function modifies nums by updating the element at index i to val.

 Example:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8

 Note:

 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly

 */
public class N307_RangeSumQueryMutable {
    // segment tree
    // 16 ms
    public class NumArray {
        public class SegmentTreeNode{
            int start, end, sum;
            SegmentTreeNode left, right;

            public SegmentTreeNode(int start, int end){
                this.start = start;
                this.end = end;
                this.sum = 0;
            }
            public SegmentTreeNode(int start, int end, int sum){
                this.start = start;
                this.end = end;
                this.sum = sum;
            }
        }

        SegmentTreeNode root = null;
        public NumArray(int[] nums) {
            if(nums == null || nums.length ==0) return ;
            this.root = buildTree(nums, 0, nums.length-1);
        }

        public SegmentTreeNode buildTree(int[] nums, int i, int j){
            if(nums ==null || nums.length==0 || i>j) return null;
            if(i==j) return new SegmentTreeNode(i,j,nums[i]);

            SegmentTreeNode root = new SegmentTreeNode(i,j);
            int mid = i+ (j-i)/2;
            root.left = buildTree(nums, i, mid);
            root.right = buildTree(nums, mid+1, j);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }

        void update(int i, int val) {
            update(root, i, val);
        }

        void update(SegmentTreeNode root, int i, int val){
            if(root == null) return;
            int mid = root.start + (root.end - root.start)/2;
            if(i<=mid) update(root.left, i, val);
            else update(root.right, i, val);
            if(root.start == root.end && root.start == i){
                root.sum = val;
                return;
            }
            root.sum = root.left.sum + root.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        public int sumRange(SegmentTreeNode root, int i, int j) {
            if(root == null || j<root.start || i>root.end || i>j) return 0;
            if(i<= root.start && j>= root.end) return root.sum;

            int mid = root.start + (root.end - root.start)/2;

            /* TLE in this format? why?
            return sumRange(root.left, i, Math.min(mid, j)) +
                    sumRange(root.right, Math.max(mid+1, i), j);
            */

            int ret = sumRange(root.left, i, Math.min(mid, j)) +
                    sumRange(root.right, Math.max(mid+1, i), j);
            return ret;
        }

    }

    //another solution. Binary indexed tree

}
