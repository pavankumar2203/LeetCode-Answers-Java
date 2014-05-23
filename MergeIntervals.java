/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> r = new ArrayList<Interval>();
        for(int i = intervals.size() - 1; i >=0 ; i--) {
            boolean merged = false;
            for(int j = i - 1; j >=0; j--) {
                if(merge(intervals.get(i), intervals.get(j))) {
                    merged = true;
                    break;
                }
            }
            if(!merged) {
                r.add(intervals.get(i));
            }
        }
        return r;
    }
    private boolean merge(Interval a, Interval b) {
        if(a.end < b.start || b.end < a.start) return false;
        b.start = Math.min(a.start, b.start);
        b.end = Math.max(a.end, b.end);
        return true;
    }
}
