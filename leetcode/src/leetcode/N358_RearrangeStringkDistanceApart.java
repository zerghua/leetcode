package leetcode;

/**
 * Created by Hua on 7/28/2017.

 Given a non-empty string s and an integer k, rearrange the string
 such that the same characters are at least distance k from each other.

 All input strings are given in lowercase letters.
 If it is not possible to rearrange the string, return an empty string "".

 Example 1:

 s = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.

 Example 2:

 s = "aaabc", k = 3

 Answer: ""

 It is not possible to rearrange the string.

 Example 3:

 s = "aaadbbcc", k = 2

 Answer: "abacabcd"

 Another possible answer is: "abcabcda"

 The same letters are at least distance 2 from each other.

 Test case:

 Input:
 "abb"
 2
 Expected:"bab"


 Input:
 "aaabc"
 2
 Expected:"abaca"


 */

import java.util.*;
public class N358_RearrangeStringkDistanceApart {
    // google
    // hashmap + heap + greedy
    // 57 / 57 test cases passed.
    // 155 ms
    public class Solution {
        private class Node{
            char c;
            int count;
            Node(char c, int count){
                this.c = c;
                this.count = count;
            }
        }

        public String rearrangeString(String s, int k) {
            if(s.length() <= 1 || k <= 0) return s;
            HashMap<Character, Integer> map = new HashMap();
            for(char c : s.toCharArray()){
                if(!map.containsKey(c)) map.put(c, 0);
                map.put(c, map.get(c) + 1);
            }

            PriorityQueue<Node> heap = new PriorityQueue<Node>((a,b) -> b.count != a.count? b.count - a.count : a.c - b.c);
            for(char c: map.keySet()) heap.add(new Node(c, map.get(c)));

            StringBuilder ret = new StringBuilder();
            while(!heap.isEmpty()){
                if(heap.size() < k && heap.peek().count > 1) return ""; // means next round will be invalid
                LinkedList<Node> list = new LinkedList();
                int size = heap.size();
                for(int i=0; i<Math.min(k, size); i++){
                    Node node = heap.remove();
                    ret.append(node.c);
                    node.count--;
                    if(node.count != 0) list.add(node);
                }
                heap.addAll(list);
            }
            return ret.toString();
        }
    }
}
