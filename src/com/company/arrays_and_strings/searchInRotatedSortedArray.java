package com.company.arrays_and_strings;

public class searchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = 1;
        boolean foundPivot = false;

        while( !foundPivot && r < nums.length){
            if(nums[r] < nums[l]) foundPivot = true;
            l++;
            r++;
        }

        if(!foundPivot) return bSearch(nums,target,nums.length-1,0);
        return (target < nums[0]) ? bSearch(nums,target,nums.length-1,r-1) : bSearch(nums,target,l,0);
    }

    private int bSearch(int[] nums, int target, int head, int tail){
        if(tail > head) return -1;

        int idx = -1;
        int mid = (head + tail) / 2;
        if(nums[mid] == target) return mid;
        else if(target > nums[mid]){
            int tmp = bSearch(nums,target,head,mid+1);
            if(tmp != -1) idx = tmp;
        } else{
            int tmp = bSearch(nums,target,mid-1,tail);
            if(tmp != -1) idx = tmp;
        }
        return idx;
    }
}
