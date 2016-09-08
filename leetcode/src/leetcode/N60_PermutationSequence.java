package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/8/2016.

 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.

 https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
 */
public class N60_PermutationSequence {
    //4 ms, had to use hard-coded factorial, or will TLE
    //math, mod
    public String getPermutation(int n, int k) {
        String ret = "";
        //int[] factorial = new int[n];
        //factorial[0] = 1;
        //for(int i=1; i<n;i++)  factorial[i] = factorial[i-1] * i;
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        LinkedList<Integer> numbers = new LinkedList<>();
        for(int i=1; i<=n;i++) numbers.add(i);

        k--;
        for(int i=n-1; i >= 0; i--){
            int index = k/ factorial[i];
            ret += numbers.get(index);
            numbers.remove(index);
            k %= factorial[i];
        }

        return ret.toString();
    }
}
