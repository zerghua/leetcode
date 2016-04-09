package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/9/2016.
 */

//remember how to iterate hashmap
public class N187_RepeatedDNASequences {
    //53 ms  o(n) time,
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new LinkedList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String sequence = s.substring(i,i+10);
            if(hm.containsKey(sequence))hm.put(sequence, hm.get(sequence)+1);
            else hm.put(sequence, 1);
        }

        for(Map.Entry<String, Integer> e: hm.entrySet()){
            if(e.getValue() >1) ret.add(e.getKey());
        }
        return ret;
    }
}
