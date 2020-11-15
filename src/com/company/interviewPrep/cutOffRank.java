package com.company.interviewPrep;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class cutOffRank {
    private int cutOffRank;
    private int nums;
    private int[] scores;

    public cutOffRank(int cutOffRank, int nums, int[] scores){
        this.cutOffRank = cutOffRank;
        this.nums = nums;
        this.scores = scores;
    }

    public int getCutOffRank(){
        Integer[] score = Arrays.stream(this.scores).boxed().toArray(Integer[]::new);
        int count = 0;
        int currRank = 0;
        int currScore = -1;
        Arrays.sort(score, Collections.reverseOrder());
        for(int i = 0; i < score.length; i++ ){
            int curr = score[i];

            if(curr != currScore){
                currScore = curr;
                currRank = count + 1;
            }

            if(currRank <= this.cutOffRank){
                count++;
            }
        }
        return count;
    }
}
