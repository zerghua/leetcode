package leetcode;
import java.util.*;
/**
 * Created by Hua on 6/18/2016.
 *
 Clone an undirected graph. Each node in the graph contains a label and
 a list of its neighbors.

 OJ's undirected graph serialization:

 Nodes are labeled uniquely.
 We use # as a separator for each node, and , as a separator for
 node label and each neighbor of the node.

 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains
 three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself),
 thus forming a self-cycle.

 Visually, the graph looks like the following:

    1
   / \
  /   \
 0 --- 2
      / \
      \_/


 */
public class N133_CloneGraph {
    // Google, Facebook
     class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;

         UndirectedGraphNode(int x) {
             label = x;
             neighbors = new ArrayList<UndirectedGraphNode>();
         }
     }


    // BFS
    // use map to store mapping of old node and new node, or will have duplicate
    // 10 ms
    class BFS {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if(node == null) return null;
            LinkedList<UndirectedGraphNode> list = new LinkedList<>();
            HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            list.add(node);
            map.put(node, newNode);
            while(!list.isEmpty()){
                UndirectedGraphNode curNode = list.remove();
                // copy curNode's neighbors, already has a copy of curNode
                for(UndirectedGraphNode neighborNode: curNode.neighbors){
                    if(map.containsKey(neighborNode)){
                        map.get(curNode).neighbors.add(map.get(neighborNode));
                    }else{
                        UndirectedGraphNode newNeighborNode =
                                new UndirectedGraphNode(neighborNode.label);
                        map.get(curNode).neighbors.add(newNeighborNode);
                        map.put(neighborNode, newNeighborNode);
                        list.add(neighborNode);
                    }
                }
            }
            return newNode;
        }
    }


    // DFS
    // 4 ms
    // copy itself and copy its neighbors, use hashmap to store {new_node_label, new_node}
    // and return new_node if encountered to avoid duplicate. recursively add its neighbors.
    class DFS{
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if(node == null) return null;
            return dfs(node, new HashMap<>());
        }
        public UndirectedGraphNode dfs(UndirectedGraphNode node,
                                       HashMap<Integer,UndirectedGraphNode> map){
            if(map.containsKey(node.label)) return map.get(node.label); // return copy of node

            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(newNode.label, newNode);
            for(UndirectedGraphNode neighbor: node.neighbors){
                newNode.neighbors.add(dfs(neighbor, map));
            }
            return newNode;
        }
    }

    // added on 10/8/2016
    // map<node, new_node> instead of map<new_node_label, new_node>
    // 8 ms 12 / 12 test cases passed.
    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if(node == null) return null;
            return dfs(node, new HashMap());
        }

        public UndirectedGraphNode dfs(UndirectedGraphNode node,
                                       HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
            if(map.containsKey(node)) return map.get(node);
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
            for(UndirectedGraphNode n: node.neighbors){
                newNode.neighbors.add(dfs(n, map));
            }
            return newNode;
        }
    }
}
