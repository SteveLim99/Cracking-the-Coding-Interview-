package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.List;

// Really good practice for backtracking!
public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtracking(output,tmp,nums);
        return output;
    }

    private void backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums){
        if(tmp.size() == nums.length){
            output.add(new ArrayList(tmp));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tmp.contains(nums[i])) continue;
                tmp.add(nums[i]);
                backtracking(output,tmp,nums);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
