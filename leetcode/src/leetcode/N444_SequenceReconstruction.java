package leetcode;

/**
 * Created by HuaZ on 7/23/2017.

 Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
 The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4.
 Reconstruction means building a shortest common supersequence of the sequences
 in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 Determine whether there is only one sequence that can be reconstructed from seqs
 and it is the org sequence.

 Example 1:

 Input:
 org: [1,2,3], seqs: [[1,2],[1,3]]

 Output:
 false

 Explanation:
 [1,2,3] is not the only one sequence that can be reconstructed,
 because [1,3,2] is also a valid sequence that can be reconstructed.

 Example 2:

 Input:
 org: [1,2,3], seqs: [[1,2]]

 Output:
 false

 Explanation:
 The reconstructed sequence can only be [1,2].

 Example 3:

 Input:
 org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

 Output:
 true

 Explanation:
 The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

 Example 4:

 Input:
 org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

 Output:
 true

 UPDATE (2017/1/8):
 The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings).
 Please reload the code definition to get the latest changes.

 */
import java.util.*;
public class N444_SequenceReconstruction {
    // google
    // wrong answer
    public class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            HashSet<String> set = new HashSet();
            if(org.length == 1) set.add(org[0] + "");
            for(int i=0; i<org.length -1 ;i++) set.add(org[i] + ":" + org[i+1]);

            for(List<Integer> list : seqs){
                if(list.size() < 1) continue;
                if(list.size() == 1){
                    if(set.contains(list.get(0))) set.remove(list.get(0));
                }
                else{
                    for(int i=0; i<list.size() - 1; i++) {
                        String key = list.get(i) + ":" + list.get(i+1);
                        if (set.contains(key)) set.remove(key);
                    }
                }

            }
            return set.size() == 0;
        }
    }


    // not very sure why, needs to revisit
    // 110 / 110 test cases passed.
    // 29 ms
    public class Solution2 {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            if(seqs.size() == 0) return false;
            int[] pos = new int[org.length+1];
            for(int i=0;i<org.length;++i) pos[org[i]] = i;
            boolean[] flags = new boolean[org.length+1];
            int toMatch = org.length-1;
            boolean flag = false;
            for(List<Integer> v : seqs) {
                for(int i=0;i<v.size();++i) {
                    flag = true;
                    if(v.get(i)<=0 || v.get(i) > org.length)return false;
                    if(i==0)continue;
                    int x = v.get(i-1), y = v.get(i);
                    if(pos[x] >= pos[y])return false;
                    if(flags[x] == false && pos[x]+1 == pos[y]) {
                        flags[x] = true;
                        --toMatch;
                    }
                }
            }
            return toMatch == 0 && flag;
        }
    }
}
