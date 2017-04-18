package queue;

import LinkedIn.TreeNode;
import java.util.*;

/**
 * Created by junm5 on 3/14/17.
 */
public class SanckGames implements Comparable<SanckGames> {
    @Override
    public int compareTo(SanckGames o) {
        return 0;
    }

    public static char[] removeDuplicate(char chs[]) {
        int tail = 1;
        for (int i = 1; i < chs.length; i++) {
            int j = 0;
            for (; j < tail; j++) {
                if (chs[i] == chs[j]) {
                    break;
                }
            }
            if (j == tail) {
                chs[tail] = chs[i];
                tail++;
            }
        }
        chs[tail] = 0;
        return chs;
    }
    public static List<TreeNode> generateTrees(int n) {
        //use dynamatic programming
        List<TreeNode>[] dp = new List[n+1];
        dp[0] = new ArrayList();
        dp[1] = new ArrayList();
        dp[1].add(new TreeNode(1));
        for(int i = 2; i <= n; i++){
            List<TreeNode> temp = new ArrayList();
            for(int j = 1; j <= i; j++){
                List<TreeNode> left = dp[j - 1];
                List<TreeNode> right = dp[i - j];
                if(left.isEmpty()){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.right = r;
                        temp.add(root);
                    }
                    continue;
                }
                if(right.isEmpty()){
                    for(TreeNode l : left){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        temp.add(root);
                    }
                    continue;
                }
                for(TreeNode l : left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        temp.add(root);
                    }
                }
            }
            dp[i] = temp;
        }
        return dp[n];

    }
    public static void main(String[] args){
        generateTrees(3);
        HashSet<Integer> integers = new HashSet<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.remove(2);
    }
}
