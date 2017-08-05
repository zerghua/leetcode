package leetcode;

/**
 * Created by HuaZ on 8/4/2017.

 已知一个List里全是interger, 还有一个set里也全是integer,求是否存在一个sublist,
 set里所有元素和sublist中所有元素一一对应。
 [sublist 这里要求必须为原List的连续项， 注意set里元素无序]

 */
import java.util.*;
public class Z1_SublistInSet {
    // sliding window
    class Solution{
        public boolean isSublistInSet(List<Integer> list, HashSet<Integer> set){
            HashMap<Integer, Integer> map = new HashMap();
            int i=0;
            for(int j=0; j< list.size(); j++){
                int num = list.get(j);
                if(!set.contains(num)) continue;
                if(!map.containsKey(num)) map.put(num, 0);
                map.put(num, map.get(num)+1);
                while(map.size() == set.size()){
                    if(j - i + 1== set.size()) return true;
                    // move left
                    int left = list.get(i++);
                    if(map.containsKey(left)){
                        map.put(left, map.get(left) -1);
                        if(map.get(left) == 0) map.remove(left);
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] str){
        Z1_SublistInSet.Solution s = new Z1_SublistInSet().new Solution();
        System.out.println(s.isSublistInSet(new ArrayList(Arrays.asList(1,2,3)),
                new HashSet(Arrays.asList(1,2))));

        System.out.println(s.isSublistInSet(new ArrayList(Arrays.asList(1,3,2)),
                new HashSet(Arrays.asList(1,2))));

        System.out.println(s.isSublistInSet(new ArrayList(Arrays.asList(3,2,1)),
                new HashSet(Arrays.asList(1,2))));

        System.out.println(s.isSublistInSet(new ArrayList(Arrays.asList(1,1,3,2,3,1)),
                new HashSet(Arrays.asList(1,2))));

        System.out.println(s.isSublistInSet(new ArrayList(Arrays.asList(3,2,2,3,1,2)),
                new HashSet(Arrays.asList(1,2))));

    }
}
