package com.company.recursionAndDp;

public class canReach {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr,start);
    }

    private boolean dfs(int[] arr, int start){
        if(start >= arr.length || start < 0 || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start];
        return dfs(arr,start+arr[start]) || dfs(arr,start-arr[start]);
    }

    public boolean canJump(int[] nums) {
        return dfs_canJump(nums,0);
    }

    private boolean dfs_canJump(int[] nums, int curr){
        if(curr >= nums.length || nums[curr] == -1) return false;
        if(curr == nums.length-1) return true;
        if(nums[curr] == 0) return false;

        boolean tmp = false;
        for(int i = 1; i <= nums[curr]; i++){
            tmp = tmp || dfs_canJump(nums,curr+i);
        }
        nums[curr] = -1;

        return tmp;
    }
}
