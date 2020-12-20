package com.company.arrays_and_strings;

import java.util.List;

public class minTimeDiff {
    public int findMinDifference(List<String> timePoints) {
        boolean[] allTimes = new boolean[24 *  60];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(String i : timePoints){
            int hours = Integer.valueOf(i.substring(0,2)) * 60;
            int mins = Integer.valueOf(i.substring(3,5));
            int total = hours + mins;

            if(allTimes[total]) return 0;
            allTimes[total] = true;
            max = Math.max(max,total);
            min = Math.min(min,total);
        }

        int minDiff = Integer.MAX_VALUE, prev = 0;
        for(int i = min; i <= max; i++){
            if(allTimes[i]){
                if(i == min) minDiff = Math.min(minDiff, Math.min(max-min, 1440 - max + min));
                else minDiff = Math.min(minDiff,i-prev);
                prev = i;
            }
        }

        return minDiff;
    }
}
