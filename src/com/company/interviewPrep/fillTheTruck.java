package com.company.interviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class fillTheTruck {
    private int nums;
    private int[] boxes;
    private int unitSize;
    private int[] unitsPerBox;
    private int truckSize;

    public fillTheTruck(int nums, int[] boxes, int[] unitsPerBox, int unitSize, int truckSize){
        this.nums = nums;
        this.boxes = boxes;
        this.unitsPerBox = unitsPerBox;
        this.unitSize = unitSize;
        this.truckSize = truckSize;
    }

    public int getFillTheTruck(){
        List<Integer> combined = new ArrayList<>();
        int totalBoxes = 0;

        for(int i = 0; i < this.boxes.length; i++){
            int noBoxes = this.boxes[i];
            int noProducts = this.unitsPerBox[i];
            for(int j = 0; j < noBoxes; j++){
                combined.add(noProducts);
                totalBoxes++;
            }
        }

        Collections.sort(combined);
        int sum = 0;
        if(totalBoxes == 0) return sum;
        int count = 0;
        for(int i = 1; i <= totalBoxes; i++){
            sum += combined.get(totalBoxes-i);
            count++;
            if(count == this.truckSize) break;
        }

        return sum;
    }
}
