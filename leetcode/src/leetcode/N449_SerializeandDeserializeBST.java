package leetcode;

/**
 * Created by Hua on 5/19/2017.

 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on
 how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree
 can be serialized to a string and this string can be deserialized to the original tree structure.

 The encoded string should be as compact as possible.

 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.

 */

import leetcode.N0_data_strcture.*;

import java.util.Arrays;
import java.util.LinkedList;

public class N449_SerializeandDeserializeBST {
    // the same as N297_SerializeandDeserializeBinaryTree
    // 62 / 62 test cases passed.
    // 28 ms
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialize(root, new StringBuilder()).toString();
        }

        public StringBuilder serialize(TreeNode root, StringBuilder sb){
            if(root == null) return sb.append("null,");
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
            return sb;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList(Arrays.asList(data.split(",")));
            return deserialize(list);
        }

        public TreeNode deserialize(LinkedList<String> list){
            String cur = list.removeFirst();
            if(cur.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(cur));
            root.left = deserialize(list);
            root.right = deserialize(list);
            return root;
        }
    }
}
