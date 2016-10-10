package com.uci.mj;


import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 10/2/16.
 */
public class PathSumII {

    private void pathSumer(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res){
        if(root == null){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            res.add(temp);
            temp.clear();
        }
        if(root.left !=null){
            pathSumer(root.left, sum - root.val, temp, res);
        }
        if(root.right !=null){
            pathSumer(root.right, sum - root.val, temp, res);
        }
        temp.remove(root.val);
    }
    public static void main(String[] args){
        PathSumII pathSumII = new PathSumII();
        TreeNode treeNode = TreeNode.builderTestData();
        int sum = 11;
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        pathSumII.pathSumer(treeNode, sum, temp, res);
        System.out.println(res);
    }

}
