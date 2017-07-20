package leetcode;

/**
 * Created by Hua on 7/20/2017.


 This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words
 and your method will be called repeatedly many times with different parameters. How would you optimize it?

 Design a class which receives a list of words in the constructor, and implements a method that
 takes two words word1 and word2 and return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */

import java.util.*;
public class N244_ShortestWordDistanceII {
    // hashmap + treemap solution
    // 12 / 12 test cases passed.
    // 205 ms
    public class WordDistance {
        HashMap<String, TreeSet<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap();
            for(int i=0; i<words.length; i++){
                if(!map.containsKey(words[i])) map.put(words[i], new TreeSet());
                map.get(words[i]).add(i);
            }

        }

        public int shortest(String word1, String word2) {
            int ret = Integer.MAX_VALUE;
            TreeSet<Integer> set = map.get(word2);
            for(int i : map.get(word1)){
                if(set.floor(i) != null) ret = Math.min(ret, Math.abs(i - set.floor(i)));
                if(set.ceiling(i) != null) ret = Math.min(ret, Math.abs(i - set.ceiling(i)));
            }
            return ret;
        }
    }


    // hashmap + two pointers
    // 12 / 12 test cases passed.
    // 146 ms
    public class WordDistance2 {
        HashMap<String, ArrayList<Integer>> map;

        public WordDistance2(String[] words) {
            map = new HashMap();
            for(int i=0; i<words.length; i++){
                if(!map.containsKey(words[i])) map.put(words[i], new ArrayList());
                map.get(words[i]).add(i);
            }

        }

        public int shortest(String word1, String word2) {
            int ret = Integer.MAX_VALUE;
            ArrayList<Integer> l1 = map.get(word1);
            ArrayList<Integer> l2 = map.get(word2);

            for(int i=0, j=0; i<l1.size() && j<l2.size(); ){
                int index1 = l1.get(i), index2 = l2.get(j);
                if(index1 < index2){
                    ret = Math.min(ret, index2 - index1);
                    i++;
                }else{
                    ret = Math.min(ret, index1 - index2);
                    j++;
                }
            }
            return ret;
        }
    }

}

