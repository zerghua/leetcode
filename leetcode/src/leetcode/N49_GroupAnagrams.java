package leetcode;

import java.util.*;

/**
 * Created by Hua on 4/4/2016.
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
}
