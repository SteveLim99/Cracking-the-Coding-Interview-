package com.company.mathAndLogic;

public class removeCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        int size = intervals.length;
        for(int i = 0; i < size; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            boolean isInterval = false;
            for(int[] x : intervals){
                int currA = x[0];
                int currB = x[1];
                if(currA == a && currB == b) continue;
                if(a >= currA && b <= currB ) {
                    isInterval = true;
                    break;
                }
            }
            if(!isInterval) count++;
        }
        return count;
    }
}
