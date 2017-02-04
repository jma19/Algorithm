package amaon;

import LinkedIn.TreeNode;

/**
 * Created by junm5 on 1/29/17.
 */
public class CountInversalTree {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CountInversalTree countInversalTree = new CountInversalTree();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(5);
        TreeNode rr = new TreeNode(5);

        root.left = left;
        root.right = right;

        left.left = ll;
        left.right = lr;
        right.right = rr;


        int i = countInversalTree.countUnivalSubtrees(root);

        System.out.println(i);
    }
}
