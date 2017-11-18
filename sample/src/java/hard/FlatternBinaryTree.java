package hard;

import LinkedIn.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * Created by junm5 on 9/29/17.
 */
public class FlatternBinaryTree {
    //root, left, right
    public void flatten(TreeNode root) {
        flattener(root);
    }
    private TreeNode flattener(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = flattener(root.left);
        TreeNode right = flattener(root.right);
        if(left != null){
            root.right = left;
            root.right.right = right;
            root.left = null;
        }
        return root;
    }

    public static void main(String[] args){
        int[] a = {1, 2};
        a[0]--;
        System.out.println(a[0]);
    }
}
