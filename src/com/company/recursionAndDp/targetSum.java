package com.company.recursionAndDp;

public class targetSum {
    public int findTargetSumWays_1(int[] nums, int S) {
        return backtrack(nums,S,0,0);
    }

    private int backtrack(int[] nums, int S, int total, int head){
        if(head > nums.length || (head == nums.length && total != S)) return 0;
        if(total == S && head == nums.length) return 1;
        return backtrack(nums,S,total+nums[head],head+1) + backtrack(nums,S,total-nums[head],head+1);
    }
}
