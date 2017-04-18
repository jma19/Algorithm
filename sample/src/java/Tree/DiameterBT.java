package Tree;

import LinkedIn.TreeNode;

/**
 * Created by junm5 on 3/21/17.
 */
public class DiameterBT {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
    public static void main(String[] args){
        DiameterBT diameterBT = new DiameterBT();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        left.left = new TreeNode(0);
        root.left = left;
        root.right = right;
        diameterBT.diameterOfBinaryTree(root);

    }
}
