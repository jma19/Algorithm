package LinkedIn;

import common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by junm5 on 12/27/16.
 */
public class MergeIntervals {
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * <p>
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();

        if (intervals == null || intervals.isEmpty()) {
            return res;
        }
        //sort the input
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval pre = intervals.get(0);
        for (Interval interval : intervals) {
            if (interval.start <= pre.end) { //overlap
                Interval newInterval = new Interval(pre.start, Math.max(interval.end, pre.end));
                pre = newInterval;
            } else {
                res.add(pre);
                pre = interval;
            }
        }
        res.add(pre);
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(10, 15));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(8, 10));


        List<Interval> merge = mergeIntervals.merge(intervals);
        System.out.println(merge);
    }
}
