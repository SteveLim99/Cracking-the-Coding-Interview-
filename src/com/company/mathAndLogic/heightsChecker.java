package com.company.mathAndLogic;

import java.util.Arrays;

public class heightsChecker {
    public int heightChecker(int[] heights) {
        final int[]  tmp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(tmp);
        int total = 0;
        for(int i = 0; i < heights.length; i++){
            if(tmp[i] != heights[i]) total++;
        }
        return total;
    }
}
