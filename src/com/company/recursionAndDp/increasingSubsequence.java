package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class increasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> total = new ArrayList();
        backtrack(nums,total,new ArrayList(),0);
        return total;
    }

    private void backtrack(int[] nums, List<List<Integer>> total, List<Integer> tmp, int head){
        if(head > nums.length) return;
        if(tmp.size() >= 2 && !total.contains(tmp)) total.add(new ArrayList(tmp));

        for(int i = head; i < nums.length; i++){
            boolean added = false;
            if(tmp.size() == 0 || nums[i] >= tmp.get(tmp.size()-1)){
                tmp.add(nums[i]);
                added = true;
            }
            backtrack(nums,total,tmp,i+1);
            if(added) tmp.remove(tmp.size()-1);
        }
    }
}
