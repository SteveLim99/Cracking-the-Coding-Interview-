package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum_backtrack(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList();
        backtrack(output,new ArrayList(), candidates,target,0);
        return output;
    }

    private void backtrack(List<List<Integer>> total, List<Integer> tmp, int[] candidates, int remain, int head){
        if(remain < 0) return;
        if(remain == 0) total.add(new ArrayList(tmp));

        for(int i = head; i < candidates.length; i++){
            tmp.add(candidates[i]);
            backtrack(total,tmp,candidates,remain-candidates[i],i);
            tmp.remove(tmp.size()-1);
        }
    }
}
