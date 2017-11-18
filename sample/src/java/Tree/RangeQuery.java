package Tree;

import java.util.List;

/**
 * Created by junm5 on 6/17/17.
 */
public class RangeQuery {

    public static void query(TreeNode root, int low, int high, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (high < root.val) {
            query(root.left, low, high, res);
        } else if (low > root.val) {
            query(root.right, low, high, res);
        } else {
            query(root.left, low, high, res);
            query(root.right, low, high, res);
        }
    }

}
