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

    public List<List<Integer>> subsetsWithDup_opti(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> total = new ArrayList();
        backtrack_opti(total,new ArrayList(), 0, nums);
        return total;
    }

    private void backtrack_opti(List<List<Integer>> total, List<Integer> tmp, int header, int[] nums)    {
        total.add(new ArrayList(tmp));
        for(int i = header; i < nums.length; i++){
            // This line of code removes duplicates
            // This is because instead of iterating through the same element twice, if it is see that the same element occurs twice in the sorted list
            // It will skip it instead of adding that element into tmp and calling the recursive operation agn. 
            if(i > header && nums[i] == nums[i-1]) continue;
            tmp.add(nums[i]);
            backtrack(total,tmp,i+1,nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
