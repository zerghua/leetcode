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

 Don't use Array.hashcode, because it might have collision in the range of int, below is the source code.
 public static int hashCode(int a[]) {
     if (a == null)
     return 0;

     int result = 1;
     for (int element : a)
     result = 31 * result + element;

     return result;
 }


 */
public class N49_GroupAnagrams {
    // Amazon, Facebook, Google
    // added on 11/30/2016
    // o(n), counting sort to construct new string instead of sort.
    // 28 ms 100 / 100 test cases passed.
    public class Solution9 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str: strs){

                char[] a = new char[26];
                for(char c: str.toCharArray()) a[c-'a']++;
                String key = new String(a);             // trick here, rearrange string in sorted order in o(n) time

                if(!map.containsKey(key)){
                    map.put(key, new ArrayList());
                }
                map.get(key).add(str);
            }
            List<List<String>> ret = new ArrayList<>();
            ret.addAll(map.values());
            return ret;
        }
    }


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
    // I think this is OK, just OJ is crazy sometime.
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
                int key = Arrays.hashCode(a);  // has to be this. map.hashCode() won't work //or can convert a[] to string, kind of sorted it, but o(n) time

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

    // added on 10/14/2016
    // convert char[] to string, using String(char[]) constructor
    // assume all input are lower-case english chars.
    // 31 ms 100 / 100 test cases passed.
    public class Solution5 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ret = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str: strs){
                char[] a = new char[26];
                for(char c: str.toCharArray()) a[c-'a']++;
                String key = new String(a);

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

    // added on 10/27/2016
    // 33 ms 100 / 100 test cases passed.
    public class Solution6 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ret = new ArrayList<>();
            HashMap<Integer, List<String>> map = new HashMap<>();
            for(String str: strs){
                int[] a = new int[128];
                for(char c: str.toCharArray()) a[c]++;
                int key = Arrays.hashCode(a);

                if(!map.containsKey(key)){
                    ArrayList<String> list = new ArrayList();
                    ret.add(list);
                    map.put(key, list);
                }
                map.get(key).add(str);
            }
            return ret;
        }
    }

    // added on 10/27/2016
    // 33 ms 100 / 100 test cases passed.
    public class Solution7 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<Integer, List<String>> map = new HashMap<>();
            for(String str: strs){
                int[] a = new int[128];
                for(char c: str.toCharArray()) a[c]++;
                int key = Arrays.hashCode(a);

                if(!map.containsKey(key)){
                    map.put(key, new ArrayList());
                }
                map.get(key).add(str);
            }
            List<List<String>> ret = new ArrayList<>();
            ret.addAll(map.values());
            return ret;
        }
    }

    // added on 11/30/2016
    // should not use Arrays.hashCode will might have a collision.
    // o(n) + o(nlogk)
    // 33 ms 100 / 100 test cases passed.
    public class Solution8 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str: strs){
                char[] a = str.toCharArray();
                Arrays.sort(a);
                String key = new String(a);
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList());
                }
                map.get(key).add(str);
            }
            List<List<String>> ret = new ArrayList<>();
            ret.addAll(map.values());
            return ret;
        }
    }


}
