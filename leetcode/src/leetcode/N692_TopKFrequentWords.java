package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/16/2017.

 Given a non-empty list of words, return the k most frequent elements.

 Your answer should be sorted by frequency from highest to lowest.
 If two words have the same frequency, then the word with the lower alphabetical order comes first.

 Example 1:

 Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 Output: ["i", "love"]
 Explanation: "i" and "love" are the two most frequent words.
 Note that "i" comes before "love" due to a lower alphabetical order.

 Example 2:

 Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 Output: ["the", "is", "sunny", "day"]
 Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 with the number of occurrence being 4, 3, 2 and 1 respectively.

 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Input words contain only lowercase letters.

 Follow up:

 Try to solve it in O(n log k) time and O(n) extra space.
 Can you solve it in O(n) time with only O(k) extra space?


 */
public class N692_TopKFrequentWords {
    // similar to N347_TopKFrequentElements
    // my solution
    // hashmap + priority queue
    // klogn time, some micro optimization which keeps k sized heap rather than n size heap.
    // 110 / 110 test cases passed.
    // 93 ms
    class Solution {
        class Node{
            String word;
            int count;
            Node(String word, int count){
                this.word = word;
                this.count = count;
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap();
            for(String word: words){
                if(!map.containsKey(word)) map.put(word, 0);
                map.put(word, map.get(word) + 1);
            }
            PriorityQueue<Node> heap = new PriorityQueue<Node>
                    ((a,b) -> a.count != b.count ? b.count - a.count : a.word.compareTo(b.word));

            for(String word : map.keySet()) heap.add(new Node(word, map.get(word)));

            List<String> ret = new LinkedList();
            for(int i=0; i<k;i++) ret.add(heap.remove().word);
            return ret;
        }
    }


    // o(n) time solution, use bucket sort, but also needs to sort each bucket or use trie?

}
