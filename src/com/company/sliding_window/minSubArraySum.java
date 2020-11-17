package com.company.sliding_window;

public class minSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, j, count = 0, max = 2147483647;
        for(j = 0; j < nums.length; j++){
            count += nums[j];
            while(count >= s){
                max = Math.min(max,j-i+1);
                count -= nums[i++];
            }
        }
        return max!=2147483647 ? max : 0;
    }
}
