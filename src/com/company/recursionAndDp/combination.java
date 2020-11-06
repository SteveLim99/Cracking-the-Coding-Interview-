package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Using backtracking for combination
public class combination {
    public List<List<Integer>> combine_bruteForce(int n, int k) {
        List<List<Integer>> output = new ArrayList();
        List<Integer> tmp = new ArrayList();
        backtrackking(output,tmp,k,1,n);
        return output;
    }

    private void backtrackking(List<List<Integer>> output, List<Integer> tmp, int size, int start, int n)      {
        if(tmp.size() == size){
            List<Integer> newTmp = new ArrayList(tmp);
            Collections.sort(newTmp);
            if(!output.contains(newTmp)) output.add(newTmp);
        } else {
            for(int i = start; i <= n; i++){
                if(tmp.contains(i)) continue;
                tmp.add(i);
                backtrackking(output,tmp,size,start+1,n);
                tmp.remove(tmp.size()-1);
            }
        }
}
