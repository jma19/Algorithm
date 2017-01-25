package LinkedIn;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by junm5 on 12/26/16.
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), new int[]{1}, n, 2);
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> tempRes, int[] acc, int target, int index) {
        if (acc[0] == target) {
            res.add(new ArrayList<Integer>(tempRes));
            return;
        }
        if (acc[0] > target) {
            return;
        }
        for (int i = index; i <= Math.sqrt(target); i++) {
            acc[0] = acc[0] * i;
            tempRes.add(i);
            helper(res, tempRes, acc, target, i);
            tempRes.remove(tempRes.size() - 1);
            acc[0] /= i;
        }
    }

    public static void main(String[] args) {
        FactorCombinations factorCombinations = new FactorCombinations();
        List<List<Integer>> factors = factorCombinations.getFactors(8192);
        System.out.println(factors);
    }

}
