package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
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

    // Lambda functions used here!!!!
    public int[][] merge_2(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        //LAMBDA FUNCTIONS
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<List<Integer>> res = new ArrayList();
        int slowStart = intervals[0][0], slowEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0], currEnd = intervals[i][1];
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

    public int[][] merge_opti(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> res = new ArrayList();
        int slowStart = intervals[0][0], slowEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            if(slowStart == currStart || slowEnd >= currStart){
                slowEnd = Math.max(slowEnd, currEnd);
            } else {
                res.add(new int[]{slowStart, slowEnd});
                slowStart = currStart;
                slowEnd = currEnd;
            }
        }
        res.add(new int[]{slowStart, slowEnd});

        // Converting Array back to primitive list
        return res.toArray(new int[res.size()][2]);
    }
}
