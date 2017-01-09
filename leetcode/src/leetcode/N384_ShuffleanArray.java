package leetcode;

import java.util.Random;

/**
 * Created by HuaZ on 8/16/2016.

 Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3]
 // must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();


 */
public class N384_ShuffleanArray {
    // 311 ms
    // random ?
    public class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] a = nums.clone();
            for(int i=1;i<a.length;i++){
                int j = random.nextInt(i+1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }


    // shuffle implementation from wiki, Fisher–Yates shuffle
    // question like shuffle a deck of card.
    // https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
    // added on 1/9/2017
    // 289ms 10 / 10 test cases passed.
    public class Solution2 {
        private int[] nums;
        private Random random;

        public Solution2(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] a = nums.clone();
            for(int i=a.length-1; i>=1 ;i--){
                int j = random.nextInt(i+1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
