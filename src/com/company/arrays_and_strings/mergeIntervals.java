package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mergeIntervals {
    public int[][] merge_1(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        List<Integer> start = new ArrayList();
        List<Integer> end = new ArrayList();

        for(int[] i : intervals){
            start.add(i[0]);
            end.add(i[1]);
        }

        Collections.sort(start);
        Collections.sort(end);

        List<List<Integer>> res = new ArrayList();
        int slowStart = start.get(0), slowEnd = end.get(0);
        for(int i = 1; i < start.size(); i++){
            int currStart = start.get(i), currEnd = end.get(i);
            if(slowStart == currStart || slowEnd >= currStart){
                slowEnd = Math.max(slowEnd, currEnd);
            } else {
                List<Integer> tmp = new ArrayList();
                tmp.add(slowStart);
                tmp.add(slowEnd);
                res.add(tmp);
                slowStart = currStart;
                slowEnd = currEnd;
            }
        }
        List<Integer> tmp = new ArrayList();
        tmp.add(slowStart);
        tmp.add(slowEnd);
        res.add(tmp);

        int[][] total = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            total[i][0] = res.get(i).get(0);
            total[i][1] = res.get(i).get(1);
        }

        return total;
    }
}
