package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] end = new int[26];

        for(int i = 0; i < S.length(); i++){
            end[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList();
        int start = 0, last = 0;
        for(int i = 0; i < S.length(); i++){
            int curr = S.charAt(i) - 'a';
            last = Math.max(end[curr],last);
            if(last == i){
                res.add(last + 1 - start);
                start = last + 1;
            }
        }

        return res;
    }
}
