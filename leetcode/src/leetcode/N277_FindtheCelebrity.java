package leetcode;

/**
 * Created by Hua on 7/20/2017.

 Suppose you are at a party with n people (labeled from 0 to n - 1) and among them,
 there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people
 know him/her but he/she does not know any of them.

 Now you want to find out who the celebrity is or verify that there is not one.
 The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of
 whether A knows B. You need to find out the celebrity (or verify there is not one) by asking
 as few questions as possible (in the asymptotic sense).

 You are given a helper function bool knows(a, b) which tells you whether A knows B.
 Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

 Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label
 if there is a celebrity in the party. If there is no celebrity, return -1.


 Test cases:
 Input:
 0 does not know 1;
 1 does not know 0.
 Expected:-1


 Input:
 0 does not know 1, 0 knows 2;
 1 knows 0,         1 does not know 2;
 2 does not know 0, 2 knows 1.

 Expected:-1


 https://discuss.leetcode.com/category/347/find-the-celebrity

 */

import java.util.*;
public class N277_FindtheCelebrity {
    public class Relation{
        boolean knows(int a, int b){return true;}
    }
    // Facebook, Linkedin
    // 171 / 171 test cases passed.
    // 20 ms
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n <= 1) return -1;
            ArrayList<Integer> candidates = new ArrayList();
            for(int i=1; i<n;i++){
                if(knows(0,i)) candidates.add(i);
            }
            if(candidates.size() == 0) candidates.add(0);

            for(int candidate: candidates){
                boolean isCelebrity = true;
                for(int i=0; i<n; i++){
                    if(candidate == i) continue;
                    if(knows(candidate, i) || !knows(i, candidate)) { // if candidate knows anyone or anyone does not know candidate
                        isCelebrity = false;
                        break;
                    }
                }
                if(isCelebrity) return candidate;
            }
            return -1;
        }
    }

    // another solution, might need to prove.
    /*
    The first loop is to find the candidate as the author explains. In detail,
    suppose the candidate after the first for loop is person k, it means 0 to k-1 cannot be the celebrity,
    because they know a previous or current candidate.
    Also, since k knows no one between k+1 and n-1, k+1 to n-1 can not be the celebrity either.
    Therefore, k is the only possible celebrity, if there exists one.
    The remaining job is to check if k indeed does not know any other persons and all other persons know k.
     */

    // 171 / 171 test cases passed.
    // 12 ms
    public class Solution2 extends Relation {
        public int findCelebrity(int n) {
            int candidate = 0;
            for(int i = 1; i < n; i++){
                if(knows(candidate, i)) candidate = i;
            }

            for(int i = 0; i < n; i++){
                if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
            }
            return candidate;
        }
    }


}
