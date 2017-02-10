package amaon;

import LinkedIn.TreeNode;

import java.util.Stack;

/**
 * Created by junm5 on 2/10/17.
 */
public class RecoveryTree {
    public void recoverTree(TreeNode root) {
        //inorder traversal
        Stack<TreeNode> stack = new Stack();
        TreeNode first = null, second = null, cur = root;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            // Start of "do some business",
            // If first element has not been found, assign it to prevous node (refer to 6 in the example above)
            if (first == null && pre.val >= node.val) {
                first = pre;
            }

            // If first element is found, assign the second element to the root (refer to 2 in the example above)
            if (first != null && pre.val >= node.val) {
                second = node;
            }
            pre = node;
            cur = node.right;
        }
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    public static void main(String [] args){
        RecoveryTree recoveryTree = new RecoveryTree();
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(1);
        root.right = right;
        recoveryTree.recoverTree(root);
        System.out.println(root.val);
    }
}
