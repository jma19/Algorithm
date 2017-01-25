package com.uci.mj;

import LinkedIn.TreeNode;

import java.util.Stack;

/**
 * Created by junm5 on 11/26/16.
 */
public class SumRootLeafNumbers {

    public void sum(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int totalSum = 0, tempSum = 0;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                tempSum = tempSum * 10 + cur.val;
                if (cur.left == null && cur.right == null) {
                    totalSum += tempSum;
                }
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
                tempSum = tempSum / 10;
            }
        }
    }
}
