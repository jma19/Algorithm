package LinkedIn;

import common.Interval;

import java.util.TreeMap;

/**
 * Created by junm5 on 12/27/16.
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        /**
         * Given a set of intervals, for each of the interval i,
         * check if there exists an interval j whose start point
         * is bigger than or equal to the end point of the interval i,
         * which can be called that j is on the "right" of i.
         */

        int[] result = new int[intervals.length];

        TreeMap<Integer, Integer> intervalMap = new TreeMap();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Integer key = intervalMap.ceilingKey(intervals[i].end);
            result[i] = (key != null) ? intervalMap.get(key) : -1;
        }

        return result;
    }

}
