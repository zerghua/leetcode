package leetcode;
import java.util.HashMap;

/**
 * Created by Hua on 5/15/2016.
 *
 *
 *  Design and implement a data structure for Least Recently Used (LRU) cache.
 *  It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key
 if the key exists in the cache, otherwise return -1.

 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently
 used item before inserting a new item.

 */

// 19 ms
// double linked list and hashmap to store nodes
public class N146_LRUCache {
    class Node{
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key, int val){
            this.key=key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    int capcity;
    HashMap<Integer, Node> hm = new HashMap<>();
    Node head_node = null;
    Node end_node = null;

    public N146_LRUCache(int capacity) {
        this.capcity = capacity;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            Node ret = hm.get(key);
            removeNode(ret);
            setHeadNode(ret);
            return ret.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(hm.containsKey(key)){
            Node n = hm.get(key);
            n.val = value;
            removeNode(n);
            setHeadNode(n);
        }
        else{
            Node newNode = new Node(key, value);
            if(hm.size() >= this.capcity){
                hm.remove(end_node.key);
                removeNode(end_node);
            }

            hm.put(key, newNode);
            setHeadNode(newNode);
        }
    }


    // double-linked list, need to handle both ways
    private void setHeadNode(Node n) {
        n.pre = null;
        n.next = head_node;
        if(head_node != null) head_node.pre = n;
        if(end_node == null) end_node = n;       //to handle first node case
        head_node = n;
    }


    private void removeNode(Node n) {
        if(n.pre == null) head_node = n.next;  //n is head, should set head_node.pre=null?
        else n.pre.next = n.next;

        if(n.next == null) end_node = n.pre;   // n is the last node
        else n.next.pre = n.pre;
    }
}
