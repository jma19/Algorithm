package com.uci.mj;

/**
 * Created by junm5 on 11/6/16.
 */
public class InOrder {
    public void inOrderShow(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        inOrderShow(treeNode.left);
        inOrderShow(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        InOrder inOrder = new InOrder();
        inOrder.inOrderShow(treeNode1);
        StringBuffer reverse = new StringBuffer("13").reverse();

    }
}
