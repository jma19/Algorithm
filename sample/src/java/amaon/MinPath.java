package amaon;

import LinkedIn.TreeNode;

/**
 * Created by junm5 on 1/19/17.
 */
public class MinPath {
    /**
     * Binary search tree minimum sum from root to leaf
     * <p>
     * 跟BST没啥关系，不要看到BST就以为是最左边的路径之和（左边路径可以很长，右边路径可以很短），用递归做很简单
     */
    public int Solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {
            return root.val + Solution(root.left);
        }
        if (root.left == null && root.right != null) {
            return Solution(root.right) + root.val;
        }
        return root.val + Math.min(Solution(root.left), Solution(root.right));
    }
}
