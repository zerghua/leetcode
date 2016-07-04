package leetcode;

import java.util.*;

/**
 * Created by Hua on 6/4/2016.

 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have
 to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs,
 is it possible for you to finish all courses?

 For example:

 2, [[1,0]]

 There are a total of 2 courses to take. To take course 1 you should have
 finished course 0. So it is possible.

 2, [[1,0],[0,1]]

 There are a total of 2 courses to take. To take course 1 you should have
 finished course 0, and to take course 0 you should also have finished course 1.
 So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges,
 not adjacency matrices. Read more about how a graph is represented.

 click to show more hints.
 Hints:

 1.This problem is equivalent to finding if a cycle exists in a directed graph.
 If a cycle exists, no topological ordering exists and therefore it will be
 impossible to take all courses.

 2.Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 explaining the basic concepts of Topological Sort.

 3.Topological sort could also be done via BFS.



 */
public class N207_CourseSchedule {
    // https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
    // 25 ms DFS, record visited node. need convert input to Adjacency list
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return true;

        // convert input to create adjacency list in HashMap
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] pair: prerequisites){
            if(map.containsKey(pair[0])) map.get(pair[0]).add(pair[1]);
            else map.put(pair[0], new HashSet<>(Arrays.asList(pair[1])));
        }

        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!canFinishDFS(map, visited, i)) return false;
        }
        return true;
    }

    // visited = 1, visiting= -1
    private boolean canFinishDFS(HashMap<Integer, HashSet<Integer>> map,
                                 int[] visited, int i) {
        if(visited[i] == -1) return false;
        if(visited[i] == 1) return true;

        visited[i] = -1;
        if(map.containsKey(i)){
            for(int adjacent_node: map.get(i)){
                if(!canFinishDFS(map, visited, adjacent_node)) return false;
            }
        }
        visited[i] = 1;
        return true;
    }
}
