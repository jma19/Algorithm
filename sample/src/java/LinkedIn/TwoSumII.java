package LinkedIn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by junm5 on 12/26/16.
 */
public class TwoSumII {
    /**
     * Design and implement a TwoSum class. It should support the following operations: add and find.
     * <p>
     * add - Add the number to an internal data structure.
     * find - Find if there exists any pair of numbers which sum is equal to the value.
     */
    // Add the number to an internal data structure.
    Map<Integer, Integer> map = new HashMap();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        Set<Integer> keys = map.keySet();
        for (Integer v : keys) {
            int target = value - v;

            if (map.containsKey(target)) {
                if (target == v && map.get(v) < 2) {
                    continue;
                }
                return true;

            }
        }
        return false;
    }
}
