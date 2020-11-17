package com.company.sliding_window;

public class countNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }

    private int atMost(int[] nums, int k){
        int i = 0, j;
        int count = 0;
        for( j = 0; j < nums.length; j++){
            if(nums[j] % 2 != 0) k--;
            while (k<0)
                if(nums[i++] % 2 != 0) k++;
            count += j - i + 1;
        }
        return count;
    }
}
