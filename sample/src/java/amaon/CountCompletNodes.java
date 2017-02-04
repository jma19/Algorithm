package amaon;

import LinkedIn.TreeNode;

/**
 * Created by junm5 on 1/31/17.
 */
public class CountCompletNodes  implements  Comparable{
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
    public static void main(String [] args){
        CountCompletNodes countCompletNodes = new CountCompletNodes();
        TreeNode root = new TreeNode(0);
        TreeNode treeNode = new TreeNode(2);
        root.right = treeNode;
        TreeNode treeNode1 = new TreeNode(3);
        root.left = treeNode1;
        treeNode1.left = new TreeNode(4);
        countCompletNodes.countNodes(root);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
