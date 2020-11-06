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

    private void backtrackking(List<List<Integer>> output, List<Integer> tmp, int size, int start, int n) {
        if (tmp.size() == size) {
            List<Integer> newTmp = new ArrayList(tmp);
            Collections.sort(newTmp);
            if (!output.contains(newTmp)) output.add(newTmp);
        } else {
            for (int i = start; i <= n; i++) {
                // Contrary to the below, we see that we have to check whether i has already been added into the temporary list
                // This is because in each run we still iterate from the default start value and are not actually iterating through the list on a higher level
                // Hence, we encounter the same values again but allows us to obtain a combination
                if (tmp.contains(i)) continue;
                tmp.add(i);
                backtrackking(output, tmp, size, start + 1, n);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combine_optimized(int n, int k) {
        List<List<Integer>> output = new ArrayList();
        backtrackking_optimized(output,new ArrayList(),1,n,k);
        return output;
    }

    private void backtrackking_optimized(List<List<Integer>> output, List<Integer> tmp, int start, int n, int k) {
        if(k == 0){
            output.add(new ArrayList(tmp));
            return;
        } else {
            // Notice that we utilize n - k + 1 instead of just n
            // The reason for this is because when we are doing our recursion, we do not want to backtrace on when we know that they are not enough elements to fill k
            // I.E.
            // Assume n = 10, k = 5 as n = 10
            // If our i = 7 and above, we would unneccesarily recurse through 7,8,9 and 10 even though there are not enough values to fill k.
            for(int i = start; i <= n-k+1; i++){
                // Contrary to the above, here we use i + 1 as the starting instead of start itself as compared to when we are doing permutation
                // This ensures that in each run we do not encounter the same value again
                // Hence, allowing us to obtain the combination
                tmp.add(i);
                backtrackking(output,tmp,i+1,n,k-1);
                tmp.remove(tmp.size()-1);
            }
        }

    }
}
