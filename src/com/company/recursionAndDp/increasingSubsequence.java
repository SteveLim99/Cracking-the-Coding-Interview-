package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<List<Integer>> findSubsequences_opt(int[] nums) {
        List<List<Integer>> total = new ArrayList();
        dfs(nums,total,new ArrayList(),0);
        return total;
    }

    private void dfs(int[] nums, List<List<Integer>> total, List<Integer> tmp, int head){
        if(tmp.size() >= 2) total.add(new ArrayList(tmp));
        Set<Integer> newNums = new HashSet();
        for(int i = head; i < nums.length; i++){
            if(newNums.contains(nums[i])) continue;
            if(tmp.size() == 0 || nums[i] >= tmp.get(tmp.size()-1)){
                tmp.add(nums[i]);
                newNums.add(nums[i]);
                dfs(nums,total,tmp,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
