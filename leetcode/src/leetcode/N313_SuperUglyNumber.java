package leetcode;

import java.util.PriorityQueue;

/**
 * Created by HuaZ on 12/8/2016.

 Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime
 list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence
 of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.

 */
public class N313_SuperUglyNumber {
    // Google
    // topk, use heap
    // o(nlogk)
    // 83 / 83 test cases passed.
    // 132 ms
    public class Solution {
        class Node{
            int val, prime, index;
            Node(int val, int prime, int index){
                this.val = val;
                this.prime = prime;
                this.index = index;
            }
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ret = new int[n];
            ret[0] = 1;
            PriorityQueue<Node> heap = new PriorityQueue<Node>((a,b) -> a.val - b.val);
            for(int e : primes) heap.add(new Node(e, e, 1));
            for(int i=1; i<n; i++){
                ret[i] = heap.peek().val;
                while(ret[i] == heap.peek().val){  // while is important here to skip duplicate
                    Node node = heap.remove();
                    heap.add(new Node(node.prime * ret[node.index], node.prime, node.index + 1));
                }
            }
            return ret[n-1];
        }
    }


    // 29 ms 83 / 83 test cases passed.
    // math. similar to N264. ugly number 2
    public class Solution2 {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ret = new int[n];
            int[] index = new int[primes.length];
            ret[0] = 1;
            for(int i=1;i<n;i++){

                ret[i] = Integer.MAX_VALUE;
                // find next min
                for(int j=0; j<primes.length; j++)
                    ret[i] = Math.min(ret[i], primes[j] * ret[index[j]]);

                // update index
                for(int j=0; j<primes.length; j++) {
                    while (primes[j] * ret[index[j]] <= ret[i]) index[j]++;
                }
            }
            return ret[n-1];
        }
    }
}
