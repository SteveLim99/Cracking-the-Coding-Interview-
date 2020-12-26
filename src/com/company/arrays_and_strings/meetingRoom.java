package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class meetingRoom {
    public int minMeetingRoomsII(int[][] intervals) {
        if(intervals.length == 0) return 0;
        List<Integer> start = new ArrayList();
        List<Integer> end = new ArrayList();

        for(int[] i : intervals){
            start.add(i[0]);
            end.add(i[1]);
        }

        Collections.sort(start);
        Collections.sort(end);

        int res = 1, tail = 0;
        for(int i = 1; i < start.size(); i++){
            if(start.get(i)<end.get(tail))
                res++;
            else
                tail++;
        }

        return res;
    }
}
