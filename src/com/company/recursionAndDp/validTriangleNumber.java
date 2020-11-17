package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class validTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int total = backtrack(nums, new ArrayList(), 0);
        return total;
    }

    private int backtrack(int[] nums, List<Integer> tmp, int head){
        int total = 0;
        if(head > nums.length) return 0;
        if(tmp.size() == 3)
            if(tmp.get(1)+tmp.get(0)>tmp.get(2)) return 1;

        for(int i = head; i < nums.length; i++){
            tmp.add(nums[i]);
            total += backtrack(nums,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }

        return total;
    }
}
