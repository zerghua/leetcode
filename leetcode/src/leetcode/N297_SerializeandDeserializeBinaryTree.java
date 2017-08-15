package leetcode;
import leetcode.N0_data_strcture.*;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.LinkedList;

/**
 * Created by Hua on 7/31/2016.
 Serialization is the process of converting a data structure or object
 into a sequence of bits so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later
 in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree.
 There is no restriction on how your serialization/deserialization
 algorithm should work. You just need to ensure that a binary tree can be
 serialized to a string and this string can be deserialized to
 the original tree structure.

 For example, you may serialize the following tree

     1
    / \
   2   3
  / \
 4   5

 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 You do not necessarily need to follow this format,
 so please be creative and come up with different approaches yourself.

 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.

 */
public class N297_SerializeandDeserializeBinaryTree {
    // Google, Amazon, Facebook, Microsoft
    // 24 ms
    // preoder tree traversal and rebuild it.
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialize(root,new StringBuilder()).toString();
        }

        public StringBuilder serialize(TreeNode node, StringBuilder sb){
            if(node == null) return sb.append("null,");
            sb.append(node.val).append(",");
            serialize(node.left, sb);
            serialize(node.right,sb);
            return sb;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(list);
        }

        public TreeNode deserialize(LinkedList<String> list){
            if(list == null || list.isEmpty()) throw new IllegalArgumentException(""); // defensive programming
            String cur = list.removeFirst();
            if(cur.equals("null")) return null;

            TreeNode node = new TreeNode(Integer.valueOf(cur));
            node.left = deserialize(list);
            node.right = deserialize(list);
            return node;
        }
    }


    // below is wrong
    // use level order traversal
    // OJ has test cases like, [5,2,3,null,null,2,4,3,1]
    // which will break the code assumption of left=2*i+1, right=2*i+2.
    public class Codec2 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder ret = new StringBuilder();
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            while(!list.isEmpty()){
                TreeNode tmp = list.removeFirst();
                if(tmp != null){
                    ret.append(tmp.val);
                    list.add(tmp.left);
                    list.add(tmp.right);
                }else ret.append("null");
                ret.append(",");
            }
            return ret.substring(0, ret.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            return deserializeHelper(arr, 0);
        }

        public TreeNode deserializeHelper(String[] arr, int i){
            if(i >= arr.length || arr[i].equals("null")) return null;
            TreeNode node = new TreeNode(Integer.valueOf(arr[i]));
            node.left = deserializeHelper(arr, 2*i + 1);
            node.right = deserializeHelper(arr, 2*i + 2);
            return node;
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
