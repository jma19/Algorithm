package google;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalendar {
    private TreeSet<Interval> intervalSet;
    public MyCalendar() {
        intervalSet = new TreeSet<>((o1, o2) -> o1.start - o2.start);
    }
    
    public boolean book(int start, int end) {
        Interval newInterval = new Interval(start, end);

        Interval ceil = intervalSet.ceiling(newInterval);
        Interval floor = intervalSet.floor(newInterval);
        
        if(ceil != null && (ceil.end < end || ceil.start == start)){
            return false;
        }
        if(floor != null && (floor.end > start || floor.start == start)){
            return false;
        }
        intervalSet.add(newInterval);
        return true;
    }
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args){
        System.out.println(1 << 3);
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */