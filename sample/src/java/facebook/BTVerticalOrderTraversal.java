package facebook;

import LinkedIn.TreeNode;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by junm5 on 1/1/17.
 */
public class BTVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap();
        verticalOrderUtil(map, root, 0);

        return res;
    }

    void verticalOrderUtil(Map<Integer, List<Integer>> map, TreeNode root, int col){
        if(root == null){
            return;
        }
        /**
         *
         */
        List<Integer> temp = map.get(col);
        if(temp == null){
            temp = new ArrayList();
            map.put(col, temp);
        }
        temp.add(root.val);
        verticalOrderUtil(map, root.left, col - 1);
        verticalOrderUtil(map, root.right, col + 1);
    }
}
