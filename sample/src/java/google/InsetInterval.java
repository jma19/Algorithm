package google;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 5/6/18.
 */
public class InsetInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList();

        int start = 0, end = intervals.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(intervals.get(mid).start < newInterval.start){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        String[] split = "".split("\\.");

        for(int i = 0; i < start - 1; i++){
            result.add(intervals.get(i));
        }

        if(start != 0){
            //backward megre previous node
            Interval pre = intervals.get(start - 1);
            if(pre.end >= newInterval.start){
                newInterval.start = pre.start;
                newInterval.end = Math.max(pre.end, newInterval.end);
            }else{
                result.add(pre);
            }
        }
        //forward merge
        int i = start;
        for(;i < intervals.size() &&
                newInterval.end >= intervals.get(i).start; i++){
            Interval cur = intervals.get(i);
            newInterval.end = Math.max(cur.end, newInterval.end);
        }

        result.add(newInterval);
        while(i < intervals.size()){
            result.add(intervals.get(i++));
        }

        return result;
    }

    public static void main(String[] args){
        InsetInterval insetInterval = new InsetInterval();
        List<Interval> origin = new ArrayList<>();
        origin.add(new Interval(1, 3));
        origin.add(new Interval(6, 9));

        List<Interval> insert = insetInterval.insert(origin, new Interval(2, 5));
        System.out.println(insert);
    }
}
