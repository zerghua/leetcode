package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Hua on 6/3/2016.

 One way to serialize a binary tree is to use pre-order traversal.
 When we encounter a non-null node, we record the node's value.
 If it is a null node, we record using a sentinel value such as #.

       _9_
      /   \
     3     2
    / \   / \
   4   1  #  6
  / \ / \   / \
 # # # #   #  #

 For example, the above binary tree can be serialized to the string
 "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

 Given a string of comma separated values, verify whether it is a correct
 preorder traversal serialization of a binary tree. Find an algorithm without
 reconstructing the tree.

 Each comma separated value in the string must be either an integer or
 a character '#' representing null pointer.

 You may assume that the input format is always valid,
 for example it could never contain two consecutive commas such as "1,,3".

 Example 1:
 "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Return true

 Example 2:
 "1,#"
 Return false

 Example 3:
 "9,#,#,1"
 Return false

 */
public class N331_VerifyPreorderSerializationofaBinaryTree {
    // Google
    // stack
    // 20 ms
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        ArrayList<String> list = new ArrayList<>();
        for(String s: arr){
            list.add(s);
            while(list.size() >=3 &&
                    list.get(list.size()-1).equals("#") &&
                    list.get(list.size()-2).equals("#") &&
                    !list.get(list.size()-3).equals("#")){
                list.remove(list.size()-1);
                list.remove(list.size()-1);
                list.remove(list.size()-1);
                list.add("#");
            }
        }
        if(list.size() == 1 && list.get(0).equals("#")) return true;
        return false;
    }

    //https://leetcode.com/discuss/83824/7-lines-easy-java-solution
    /*
    Some used stack. Some used the depth of a stack.
    Here I use a different perspective. In a binary tree,
    if we consider null as leaves, then all non-null node provides
    2 outdegree and 1 indegree (2 children and 1 parent), except root
    all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

    Suppose we try to build this tree. During building, we record the
    difference between out degree and in degree
    diff = outdegree - indegree.

    When the next node comes, we then decrease diff by 1, because the node
    provides an in degree. If the node is not null, we increase diff by 2,
    because it provides two out degrees. If a serialization is correct,
    diff should never be negative and diff will be zero when finished.

     */
    // if it's correct
    // the number of # = the number of digit + 1
    // meaning,  null leaves = non-leaves + 1
    // 12 ms
    public boolean isValidSerialization2(String preorder) {
        String[] arr = preorder.split(",");
        int count = 1;
        for(String s: arr){
            if(--count <0) return false;
            if(!s.equals("#")) count+=2;
        }
        return count == 0;
    }

}
