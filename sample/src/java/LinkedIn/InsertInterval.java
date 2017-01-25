package LinkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by junm5 on 12/27/16.
 * 57. Insert Interval
 * <p>
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList();
        if(intervals == null || intervals.isEmpty()){
            return res;
        }
        int pos = 0;
        for(Interval interval : intervals){
            if(interval.end < newInterval.start){
                pos++;
                res.add(interval);
            }else if(interval.start > newInterval.end){
                res.add(interval);
            }else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        res.add(pos, newInterval);
        return res;
    }

}
