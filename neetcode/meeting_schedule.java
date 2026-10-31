package org.example.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class meeting_schedule {
    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // t: O(n*lg(n))
    // s: O(n) or O(1)
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            return true;
        }
        // O(n lg(n))
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }

    void main() {
        boolean res = canAttendMeetings(new ArrayList<>(Arrays.asList(new Interval(0, 30), new Interval(5,10), new Interval(15,20))));
    }
}
