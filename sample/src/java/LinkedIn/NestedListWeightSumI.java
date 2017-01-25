package LinkedIn;

import java.util.List;

/**
 * Created by junm5 on 12/26/16.
 */
public class NestedListWeightSumI {
    public int depthSum(List<NestedInteger> nestedList) {
        //recursive solve this problem
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            sum += getSum(nestedInteger, 1);
        }
        return sum;
    }

    private int getSum(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * depth;
        }
        int sum = 0;
        List<NestedInteger> list = nestedInteger.getList();
        for (NestedInteger ni : list) {
            sum += getSum(ni, depth + 1);
        }
        return sum;
    }

}
