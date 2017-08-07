package leetcode;
import leetcode.N0_data_strcture.*;
import java.util.*;
/**
 * Created by Hua on 4/25/2016.
 *
 *  Two elements of a binary search tree (BST) are swapped by mistake.

 *  Recover the tree without changing its structure.
 */
    //[146,71,-13,55,null,231,399,321,null,null,null,null,null,-33]
    //[146,71,321,55,null,231,399,-13,null,null,null,null,null,-33]
public class N99_RecoverBinarySearchTree {
    // no company
    //9 ms
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        recoverTree(root,list);
        ArrayList<TreeNode> ret = new ArrayList<>();

        if(list.get(0).val > list.get(1).val) ret.add(list.get(0));
        for(int i=1; i<list.size()-1;i++){
            int val_i = list.get(i).val;
            int val_pre_i = list.get(i-1).val;
            int val_post_i = list.get(i+1).val;
            if( (val_i > val_pre_i && val_i > val_post_i) ||
                    (val_i < val_pre_i && val_i < val_post_i)){
                ret.add(list.get(i));
            }
        }
        if(list.get(list.size()-1).val < list.get(list.size()-2).val)
            ret.add(list.get(list.size()-1));

        // swap them back
        int tmp = ret.get(0).val;
        ret.get(0).val = ret.get(ret.size()-1).val;
        ret.get(ret.size()-1).val = tmp;
    }

    //in order traversal
    public void recoverTree(TreeNode root, ArrayList<TreeNode> list) {
        if(root == null) return;
        recoverTree(root.left, list);
        list.add(root);
        recoverTree(root.right, list);
    }


    //15 ms
    public void recoverTree2(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>();
        recoverTree2(root, list,vals);
        Collections.sort(vals);
        for(int i=0; i<list.size();i++){
            list.get(i).val = vals.get(i);
        }
    }

    public void recoverTree2(TreeNode root, ArrayList<TreeNode> list,ArrayList<Integer> vals) {
        if(root == null) return;
        recoverTree2(root.left, list,vals);
        list.add(root);
        vals.add(root.val);
        recoverTree2(root.right, list,vals);
    }


    //6 ms
    TreeNode preNode =null;
    public void recoverTree3(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inorderTraversal(root, list);
        int tmp = list.get(0).val;
        list.get(0).val = list.get(list.size()-1).val;
        list.get(list.size()-1).val = tmp;
    }

    public void inorderTraversal(TreeNode root,ArrayList<TreeNode> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        if(preNode != null) {
            if(preNode.val > root.val) {
                if(list.size() == 0) list.add(preNode);
                list.add(root);
            }
        }
        preNode = root;
        inorderTraversal(root.right, list);
    }


    //Morris Traversal o(1) space...
}
