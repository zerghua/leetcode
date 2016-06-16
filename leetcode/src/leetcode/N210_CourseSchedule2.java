package leetcode;

import java.util.*;

/**
 * Created by Hua on 6/15/2016.
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to
 first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the
 ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them.
 If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]

 There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]

 There are a total of 4 courses to take. To take course 3 you should have finished
 both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

 */
public class N210_CourseSchedule2 {
    int[] ret;
    int index;
    // 24 ms
    // there is also a BFS solution, can take a look
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ret = new int[numCourses];
        index = numCourses - 1;
        if(numCourses == 0 || prerequisites.length == 0) {
            for(int i=0;i<numCourses;i++) ret[i] = i;
            return ret;
        }

        // convert input to create adjacency list in HashMap
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] pair: prerequisites){
            if(map.containsKey(pair[1])) map.get(pair[1]).add(pair[0]);
            else map.put(pair[1], new HashSet<>(Arrays.asList(pair[0])));
        }

        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!canFinishDFS(map, visited, i)) return new int[0];
        }
        return ret;
    }

    // visited = 1, currently visiting= -1
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
        ret[index--] = i;
        return true;
    }
}
