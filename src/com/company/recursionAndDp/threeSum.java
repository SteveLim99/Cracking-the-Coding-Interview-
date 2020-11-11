package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum_backtrack(int[] nums) {
        List<List<Integer>> total = new ArrayList();
        Arrays.sort(nums);
        backtrack(total,new ArrayList(),nums,0);
        return total;
    }

    private void backtrack(List<List<Integer>> total, List<Integer> tmp, int[] nums, int head){
        if (tmp.size() == 3){
            int sum = tmp.get(0) + tmp.get(1) + tmp.get(2);
            if(sum == 0 && !total.contains(tmp)) total.add(new ArrayList(tmp));
        }

        for( int i = head; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(total,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
