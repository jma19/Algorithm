package com.uci.mj;

import LinkedIn.TreeNode;

import java.util.Stack;

/**
 * Created by junm5 on 11/26/16.
 */
public class PreOrder {
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;

            }
        }
    }
}
