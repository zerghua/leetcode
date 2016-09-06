package leetcode;

import java.util.*;

/**
 * Created by Hua on 4/4/2016.

 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
 ]

 Note: All inputs will be in lower-case.


 */
public class N49_GroupAnagrams {
    //29 ms, sort, hashtable, look at how to list hashtable
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        HashMap<String, LinkedList<String>> hm = new HashMap<>();
        for(String s: strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String tmp_str = new String(tmp);

            if(hm.containsKey(tmp_str)){
                hm.get(tmp_str).add(s);
            }else{
                LinkedList<String> list = new LinkedList<>();
                list.add(s);
                hm.put(tmp_str, list);
            }
        }

        //list hashmap and sorted each list
        for(LinkedList<String> l: hm.values()){
            Collections.sort(l);
            ret.add(l);
        }

        return ret;
    }


    // TLE caused by  ret.addAll(map.values()) ???
    public class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ret = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str: strs){
                char[] tmp = str.toCharArray();
                Arrays.sort(tmp);
                String sorted_str = new String(tmp);
                if(map.containsKey(sorted_str)){
                    map.get(sorted_str).add(str);
                }else{
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
                    map.put(sorted_str, list);
                }
            }

            ret.addAll(map.values());   // this will cause TLE!!!
            return ret;
        }
    }




    // version 3 added on 9/6/2016
    // 26 ms   100 / 100 test cases passed.
    // sort + hashmap
    public class Solution3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ret = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str: strs){
                char[] tmp = str.toCharArray();
                Arrays.sort(tmp);
                String sorted_str = new String(tmp);
                if(map.containsKey(sorted_str)){
                    map.get(sorted_str).add(str);
                }else{
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
                    map.put(sorted_str, list);
                    ret.add(list);
                }
            }
            return ret;
        }
    }

    // only hashmap, use hashcode of array as key
    // 24 ms   100 / 100 test cases passed.
    public class Solution4 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ret = new ArrayList<>();
            HashMap<Integer, List<String>> map = new HashMap<>();
            for(String str: strs){
                int[] a = new int[128];
                for(char c: str.toCharArray()) a[c]++;
                int key = Arrays.hashCode(a);  // has to be this. map.hashCode() won't work

                if(map.containsKey(key)){
                    map.get(key).add(str);
                }else{
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
                    map.put(key, list);
                    ret.add(list);
                }
            }
            return ret;
        }
    }


}
