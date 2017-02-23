package amaon;

import LinkedIn.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junm5 on 2/21/17.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap();
        buildMap(map, root);
        List<Integer> res = new ArrayList();
        for(Integer key: map.keySet()){
            if(map.get(key) == max){
                res.add(key);
            }
        }
        int[] finalRes = new int[res.size()];
        for(int i = 0;i < res.size(); i++){
            finalRes[i] = res.get(i);
        }
        return finalRes;

    }
    private int max = 0;
    private int buildMap(Map<Integer, Integer> map, TreeNode root){
        if(root == null){
            return 0;
        }
        int key = buildMap(map, root.left) + buildMap(map, root.right) + root.val;
        int value = map.getOrDefault(key, 0) + 1;
        max = Math.max(value, max);
        map.put(key, value);
        return key;
    }
    public static void main(String[] args){
        MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();
        TreeNode root = new TreeNode(5);
        TreeNode left  = new TreeNode(2);
        TreeNode right = new TreeNode(-3);
        root.left = left;
        root.right = right;
        mostFrequentSubtreeSum.findFrequentTreeSum(root);
    }

}
