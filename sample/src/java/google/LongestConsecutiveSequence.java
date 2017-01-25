package google;

import LinkedIn.TreeNode;

/**
 * Created by junm5 on 12/27/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        preOrder(root, root.val, 0, res);
        //using spark computing
        return res[0];
    }

    void preOrder(TreeNode root, int pre, int count, int[] res) {
        if (root != null) {
            if (root.val == pre + 1) {
                count++;
                if (count > res[0]) {
                    res[0] = count;
                }
            } else {
                count = 1;
                if (count > res[0]) {
                    res[0] = count;
                }
            }
            preOrder(root.left, root.val, count, res);
            preOrder(root.right, root.val, count, res);
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        int i = longestConsecutiveSequence.longestConsecutive(root);
        System.out.println(i);
    }
}
