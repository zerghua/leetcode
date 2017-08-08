package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Hua on 5/22/2017.

 Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number
 (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 where equations.size() == values.size(), and the values are positive. This represents the equations.
 Return vector<double>.


 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

 The input is always valid.
 You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


 */
public class N399_EvaluateDivision {
    // Google
    // graph, DFS + backtracking + hashmap + hashset.
    // non-trivial
    // 11 / 11 test cases passed.
    // 5 ms
    public class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            // put into map
            HashMap<String, HashMap<String, Double>> map = new HashMap();
            for(int i=0; i<values.length; i++){
                AddToMap(equations[i][0], equations[i][1], values[i], map);
                AddToMap(equations[i][1], equations[i][0], 1.0 / values[i], map);
            }

            // handle queries, DFS + backtracking
            double[] ret = new double[queries.length];
            for(int i=0; i<queries.length; i++){
                ret[i] = dfs(queries[i][0], queries[i][1], map, new HashSet<String>());
            }
            return ret;
        }

        public void AddToMap(String a, String b, double val, HashMap<String, HashMap<String, Double>> map){
            if(!map.containsKey(a)) map.put(a, new HashMap());
            map.get(a).put(b, val);
        }

        public Double dfs(String a, String b, HashMap<String, HashMap<String, Double>> map, HashSet<String> set){
            String key = a + ":" + b;
            if(set.contains(key) || !map.containsKey(a) || !map.containsKey(b)) return -1.0;
            if(a.equals(b)) return 1.0;

            set.add(key);

            for(String a_neighbour : map.get(a).keySet()){
                double ret = dfs(a_neighbour, b, map, set);
                if(ret != -1.0) return ret *  map.get(a).get(a_neighbour);
            }

            set.remove(key);
            return -1.0;
        }
    }
}
