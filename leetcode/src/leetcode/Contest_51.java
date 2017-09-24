package leetcode;
import java.util.*;

/**
 * Created by HuaZ on 9/23/2017.
 Rank	    Name	Score	 Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	    Q4 (9)
 821 / 2879	zerghua	    9	 1:11:23	   0:21:23 1	0:56:23 2


 */
public class Contest_51 {
    // stack
    class Solution {
        public int calPoints(String[] ops) {
            int sum = 0;
            Stack<Integer> stack = new Stack();
            for(String s : ops){
                if(s.equals("+")){ // maybe bug if not has two items
                    int last = stack.pop();
                    int ret = last + stack.peek();
                    sum += ret;
                    stack.push(last);
                    stack.push(ret);
                }else if(s.equals("C")){
                    int last = stack.pop();
                    sum -= last;
                }else if(s.equals("D")){
                    int last = stack.peek() * 2;
                    sum += last;
                    stack.push(last);
                }else{ // integer
                    int i = Integer.parseInt(s);
                    sum += i;
                    stack.push(i);
                }
            }
            return sum;
        }
    }


    // greedy? string?
    class Solution2 {
        public String nextClosestTime(String time) {
            String[] str = time.split(":");
            String hour = str[0];  //  should less than 24
            String min = str[1];    //  should less than 60
            HashSet<Integer> set = new HashSet();
            int small = 9;
            for(int i=0; i<=4; i++){
                if(i == 2) continue;
                int num = time.charAt(i) - '0';
                small = Math.min(small, num);
                set.add(num);
            }

            for(int i=4; i>=0; i--){
                if(i == 2) continue;
                if(i>2){ // mins, a bug fix last digit as well
                    for(int num : set){
                        if(num > time.charAt(i) - '0'){
                            StringBuilder tmp = new StringBuilder(min);
                            tmp.setCharAt(i-3, (char)(num + '0'));
                            if(Integer.parseInt(tmp.toString()) < 60) {
                                if(i == 4) return hour +":" + tmp.toString();
                                return hour +":" + (char)(num + '0') + "" + small;
                            }
                        }
                    }
                }else{  // hours, a bug fix min as well
                    for(int num : set){
                        if(num > time.charAt(i) - '0'){
                            StringBuilder tmp = new StringBuilder(hour);
                            tmp.setCharAt(i, (char)(num + '0'));
                            if(Integer.parseInt(tmp.toString()) < 24) return tmp.toString() +":" + small + "" + small;
                        }
                    }
                }
            }

            return small + "" + small + ":" + small + "" + small;
        }
    }


    // graph?
    // not binary tree, tree can has multiple children
    // not cycle
    /*
    Input:[[2,3],[5,2],[1,5],[4,2],[4,1]]
    Expected:[4,1]

     */
    // union find
    class Solution3 {
        public int[] findRedundantConnection(int[][] edges) {
            HashMap<Integer, List<Integer>> map = new HashMap();
            HashSet<Integer> parentSet = new HashSet();
            int[] ret = null;
            for(int[] a : edges){
                int parent = a[0], child = a[1];
                if(parentSet.contains(child)) ret= a;  // this child has a parent already
                parentSet.add(child);

                if(!map.containsKey(parent)) map.put(parent, new LinkedList());
                map.get(parent).add(child);
                if(map.get(parent).size() > 2) ret = a;  // not
            }

            return ret == null ? edges[edges.length-1] : ret;
        }
    }

}
