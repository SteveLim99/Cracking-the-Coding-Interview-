package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class intervalIntersection {
    public int[][] intervalIntersection_1(int[][] A, int[][] B) {
        List<int[]> total = new ArrayList();

        for(int[] i : A){
            int lowerA = i[0], upperA = i[1];
            for(int[] j : B){
                int lowerB = j[0], upperB = j[1];
                if(lowerA > upperB) continue;
                if(upperA < lowerB) break;
                if(upperB >= upperA || upperA >= upperB || lowerB >= lowerA || lowerA >= lowerB) {
                    upperB = Math.min(upperA, upperB);
                    lowerB = Math.max(lowerA, lowerB);
                    total.add(new int[]{lowerB, upperB});
                }
            }
        }

        return total.toArray(new int[total.size()][2]);
    }
}
