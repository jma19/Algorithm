package com.uci.mj;

import LinkedIn.TreeNode;

import java.util.*;

/**
 * Created by junm5 on 10/19/16.
 */
public class BTL {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        Map<Integer, List<Integer>> map = new HashMap();
        if (root == null) {
            return res;
        }
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Integer> temp = map.get(node.level);
            if (temp == null) {
                temp = new ArrayList<Integer>();
                map.put(node.level, temp);
            }
            temp.add(node.treeNode.val);
            if (node.treeNode.left != null) {
                queue.offer(new Node(node.treeNode.left, node.level + 1));
            }
            if (node.treeNode.right != null) {
                queue.offer(new Node(node.treeNode.right, node.level + 1));
            }
        }
        int deep = map.size();

        for (int i = deep - 1; i >= 0; i--) {
            List<Integer> temp = map.get(i);
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode4.right = treeNode5;

        BTL btl = new BTL();
        btl.levelOrderBottom(treeNode1);
    }

}

class Node {
    TreeNode treeNode;
    Integer level;

    Node(TreeNode treeNode, Integer level) {
        this.treeNode = treeNode;
        this.level = level;
    }
}
