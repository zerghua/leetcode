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


 see graph here, it requires at least 2*n - 1 node, uppper bound is ~ 4n node.
 non-leaf node are contains range of sum
 leaf node contains value of each index.
 http://www.programcreek.com/2014/04/leetcode-range-sum-query-mutable-java/

 */
public class N307_RangeSumQueryMutable {
    // Google
    // segment tree
    // 10 / 10 test cases passed. 141 ms 8/23/2017
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
            if(root == null || i < root.start || i > root.end) return;
            if(root.start == root.end && root.start == i){
                root.sum = val;
                return;
            }

            update(root.left, i, val);
            update(root.right, i, val);
            root.sum = root.left.sum + root.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        public int sumRange(SegmentTreeNode root, int i, int j) {
            if(root == null || j<root.start || i>root.end || i>j) return 0;
            if(i<= root.start && j>= root.end) return root.sum;

            int mid = root.start + (root.end - root.start)/2;
            return sumRange(root.left, i, Math.min(mid, j)) + sumRange(root.right, Math.max(mid+1, i), j);
        }

    }


    // Google
    // given a data stream which contains all positive integer,
    // design a data structure is able query the count of each number
    // in a range
    // solution is segment tree, o(logn) insert, o(logn) query
    /*
                                     [0,5]
                                   /       \
                              [0,3]        [4,5]
                             /    \        /   \
                        [0,1]     [2,3]  [4,4] [5,5]
                       /    \     /    \
                    [0,0] [1,1] [2,2]  [3,3]
     */
    public class RangeCount {
        class SegTreeNode{
            int start, end, sum;
            SegTreeNode left, right;
            SegTreeNode(int start, int end){
                this.start = start;
                this.end = end;
                this.sum = 0;
            }
        }

        // init, assume are all positive integers
        // all sum are 0 initially
        SegTreeNode root;
        RangeCount(){
            root = buildTree(0, Integer.MAX_VALUE);
        }

        SegTreeNode buildTree(int lo, int hi){
            if(lo > hi) return null;
            if(lo == hi) return new SegTreeNode(lo, lo);

            int mid = (hi-lo)/2 + lo;
            root = new SegTreeNode(lo,hi);
            root.left = buildTree(lo, mid);
            root.right = buildTree(mid+1, hi);
            return root;
        }

        // increase 1 count for that number
        void update(int num){
            update(num, root);
        }

        void update(int num, SegTreeNode node){
            if(node == null || num < node.start || num > node.end) return;
            if(num == node.start && num ==  node.end){
                node.sum++;
                return;
            }

            update(num, node.left);
            update(num, node.right);
            node.sum = node.left.sum + node.right.sum;
        }

        // query count of each number between i and j
        int query(int i, int j){
            return query(i,j, root);
        }

        int query(int i, int j, SegTreeNode node){
            if(node==null || i > j || i > node.end || j<node.start) return 0;

            int lo = node.start, hi = node.end, mid = (hi-lo)/2 + lo;
            if(i <= lo && j>= hi) return node.sum;

            // the min and max are important
            return query(i, Math.min(mid, j), node.left) + query(Math.max(i,mid+1), hi, node.right);
        }


    }


    //another solution. Binary indexed tree

}
