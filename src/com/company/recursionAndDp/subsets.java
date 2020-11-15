package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), 0, nums);
        return list;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> tmp, int index, int[] nums){
        output.add(new ArrayList<>(tmp));
        for(int i = index; i < nums.length; i++ ){
            tmp.add(nums[i]);
            backtrack(output,tmp,i+1,nums);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup_2(int[] nums) {
        List<List<Integer>> total = new ArrayList();
        Arrays.sort(nums);
        backtrack_2(total,new ArrayList(), 0, nums);
        return total;
    }

    private void backtrack_2(List<List<Integer>> total, List<Integer> tmp, int header, int[] nums)    {
        if(header > nums.length) return;
        List<Integer> tmpArr = new ArrayList(tmp);
        if(!total.contains(tmpArr)) total.add(tmpArr);

        for(int i = header; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(total,tmp,i+1,nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
