package LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 12/26/16.
 */
public class NestedListWeightSumII {
    /**
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     * <p>
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     * <p>
     * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
     * <p>
     * Example 1:
     * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
     * <p>
     * Example 2:
     * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
     */

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
    public static void main(String [] args){
        NestedListWeightSumII nestedListWeightSumII = new NestedListWeightSumII();
    }

    private int DFS(List<NestedInteger> nestedList, int sum) {
        List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
        int res;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger();
            } else {
                nextLevel.addAll(nestedInteger.getList());
            }
        }
        res = nextLevel.isEmpty() ? 0 : DFS(nextLevel, sum);
        return res;
    }



}
